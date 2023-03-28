package com.douzone.dzfinal.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.dzfinal.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@PostMapping("/register")
	public boolean register(@RequestParam("file") MultipartFile file) {
		String real_image = "upload" + System.currentTimeMillis();
		File saveFile = new File("c:\\upload\\image\\" + real_image);
		boolean message = false;
		
		try (OutputStream os = new FileOutputStream(saveFile)) {
			os.write(file.getBytes());
			adminService.register();
			message = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return message;
	}
}
