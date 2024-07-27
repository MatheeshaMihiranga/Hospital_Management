package servletProcess;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.details.DoctorDetails;
import com.java.IUDProcess;


@WebServlet("/DoctorUpdateProfileProcessServlet")
public class DoctorUpdateProfileProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String email = request.getParameter("email");
	String Name = request.getParameter("Name");
	String mobile = request.getParameter("mobile");
	String gender = request.getParameter("gender");
	String age = request.getParameter("age");
	
	boolean status =IUDProcess.DoctorUpdateProfile(email, Name, mobile, gender, age);
	
	if(status == true) {
		RequestDispatcher dis = request.getRequestDispatcher("DoctorUpdate.jsp");
		dis.forward(request, response);
		
	}else if(status == false) {
		RequestDispatcher dis = request.getRequestDispatcher("ErrorPage.jsp");
		dis.forward(request, response);
		
		
	}
	
	
	}
}
