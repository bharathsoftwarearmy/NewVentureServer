package com.bijesh.donateblood.utils;

public class ResponseUtil {
	
	public static String getSuccessResponse(){
		String response = "{\"response\":{"+
       "\"code\":\"2000\","+
       "\"description\":\"reponse desc here\","+
       "\"severity\":\","+
       "\"level\":\"\"}"+"}";
		return response;
	}

}
