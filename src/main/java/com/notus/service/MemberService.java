package com.notus.service;

import javax.servlet.http.HttpSession;

import com.notus.domain.MemberVO;

public interface MemberService {
	
	public void signup(MemberVO vo) throws Exception;
	
	public MemberVO signin(MemberVO vo) throws Exception;
	
	public void signout(HttpSession session) throws Exception;
	
	public void modify(MemberVO vo) throws Exception;
	
	public void withdrawal(MemberVO vo) throws Exception;
}
