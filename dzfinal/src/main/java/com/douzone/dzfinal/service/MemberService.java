package com.douzone.dzfinal.service;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.douzone.dzfinal.dto.LoginRequest;
import com.douzone.dzfinal.dto.RegisterRequest;
import com.douzone.dzfinal.entity.Member;
import com.douzone.dzfinal.repository.MemberRepository;

@Service
public class MemberService {
	
	private final MemberRepository memberRepository;
//	private PasswordEncoder passwordEncoder;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
//		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public boolean register(RegisterRequest registerRequest) {
		return memberRepository.insert(registerRequest);
	}
	
	public Member login(LoginRequest loginRequest) {
		Member member = memberRepository.findOneById(loginRequest.getId());
//		if (member == null || !passwordEncoder.matches(loginRequest.getPwd(), member.getPwd())) throw new IllegalArgumentException();
		return member;
	}
}
