package com.notus.service;

import java.util.List;

import com.notus.domain.Criteria;
import com.notus.domain.QnaVO;
import com.notus.domain.SearchCriteria;

public interface QnaService {
	public void write(QnaVO vo) throws Exception;

	// 조회
	public QnaVO read(int bno) throws Exception;

	// 수정
	public void update(QnaVO vo) throws Exception;

	// 삭제
	public void delete(int bno) throws Exception;

	public List<QnaVO> list() throws Exception;
	
	public List<QnaVO> listPage(Criteria cri) throws Exception;
	
	public int listCount() throws Exception;
	
	public List<QnaVO> listSearch(SearchCriteria scri) throws Exception;
	
	public int countSearch(SearchCriteria scri) throws Exception;

}
