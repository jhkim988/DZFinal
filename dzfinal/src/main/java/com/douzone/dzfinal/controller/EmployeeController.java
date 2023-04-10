package com.douzone.dzfinal.controller;

import com.douzone.dzfinal.dto.EmployeeDTO;
import com.douzone.dzfinal.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.server.resource.authentication.JwtBearerTokenAuthenticationConverter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/{user_id}")
	public EmployeeDTO.EmployeeLoginInfo getEmployee(@PathVariable("user_id") String user_id) {
		return employeeService.getEmployee(user_id);
	}
	
	@GetMapping("/by_token")
	public EmployeeDTO.EmployeeInfo selectEmployeeInfo(Authentication auth){
		System.out.println(auth);
		OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) auth.getDetails();
		System.out.println(details.getDecodedDetails());
		return employeeService.selectEmployeeInfo("");
	}
}
