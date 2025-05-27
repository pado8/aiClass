package org.zerock.mreview.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    //review 번호
    private Long reviewnum;
    //Movie 번호
    private Long mno;
    //Membmer id
    private Long mid;
    //Member nickname
    private String nickname;
    //Member 이메일
    private String email;
    //평점. 1~5
    private int grade;
    //리뷰내용
    private String text;
    //등록일.수정일
    private LocalDateTime regDate, modDate;


}