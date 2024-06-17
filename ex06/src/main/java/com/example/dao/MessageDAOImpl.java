package com.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO{
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.MessageMapper";
	
	@Override
	public void insert(MessageVO vo) {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public MessageVO readSend(int mid) {
		return session.selectOne(namespace + ".readSend", mid);
	}

	@Override
	public MessageVO readReceive(int mid) {
		return session.selectOne(namespace + ".readReceive", mid);
	}

	@Override
	public void updateReadDate(int mid) {
		session.update(namespace + ".updateReadDate", mid);
	}
}
