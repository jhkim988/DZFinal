package com.douzone.dzfinal.controller;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.dzfinal.entity.Reservation;
import com.douzone.dzfinal.service.ReservationService;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping
	public List<Reservation> todayReservationList(){
		return reservationService.todayReservationList();
	}
	
//	@GetMapping("/{reservation_id}")
//	public List<Reservation> selectedReservationDetails(@PathVariable("reservation_id")int reservation_id){
//		return reservationService.selectedReservationDetails(reservation_id);
//	}
	@GetMapping("/{reservation_id}")
	public Reservation  selectedReservationDetails(@PathVariable("reservation_id") @Digits(integer = 8, fraction = 0) @Min(0) int reservation_id){
		return reservationService.selectedReservationDetails(reservation_id);
	}
}
