package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.GoodsDAO;
import com.example.domain.GoodsVO;

@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	GoodsDAO dao;
	
	@Transactional
	@Override
	public int insert(GoodsVO vo) {
		GoodsVO goods=dao.read(vo.getGid());
		if(goods==null) {
			dao.insert(vo);
			return 1;
		}
		return 0;
	}
}
