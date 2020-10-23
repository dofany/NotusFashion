package com.notus.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.notus.domain.MemberVO;
import com.notus.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	private MemberDAO dao;
	
	@Override
	public void signup(MemberVO vo) throws Exception{
		dao.signup(vo);
	}

}
