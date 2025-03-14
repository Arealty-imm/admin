package admin_siteinfo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class admin_siteok extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	PrintWriter pw = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("./admin_siteinfo.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		siteinfo_dto dto = new siteinfo_dto();
		
		dto.setPageName(request.getParameter("page_name"));
        dto.setAdminMail(request.getParameter("admin_mail"));
        dto.setUsePoint(request.getParameter("use_point"));
        dto.setWelcomePoints(Integer.parseInt(request.getParameter("welcome_points")));
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
        dto.setMinUsePoint(Integer.parseInt(request.getParameter("min_use_point")));
        dto.setMaxUsePoint(Integer.parseInt(request.getParameter("max_use_point")));
        dto.setCashReceipt(request.getParameter("cash_receipt"));
        dto.setDeliveryCorp(request.getParameter("delivery_corp"));
        dto.setDeliveryPay(Integer.parseInt(request.getParameter("delivery_pay")));
        dto.setDeliveryDate(request.getParameter("delivery_date"));
        dto.setEntryDate(request.getParameter("entry_date"));
        
        int result = new insert_siteinfo().insert_siteinfo(dto);
        this.pw = response.getWriter();
        

        if(result > 0) {
        	this.pw.write("<script>"
					+ "alert('정상적으로 등록이 되었습니다.');"
					+ "location.href='./admin_siteinfo.jsp';"
					+ "</script>");
        	session_siteinfo ss = new session_siteinfo(request, dto);
        } else {
        	this.pw.write("<script>"
					+ "alert('데이터 처리중 오류가 발생하였습니다.');"
					+ "history.go(-1);"
					+ "</script>");
        }
	}

}
