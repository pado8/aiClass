package com.application.service;

import java.util.List;

import com.application.domain.KeyWordVO;

public interface WordService {
	//등록
	public void register(KeyWordVO board);
	//상세보기
	public KeyWordVO get(Long bno);
	//수정
	public boolean modify(KeyWordVO board);
	//삭제
	public boolean remove(Long bno);
	//목록
	public List<KeyWordVO> getList();
}
