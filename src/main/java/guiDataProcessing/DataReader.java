package guiDataProcessing;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * In this class will be processed requests from JSP pages. Later can be use URL filter, or Spring framework for request 
 * handle
 */
@WebServlet("/addStaffMember")
public class DataReader extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		
		String firstName = request.getParameter("firstname");
		String surname = request.getParameter("surname");
		String city = request.getParameter("city");
		String postalCode = request.getParameter("postalCode");
		String street = request.getParameter("street");
		String houseNumber = request.getParameter("houseNumber");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		
    }
}
