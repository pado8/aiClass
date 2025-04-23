package com.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.domain.Criteria;
import com.application.domain.WordVO;
import com.application.mapper.WordMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Service
@AllArgsConstructor
public class WordServiceImpl implements WordService{

	@Setter(onMethod_ = @Autowired)
	private WordMapper mapper;
	
	@Override
	public void register(WordVO word) {
		mapper.insertSelectKey(word); //mapper의 insert 메서드 호출
	}

	@Override
	public WordVO get(Long no) {
		return mapper.read(no);
	}

	@Override
	public boolean modify(WordVO word) {
		return mapper.update(word) == 1; //영향을 받은 행의 수가 1이면 true.
	}

	@Override
	public boolean remove(Long no) {
		return mapper.delete(no) == 1; //영향을 받은 행의 수가 1이면 true.
	}

	//@Override
	//public List<WordVO> getList() {
	//	return mapper.getList();
	//}
	
	@Override
	public List<WordVO> getList(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
	
}
