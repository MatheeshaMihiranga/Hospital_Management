package servletProcess;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.IUDProcess;

@WebServlet("/AdminDeleteAppoinmentProcess")
public class AdminDeleteAppoinmentProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Appo_ID = request.getParameter("Deletebtn");

		boolean status = IUDProcess.AdminDeleteappoinemnt(Appo_ID);
		
		if(status == true) {
			RequestDispatcher dis = request.getRequestDispatcher("Appinment.jsp");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis = request.getRequestDispatcher("ErroPage.jsp");
			dis.forward(request, response);
		}

	}

}
