package servletProcess;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.IUDProcess;

@WebServlet("/DoctorRegisterProcessServlet")
public class DoctorRegisterProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Email = request.getParameter("Email");
		String Name = request.getParameter("Name");
		String mobile = request.getParameter("gender");
		String age = request.getParameter("age");
		String password = request.getParameter("password");

		boolean status = IUDProcess.DoctorRegisterProcess(Email, Name, mobile, age, password);
		
		if(status == true) {
			RequestDispatcher dis = request.getRequestDispatcher("DoctorLogin.jsp");
			dis.forward(request, response);
		}else if(status == false){
			RequestDispatcher dis = request.getRequestDispatcher("ErrorPage.jsp");
			dis.forward(request, response);
			
		}
		

	}

}
