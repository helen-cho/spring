package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.UserVO;

@Repository
public class UsersDAOImpl implements UsersDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.UesrsMapper";
	
	@Override
	public List<HashMap<String, Object>> list() {
		return session.selectList(namespace + ".list");
	}

	@Override
	public HashMap<String, Object> read(String uid) {
		return session.selectOne(namespace + ".read", uid);
	}

	@Override
	public void insert(UserVO vo) {
		session.insert(namespace + ".insert", vo);
	}

}
