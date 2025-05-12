package org.zerock.board.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.QBoard;
import org.zerock.board.entity.QMember;
import org.zerock.board.entity.QReply;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SearchBoardRepositoryImpl extends QuerydslRepositorySupport implements SearchBoardRepository{
    public SearchBoardRepositoryImpl() {
        super(Board.class);
    }

    @Override
    public Page<Object[]> searchPage(String type, String keyword, Pageable pageable) {
        QBoard board = QBoard.board;
        QReply reply = QReply.reply;
        QMember member = QMember.member;

        JPQLQuery<Board> jpqlQuery = from(board);  // from board
        jpqlQuery.leftJoin(member).on(board.writer.eq(member)); // left join member on board.writer_email=member.email
        jpqlQuery.leftJoin(reply).on(reply.board.eq(board)); // left join reply on reply.board_bno=board.bno

        JPQLQuery<Tuple> tuple = jpqlQuery.select(board, member, reply.count()); // select board.*, member.*, count(*)

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        BooleanExpression expression = board.bno.gt(0L); // board.bno>0;

        booleanBuilder.and(expression); // where board.bno>0;

        if(type != null){
            String[] typeArr = type.split("");
            //검색 조건을 작성하기
            BooleanBuilder conditionBuilder = new BooleanBuilder();

            for (String t:typeArr) {
                switch (t) {
                    case "t" -> conditionBuilder.or(board.title.contains(keyword)); // or board.title like '%spring%'
                    case "w" -> conditionBuilder.or(member.email.contains(keyword));// or board.writer_email like '%spring%'
                    case "c" -> conditionBuilder.or(board.content.contains(keyword));// or board.content like '%spring%'
                }
            }
            // where board.bno>0
            // and (board.title like '%spring%'
            //  or board.writer_email like '%spring%'
            //  or board.content like '%spring%'
            // )
            booleanBuilder.and(conditionBuilder);
        }

        // select board.*, tbl_member.*, count(*)
        // from board
        // left join tbl_member on board.writer_email=tbl_member.email
        // left join reply on reply.board_bno=board.bno
        // where board.bno>0
        // and (board.title like '%spring%'
        //  or board.writer_email like '%spring%'
        //  or board.content like '%spring%'
        // )
        // group by board.bno
        tuple.where(booleanBuilder);
        tuple.groupBy(board);
        //paging처리적용
        Objects.requireNonNull(this.getQuerydsl()).applyPagination(pageable, tuple);

        List<Tuple> result = tuple.fetch(); //쿼리실행
        long count = tuple.fetchCount();

        return new PageImpl<Object[]>(
                result.stream().map(Tuple::toArray).collect(Collectors.toList()),
                pageable,
                count);

    }
}
