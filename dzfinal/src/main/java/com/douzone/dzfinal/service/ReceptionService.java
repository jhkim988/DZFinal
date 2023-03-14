package com.douzone.dzfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.dzfinal.entity.Reception;
import com.douzone.dzfinal.repository.ReceptionRepository;

@Service
public class ReceptionService {
	
	@Autowired
	ReceptionRepository receptionRepository;

	public List<Reception> receptionList() {
		return receptionRepository.receptionList();
	}
}
