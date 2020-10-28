package com.notus.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.notus.domain.GoodsViewVO;
import com.notus.domain.ReplyListVO;
import com.notus.domain.ReplyVO;
@Repository
public class ShopDAOImpl implements ShopDAO {
	@Inject
	private SqlSession sql;

	private static String namespace = "com.notus.mappers.shopMapper";

	@Override
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception{
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cateCode", cateCode);
		map.put("cateCodeRef",cateCodeRef);
		return sql.selectList(namespace+".list_1",map);
	}
	
	@Override
	public List<GoodsViewVO> list(int cateCode) throws Exception {

		return sql.selectList(namespace + ".list_2", cateCode);
	}
	
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception{
		return sql.selectOne("com.notus.mappers.adminMapper" + ".goodsView",gdsNum);
	}
	
	@Override
	public void registReply(ReplyVO reply)throws Exception{
		sql.insert(namespace + ".registReply",reply);
	}
	
	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception{
		return sql.selectList(namespace + ".replyList",gdsNum);
	}
}
