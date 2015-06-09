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
	
	public static String getErrorResponse(String message){
		String response = "{\"response\":{"+
			       "\"code\":\"1000\","+
			       "\"description\":\""+message+"\","+
			       "\"severity\":\"\","+
			       "\"level\":\"\"}"+"}";
					return response;
	}

}
