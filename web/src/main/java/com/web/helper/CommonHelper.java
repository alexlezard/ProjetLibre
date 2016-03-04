package com.web.helper;

import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
  
import org.springframework.validation.Errors;  
import org.springframework.validation.ValidationUtils;  
import org.springframework.validation.Validator;  

public class CommonHelper {
	
	 private static Pattern pattern;  
	 private static Matcher matcher;  
	  
	 private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
	   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";  
	
	 public static boolean emailValidator(String email) {
		if (!(email != null && email.isEmpty())) 
		{  
			pattern = Pattern.compile(EMAIL_PATTERN);  
			matcher = pattern.matcher(email);  
			if (matcher.matches())  
				return true;
		}
		return false;
		
	}
}
