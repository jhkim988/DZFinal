package com.douzone.dzfinal.controller;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.dzfinal.dto.ClinicResponse;
import com.douzone.dzfinal.service.ClinicService;

@Validated
@RestController
@RequestMapping("/api/clinic")
public class ClinicController {

	@Autowired
	ClinicService clinicService;
	
	@GetMapping("/{reception_id}")
	public ClinicResponse.Clinic getUnderlyingList(@PathVariable("reception_id") @Digits(integer = 8, fraction = 0) @Min(1) int reception_id) {		
		return clinicService.getClinic(reception_id);
	}
}