package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UsersDAO;
import com.example.domain.UserVO;

@RestController
@RequestMapping("/users")
public class UsersRestController {
	@Autowired
	UsersDAO dao;
	
	@GetMapping("/list.json")
	public List<HashMap<String,Object>> list(){
		return dao.list();
	}
	
	@GetMapping("/{uid}")
	public HashMap<String,Object> read(@PathVariable("uid") String uid){
		return dao.read(uid);
	}
	
	@PostMapping("/insert")
	public int insert(UserVO vo) {
		if(dao.read(vo.getUid())==null) {
			dao.insert(vo);
			return 1;
		}
		return 0;
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UserVO vo) {
		//System.out.println(vo.toString());
		dao.update(vo);
	}
	
	@PostMapping("/delete/{uid}")
	public void delete(@PathVariable("uid") String uid) {
		dao.delete(uid);
	}
}







