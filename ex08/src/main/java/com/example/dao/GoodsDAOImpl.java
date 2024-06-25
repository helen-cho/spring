package com.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.GoodsVO;

@Repository
public class GoodsDAOImpl implements GoodsDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.GoddsMapper";
	
	@Override
	public void insert(GoodsVO vo) {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public GoodsVO read(String gid) {
		return session.selectOne(namespace + ".read", gid);
	}
}
