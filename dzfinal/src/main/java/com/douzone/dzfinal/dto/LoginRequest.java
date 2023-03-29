package com.douzone.dzfinal.dto;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Data
public class LoginRequest {
	private String id;
	private String pwd;
	
	public static class LoginRequestValidator implements Validator {

		@Override
		public boolean supports(Class<?> clazz) {
			return LoginRequest.class.isAssignableFrom(clazz);
		}

		@Override
		public void validate(Object target, Errors errors) {
			LoginRequest loginRequest = (LoginRequest) target;
			if (loginRequest.getId() == null || loginRequest.getId().trim().isEmpty()) {
				errors.rejectValue("id", "required");
			}
			if (loginRequest.getPwd() == null || loginRequest.getPwd().trim().isEmpty()) {
				errors.rejectValue("pwd", "required");
			}
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");
		}
	}
}