package com.notus.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.notus.domain.CartListVO;
import com.notus.domain.CartVO;
import com.notus.domain.GoodsViewVO;
import com.notus.domain.OrderDetailVO;
import com.notus.domain.OrderListVO;
import com.notus.domain.OrderVO;
import com.notus.domain.ReplyListVO;
import com.notus.domain.ReplyVO;
import com.notus.persistence.ShopDAO;

@Service
public class ShopServiceImpl implements ShopService {

	@Inject
	private ShopDAO dao;

	@Override
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception {
		int cateCodeRef = 0;

		if (level == 1) {
			cateCodeRef = cateCode;
			return dao.list(cateCode, cateCodeRef);
		} else {
			return dao.list(cateCode);
		}

	}
	
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception{
		return dao.goodsView(gdsNum);
	}
	
	@Override
	public void registReply(ReplyVO reply)throws Exception{
		dao.registReply(reply);
	}
	
	@Override
	public List<ReplyListVO> replyList(int gdsNum) throws Exception{
		return dao.replyList(gdsNum);
	}
	
	@Override
	public void deleteReply(ReplyVO reply) throws Exception{
		dao.deleteReply(reply);
	}
	
	@Override
	public String idCheck(int repNum) throws Exception{
		return dao.idCheck(repNum);
	}
	
	@Override
	public void modifyReply(ReplyVO reply)throws Exception{
		dao.modifyReply(reply);
	}
	
	@Override
	public void addCart(CartVO cart)throws Exception{
		dao.addCart(cart);
	}
	
	@Override
	public List<CartListVO> cartList(String userId) throws Exception{
		return dao.cartList(userId);
	}
	
	@Override
	public void deleteCart(CartVO cart) throws Exception{
		dao.deleteCart(cart);
	}
	
	@Override
	public void orderInfo(OrderVO order) throws Exception{
		dao.orderInfo(order);
	}
	
	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception{
		dao.orderInfo_Details(orderDetail);
	}
	
	@Override
	public void cartAllDelete(String userId) throws Exception{
		dao.cartAllDelete(userId);
	}
	
	@Override
	public List<OrderVO> orderList(OrderVO order) throws Exception{
		return dao.orderList(order);
	}
	
	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception{
		return dao.orderView(order);
	}

}
