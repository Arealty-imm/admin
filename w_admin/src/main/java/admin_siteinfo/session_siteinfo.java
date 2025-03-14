package admin_siteinfo;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class session_siteinfo {
	public session_siteinfo(HttpServletRequest request, siteinfo_dto dto){
		HttpSession session = request.getSession();
        session.setAttribute("siteInfo", dto);
	}
}
