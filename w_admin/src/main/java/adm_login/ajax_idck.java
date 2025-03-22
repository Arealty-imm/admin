package adm_login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import w_admin.m_dbinfo;


public class ajax_idck extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    m_dbinfo db = null;
	PrintWriter pw = null;
	String sql = "";
	int result = 0;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.db = new m_dbinfo();
		this.pw = response.getWriter();
		
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Credentials","true");
		String adm_id = request.getParameter("adm_id");
		
		
		try {
			this.con = this.db.db_info();
			this.sql = "select adm_id from adm_info where adm_id = ?;";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, adm_id);
			this.rs = this.ps.executeQuery();
			
			if (this.rs.next()) {
		        this.result = 1;  // 아이디가 존재하면 1
		    } 
			else {
		        this.result = 0;  // 아이디가 존재하지 않으면 0
		    }
		}
		catch (Exception e) {
			System.out.println(e);
		} 
		finally {
			try {
				this.rs.close();
				this.ps.close();
				this.con.close();
				
			} 
			catch (Exception e2) {
				System.out.println(e2);
			}
		}
		 pw.write(String.valueOf(this.result));  // 1 또는 0 응답
	     pw.flush();  // 스트림을 플러시하여 전송
	}

}
