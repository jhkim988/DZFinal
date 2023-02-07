package com.douzone.dzfinal.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.douzone.dzfinal.dto.RegisterRequest;
import com.douzone.dzfinal.entity.Member;

@Repository
@Mapper
public interface MemberRepository {
	boolean insert(RegisterRequest RegisterRequest);
	Member findOneById(String id);
}
