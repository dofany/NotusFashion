package com.notus.persistence;

import java.util.List;

import com.notus.domain.CategoryVO;
import com.notus.domain.GoodsVO;
import com.notus.domain.GoodsViewVO;
import com.notus.domain.OrderListVO;
import com.notus.domain.OrderVO;
import com.notus.domain.ReplyListVO;
public interface AdminDAO {
	
	public List<CategoryVO> category() throws Exception;
	
	public void register(GoodsVO vo) throws Exception;
	
	public List<GoodsViewVO> goodslist() throws Exception;
	
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	public void goodsModify(GoodsVO vo) throws Exception;
	
	public void goodsDelete(int gdsNum) throws Exception;
	
	public List<OrderVO> orderList() throws Exception;
	
	public List<OrderListVO> orderView(OrderVO order) throws Exception;
	
	public void delivery(OrderVO order) throws Exception;
	
	public void changeStock(GoodsVO goods) throws Exception;
	
	public List<ReplyListVO> allReply() throws Exception;
	
	public void deleteReply(int repNum) throws Exception;

}
