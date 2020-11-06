package com.notus.persistence;



import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.notus.domain.Criteria;
import com.notus.domain.QnaVO;
import com.notus.domain.SearchCriteria;

@Repository
public class QnaDAOImpl implements QnaDAO{
	@Inject
	 private SqlSession sql;
	 
	 // 매퍼
	 private static String namespace = "com.notus.mappers.qnaMapper";
	  
	 // 작성
	 @Override
	 public void write(QnaVO vo) throws Exception {
	  sql.insert(namespace + ".write", vo);
	 }
	 // 조회

	 @Override
	 public QnaVO read(int bno) throws Exception {
	  return sql.selectOne(namespace + ".read", bno);
	 }

	 // 수정
	 @Override
	 public void update(QnaVO vo) throws Exception {
	  sql.update(namespace + ".update", vo);
	 }

	 // 삭제
	 @Override
	 public void delete(int bno) throws Exception {
	  sql.delete(namespace + ".delete", bno);
	 }

	 @Override
	 public List<QnaVO> list() throws Exception {
	  return sql.selectList(namespace + ".list");
	 }
	 
	 @Override
	 public List<QnaVO> listPage(Criteria cri) throws Exception{
		 return sql.selectList(namespace + ".listPage",cri);
	 }
	 
	 @Override
	 public int listCount() throws Exception{
		 return sql.selectOne(namespace + ".listCount");
	 }
	 
	 @Override
	 public List<QnaVO> listSearch(SearchCriteria scri) throws Exception{
		 return sql.selectList(namespace + ".listSearch", scri);
	 }
	 
	 @Override
	 public int countSearch(SearchCriteria scri) throws Exception{
		 return sql.selectOne(namespace + ".countSearch",scri);
	 }


}
