package add_master;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import w_admin.m_dbinfo;



public class add_masterok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PrintWriter pw = null;
	PreparedStatement ps = null;
	String sql = "";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.pw = response.getWriter();
		m_dbinfo db = new m_dbinfo();
		
		try {
			this.con = db.db_info();
			//md_5 모델 추가 pw 수정
			
			 this.sql = "INSERT INTO adm_info (admidx, adm_id, adm_pass, adm_emails, adm_name, adm_tel1, "
			           + "adm_tel2, adm_tel3, adm_dp, adm_pos, adm_date) "
			           + "VALUES (0, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1,request.getParameter("adm_id"));
			this.ps.setString(2,request.getParameter("adm_pass"));
			this.ps.setString(3,request.getParameter("adm_emails"));
			this.ps.setString(4,request.getParameter("adm_name"));
			this.ps.setString(5,request.getParameter("adm_tel1"));
			this.ps.setString(6,request.getParameter("adm_tel2"));
			this.ps.setString(7,request.getParameter("adm_tel3"));
			this.ps.setString(8,request.getParameter("adm_dp"));
			this.ps.setString(9,request.getParameter("adm_pos"));
			
			int result = this.ps.executeUpdate();
			
			if(result > 0) {
				this.pw.write("<script>"
						+ "alert('관리자 회원가입이 정상적으로 완료 되었습니다.')"
						+ "location.href='./index.html'"
						+ "</script>");
			}
			
		} catch (Exception e) {
			System.out.println("db error 발생 : "+e);
		}finally {
			try {
				this.ps.close();
				this.con.close();
				this.pw.close();				
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}

}
