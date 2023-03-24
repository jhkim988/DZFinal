package com.douzone.dzfinal.service;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.douzone.dzfinal.repository.MemberRepository;

@Service
public class MemberService {
	private final MemberRepository memberRepository;
//	private PasswordEncoder passwordEncoder;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
//		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
}
