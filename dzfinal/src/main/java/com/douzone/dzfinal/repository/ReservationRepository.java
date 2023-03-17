package com.douzone.dzfinal.repository;

import com.douzone.dzfinal.dto.ReservationDTO;
import com.douzone.dzfinal.entity.Reservation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ReservationRepository {
    List<ReservationDTO.Month> monthList(String start, String end);
    List<ReservationDTO.Week> weekList(String start, String end);
    List<ReservationDTO.Day> dayList(String target);
    Optional<Reservation> findOneById(int reservation_id);
    void save(Reservation reservation);
    void update(Reservation reservation);
}
