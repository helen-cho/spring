package com.example.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.CouVO;
import com.example.domain.QueryVO;

@Repository
public class CouDAOImpl implements CouDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.CouMapper";
	
	@Override
	public List<CouVO> list(QueryVO vo) {
		return session.selectList(namespace + ".list", vo);
	}

	@Override
	public String getlcode(String dept) {
		return session.selectOne(namespace + ".getcode", dept);
	}

	@Override
	public void insert(CouVO vo) {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public CouVO read(String lcode) {
		return session.selectOne(namespace + ".read", lcode);
	}

	@Override
	public void delete(String lcode) {
		session.delete(namespace + ".delete", lcode);
	}

	@Override
	public void update(CouVO vo) {
		session.update(namespace + ".update", vo);
	}
}
