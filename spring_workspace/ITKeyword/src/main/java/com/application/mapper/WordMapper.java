package com.application.mapper;

import java.util.List;

import com.application.domain.Criteria;
import com.application.domain.WordVO;

public interface WordMapper {
	// where no>0은 pk에 설정된 index를 사용을 유도해서 데이터 처리 항샹 
	//@Select("select * from itkeyword where no>0")
	//public List<WordVO> getList();
	
	//등록
	public void insert(WordVO word);
	//등록. sequence로 만들어진 bno값을 구해서 처리
	public void insertSelectKey(WordVO word);
	//상세보기
	public WordVO read(Long no);
	//수정
	public int update(WordVO word); //리턴값은 영향을 받은 행의 수
	//삭제
	public int delete(Long no); //리턴값은 영향을 받은 행의 수
	//목록
	public List<WordVO> getList();
	//목록 with paging
	public List<WordVO> getListWithPaging(Criteria cri);
	// 전체 목록 수
	public int getTotalCount(Criteria cri);

}
