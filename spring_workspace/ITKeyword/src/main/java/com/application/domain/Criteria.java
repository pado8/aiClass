package com.application.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Criteria {
    private int pageNum;
    private int amount;
    
    private String type;  // searchtype (T, C, TC 등)
    private String searchkeyword;  // 검색 키워드

    // 기본 생성자
    public Criteria() {
        this(1, 10);  // 기본적으로 pageNum 1, amount 10으로 설정
    }
    
    // pageNum과 amount를 지정할 수 있는 생성자
    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    // type 값을 배열로 변환하는 메서드 (검색 타입 처리)
    public String[] getTypeArr() {
        return type == null ? new String[] {} : type.split("");  // 'T', 'C', 'TC' 등
    }
}
