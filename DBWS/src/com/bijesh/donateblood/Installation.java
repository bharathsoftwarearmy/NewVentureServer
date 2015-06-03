package com.bijesh.donateblood;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.bijesh.donateblood.dao.InstallationDAO;


/**
 * Servlet implementation class Installation
 */
@WebServlet("/Installation")
public class Installation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Installation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		TODO: get the response and initialise the Installation class 
		
		com.bijesh.donateblood.models.Installation installation = new com.bijesh.donateblood.models.Installation();
		
//		installation.setUniqueId(request.getParameter("uniqueID"));
//		installation.setTime(request.getParameter("time"));
//		installation.setTimezone(request.getParameter("timezone"));
		System.out.println("uniID from request "+request.getParameter("uniqueID"));
		System.out.println("data "+request.getParameterNames());
		
		Enumeration es = request.getParameterNames();
		String responseAsString = new String();
		
		while (es.hasMoreElements()) {
			Object object = (Object) es.nextElement();
			responseAsString = object.toString();
		}
		
		try{
			
	    System.out.println("$$$ response as string "+responseAsString);
			
		JSONObject jsonObject = new JSONObject(responseAsString);
		JSONObject data = jsonObject.getJSONObject("Data");
		
		String uniqueId = data.getString("uniqueID");
		String time = data.getString("time");
		String timeZone = data.getString("timezone");
		
		installation.setUniqueId(uniqueId);
		installation.setTime(time);
		installation.setTimezone(timeZone);
		
		System.out.println("$$$ uniqueId "+uniqueId);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		String res = new InstallationDAO().insertDeviceInstallation(installation);
		response.getWriter().write(res);
	}

}
