package com.notus.persistence;

import java.util.List;

import com.notus.domain.CategoryVO;

public interface AdminDAO {
	
	public List<CategoryVO> category() throws Exception;

}
