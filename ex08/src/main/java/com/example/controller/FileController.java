package com.example.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {
	@PostMapping("/download") //테스트 /download?file=http//~
	public void download(@RequestParam("file") String file)throws Exception {
		URL url=new URL(file);
		InputStream in=url.openStream();
		String filePath="c:/download/mall/";
		String fileName=System.currentTimeMillis() + ".jpg";
		FileOutputStream out=new FileOutputStream(filePath + fileName);
		FileCopyUtils.copy(in, out);
	}
}