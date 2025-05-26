package org.zerock.board.repository;

import com.querydsl.core.Tuple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.board.dto.BoardDTO;

import java.util.List;

public interface BoardRepositoryCustom {
    Page<BoardDTO> getBoardWithReplyCount2(String type, String keyword,Pageable pageable);
}
