package com.douzone.dzfinal.repository;

import com.douzone.dzfinal.dto.ReservationResponse;
import com.douzone.dzfinal.entity.Reservation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ReservationRepository {
    List<ReservationResponse.Month> monthList(String start, String end);
    List<ReservationResponse.Week> weekList(String start, String end);
    List<ReservationResponse.Day> dayList(String target);
    Optional<Reservation> findOneById(int reservation_id);
}
