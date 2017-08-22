/*package com.cogzy.gtruckways.validator;


	import org.springframework.stereotype.Component;
	import org.springframework.validation.Errors;
	import org.springframework.validation.ValidationUtils;
	import org.springframework.validation.Validator;

import com.cogzy.gtruckways.valueObjects.UserPostInfo;
	 
	 
	@Component
	public class UserInfoValidator implements Validator  {

	 
	    public boolean supports(Class clazz) {
	        return UserPostInfo.class.isAssignableFrom(clazz);
	    }
	 
	    public void validate(Object target, Errors errors) 
	    {
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.userName", "User name is required.");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileNo", "error.mobileNo", "Mobile No is required.");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email", "Email is required.");
	    }
	 
	}
	*/
