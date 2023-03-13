package com.douzone.dzfinal.service;

import com.douzone.dzfinal.dto.ReservationResponse;
import com.douzone.dzfinal.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationResponse.Month> monthList(String start, String end) {
        return reservationRepository.monthList(start, end);
    }

    public List<ReservationResponse.Week> weekList(String start, String end) {
        return reservationRepository.weekList(start, end);
    }

    public List<ReservationResponse.Day> dayList(String target) {
        return reservationRepository.dayList(target);
    }
}
