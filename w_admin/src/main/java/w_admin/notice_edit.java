package w_admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice_edit.do")  // 수정 요청을 처리할 URL
public class notice_edit extends HttpServlet {
    private static final long serialVersionUID = 1L;
    m_dbinfo db = new m_dbinfo();
    Connection con = null;
    PreparedStatement ps = null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 파라미터 받아오기
        String nidx = request.getParameter("nidx");
        String subject = request.getParameter("subject");
        String writer = request.getParameter("writer");
        String texts = request.getParameter("texts");
        String ncheck = request.getParameter("ncheck");

        if (ncheck == null) {
            ncheck = "N";  // 체크 안 하면 기본값 "N"
        }


        try {
        	this.con = db.db_info();

            String sql = "UPDATE notice SET subject=?, writer=?, texts=?, ncheck=? WHERE nidx=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, subject);
            ps.setString(2, writer);
            ps.setString(3, texts);
            ps.setString(4, ncheck);
            ps.setString(5, nidx);

            int result = ps.executeUpdate();

            if (result > 0) {
                response.sendRedirect("notice_view.jsp?nidx=" + nidx); // 수정 완료 후 다시 보기 페이지로 이동
            } else {
                response.getWriter().println("<script>alert('수정 실패'); history.back();</script>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<script>alert('오류 발생!'); history.back();</script>");
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}