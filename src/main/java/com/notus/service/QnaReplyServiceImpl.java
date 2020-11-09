package com.notus.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.notus.domain.QnaReplyVO;
import com.notus.persistence.QnaReplyDAO;

@Service
public class QnaReplyServiceImpl implements QnaReplyService {

	@Inject
	private QnaReplyDAO dao;

	@Override
	public List<QnaReplyVO> readReply(int bno) throws Exception {
		return dao.readReply(bno);
	}

	@Override
	public void writeReply(QnaReplyVO vo) throws Exception {
		dao.writeReply(vo);
	}

	@Override
	public QnaReplyVO readReplySelect(int rno) throws Exception {
		return dao.readReplySelect(rno);
	}

	@Override
	public void replyUpdate(QnaReplyVO vo) throws Exception {
		dao.replyUpdate(vo);
	}
	
	@Override
	public void replyDelete(QnaReplyVO vo) throws Exception{
		dao.replyDelete(vo);
	}
	
	

}
