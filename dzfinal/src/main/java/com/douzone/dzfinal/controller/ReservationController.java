package com.douzone.dzfinal.controller;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.dzfinal.dto.ReceptionDTO;
import com.douzone.dzfinal.dto.ReceptionDTO.DetailTodayReservationList;
import com.douzone.dzfinal.dto.ReservationDTO;
import com.douzone.dzfinal.entity.Reservation;
import com.douzone.dzfinal.service.ReservationService;

@Validated
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    
    @GetMapping
	public List<ReceptionDTO.TodayReservationList> todayReservationList(){
		return reservationService.todayReservationList();
	}

    @GetMapping("/month")
    public List<ReservationDTO.Month> monthList(@RequestParam String start, @RequestParam String end) {
        return reservationService.monthList(start, end);
    }

    @GetMapping("/week")
    public List<ReservationDTO.Week> weekList(@RequestParam String start, @RequestParam String end) {
        return reservationService.weekList(start, end);
    }

    @GetMapping("/day")
    public List dayList(@RequestParam String target) {
        return reservationService.dayList(target);
    }

    @GetMapping("/{reservation_id}")
    public Reservation detail(@PathVariable("reservation_id") @Digits(integer = 8, fraction = 0) @Min(0) int reservation_id) {
        Reservation reservation = reservationService.details(reservation_id);
        return reservation;
    }
    
    @GetMapping("/detail/{reservation_id}")
    public ReceptionDTO.DetailTodayReservationList detailTodayReservationList(@PathVariable("reservation_id") @Digits(integer = 8, fraction = 0) @Min(0) int reservation_id) {
    	DetailTodayReservationList reservation = reservationService.detailTodayReservationList(reservation_id);
        return reservation;
    }

    @PostMapping
    public int save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @PutMapping
    public void update(@RequestBody Reservation reservation) {
        reservationService.update(reservation);
    }

    @GetMapping("/impossible/day")
    public List<String> impossibleDay(@RequestParam int doctor, @RequestParam int year, @RequestParam int month) {
        return reservationService.impossibleDay(doctor, year, month);
    }

    @GetMapping("/impossible/time")
    public List<String> impossibleTime(@RequestParam int doctor, @RequestParam String date) {
        return reservationService.impossibleTime(doctor, date);
    }
}
