package com.douzone.dzfinal.controller;

import com.douzone.dzfinal.dto.ReservationResponse;
import com.douzone.dzfinal.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
