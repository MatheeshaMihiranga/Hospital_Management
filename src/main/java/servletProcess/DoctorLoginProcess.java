package servletProcess;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.IUDProcess;

@WebServlet("/DoctorLoginProcess")
public class DoctorLoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String DoctorEmail = request.getParameter("email");
		String password = request.getParameter("password");

		boolean status = IUDProcess.DoctorLoginProcess(DoctorEmail, password);

		if (status == true) {
			
			
			RequestDispatcher dis = request.getRequestDispatcher("DoctorDashboard.jsp");
			dis.forward(request, response);

		} else if (status == false) {
			RequestDispatcher dis = request.getRequestDispatcher("ErrorPage.jsp");
			dis.forward(request, response);

		}

	}

}
