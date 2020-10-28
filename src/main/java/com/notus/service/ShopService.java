package com.notus.service;

import java.util.List;

import com.notus.domain.GoodsViewVO;
import com.notus.domain.ReplyListVO;
import com.notus.domain.ReplyVO;

public interface ShopService {
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception;
	
	public GoodsViewVO goodsView(int gdsNum)throws Exception;
	
	public void registReply(ReplyVO reply)throws Exception;
	
	public List<ReplyListVO> replyList(int gdsNum)throws Exception;
}
