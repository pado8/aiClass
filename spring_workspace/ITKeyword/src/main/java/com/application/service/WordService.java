package com.application.service;

import java.util.List;

import com.application.domain.Criteria;
import com.application.domain.WordVO;

public interface WordService {
	//등록
	public void register(WordVO word);
	//상세보기
	public WordVO get(Long no);
	//수정
	public boolean modify(WordVO word);
	//삭제
	public boolean remove(Long no);
	//목록
	//public List<WordVO> getList();
	//목록 with paging
	public List<WordVO> getList(Criteria cri);
	//전체 글 수
	public int getTotal(Criteria cri);
	
}
