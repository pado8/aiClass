package org.zerock.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Reply;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
    @Modifying
    @Query("delete from Reply r where r.board.bno=:bno")
    void deleteByBno(Long bno);

    //댓글목록. 쿼리메서드
    // select * from reply
    // where board_bno=10
    // order by rno
    List<Reply> getRepliesByBoardOrderByRno(Board board);
}
