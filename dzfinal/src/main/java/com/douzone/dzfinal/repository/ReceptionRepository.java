package com.douzone.dzfinal.repository;

import com.douzone.dzfinal.dto.ReceptionDTO;
import com.douzone.dzfinal.dto.WaitingDTO;
import com.douzone.dzfinal.entity.Reception;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Mapper
public interface ReceptionRepository {
	
	public List<Reception> receptionList();

	List<WaitingDTO.WaitingData> todayList();
	
	public int insertReception(Reception reception);
	
	public void updateTodayReservationState(Reception reception);
	public void deleteReception(Reception reception);
	
	void update(WaitingDTO.WaitingData data);
	Optional<Reception> findOneById(int reception_id);
	ReceptionDTO.Detail detail(int reception_id);
	
	public void updateReceptionInfo(Reception reception);
	Optional<WaitingDTO.WaitingData> findReceptionInfoById(int reception_id);
}
