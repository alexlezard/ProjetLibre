package com.web.helper;

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.validation.Errors;  
import org.springframework.validation.ValidationUtils;  
import org.springframework.validation.Validator;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;  

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
	 
	public static String toSha1(String password)
	{
	        MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
	        md.update(password.getBytes());
	        
	        byte byteData[] = md.digest();
	 
	        //convert the byte to hex format method 1
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	        
	        //convert the byte to hex format method 2
	        StringBuffer hexString = new StringBuffer();
	    	for (int i=0;i<byteData.length;i++) {
	    		String hex=Integer.toHexString(0xff & byteData[i]);
	   	     	if(hex.length()==1) hexString.append('0');
	   	     	hexString.append(hex);
	    	}
	    	return hexString.toString();
	   }

	   private static String createJWT(String id, String issuer, String subject, long ttlMillis) {

		 //The JWT signature algorithm we will be using to sign the token
		 SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		 
		 long nowMillis = System.currentTimeMillis();
		 Date now = new Date(nowMillis);

		 //We will sign our JWT with our ApiKey secret
		 byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("tokensecret");
		 Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		   //Let's set the JWT Claims
		 JwtBuilder builder = Jwts.builder().setId(id)
		                                 .setIssuedAt(now)
		                                 .setSubject(subject)
		                                 .setIssuer(issuer)
		                                 .signWith(signatureAlgorithm, signingKey);

		  //if it has been specified, let's add the expiration
		 if (ttlMillis >= 0) {
		     long expMillis = nowMillis + ttlMillis;
		     Date exp = new Date(expMillis);
		     builder.setExpiration(exp);
		 }

		  //Builds the JWT and serializes it to a compact, URL-safe string
		 return builder.compact();
		 }
}
