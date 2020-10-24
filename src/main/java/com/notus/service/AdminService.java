package com.notus.service;

import java.util.List;

import com.notus.domain.CategoryVO;
import com.notus.domain.GoodsVO;
import com.notus.domain.GoodsViewVO;

public interface AdminService {
	
	public List<CategoryVO> category() throws Exception;
	
	public void register(GoodsVO vo) throws Exception;
	
	public List<GoodsVO> goodslist() throws Exception;
	
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	public void goodsModify(GoodsVO vo) throws Exception;
	
	public void goodsDelete(int gdsNum) throws Exception;

}
