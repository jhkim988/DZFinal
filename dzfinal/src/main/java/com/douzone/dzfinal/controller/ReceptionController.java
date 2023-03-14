package com.douzone.dzfinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.dzfinal.entity.Reception;
import com.douzone.dzfinal.service.ReceptionService;

@RestController
@RequestMapping("/api/reception")
public class ReceptionController {
	
	@Autowired
	private ReceptionService receptionService;

	@GetMapping("/list")
	public List<Reception> receptionList() {

		return receptionService.receptionList();
	}
}
