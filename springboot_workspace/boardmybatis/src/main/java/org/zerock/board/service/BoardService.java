package org.zerock.board.service;


import java.util.List;

import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResultDTO;
import org.zerock.board.dto.PageResultDTO2;
import org.zerock.board.entity.Board;
import org.zerock.board.entity.Member;

public interface BoardService {

    //등록
    Long register(BoardDTO dto);
    //목록
    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);
    //상세보기.수정화면
    BoardDTO get(Long bno);
    //삭제
    void removeWithReplies(Long bno);
    //수정
    void modify(BoardDTO boardDTO);

    PageResultDTO2<BoardDTO> getList2(PageRequestDTO pageRequestDTO);

   //목록.MyBatis
    List<BoardDTO> list2();
    //삭제.MyBatis
    void deleteTest();



    default Board dtoToEntity(BoardDTO dto){
        Member member = Member.builder().email(dto.getWriterEmail()).build();
        Board board = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(member)
                .build();
        return board;
    }

    default BoardDTO entityToDTO(Board board, Member member, Long replyCount) {
        BoardDTO boardDTO = BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .writerEmail(member.getEmail())
                .writerName(member.getName())
                .replyCount(replyCount.intValue()) //int로 처리하도록
                .build();

        return boardDTO;
    }


}