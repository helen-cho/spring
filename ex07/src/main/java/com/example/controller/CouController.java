package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.CouDAO;
import com.example.domain.CouVO;
import com.example.domain.QueryVO;
import com.example.service.CouService;

@RestController
@RequestMapping("/cou")
public class CouController {
	@Autowired
	CouDAO dao;
	
	@Autowired
	CouService service;
	
	@GetMapping("/{lcode}")
	public CouVO read(@PathVariable("lcode") String lcode) {
		return dao.read(lcode);
	}
	
	@PostMapping("/delete/{lcode}")
	public void delete(@PathVariable("lcode") String lcode) {
		dao.delete(lcode);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody CouVO vo) {
		dao.update(vo);
	}
	
	@GetMapping("") //테스트 /cou?page=1&size=3
	public List<CouVO> list(QueryVO vo){
		return dao.list(vo);
	}
	
	@PostMapping("/insert")
	public void insert(@RequestBody CouVO vo) {
		service.insert(vo);
	}
}
