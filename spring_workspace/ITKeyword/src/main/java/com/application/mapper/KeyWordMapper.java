package com.application.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.application.domain.KeyWordVO;

@Service
public interface KeyWordMapper {
	//목록
	public List<KeyWordVO> getList();
	//등록
	public void insert(KeyWordVO Word);
	//등록. sequence로 만들어진 bno값을 구해서 처리
	public void insertSelectKey(KeyWordVO Word);
	//상세보기
	public KeyWordVO read(Long no);
}
