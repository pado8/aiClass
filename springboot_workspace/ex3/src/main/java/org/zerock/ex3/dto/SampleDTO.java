package org.zerock.ex3.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true) //빌더패턴사용
public class SampleDTO {

    private Long sno;

    private String first;

    private String last;

    private LocalDateTime regTime;
}