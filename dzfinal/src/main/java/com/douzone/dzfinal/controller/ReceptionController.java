package com.douzone.dzfinal.controller;

import com.douzone.dzfinal.dto.ReceptionDTO;
import com.douzone.dzfinal.dto.WaitingDTO;
import com.douzone.dzfinal.entity.Reception;
import com.douzone.dzfinal.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reception")
public class ReceptionController {

	@Autowired
	private ReceptionService receptionService;

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

	@GetMapping("/today")
	public List<WaitingDTO.WaitingData> todayList() {
		return receptionService.todayList();
	}

	@GetMapping("/detail/{reception_id}")
	public ReceptionDTO.Detail detail(@PathVariable int reception_id) {
		return receptionService.detail(reception_id);
	}
}