package com.douzone.dzfinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.dzfinal.entity.Reservation;
import com.douzone.dzfinal.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepository;

	public List<Reservation> todayReservationList() {
		return reservationRepository.todayReservationList();
	}

//	public Reservation selectedReservationDetails(int reservation_id){
//		return reservationRepository.selectedReservationDetails(reservation_id);
//	}
	public Reservation selectedReservationDetails(int reservation_id) {
		return reservationRepository.selectedReservationDetails(reservation_id)
				.orElseThrow(IllegalArgumentException::new);
	}

}
