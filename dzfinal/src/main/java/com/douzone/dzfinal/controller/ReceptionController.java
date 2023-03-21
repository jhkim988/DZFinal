package com.douzone.dzfinal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.dzfinal.entity.Reception;
import com.douzone.dzfinal.service.ReceptionService;

@RestController
@RequestMapping("/api/reception")
public class ReceptionController {
	
	@Autowired
	private ReceptionService receptionService;

//	@GetMapping("/list")
//	public List<Reception> receptionList() {
//
//		return receptionService.receptionList();
//	}
	
	@PostMapping
	public Map<String,Object> insertReception(@RequestBody Reception reception){
		Map<String, Object> map = new HashMap<>();
		
		//수정
		if(reception != null) {
			receptionService.insertReception(reception);
			map.put("status", "true");
			map.put("message", "접수등록 성공");
		}else {
			map.put("status", "false");
			map.put("message", "접수등록 실패");
		}
		
		return map;
	}
}
