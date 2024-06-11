package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dao.BBSDAO;
import com.example.dao.UserDAO;
import com.example.domain.QueryVO;

@SpringBootTest
public class MysqlTest {
	@Autowired
	UserDAO dao;
	
	@Autowired
	BBSDAO bdao;
	
	@Test
	public void test() {
		QueryVO vo=new QueryVO();
		vo.setKey("title");
		vo.setWord("이유");
		vo.setPage(2);
		vo.setSize(3);
		bdao.list(vo);
	}
}
