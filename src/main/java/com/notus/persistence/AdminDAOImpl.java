package com.notus.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.notus.domain.CategoryVO;
import com.notus.domain.GoodsVO;
import com.notus.domain.GoodsViewVO;

@Repository
public class AdminDAOImpl implements AdminDAO{
	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.notus.mappers.adminMapper";
	
	@Override
	public List<CategoryVO> category() throws Exception {
		return sql.selectList(namespace + ".category");
	}
	
	@Override
	public void register(GoodsVO vo) throws Exception{
		sql.insert(namespace + ".register", vo);
	}
	
	@Override
	public List<GoodsViewVO> goodslist() throws Exception{
		return sql.selectList(namespace + ".goodslist");
	}
	
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception{
		return sql.selectOne(namespace + ".goodsView",gdsNum);
	}
	
	@Override
	public void goodsModify(GoodsVO vo) throws Exception{
		sql.update(namespace + ".goodsModify", vo);
	}
	
	@Override
	public void goodsDelete(int gdsNum) throws Exception{
		sql.delete(namespace + ".goodsDelete",gdsNum);
	}

}
