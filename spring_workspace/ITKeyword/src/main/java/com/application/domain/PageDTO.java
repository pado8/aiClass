package com.application.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
    private int startPage; // 1.2.3...10에서 시작 페이지
    private int endPage; // 1.2.3...10에서 끝 페이지
    private boolean prev, next; // 이전, 다음 구간 존재 여부
    private int total; // 전체 글 수
    private Criteria cri; // 페이징을 위한 Criteria

    public PageDTO(Criteria cri, int total) {
        this.cri = cri;
        this.total = total;

        // endPage 계산: 10 페이지씩 나누어 끝 페이지를 설정
        this.endPage = (int) (Math.ceil((cri.getPageNum() / 10.0))) * 10;

        // startPage 계산: endPage에서 9를 뺀 값
        this.startPage = this.endPage - 9;

        // 실제 마지막 페이지 (realEnd) 계산
        int realEnd = (int) Math.ceil((total * 1.0) / cri.getAmount());

        // endPage가 realEnd보다 크면 endPage를 realEnd로 수정
        if (realEnd <= this.endPage) {
            this.endPage = realEnd;
        }

        // 이전 페이지 존재 여부
        this.prev = this.startPage > 1;

        // 다음 페이지 존재 여부
        this.next = this.endPage < realEnd;
    }
}
