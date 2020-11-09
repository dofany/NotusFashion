package com.notus.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.notus.domain.QnaReplyVO;

@Repository
public class QnaReplyDAOImpl implements QnaReplyDAO{
	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.notus.mappers.replyMapper";
	
	@Override
	public List<QnaReplyVO> readReply(int bno)throws Exception{
		return sql.selectList(namespace + ".readReply",bno);
		
	}
	
	@Override
	public void writeReply(QnaReplyVO vo) throws Exception{
		sql.insert(namespace + ".writeReply",vo);
	}
	
	@Override
	public QnaReplyVO readReplySelect(int rno) throws Exception{
		return sql.selectOne(namespace + ".readReplySelect",rno);
	}
	
	@Override
	public void replyUpdate(QnaReplyVO vo) throws Exception{
		sql.update(namespace + ".updateReply",vo);
		
	}
	
	@Override
	public void replyDelete(QnaReplyVO vo) throws Exception{
		sql.delete(namespace + ".deleteReply",vo);
		
	}

}
