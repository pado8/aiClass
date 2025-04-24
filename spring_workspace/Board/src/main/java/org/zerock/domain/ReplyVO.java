package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private Long rno; //댓글번호
	private Long bno; //부모글번호
	private String reply;//댓글내용
	private String replyer;//댓글작성자
	private Date replyDate;//작성일
	private Date updateDate;//수정일

}
