package org.zerock.board.service;

import java.util.List;

import org.zerock.board.dto.ReplyDTO;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Reply;

public interface ReplyService {
    //등록
    Long register(ReplyDTO replyDTO);
    //목록
    List<ReplyDTO> getList(Long bno);
    //수정
    void modify(ReplyDTO replyDTO);
    //삭제
    void remove(Long rno);

    // dto to entity
    default Reply dtoToEntity(ReplyDTO replyDTO){
        Board board = Board.builder().bno(replyDTO.getBno()).build();
        Reply reply = Reply.builder()
                .rno(replyDTO.getRno())
                .text(replyDTO.getText())
                .replyer(replyDTO.getReplyer())
                .board(board)
                .build();

        return reply;
    }

    //entity to dto
    default ReplyDTO entityToDTO(Reply reply){
        ReplyDTO dto = ReplyDTO.builder()
                .rno(reply.getRno())
                .text(reply.getText())
                .replyer(reply.getReplyer())
                .regDate(reply.getRegDate())
                .modDate(reply.getModDate())
                .build();

        return dto;
    }


}
