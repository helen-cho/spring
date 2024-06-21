package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.EnrollDAO;

@RestController
@RequestMapping("/enroll")
public class EnrollController {
	@Autowired
	EnrollDAO dao;
	
	@GetMapping("/scode/{scode}") //테스트 /enroll/scode/92414029
	public List<HashMap<String,Object>> scodeList(@PathVariable("scode") String scode){
		return dao.scodeList(scode);
	}
}
