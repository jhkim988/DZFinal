package com.douzone.dzfinal.service;

import com.douzone.dzfinal.dto.PatientDTO;
import com.douzone.dzfinal.entity.Patient;
import com.douzone.dzfinal.entity.Reservation;
import com.douzone.dzfinal.repository.PatientRepository;
import com.douzone.dzfinal.repository.ReservationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	public int insertPatient(PatientDTO.UpdateDailyReservationList patient) {
		int patient_id =patientRepository.insertPatient(patient);
		int reservation_id = patient.getReservation_id();
		
		System.out.println(reservation_id);
		
		if (reservation_id != 0) {
//			reservationRepository.update(Reservation.builder()
//					.reservation_id(reservation_id)
//					.patient_id(patient_id)
//					.build());
			reservationRepository.updateTodayReservationPatientId(patient);
		}
		return patient_id;
	}
	
	public void updatePatientInfo(Patient patient) {
		patientRepository.updatePatientInfo(patient);
	}
	
	public int getPatientId(PatientDTO.UpdateDailyReservationList patient) {
		return patientRepository.getPatientId(patient);
	}
	
	public List<Patient> searchPatient(String patient_name){
		return patientRepository.searchPatient(patient_name);
	}
	
	public Patient searchPatientInfo(int patient_id) {
		return patientRepository.searchPatientInfo(patient_id).orElseThrow(IllegalArgumentException::new);
	}
	
//	public Patient searchPatient(String patient_name){
//		return patientRepository.searchPatient(patient_name).orElseThrow(IllegalArgumentException::new);
//	}
	
//	public List<Patient> searchPatient(Map<String, String> param){
//		return patientRepository.searchPatient(param);
//	}
	/*
	 * public Patient getOnePatientId(int patient_id) { return
	 * patientRepository.getOnePatientId(patient_id).orElseThrow(
	 * IllegalArgumentException::new); }
	 */
}
