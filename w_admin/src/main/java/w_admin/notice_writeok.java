package w_admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
	fileSizeThreshold = 1024*1024*2,
	maxFileSize= 1024*1024*2
)
public class notice_writeok extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement ps = null;
	PrintWriter pw = null;
	m_dbinfo db = new m_dbinfo();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		this.pw = response.getWriter();
		
		Part nfile = request.getPart("nfile");
		long filesize = nfile.getSize();
		
		try {
			this.con = db.db_info();
			String ncheck = request.getParameter("ncheck");
			String subject = request.getParameter("subject");
			String writer = request.getParameter("writer");
			String texts = request.getParameter("texts");
			
			String sql = "";
			int result = 0;
			this.pw.print("dddd");
			if(filesize == 0) {
				sql = "insert into notice (nidx,ncheck,subject,writer,texts,ndate)"
					+ "values ('0',?,?,?,?,now())";
				this.ps.setString(1, ncheck);
				this.ps.setString(2, subject);
				this.ps.setString(3, writer);
				this.ps.setString(4, texts);
				result = this.ps.executeUpdate();
				if(result > 0) {
					this.pw.write("<script>"
							+ "alert('게시물이 올바르게 등록 되었습니다.');"
							+ "location.href = './notice_list.do';"
							+ "</script>");
				}
				
			}else {
				m_notice nt = new m_notice(nfile, subject, writer, ncheck, texts, request);
				String msg = nt.msg;
				if(msg.equals("ok")) {
					this.pw.write("<script>"
							+ "alert('첨부파일 추가 게시물이 올바르게 등록 되었습니다.');"
							+ "location.href = './notice_list.do';"
							+ "</script>");
				}
				else {
					this.pw.write("<script>"
							+ "alert('Database 및 첨부파일 오류 발생.');"
							+ "history.go(-1);"
							+ "</script>");
				}
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			try {
				this.ps.close();
				this.con.close();
				this.pw.close();
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}

}
