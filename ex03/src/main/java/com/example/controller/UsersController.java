package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dao.UsersDAO;
import java.util.*;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	UsersDAO dao;
	
	@GetMapping("/list")
	public String list() {
		return "/users/list.html";
	}
	
	@GetMapping("/list.json")
	@ResponseBody
	public List<HashMap<String,Object>> listJSON(){
		return dao.list();
	}
}
