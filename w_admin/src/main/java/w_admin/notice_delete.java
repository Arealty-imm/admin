package w_admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class notice_delete extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    m_dbinfo db = new m_dbinfo();
    PrintWriter pw = null;
    ArrayList<String> nidxarr = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        pw = response.getWriter();

        String[] nidx = request.getParameterValues("nidx");

        if (nidx == null || nidx.length == 0) {
            pw.write("<script>alert('올바른 접근이 아닙니다'); history.go(-1);</script>");
            return;
        }

        // 배열 → ArrayList로 변환
        nidxarr = new ArrayList<>(Arrays.asList(nidx));
        System.out.println("삭제할 nidx 목록: " + nidxarr);

        try {
            con = db.db_info();
            sql = "DELETE FROM notice WHERE nidx = ?";
            ps = con.prepareStatement(sql);

            for (String idx : nidxarr) {
                ps.setString(1, idx);
                ps.addBatch();
            }

            int[] results = ps.executeBatch();

            pw.write("<script>"
                    + "alert('총 " + results.length + "개의 게시물이 삭제되었습니다.');"
                    + "location.href='./notice_list.do';"
                    + "</script>");

        } catch (Exception e) {
            pw.write("<script>alert('DB 삭제 오류'); history.go(-1);</script>");
            e.printStackTrace();
        } finally {
            try {
                if (pw != null) pw.close();
                if (con != null) con.close();
                if (ps != null) ps.close();
            } catch (Exception e) {
                System.out.println("DB 자원 해제 중 오류 발생");
            }
        }
    }
}