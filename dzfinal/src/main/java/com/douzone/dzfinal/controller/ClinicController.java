package com.douzone.dzfinal.controller;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.dzfinal.dto.ClinicResponse;
import com.douzone.dzfinal.entity.Pagination;
import com.douzone.dzfinal.service.ClinicService;

@Validated
@RestController
@RequestMapping("/clinic")
public class ClinicController {

	@Autowired
	ClinicService clinicService;
	
	@GetMapping("/{reception_id}")
	public ClinicResponse.PatientInfo getPatientInfo(@PathVariable("reception_id") @Digits(integer = 8, fraction = 0) @Min(1) int reception_id) {		
		return clinicService.getPatientInfo(reception_id);
	}
	
	@GetMapping("/disease/{type}/{keyword}")
	public List<ClinicResponse.Underlying> getDiseaseList(@PathVariable("type") String type, @PathVariable("keyword") String keyword) {
		return clinicService.getDiseaseList(type, keyword);
	}
	
	@GetMapping("/drug/{type}/{keyword}")
	public List<ClinicResponse.DrugTaking> getDrugList(@PathVariable("type") String type, @PathVariable("keyword") String keyword) {
		return clinicService.getDrugList(type, keyword);
	}
	
	@PostMapping("/disease")
	public void insertUnderlying(@RequestBody ClinicResponse.Disease paramData) {
		clinicService.insertUnderlying(paramData);
	}
	
	@DeleteMapping("/disease")
	public void deleteUnderlying(@RequestParam @Digits(integer = 8, fraction = 0) @Min(1) int patient_id,
			@RequestParam @Digits(integer = 8, fraction = 0) @Min(1) int disease_id) {
		clinicService.deleteUnderlying(patient_id, disease_id);
	}
	
	@PostMapping("/drug")
	public void insertDrugTaking(@RequestBody ClinicResponse.Drug paramData) {
		clinicService.insertDrugTaking(paramData);
	}
	
	@DeleteMapping("/drug")
	public void deleteDrugTaking(@RequestParam @Digits(integer = 8, fraction = 0) @Min(1) int patient_id,
			@RequestParam @Digits(integer = 8, fraction = 0) @Min(1) int drug_id) {
		clinicService.deleteDrugTaking(patient_id, drug_id);
	}
	
	@PostMapping("/clinic")
	public void insertClinic(@RequestBody ClinicResponse.Clinic paramData) {
		System.out.println("insert : " + paramData);
		clinicService.insertClinic(paramData);
	}
	
	@PutMapping("/clinic")
	public void updateClinic(@RequestBody ClinicResponse.Clinic paramData) {
		System.out.println("update : " + paramData);
		clinicService.updateClinic(paramData);
	}
	
	@GetMapping("/mri/{patient_id}/{currentPage}")
	public ClinicResponse.MriPage getMriList(
	    @PathVariable("patient_id") @Digits(integer = 8, fraction = 0) @Min(1) int patient_id, @PathVariable("currentPage") int currentPage) {
		int amount = 10;
		
		int total = clinicService.getTotal(patient_id);
		ClinicResponse.Pagination pagination = new ClinicResponse.Pagination(currentPage, amount, total);
		
		ClinicResponse.MriPage mriPage = new ClinicResponse.MriPage(clinicService.getMriList(patient_id, pagination), pagination);
		
	  return mriPage;
	}
	
	@PostMapping("/mri/search")
	public List<ClinicResponse.MedicalRecordInquiry> getSearchMriList(@RequestBody ClinicResponse.SearchInfo paramData) {
	    return clinicService.getSearchMriList(paramData);
	}
	
	@GetMapping("/medicalinfo/{reception_id}")
	public ClinicResponse.MedicalInfo getMedicalInfo(@PathVariable("reception_id") @Digits(integer = 8, fraction = 0) @Min(1) int reception_id) {
		return clinicService.getMedicalInfo(reception_id);
	}
}