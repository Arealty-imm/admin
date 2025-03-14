package admin_siteinfo;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class session_siteinfo {
	public session_siteinfo(HttpServletRequest request, siteinfo_dto dto){
		HttpSession session = request.getSession();
		
		session.setAttribute("page_name", dto.getPageName());
		session.setAttribute("admin_mail", dto.getAdminMail());
		session.setAttribute("use_point", dto.getUsePoint());
		session.setAttribute("welcome_points", dto.getWelcomePoints());
		session.setAttribute("user_level", dto.getUserLevel());
		session.setAttribute("corp_name", dto.getCorpName());
		session.setAttribute("business_no", dto.getBusinessNo());
		session.setAttribute("ceo_name", dto.getCeoName());
		session.setAttribute("ceo_tel", dto.getCeoTel());
		session.setAttribute("license_no", dto.getLicenseNo());
		session.setAttribute("vas_license_no", dto.getVasLicenseNo());
		session.setAttribute("corp_post", dto.getCorpPost());
		session.setAttribute("corp_addr", dto.getCorpAddr());
		session.setAttribute("info_mgr", dto.getInfoMgr());
		session.setAttribute("info_mgr_email", dto.getInfoMgrEmail());
		session.setAttribute("bank_name", dto.getBankName());
		session.setAttribute("account_num", dto.getAccountNum());
		session.setAttribute("use_card", dto.getUseCard());
		session.setAttribute("use_phone", dto.getUsePhone());
		session.setAttribute("use_giftcard", dto.getUseGiftcard());
		session.setAttribute("min_use_point", dto.getMinUsePoint());
		session.setAttribute("max_use_point", dto.getMaxUsePoint());
		session.setAttribute("cash_receipt", dto.getCashReceipt());
		session.setAttribute("delivery_corp", dto.getDeliveryCorp());
		session.setAttribute("delivery_pay", dto.getDeliveryPay());
		session.setAttribute("delivery_date", dto.getDeliveryDate());
	}
}
