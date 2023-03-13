package com.douzone.dzfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.dzfinal.service.ClinicService;

@RestController
@RequestMapping("/api/clinic")
public class ClinicController {

	@Autowired
	ClinicService clinicService;
	
	@GetMapping
	public void test() {
		System.out.println(clinicService.test());
	}
	
	@GetMapping(value = "/asd")
	public void test1() {
		clinicService.test1();
	}
}