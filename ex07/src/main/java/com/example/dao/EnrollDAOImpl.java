package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EnrollDAOImpl implements EnrollDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.EnrollMapper";
	
	@Override
	public List<HashMap<String, Object>> scodeList(String scode) {
		return session.selectList(namespace + ".scodeList", scode);
	}

}
