package com.douzone.dzfinal.repository;

import com.douzone.dzfinal.dto.ReservationDTO;
import com.douzone.dzfinal.entity.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ReservationRepository {
	List<Reservation> todayReservationList();
    List<ReservationDTO.Month> monthList(@Param("start") String start, @Param("end") String end);
    List<ReservationDTO.Week> weekList(@Param("start") String start, @Param("end") String end);
    List<ReservationDTO.Day> dayList(String target);
    Optional<Reservation> findOneById(int reservation_id);
    int save(Reservation reservation);
    void update(Reservation reservation);
    List<String> impossibleDay(@Param("doctor") int doctor, @Param("year") int year, @Param("month") int month);
    List<String> impossibleTime(@Param("doctor") int doctor, @Param("date") String date);
}
