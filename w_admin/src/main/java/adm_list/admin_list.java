package adm_list;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import w_admin.m_dbinfo;


public class admin_list extends HttpServlet {
	ResultSet rs = null;
	PreparedStatement ps = null;
	Connection con = null;
	m_dbinfo db = new m_dbinfo();
	String sql = "";
	Integer result;
	ArrayList<ArrayList<String>> adminList = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.adminList = new ArrayList<>();
		try {
			this.con = this.db.db_info();
			this.sql = "select admidx,adm_name,adm_id,adm_tel1,adm_tel2,"
					+ "adm_tel3,adm_emails,adm_dp,adm_pos,adm_date,"	
					+ "(select count(admidx) from adm_info)as idx_num"
					+ " from adm_info";
			this.ps = this.con.prepareStatement(this.sql);
			this.rs = this.ps.executeQuery();
			
			while(rs.next()) {
				 ArrayList<String> admin = new ArrayList<>();
				 admin.add(String.valueOf(rs.getInt("admidx")));
	                admin.add(rs.getString("adm_name"));
	                admin.add(rs.getString("adm_id"));
	                admin.add(rs.getString("adm_tel1") + "-" + rs.getString("adm_tel2") + "-" + rs.getString("adm_tel3"));
	                admin.add(rs.getString("adm_emails"));
	                admin.add(rs.getString("adm_dp"));
	                admin.add(rs.getString("adm_pos"));
	                admin.add(rs.getString("adm_date"));
	               this.adminList.add(admin);
	               
	               this.result = rs.getInt("idx_num");
			}
			//관리자가 없을 경우를 jsp에서 핸들링 하기 위한 결과값 셋팅
			Integer trs = this.result;	//디비에 1개 이상의 데이터가 있는지 비교
			request.setAttribute("result", this.result); //프론트 엔드에 결과값 전송
 			
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				rs.close();
                ps.close();
                con.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		request.setAttribute("adminList", adminList);
		
		RequestDispatcher rd = request.getRequestDispatcher("./admin_list.jsp");
		rd.forward(request, response);
	}

}
