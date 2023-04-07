package com.douzone.dzfinal.service;

import com.douzone.dzfinal.dto.PatientDTO;
import com.douzone.dzfinal.dto.ReceptionDTO;
import com.douzone.dzfinal.dto.ReservationDTO;
import com.douzone.dzfinal.entity.Reservation;
import com.douzone.dzfinal.repository.PatientRepository;
import com.douzone.dzfinal.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final PatientRepository patientRepository;

    public List<ReceptionDTO.TodayReservationList> todayReservationList() {
		return reservationRepository.todayReservationList();
	}
    
    public ReservationService(ReservationRepository reservationRepository, PatientRepository patientRepository) {
        this.reservationRepository = reservationRepository;
        this.patientRepository = patientRepository;
    }

    public List<ReservationDTO.Month> monthList(String start, String end) {
        return reservationRepository.monthList(start, end);
    }

    public List<ReservationDTO.Week> weekList(String start, String end) {
        return reservationRepository.weekList(start, end);
    }

    public List<ReservationDTO.Day> dayList(String target) {
        return reservationRepository.dayList(target);
    }

    public Reservation details(int reservation_id) {
        return reservationRepository.findOneById(reservation_id).orElseThrow(IllegalArgumentException::new);
    }
    
    public ReceptionDTO.DetailTodayReservationList detailTodayReservationList(int reservation_id) {
    	return reservationRepository.detailTodayReservationList(reservation_id).orElseThrow(IllegalArgumentException::new);
    }
    
    public void updateTodayReservationPatientId(PatientDTO.UpdateDailyReservationList patient) {
    	reservationRepository.updateTodayReservationPatientId(patient);
    }

    public int save(Reservation reservation) {
        reservationRepository.save(reservation);
        PatientDTO.PhoneNumbers phoneNumber = PatientDTO.PhoneNumbers.builder()
                .phone_number1(reservation.getPhone_number1())
                .phone_number2(reservation.getPhone_number2())
                .phone_number3(reservation.getPhone_number3())
                .build();
//        patientRepository.findOneByPhone(phoneNumber).ifPresent(patient -> {
//            reservation.setPatient_id(patient.getPatient_id());
//            reservationRepository.update(reservation);
//        });
        return reservation.getReservation_id();
    }

    public void update(Reservation reservation) {
        reservationRepository.update(reservation);
    }

    public List<String> impossibleDay(int doctor, int year, int month) {
        return reservationRepository.impossibleDay(doctor, year, month);
    }

    public List<String> impossibleTime(int doctor, String date) {
        return reservationRepository.impossibleTime(doctor, date);
    }
}
