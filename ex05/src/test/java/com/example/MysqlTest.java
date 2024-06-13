package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dao.BBSDAO;
import com.example.dao.ReplyDAO;
import com.example.dao.UserDAO;
import com.example.domain.QueryVO;
import com.example.domain.ReplyVO;

@SpringBootTest
public class MysqlTest {
	@Autowired
	UserDAO dao;
	
	@Autowired
	BBSDAO bdao;
	
	@Autowired
	ReplyDAO rdao;
	
	@Test
	public void test() {
		ReplyVO vo=new ReplyVO();
		vo.setBid(252);
		vo.setUid("blue");
		vo.setContents("에어소프트건과 전동건의 주 동력원으로도 쓰인다. 피스톤에서 나오는 공기압을 이용해 BB탄을 발사하는데, 피스톤을 밀어내는 동력은 당연히 스프링이다.");
		rdao.insert(vo);
	}
}






