package com.douzone.dzfinal.controller;

import com.douzone.dzfinal.entity.Reception;
import com.douzone.dzfinal.service.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reception")
public class ReceptionController {
	
	@Autowired
	private ReceptionService receptionService;

	@GetMapping("/list")
	public List<Reception> receptionList() {

		return receptionService.receptionList();
	}
}
