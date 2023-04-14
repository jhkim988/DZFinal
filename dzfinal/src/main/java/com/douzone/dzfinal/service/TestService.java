package com.douzone.dzfinal.service;

import com.douzone.dzfinal.dto.ChatDTO;
import com.douzone.dzfinal.dto.PatientDTO;
import com.douzone.dzfinal.entity.Patient;
import com.douzone.dzfinal.entity.Receipt;
import com.douzone.dzfinal.entity.Reception;
import com.douzone.dzfinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TestService {


    @Autowired
    private ReceptionRepository receptionRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private ChatRepository chatRepository;

    public List<Integer> addPatient(int num) {
        List<Integer> patientIds = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            PatientDTO.UpdateDailyReservationList dto = PatientDTO.UpdateDailyReservationList.builder()
                    .patient_name("_test" + i)
                    .phone_number1("010")
                    .phone_number2("1234")
                    .phone_number3("5678")
                    .front_registration_number("123")
                    .back_registration_number("456")
                    .gender("M")
                    .zip_code("12345")
                    .address("서울시 강남구")
                    .detail_address("테스트동")
                    .insurance(true)
                    .build();
            patientRepository.insertPatient(dto);
            patientIds.add(dto.getPatient_id());
        }
        return patientIds;
    }

    public List<Integer> addReception(List<Integer> patientIds) {
        List<Integer> receptionIds = new ArrayList<>();
        for (int i = 0; i < patientIds.size(); i++) {
            Reception reception = Reception.builder()
                            .patient_id(patientIds.get(i))
                                    .doctor(1)
                                    .treatment_reason("테스트")
                                    .build();
            receptionRepository.insertReception(reception);
            receptionIds.add(reception.getReception_id());
        }
        return receptionIds;
    }

    public void addClinic(List<Integer> receptionIds) {
        for (int i = 0; i < receptionIds.size(); i++) {
            clinicRepository.insertClinic(receptionIds.get(i)
                , "테스트"
                , true
                , true
                , 1);
        }
    }

    public void addReceipt(List<Integer> receptionIds) {
        for (int i = 0; i < receptionIds.size(); i++) {
            receiptRepository.insertReceipt(Receipt.builder()
                    .reception_id(receptionIds.get(i))
                            .total_amount(10000)
                            .ratio(0.9)
                            .card_name("신한카드")
                            .card_number("1234567890123456")
                            .mode("카드")
                    .build());
    }
    }

    public void addChat(int num) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        	for (int i = 0; i < num; i++) {
        		chatRepository.insert(ChatDTO.Message.builder()
                        .chatroom_id(1)
                        .message("테스트" + i)
                        .created_at(format.format(new Date()))
                        .from(1)
                        .build());
        	}
    }
}
