package com.notus.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.notus.domain.Criteria;
import com.notus.domain.QnaVO;
import com.notus.domain.SearchCriteria;
import com.notus.persistence.QnaDAO;

@Service
public class QnaServiceImpl implements QnaService{
	@Inject
	private QnaDAO dao;
	
	@Override
	public void write(QnaVO vo) throws Exception{
		dao.write(vo);
	}
	
	@Override
	public QnaVO read(int bno) throws Exception{
		return dao.read(bno);
	}
	
	@Override
	public void update(QnaVO vo) throws Exception{
		dao.update(vo);
	}

	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
		
	}
	
	 @Override
	 public List<QnaVO> list() throws Exception {
	  return dao.list();
	 }
	 
	 @Override
	 public List<QnaVO> listPage(Criteria cri) throws Exception{
		 return dao.listPage(cri);
	 }
	 
	 @Override
	 public int listCount() throws Exception{
		 return dao.listCount();
	 }
	 
	 @Override
	 public List<QnaVO> listSearch(SearchCriteria scri) throws Exception{
		 return dao.listSearch(scri);
	 }
	 
	 @Override
	 public int countSearch(SearchCriteria scri) throws Exception{
		 return dao.countSearch(scri);
	 }

}
