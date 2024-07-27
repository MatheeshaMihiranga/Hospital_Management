package servletProcess;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.IUDProcess;

@WebServlet("/AdminNewAdminProcess")
public class AdminNewAdminProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("Email");
		String name = request.getParameter("Name");
		String gender = request.getParameter("Gender");
		String password = request.getParameter("Password");
		String mobile = request.getParameter("Mobile");

		boolean status = IUDProcess.AddNewAdminProcess(email, name, gender, password, mobile);

		
		if(status == true) {
			RequestDispatcher dis = request.getRequestDispatcher("AdminDashboard.jsp");
			dis.forward(request, response);
			
		}else if(status == false) {
			RequestDispatcher dis = request.getRequestDispatcher("ErrorPage.jsp");
			dis.forward(request, response);
		}
	}

}
