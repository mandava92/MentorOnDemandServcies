package com.mentorondemand.user.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mentorondemand.user.dto.UserDTO;

public class UserValidator implements ConstraintValidator<UserValidation,UserDTO>{

	public boolean isValid(UserDTO value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return true;
	}

}
