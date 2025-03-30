<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%	
    	//로그인 세션 관리
    	HttpSession se = request.getSession();
    	String adm_name = (String)session.getAttribute("adm_name");
    	String adm_id = (String)session.getAttribute("adm_id");
    	String adm_pass = (String)session.getAttribute("adm_pass");
    	
  		request.setAttribute("id", adm_id);//master 여부 확인.
    	if (adm_id == null) {
            // 로그인하지 않은 상태일 경우 로그인 페이지로 리다이렉트
            //response.sendRedirect("./index.jsp");
        }
    %>
<header class="headercss">
    <div class="header_div">
        <p><img src="./img/logo.png" class="logo_sm"> ADMINISTRATOR</p>
        <p><%=adm_name%> 관리자 <a href="#">[개인정보 수정]</a> <a href="./logout.do">[로그아웃]</a></p>
    </div>
</header>
<nav class="navcss">
    <div class="nav_div">
        <ol><!-- href 필요 -->
            <li title="쇼핑몰 관리자 리스트"><a href="./admin_list.do">쇼핑몰 관리자 리스트</a></li>
            <li title="쇼핑몰 상품관리">쇼핑몰 상품관리</li>
            <li title="쇼핑몰 기본설정"><a href="./admin_siteinfo.do">쇼핑몰 기본설정</a></li>
            <li title="쇼핑몰 공지사항"><a href="./notice_list.do">쇼핑몰 공지사항</a></li>
        </ol>
    </div>
</nav>