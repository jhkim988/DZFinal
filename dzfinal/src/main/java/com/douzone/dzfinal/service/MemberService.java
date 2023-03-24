package com.douzone.dzfinal.service;

<<<<<<< HEAD
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

=======
import com.douzone.dzfinal.dto.LoginRequest;
import com.douzone.dzfinal.dto.RegisterRequest;
import com.douzone.dzfinal.entity.Member;
>>>>>>> main
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
	
}
