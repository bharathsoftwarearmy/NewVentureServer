package com.bijesh.donateblood.utils;

public class ResponseUtil {
	
	public static String getSuccessResponse(){
		String response = "{\"response\":{"+
       "\"code\":\"2000\","+
       "\"description\":\"Success\","+
       "\"severity\":\","+
       "\"level\":\"\"}"+"}";
		return response;
	}
	
	public static String getErrorResponse(){
		String response = "{\"response\":{"+
			       "\"code\":\"1000\","+
			       "\"description\":\"failure\","+
			       "\"severity\":\","+
			       "\"level\":\"\"}"+"}";
					return response;
	}

}
