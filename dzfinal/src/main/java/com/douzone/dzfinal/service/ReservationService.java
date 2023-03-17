package com.douzone.dzfinal.service;

import com.douzone.dzfinal.dto.PatientDTO;
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

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
        PatientDTO.PhoneNumbers phoneNumber = PatientDTO.PhoneNumbers.builder()
                .phone1(reservation.getPhone1())
                .phone2(reservation.getPhone2())
                .phone3(reservation.getPhone3())
                .build();
        patientRepository.findOneByPhone(phoneNumber).ifPresent(patient -> {
            reservation.setPatient_id(patient.getPatient_id());
            reservationRepository.update(reservation);
        });
    }
}
