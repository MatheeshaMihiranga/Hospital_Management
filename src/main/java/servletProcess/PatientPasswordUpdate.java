package servletProcess;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.details.PatientDetails;
import com.java.IUDProcess;
import com.java.myConn;

@WebServlet("/PatientPasswordUpdate")
public class PatientPasswordUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Currunt = request.getParameter("currentPassword");
		String New = request.getParameter("newPassword");
		String confirm = request.getParameter("confirmPassword");
		
		
	

		try {
			ResultSet prs = myConn.execute("SELECT * FROM `patient` WHERE `email` = '" + PatientDetails.getEmail() + "' ");
			
			if (prs.next()) {
				
				System.out.println(prs.getString(1));				

				if (New.equals(confirm)) {
					

					Boolean status = IUDProcess.PatientUpdatePasswordProcess(New);
					
					

					if (status == true) {
						
						RequestDispatcher dis = request.getRequestDispatcher("PatientUpdate.jsp");
						dis.forward(request, response);
					} else if (status == false) {
						
						RequestDispatcher dis = request.getRequestDispatcher("ErrorPage.jsp");
						dis.forward(request, response);
					}
				}

			} 
			
			
			else {
				
				RequestDispatcher dis = request.getRequestDispatcher("ErrorPage.jsp");
				dis.forward(request, response);
			}

		} catch (Exception e) {
			
			RequestDispatcher dis = request.getRequestDispatcher("ErrorPage.jsp");
			dis.forward(request, response);
			e.printStackTrace();
		}

	}

}