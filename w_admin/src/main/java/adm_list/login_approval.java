package adm_list;

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

public class login_approval extends HttpServlet {

    PrintWriter pw = null;
    Connection con = null;
    PreparedStatement ps = null;
    String sql;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        this.pw = response.getWriter();
        m_dbinfo db = new m_dbinfo();

        String approval_status = request.getParameter("approval_status");
        String approval_id = request.getParameter("approval_id");

        System.out.println(approval_status + " " + approval_id);

        try {
            this.con = db.db_info();
            this.sql = "UPDATE adm_info SET permission = ? WHERE adm_id = ?";

            // approval_status와 approval_id가 null이 아니고 빈 값이 아니어야 쿼리를 실행
            if (approval_status != null && !approval_status.isEmpty() && approval_id != null && !approval_id.isEmpty()) {
                // PreparedStatement 준비
                ps = con.prepareStatement(sql);
                ps.setString(1, approval_status);  // 'Y' 또는 'N'
                ps.setString(2, approval_id);  // approval_id (user ID)

                int result = this.ps.executeUpdate();

                if (result > 0) { //쿼리 성공 시
                    if ("Y".equals(approval_status)) {
                        this.pw.write("<script>"
                                + "alert('관리자 회원의 로그인을 허가 했습니다.');"
                                + "history.go(-1);"
                                + "</script>");
                    } else if ("N".equals(approval_status)) {
                        this.pw.write("<script>"
                                + "alert('관리자 회원의 로그인을 불허 했습니다.');"
                                + "history.go(-1);"
                                + "</script>");
                    }
                } else {
                    // 쿼리 실패 시
                    this.pw.write("<script>"
                            + "alert('관리자 회원의 로그인을 처리할 수 없습니다.');"
                            + "history.go(-1);"
                            + "</script>");
                }
            } else {
                // 필수 값이 없을 경우
                this.pw.write("<script>"
                        + "alert('필수 값이 누락되었습니다.');"
                        + "history.go(-1);"
                        + "</script>");
            }

        } catch (Exception e) {
            System.out.println("db error 발생 : " + e);
        } finally {
            try {
                if (this.ps != null) this.ps.close();
                if (this.con != null) this.con.close();
                if (this.pw != null) this.pw.close();
            } catch (Exception e2) {
                System.out.println(e2);
            }
        }
    }
}
