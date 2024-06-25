package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.GoodsVO;
import com.example.domain.QueryVO;

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

	@Override
	public int total() {
		return session.selectOne(namespace + ".total");
	}

	@Override
	public List<HashMap<String, Object>> list(QueryVO vo) {
		return session.selectList(namespace + ".list", vo);
	}
}
