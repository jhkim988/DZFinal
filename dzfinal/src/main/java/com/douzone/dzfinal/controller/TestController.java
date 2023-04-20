package com.douzone.dzfinal.controller;

import com.douzone.dzfinal.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/receiptData")
    public void addPatientData(@RequestParam("numData") int num) {
        List<Integer> patientIds = testService.addPatient(num);
        List<Integer> receptionIds = testService.addReception(patientIds);
        testService.addClinic(receptionIds);
        testService.addReceipt(receptionIds);
    }

    @PostMapping("/chat")
    public void addChatData(@RequestParam("numData") int num) {
        testService.addChat(num);
    }
}
