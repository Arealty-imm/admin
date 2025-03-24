package admin_siteinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class admin_siteok extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	PrintWriter pw = null;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		siteinfo_dto dto = new siteinfo_dto();

		dto.setPageName(request.getParameter("page_name"));
        dto.setAdminMail(request.getParameter("admin_mail"));
        dto.setUsePoint(request.getParameter("use_point"));
        dto.setUserLevel(request.getParameter("user_level"));
        dto.setCorpName(request.getParameter("corp_name"));
        dto.setBusinessNo(request.getParameter("business_no"));
        dto.setCeoName(request.getParameter("ceo_name"));
        dto.setCeoTel(request.getParameter("ceo_tel"));
        dto.setLicenseNo(request.getParameter("license_no"));
        dto.setVasLicenseNo(request.getParameter("vas_license_no"));
        dto.setCorpPost(request.getParameter("corp_post"));
        dto.setCorpAddr(request.getParameter("corp_addr"));
        dto.setInfoMgr(request.getParameter("info_mgr"));
        dto.setInfoMgrEmail(request.getParameter("info_mgr_email"));
        dto.setBankName(request.getParameter("bank_name"));
        dto.setAccountNum(request.getParameter("account_num"));
        dto.setUseCard(request.getParameter("use_card"));
        dto.setUsePhone(request.getParameter("use_phone"));
        dto.setUseGiftcard(request.getParameter("use_giftcard"));
        dto.setCashReceipt(request.getParameter("cash_receipt"));
        dto.setDeliveryCorp(request.getParameter("delivery_corp"));
        dto.setDeliveryDate(request.getParameter("delivery_date"));
        dto.setEntryDate(request.getParameter("entry_date"));
        
        
        // parseInt NumberFormatExcetion 방지
        String welcome_points = request.getParameter("welcome_points");
        String min_use_point = request.getParameter("min_use_points");
        String max_use_point = request.getParameter("max_use_point");
        String delivery_pay = request.getParameter("delivery_pay");
        
        if(welcome_points == null) {
        	welcome_points = "0";        
        }
        if(min_use_point == null) {
        	min_use_point = "0";        
        }
        if(max_use_point == null) {
        	max_use_point = "0";
        }
        if(delivery_pay == null) {
        	delivery_pay = "0";
        }
        
        dto.setWelcomePoints(Integer.parseInt(welcome_points));
        dto.setMinUsePoint(Integer.parseInt(min_use_point));
        dto.setMaxUsePoint(Integer.parseInt(max_use_point));
        dto.setDeliveryPay(Integer.parseInt(delivery_pay));
        
        int result = new insert_siteinfo().insert_siteinfo(dto);
        this.pw = response.getWriter();
        

        if(result > 0) {
        	this.pw.write("<script>"
					+ "alert('정상적으로 등록이 되었습니다.');"
					+ "location.href='./admin_siteinfo.do';"
					+ "</script>");
        	session_siteinfo ss = new session_siteinfo(request, dto);
        } else {
        	this.pw.write("<script>"
					+ "alert('데이터 처리중 오류가 발생하였습니다.');"
					+ "history.go(-1);"
					+ "</script>");
        }
        
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("./admin_siteinfo.jsp");
		rd.forward(request, response);
	}
}
