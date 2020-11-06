package com.notus.persistence;

import java.util.List;

import com.notus.domain.Criteria;
import com.notus.domain.QnaVO;
import com.notus.domain.SearchCriteria;

public interface QnaDAO {
	public void write(QnaVO vo) throws Exception;

	public QnaVO read(int bno) throws Exception;

	public void update(QnaVO vo) throws Exception;

	public void delete(int bno) throws Exception;
	
	public List<QnaVO> list() throws Exception;
	
	public List<QnaVO> listPage(Criteria cri) throws Exception;
	
	public int listCount() throws Exception;
	
	public List<QnaVO> listSearch(SearchCriteria scri) throws Exception;
	
	public int countSearch(SearchCriteria scri) throws Exception;

}
