package com.douzone.dzfinal.repository;

import com.douzone.dzfinal.dto.ReceptionDTO;
import com.douzone.dzfinal.dto.ReservationDTO;
import com.douzone.dzfinal.entity.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ReservationRepository {
	List<ReceptionDTO.TodayReservationList> todayReservationList();
    List<ReservationDTO.Month> monthList(@Param("start") String start, @Param("end") String end);
    List<ReservationDTO.Week> weekList(@Param("start") String start, @Param("end") String end);
    List<ReservationDTO.Day> dayList(String target);
    Optional<Reservation> findOneById(int reservation_id);
    int save(Reservation reservation);
    void update(Reservation reservation);
    List<String> impossibleDay(@Param("doctor") int doctor, @Param("year") int year, @Param("month") int month);
    List<String> impossibleTime(@Param("doctor") int doctor, @Param("date") String date);
    
    //접수화면 당일예약현황에서 환자 클릭시 환자(초진/재진) 정보 조회 기능
    Optional<ReceptionDTO.DetailTodayReservationList> detailTodayReservationList(int reservation_id);
}
