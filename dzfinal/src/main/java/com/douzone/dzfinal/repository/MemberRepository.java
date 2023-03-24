package com.douzone.dzfinal.repository;

import com.douzone.dzfinal.dto.RegisterRequest;

//@Mapper
public interface MemberRepository {
	boolean insert(RegisterRequest RegisterRequest);
}
