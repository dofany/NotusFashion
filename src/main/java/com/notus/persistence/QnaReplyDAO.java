package com.notus.persistence;

import java.util.List;

import com.notus.domain.QnaReplyVO;

public interface QnaReplyDAO {
	
	public List<QnaReplyVO> readReply(int bno) throws Exception;
	
	public void writeReply(QnaReplyVO vo) throws Exception;
	
	public QnaReplyVO readReplySelect(int rno) throws Exception;
	
	public void replyUpdate(QnaReplyVO vo) throws Exception;
	
	public void replyDelete(QnaReplyVO vo) throws Exception;
	

}
