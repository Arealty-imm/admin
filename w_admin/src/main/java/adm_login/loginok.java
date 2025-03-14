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
import javax.servlet.http.HttpSession;

import add_master.m_md5;
import w_admin.m_dbinfo;


public class loginok extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PrintWriter pw = null;
    Connection con = null;
    PreparedStatement ps = null;
    m_dbinfo db = null;
    m_md5 md5 = null;
    String sql = "";
    ResultSet rs = null;
    HttpServlet hs = null;
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		this.db = new m_dbinfo();
		this.md5 = new m_md5();
		this.pw = response.getWriter();
		String adm_pw = request.getParameter("adm_pass");
		
		try {
			this.con = db.db_info();
			adm_pw = this.md5.md5_code(adm_pw); //md5 암호화
			String ad_id = "";
			String ad_ps = "";
			String ad_name = "";
			String ad_emails = "";
			
			this.sql = "select adm_id, adm_pass, adm_name, adm_emails from adm_info where adm_id=?;";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1, request.getParameter("adm_id"));
			this.rs = this.ps.executeQuery();
			while(this.rs.next()) {
				ad_id = this.rs.getString("adm_id");
				ad_ps = this.rs.getString("adm_pass");
				ad_name = this.rs.getString("adm_name");
				ad_emails = this.rs.getString("adm_emails");
			}
			if(ad_id.equals("") || ad_ps.equals("")) {
				this.pw.write("<script>"
						+ "alert('해당 아이디를 확인할 수 없습니다.');"
						+ "history.go(-1);"
						+ "</script>");		
			}
			else {
				if(adm_pw.equals(ad_ps)) {
					HttpSession session = request.getSession();
					System.out.println("로그인 성공");
					
					session.setAttribute("adm_id", ad_id);
					session.setAttribute("adm_name", ad_name);
					session.setAttribute("adm_emails", ad_emails);

					 System.out.println("세션 아이디: " + session.getAttribute("adm_id"));
	                 System.out.println("세션 이름: " + session.getAttribute("adm_name"));

	                 
	                 this.pw.write("<script>"
	                            + "alert('정상적으로 로그인 하셨습니다.');"
	                            + "location.href='./notice_list.jsp';"//어디 페이지로 갈지 .. 로그인 후 메인
	                            + "</script>");
	              
				
				}
				else {
					  // 비밀번호가 틀리면
                    this.pw.write("<script>"
                            + "alert('비밀번호가 틀립니다.');"
                            + "history.go(-1);"
                            + "</script>");
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				 if (this.rs != null) this.rs.close();
	                if (this.ps != null) this.ps.close();
	                if (this.con != null) this.con.close();
			}catch (Exception e2) {
				System.out.println(e2);
			}
		}
	
	
	}

	
	
	
	
}










