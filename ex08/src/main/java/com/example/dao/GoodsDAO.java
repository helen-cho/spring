package com.example.dao;

import com.example.domain.GoodsVO;

public interface GoodsDAO {
	public void insert(GoodsVO vo);
	public GoodsVO read(String gid);
}
