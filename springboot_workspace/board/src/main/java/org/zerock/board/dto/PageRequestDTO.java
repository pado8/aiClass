package org.zerock.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Builder //builder pattern사용
@AllArgsConstructor
@Data
public class PageRequestDTO {

    private int page; //페이지번호
    private int size; //한페이지에 출력되는 글의 수
    private String type; // 검색 field
    private String keyword; // 검색어


    public PageRequestDTO(){
        this.page = 1;
        this.size = 10;
    }

    public Pageable getPageable(Sort sort){
        return PageRequest.of(page -1, size, sort);

    }
}