package com.notus.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.notus.domain.QnaVO;
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
	

}
