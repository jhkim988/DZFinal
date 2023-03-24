package com.douzone.dzfinal.controller;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.douzone.dzfinal.dto.LoginRequest;
//import com.douzone.dzfinal.dto.RegisterRequest;
//import com.douzone.dzfinal.entity.Member;
//import com.douzone.dzfinal.service.MemberService;
//
//import io.swagger.annotations.ApiOperation;
//
//@RestController
//@RequestMapping("/api/member")
//public class MemberController {
//
//	@Autowired
//	private MemberService memberService;
//	
//	@ApiOperation("dd")
//	@PostMapping("/register")
//	public ResponseEntity<Object> register(@RequestBody RegisterRequest registerRequest, Errors errors) {
//		boolean result = memberService.register(registerRequest);
//		return ResponseEntity.status(HttpStatus.OK).body(result);
//	}
//	
//	@PostMapping("/login")
//	public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest, Errors errors, HttpServletRequest request) {
//		new LoginRequest.LoginRequestValidator().validate(loginRequest, errors);
//		if (errors.hasErrors()) throw new IllegalArgumentException(errors.toString());
//		Member member = memberService.login(loginRequest);
//		request.getSession().setAttribute("member", member);
//		return ResponseEntity.status(HttpStatus.OK).body(member != null);
//	}
//	
//	@GetMapping("/cacheTest")
//	public String cacheTest(@RequestParam String id) {
//		System.out.println("controller: " + memberService.cacheTest(id));
//		return "";
//	}
//}

import com.douzone.dzfinal.dto.LoginRequest;
import com.douzone.dzfinal.dto.RegisterRequest;
import com.douzone.dzfinal.entity.Member;
import com.douzone.dzfinal.service.MemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@ApiOperation("dd")
	@PostMapping("/register/")
	public ResponseEntity<Object> register(@RequestBody RegisterRequest registerRequest, Errors errors) {
		boolean result = memberService.register(registerRequest);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest, Errors errors, HttpServletRequest request) {
		new LoginRequest.LoginRequestValidator().validate(loginRequest, errors);
		if (errors.hasErrors()) throw new IllegalArgumentException(errors.toString());
		Member member = memberService.login(loginRequest);
		request.getSession().setAttribute("member", member);
		return ResponseEntity.status(HttpStatus.OK).body(member != null);
	}
	
	@GetMapping("/cacheTest")
	public String cacheTest(@RequestParam String id) {
		System.out.println("controller: " + memberService.cacheTest(id));
		return "";
	}
}
