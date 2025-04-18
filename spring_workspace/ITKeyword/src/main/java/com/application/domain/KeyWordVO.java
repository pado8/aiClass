package com.application.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class KeyWordVO {
	private Long no;
	private String keyword;
	private String description;
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate regdate;
}