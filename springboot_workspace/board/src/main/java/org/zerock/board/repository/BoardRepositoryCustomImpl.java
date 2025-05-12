package org.zerock.board.repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.entity.QBoard;
import org.zerock.board.entity.QMember;
import org.zerock.board.entity.QReply;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardRepositoryCustomImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    // 생성자 주입 방식 (스프링이 자동으로 EntityManager를 넣어줌)
    public BoardRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Page<Object[]> getBoardWithReplyCount2(Pageable pageable) {
        QBoard board = QBoard.board;
        QReply reply = QReply.reply;

        List<Tuple> result = queryFactory
                .select(
                        board.bno,
                        board.title,
                        board.writer,
                        board.modDate,
                        board.regDate,
                        reply.count() // group by와 함께 count
                )
                .from(board)
                .leftJoin(reply).on(reply.board.eq(board))
                .groupBy(board.bno)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        // 전체 개수 쿼리
        Long total = queryFactory
                .select(board.count())
                .from(board)
                .fetchOne();

        List<Object[]> result1=new ArrayList<>();
        for (Tuple tuple : result) {
            Object[] arr = tuple.toArray();
            result1.add(arr);
        }

        return new PageImpl<>(result1, pageable, total);
    }
}
