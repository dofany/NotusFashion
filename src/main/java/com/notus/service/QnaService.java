package com.notus.service;

import java.util.List;

import com.notus.domain.QnaVO;

public interface QnaService {
	public void write(QnaVO vo) throws Exception;

	// 조회
	public QnaVO read(int bno) throws Exception;

	// 수정
	public void update(QnaVO vo) throws Exception;

	// 삭제
	public void delete(int bno) throws Exception;
	
	 public List<QnaVO> list() throws Exception;


}
