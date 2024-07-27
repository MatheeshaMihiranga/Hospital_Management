package servletProcess;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.IUDProcess;

@WebServlet("/PatientDeleteAppoinmentRawServlet")
public class PatientDeleteAppoinmentRawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Appo_ID = request.getParameter("Deletebtn");

		boolean status = IUDProcess.PatientDeleteAppoinmentRaw(Appo_ID);
		if (status == true) {

			RequestDispatcher dis = request.getRequestDispatcher("AppoinmentRequest.jsp");
			dis.forward(request, response);

		} else if (status == false) {
			RequestDispatcher dis = request.getRequestDispatcher("ErrorPage.jsp");
			dis.forward(request, response);

		}

	}

}
