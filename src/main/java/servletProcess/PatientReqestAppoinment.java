package servletProcess;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.IUDProcess;

@WebServlet("/PatientReqestAppoinment")
public class PatientReqestAppoinment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Patient_Email = request.getParameter("PatientEmail");
		String PatientName = request.getParameter("PatientName");
		String Date = request.getParameter("Date");
		String Time = request.getParameter("Time");
		String Docotr_ID = request.getParameter("Docotr_ID");
		String Problem = request.getParameter("Problem");

		System.out
				.println(Patient_Email + " " + PatientName + " " + Date + " " + Time + " " + Docotr_ID + " " + Problem);

		boolean status = IUDProcess.PatientAppoinmentRequest(Patient_Email, PatientName, Date, Time, Docotr_ID,
				Problem);

		if (status == true) {
			RequestDispatcher dis = request.getRequestDispatcher("AppoinmentRequest.jsp");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis = request.getRequestDispatcher("ErrorPage.jsp");
			dis.forward(request, response);
		}

	}

}
