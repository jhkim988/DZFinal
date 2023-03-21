package com.douzone.dzfinal.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.entity.Reservation;

@Repository
@Mapper
public interface ReservationRepository {

	public List<Reservation> todayReservationList();
	
//	public List<Reservation> selectedReservationDetails(int reservation_id);
	Optional<Reservation> selectedReservationDetails(int reservation_id);
}
