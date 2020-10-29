package com.notus.persistence;

import java.util.List;

import com.notus.domain.CartListVO;
import com.notus.domain.CartVO;
import com.notus.domain.GoodsViewVO;
import com.notus.domain.OrderDetailVO;
import com.notus.domain.OrderListVO;
import com.notus.domain.OrderVO;
import com.notus.domain.ReplyListVO;
import com.notus.domain.ReplyVO;

public interface ShopDAO {
	
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef)throws Exception;
	
	public List<GoodsViewVO> list(int cateCode)throws Exception;
	
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	public void registReply(ReplyVO reply)throws Exception;
	
	public List<ReplyListVO> replyList(int gdsNum) throws Exception;
	
	public void deleteReply(ReplyVO reply)throws Exception;
	
	public String idCheck(int repNum) throws Exception;
	
	public void modifyReply(ReplyVO reply)throws Exception;
	
	public void addCart(CartVO cart)throws Exception;
	
	public List<CartListVO> cartList(String userId) throws Exception;
	
	public void deleteCart(CartVO cart) throws Exception;
	
	public void orderInfo(OrderVO order) throws Exception;
	
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception;
	
	public void cartAllDelete(String userId) throws Exception;
	
	public List<OrderVO> orderList(OrderVO order) throws Exception;

	public List<OrderListVO> orderView(OrderVO order) throws Exception;
}
