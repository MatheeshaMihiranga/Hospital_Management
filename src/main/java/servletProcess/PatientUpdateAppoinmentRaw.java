package servletProcess;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.IUDProcess;

@WebServlet("/PatientUpdateAppoinmentRaw")
public class PatientUpdateAppoinmentRaw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Appoinment_ID = request.getParameter("UpdateBtn");

		String Date = request.getParameter("Date");
		String Time = request.getParameter("Time");
		String Problem = request.getParameter("problem");

		boolean status = IUDProcess.PatientUpdateAppoinent(Appoinment_ID, Date, Time, Problem);
		
		if(status == true) {
			
			RequestDispatcher dis = request.getRequestDispatcher("AppoinmentRequest.jsp");
			dis.forward(request, response);
			
		}else if(status == false){
			RequestDispatcher dis = request.getRequestDispatcher("ErrorPage.jsp");
			dis.forward(request, response);
				
		}

	}

}
