package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Criteria {
	private int pageNum; //페이지번호
	private int amount; //한페이지에 출력되는 글수
	
	private String type;  //검색필드
	private String keyword;//검색억
	
	public Criteria() {
		this(1,10); // 기본값설정 - pageNum 1, amount 10
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
	public String[] getTypeArr() {
	    // TCW 등을 한글자씩 분리
	    return type == null? new String[] {}: type.split("");
	}
	public String getListLink() {
		UriComponentsBuilder builder=UriComponentsBuilder.fromPath("")
				.queryParam("pageNum",this.pageNum)
				.queryParam("amount",this.amount)
				.queryParam("type",this.type)
				.queryParam("keyword",this.keyword);
		
		return builder.toUriString(); // ?pagNum=1&amount=10&type=c&keyword=spring 형식의 문자열이 리턴됨.
				
	}
	
}
