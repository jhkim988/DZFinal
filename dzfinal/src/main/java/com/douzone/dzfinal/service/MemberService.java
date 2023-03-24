package com.douzone.dzfinal.service;

import com.douzone.dzfinal.dto.LoginRequest;
import com.douzone.dzfinal.dto.RegisterRequest;
import com.douzone.dzfinal.entity.Member;
import com.douzone.dzfinal.repository.MemberRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	private MemberRepository memberRepository = null;
//	private PasswordEncoder passwordEncoder;
	
//	public MemberService(MemberRepository memberRepository) {
//		this.memberRepository = memberRepository;
//		this.passwordEncoder = new BCryptPasswordEncoder();
//	}
	
	public boolean register(RegisterRequest registerRequest) {
		return memberRepository.insert(registerRequest);
	}
	
	public Member login(LoginRequest loginRequest) {
		Member member = memberRepository.findOneById(loginRequest.getId());
//		if (member == null || !passwordEncoder.matches(loginRequest.getPwd(), member.getPwd())) throw new IllegalArgumentException();
		return member;
	}
	
	@Cacheable(key = "#id", value = "cacheTest")
	public Member cacheTest(String id) {
		System.out.println("cacheTest");
		return new Member(id, "pwd");
	}
}
