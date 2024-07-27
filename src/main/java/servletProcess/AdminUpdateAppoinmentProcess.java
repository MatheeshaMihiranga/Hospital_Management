package servletProcess;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.IUDProcess;

@WebServlet("/AdminUpdateAppoinmentProcess")
public class AdminUpdateAppoinmentProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Appoinment_id = request.getParameter("UpdateBtn");

		boolean status = IUDProcess.AdminUpdateAppoinmentStatusProcess(Appoinment_id);
		
		if(status == true) {
			
			RequestDispatcher dis = request.getRequestDispatcher("Appinment.jsp");
			dis.forward(request, response);
			
		}else if(status == false) {
			
			RequestDispatcher dis = request.getRequestDispatcher("ErrorPage.jsp");
			dis.forward(request, response);
			
		}

	}

}
