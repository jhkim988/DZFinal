package com.douzone.dzfinal.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.dzfinal.dto.AdminDTO;
import com.douzone.dzfinal.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@PostMapping("/employee")
	public boolean register(@RequestParam("file") MultipartFile file, @RequestPart("employee") AdminDTO.EmployeeInfo employee) {		
		String real_image = "upload" + System.currentTimeMillis();
		employee.setReal_image(real_image);
		employee.setImage_name(file.getOriginalFilename());		
		
		File saveFile = new File("c:\\upload\\image\\" + real_image);
		boolean message = false;
		
		try (OutputStream os = new FileOutputStream(saveFile)) {
			os.write(file.getBytes());
			adminService.register(employee);
			message = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return message;
	}
	
	@GetMapping("/employee")
	public List<AdminDTO.Employee> getEmployee() {
		return adminService.getEmployee();
	}
	
	@GetMapping("/getimage")
	public ResponseEntity<byte[]> getImage(@RequestParam("real_image") String real_image) {
		File file = new File("c:\\upload\\image\\" + real_image);
		
		try {
	        FileInputStream ifo = new FileInputStream(file);
	        ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        byte[] buf = new byte[1024];
	        int readlength = 0;
	        
	        while((readlength = ifo.read(buf)) != -1 ) {
	            baos.write(buf,0,readlength);
	        }
	        
	        byte[] imgbuf = null;
	        imgbuf = baos.toByteArray();
	        baos.close();
	        ifo.close();    
	           
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.IMAGE_JPEG);
	        headers.setContentLength(imgbuf.length);
	        
	        return new ResponseEntity<byte[]>(imgbuf, headers, HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<byte[]>(null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@PutMapping("/employee")
	public void updateEmployee(@RequestBody AdminDTO.EmployeeInfo employee) {
		adminService.updateEmployee(employee);
	}
	
	@DeleteMapping("/employee")
	public void deleteEmployee(@RequestParam("employ_id") int employ_id) {
		adminService.deleteEmployee(employ_id);
	}
}
