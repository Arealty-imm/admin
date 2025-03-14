package w_admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class notice_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pageno = request.getParameter("pageno");
		
		if(pageno == null || pageno.equals("1")) { 
			pageno = "0";	
		}
		
		m_noticelist nl = new m_noticelist(Integer.parseInt(pageno));
		ArrayList<ArrayList<String>> result = nl.db_data();
		
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("./notice_list.jsp");
		rd.forward(request, response);
	}

}
