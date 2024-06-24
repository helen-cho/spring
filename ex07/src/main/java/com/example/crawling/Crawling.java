package com.example.crawling;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.*;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crawl")
public class Crawling {
	@GetMapping("/finance")
	public List<HashMap<String,Object>> finance(){
		List<HashMap<String,Object>> list=new ArrayList<>();
		try {
			Document doc=Jsoup.connect("https://finance.naver.com/").get();
			Elements es=doc.select("#_topItems1 tr");
			for(Element e:es) {
				String title=e.select("a").text();
				String price=e.select("td").get(0).text();
				String range=e.select("td").get(1).text();
				System.out.println(title + ":" + price + ":" + range);
				System.out.println("-----------------------------------");
				HashMap<String, Object> map=new HashMap<>();
				map.put("title", title);
				map.put("price", price);
				map.put("range", range);
				list.add(map);
			}
		}catch(Exception e) {
			System.out.println("Top종록:" + e.toString());
		}
		return list;
	}
	
	@PostMapping("/cgv/download") //테스트 /crawl/cgv/download?image=http://~
	public void download(@RequestParam("image") String image) {
		try {
			URL url=new URL(image);
			InputStream in=url.openStream();
			FileOutputStream out=new FileOutputStream("c:/download/poster/" 
						+ System.currentTimeMillis()+".jpg");
			FileCopyUtils.copy(in, out);
		}catch(Exception e) {
			System.out.println("이미지다운로드:" + e.toString());
		}
	}
	
	@GetMapping("/cgv")
	public List<HashMap<String,Object>> cgv(){
		List<HashMap<String,Object>> list=new ArrayList<>();
		try {
			Document doc=Jsoup.connect("http://www.cgv.co.kr/movies/?lt=1&ft=0").get();
			Elements es=doc.select(".sect-movie-chart ol");
			for(Element e:es.select("li")) {
				HashMap<String,Object> map=new HashMap<String,Object>();
				String title=e.select(".title").text();
				String img=e.select("img").attr("src");
				String date=e.select(".txt-info strong").text();
				String percent=e.select(".score .percent span").text();
				System.out.println("title............." + title);
				System.out.println("image............." + img);
				System.out.println("date............." + date);
				System.out.println("percent.........." + percent);
				if(title!="") {
					map.put("title", title);
					map.put("image", img);
					map.put("date", date);
					map.put("percent", percent);
					list.add(map);
				}
			}
		}catch(Exception e) {
			System.out.println("cgv오류:" + e.toString());
		}
		return list;
	}
}
