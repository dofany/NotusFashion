package com.notus.persistence;

import java.util.List;

import com.notus.domain.QnaVO;

public interface QnaDAO {
	public void write(QnaVO vo) throws Exception;

	public QnaVO read(int bno) throws Exception;

	public void update(QnaVO vo) throws Exception;

	public void delete(int bno) throws Exception;
	
	public List<QnaVO> list() throws Exception;

}
