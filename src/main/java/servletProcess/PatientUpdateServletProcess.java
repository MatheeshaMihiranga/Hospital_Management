package servletProcess;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.IUDProcess;

@WebServlet("/PatientUpdateServletProcess")
public class PatientUpdateServletProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Name = request.getParameter("Name");
		String mobile = request.getParameter("mobile");
		String Gender = request.getParameter("gender");
		String Age = request.getParameter("age");
		
		
	boolean status = 	IUDProcess.PateintUpdateProfileProcess(Name,mobile,Gender,Age);
		
		if(status == true) {
			RequestDispatcher dis = request.getRequestDispatcher("PatientUpdate.jsp");
			dis.forward(request, response);
			
		}else if(status == false) {
			RequestDispatcher dis = request.getRequestDispatcher("ErrorPage.jsp");
			dis.forward(request, response);
			
		}
		
	}

}
