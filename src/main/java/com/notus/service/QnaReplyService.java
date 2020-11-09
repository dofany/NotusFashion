package com.notus.service;

import java.util.List;

import com.notus.domain.QnaReplyVO;

public interface QnaReplyService {
	
	public List<QnaReplyVO> readReply(int bno) throws Exception;
	
	public void writeReply(QnaReplyVO vo) throws Exception;
	
	public QnaReplyVO readReplySelect(int rno) throws Exception;
	
	public void replyUpdate(QnaReplyVO vo) throws Exception;
	
	public void replyDelete(QnaReplyVO vo) throws Exception;

}
