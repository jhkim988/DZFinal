package com.douzone.dzfinal.service;

import com.douzone.dzfinal.entity.Reception;
import com.douzone.dzfinal.repository.ReceptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionService {
	
	@Autowired
	ReceptionRepository receptionRepository;

	public List<Reception> receptionList() {
		return receptionRepository.receptionList();
	}
}
