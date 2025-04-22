package com.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.domain.KeyWordVO;
import com.application.mapper.KeyWordMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class WordServiceImpl implements WordService {

	@Setter(onMethod_ = @Autowired)
	private KeyWordMapper mapper;
	
	@Override
	public void register(KeyWordVO Word) {
		mapper.insertSelectKey(Word); //mapper의 insert 메서드 호출
	}

	@Override
	public KeyWordVO get(Long no) {
		return mapper.read(no);
	}

	@Override
	public boolean modify(KeyWordVO board) {
		return false;
	}

	@Override
	public boolean remove(Long bno) {
		return false;
	}

	@Override
	public List<KeyWordVO> getList() {
		return mapper.getList();
	}
	
}
