package com.notus.persistence;

import com.notus.domain.MemberVO;


public interface MemberDAO {
	
	public void signup(MemberVO vo) throws Exception;

	public MemberVO signin(MemberVO vo) throws Exception;
	
	public void modify(MemberVO vo) throws Exception;

}
