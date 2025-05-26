package org.zerock.board.repository;


import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.BooleanTemplate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.entity.QBoard;
import org.zerock.board.entity.QReply;

import java.util.List;

@Repository
public class BoardRepositoryCustomImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    // 생성자 주입 방식 (스프링이 자동으로 EntityManager를 넣어줌)
    public BoardRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Page<BoardDTO> getBoardWithReplyCount2(String type, String keyword,Pageable pageable) {
        QBoard board = QBoard.board;
        QReply reply = QReply.reply;

        BooleanExpression filter=board.bno.gt(0L);
        if(type!=null && type.length()>0) {
            //동적쿼리. 검색조건
            if (type.equals("t")) {
                filter = filter.and(board.title.containsIgnoreCase(keyword)); // title에 대해 대소문자 구분 없이 검색
            }else if (type.equals("c")) {
                filter = filter.and(board.content.containsIgnoreCase(keyword)); // content에 대해 대소문자 구분 없이 검색
            }else if (type.equals("tc")) {
                filter = filter.and(
                        board.title.containsIgnoreCase(keyword)
                        .or(board.content.containsIgnoreCase(keyword))
                );
            }
        }

        List<BoardDTO> result = queryFactory
                .select(Projections.constructor(
                                BoardDTO.class,
                        board.bno,
                        board.title,
                        board.content,
                        board.writer.email,
                        board.writer.name,
                        board.regDate,
                        board.modDate,
                        reply.count().intValue() // group by와 함께 count
                ))
                .from(board)
                .leftJoin(reply).on(reply.board.eq(board))
                .where(filter)
                .groupBy(board.bno)
                .orderBy(board.bno.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        // 전체 개수 쿼리
        Long total = queryFactory
                .select(board.count())
                .from(board)
                .where(filter)
                .fetchOne();

        return new PageImpl<>(result, pageable, total);
    }
}
