package com.notus.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.notus.domain.CartListVO;
import com.notus.domain.CartVO;
import com.notus.domain.GoodsViewVO;
import com.notus.domain.OrderDetailVO;
import com.notus.domain.OrderListVO;
import com.notus.domain.OrderVO;
import com.notus.domain.ReplyListVO;
import com.notus.domain.ReplyVO;

@Repository
public class ShopDAOImpl implements ShopDAO {
	@Inject
	private SqlSession sql;

	private static String namespace = "com.notus.mappers.shopMapper";

	@Override
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cateCode", cateCode);
		map.put("cateCodeRef", cateCodeRef);
		return sql.selectList(namespace + ".list_1", map);
	}

	@Override
	public List<GoodsViewVO> list(int cateCode) throws Exception {

		return sql.selectList(namespace + ".list_2", cateCode);
	}

	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return sql.selectOne("com.notus.mappers.adminMapper" + ".goodsView", gdsNum);
	}

	@Override
	public void registReply(ReplyVO reply) throws Exception {
		sql.insert(namespace + ".registReply", reply);
	}

	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception {
		return sql.selectList(namespace + ".replyList", gdsNum);
	}

	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		sql.delete(namespace + ".deleteReply", reply);
	}

	@Override
	public String idCheck(int repNum) throws Exception {
		return sql.selectOne(namespace + ".replyUserIdCheck", repNum);
	}

	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		sql.update(namespace + ".modifyReply", reply);
	}

	@Override
	public void addCart(CartVO cart) throws Exception {
		sql.insert(namespace + ".addCart", cart);
	}

	@Override
	public List<CartListVO> cartList(String userId) throws Exception {
		return sql.selectList(namespace + ".cartList", userId);
	}
	
	@Override
	public void deleteCart(CartVO cart) throws Exception{
		sql.delete(namespace + ".deleteCart",cart);
	}
	
	@Override
	public void orderInfo(OrderVO order) throws Exception{
		sql.insert(namespace + ".orderInfo",order);
	}
	
	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail)throws Exception{
		sql.insert(namespace + ".orderInfo_Details",orderDetail);
	}
	
	@Override
	public void cartAllDelete(String userId) throws Exception{
		sql.delete(namespace + ".cartAllDelete",userId);
	}
	
	@Override
	public List<OrderVO> orderList(OrderVO order) throws Exception{
		return sql.selectList(namespace + ".orderList",order);
	}
	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception{
		return sql.selectList(namespace + ".orderView",order);
	}
}
