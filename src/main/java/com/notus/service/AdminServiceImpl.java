package com.notus.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.notus.domain.CategoryVO;
import com.notus.domain.GoodsVO;
import com.notus.domain.GoodsViewVO;
import com.notus.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Inject
	private AdminDAO dao;
	
	@Override
	public List<CategoryVO> category() throws Exception {
		return dao.category();
	}
	
	@Override
	public void register(GoodsVO vo) throws Exception{
		dao.register(vo);
	}
	
	@Override
	public List<GoodsVO> goodslist() throws Exception{
		System.out.println("서비스");
		return dao.goodslist();
	}
	
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception{
		return dao.goodsView(gdsNum);
	}
	
	@Override
	public void goodsModify(GoodsVO vo)throws Exception{
		dao.goodsModify(vo);
	}
	
	@Override
	public void goodsDelete(int gdsNum) throws Exception{
		dao.goodsDelete(gdsNum);
	}
}
