package com.douzone.dzfinal.controller;

import com.douzone.dzfinal.dto.ReservationResponse;
import com.douzone.dzfinal.entity.Reservation;
import com.douzone.dzfinal.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/month")
    public List<ReservationResponse.Month> monthList(@RequestParam String start, @RequestParam String end) {
        return reservationService.monthList(start, end);
    }

    @GetMapping("/week")
    public List<ReservationResponse.Week> weekList(@RequestParam String start, @RequestParam String end) {
        return reservationService.weekList(start, end);
    }

    @GetMapping("/day")
    public List dayList(@RequestParam String target) {
        return reservationService.dayList(target);
    }

    @GetMapping("/{reservation_id}")
    public Reservation detail(@PathVariable("reservation_id") @Digits(integer = 8, fraction = 0) @Min(0) int reservation_id) {
        return reservationService.details(reservation_id);
    }
}
