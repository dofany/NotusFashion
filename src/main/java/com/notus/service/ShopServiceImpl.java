package com.notus.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.notus.domain.GoodsViewVO;
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

}
