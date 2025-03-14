<%@page import="admin_siteinfo.siteinfo_dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
HttpSession info_session = request.getSession();
siteinfo_dto siteInfo = (siteinfo_dto) info_session.getAttribute("siteInfo");

String adm_emails = (String)session.getAttribute("adm_emails");

out.print(adm_emails);

// 최초접속시 기본값 설정
if (siteInfo == null) {
    siteInfo = new siteinfo_dto();
}

String page_name = siteInfo.getPageName();
String admin_mail = siteInfo.getAdminMail();
String use_point = siteInfo.getUsePoint();
int welcome_points = siteInfo.getWelcomePoints();
String user_level = siteInfo.getUserLevel();
String corp_name = siteInfo.getCorpName();
String business_no = siteInfo.getBusinessNo();
String ceo_name = siteInfo.getCeoName();
String ceo_tel = siteInfo.getCeoTel();
String license_no = siteInfo.getLicenseNo();
String vas_license_no = siteInfo.getVasLicenseNo();
String corp_post = siteInfo.getCorpPost();
String corp_addr = siteInfo.getCorpAddr();
String info_mgr = siteInfo.getInfoMgr();
String info_mgr_email = siteInfo.getInfoMgrEmail();
String bank_name = siteInfo.getBankName();
String account_num = siteInfo.getAccountNum();
String use_card = siteInfo.getUseCard();
String use_phone = siteInfo.getUsePhone();
String use_giftcard = siteInfo.getUseGiftcard();
int min_use_point = siteInfo.getMinUsePoint();
int max_use_point = siteInfo.getMaxUsePoint();
String cash_receipt = siteInfo.getCashReceipt();
String delivery_corp = siteInfo.getDeliveryCorp();
int delivery_pay = siteInfo.getDeliveryPay();
String delivery_date = siteInfo.getDeliveryDate();


if(adm_emails != null && admin_mail == null){
	admin_mail = adm_emails;
}
%>
<form id="frm" method="get" action="./admin_siteok.do">
<main class="maincss">
<section>
    <p>홈페이지 가입환경 설정</p>
<div class="subpage_view">
<ul class="info_form">
    <li>홈페이지 제목</li>
    <li>
        <input type="text" value="<%= page_name != null ? page_name : "" %>" class="in_form1" name="page_name"> 
    </li>
</ul>    
<ul class="info_form">
    <li>관리자 메일 주소</li>
    <li>
        <input type="text" value="<%= admin_mail != null ? admin_mail : "" %>" class="in_form2" name="admin_mail"> ※ 관리자가 보내고 받는 용도로 사용하는 메일 주소를 입력합니다.(회원가입, 인증메일, 회원메일발송 등에서 사용)
    </li>
</ul> 
<ul class="info_form">
    <li>포인트 사용 유/무</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" name="use_point" value="Y" <%= "Y".equals(use_point) ? "checked" : "" %>>포인트 사용</label></em> 
        <em><label><input type="radio" class="ckclass" name="use_point" value="N" <%= "N".equals(use_point) ? "checked" : "" %> >포인트 미사용</label></em>
    </li>
</ul>
<ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>회원가입시 적립금</li>
    <li>
        <input type="text" class="in_form3" maxlength="5" value="<%= welcome_points != 0 ? welcome_points : "" %>" id="numberInput" name="welcome_points"> 점
    </li>
    <li>회원가입시 권한레벨</li>
    <li>
        <input type="text" class="in_form3" maxlength="1" value="<%= user_level != null ? user_level : "" %>" id="numberInput" name="user_level"> 레벨
    </li>
</ul> 
</div>
<p>홈페이지 기본환경 설정</p>
<div class="subpage_view">
<ul class="info_form2">
    <li>회사명</li>
    <li>
        <input type="text" class="in_form0" value="<%= corp_name != null ? corp_name : "" %>" name="corp_name"> 
    </li>
    <li>사업자등록번호</li>
    <li>
        <input type="text" class="in_form0" value="<%= business_no != null ? business_no : "" %>" name="business_no"> 
    </li>
</ul> 
<ul class="info_form2">
    <li>대표자명</li>
    <li>
        <input type="text" class="in_form0" value="<%= ceo_name != null ? ceo_name : "" %>" name="ceo_name"> 
    </li>
    <li>대표전화번호</li>
    <li>
        <input type="text" class="in_form0" value="<%= ceo_tel != null ? ceo_tel : "" %>" name="ceo_tel"> 
    </li>
</ul>
<ul class="info_form2">
    <li>통신판매업 신고번호</li>
    <li>
        <input type="text" class="in_form0" value="<%= license_no != null ? license_no : "" %>" name="license_no"> 
    </li>
    <li>부가통신 사업자번호</li>
    <li>
        <input type="text" class="in_form0" value="<%= vas_license_no != null ? vas_license_no : "" %>" name="vas_license_no"> 
    </li>
</ul>
<ul class="info_form2">
    <li>사업장 우편번호</li>
    <li>
        <input type="text" class="in_form0" value="<%= corp_post != null ? corp_post : "" %>" name="corp_post" id="numberInput"> 
    </li>
    <li>사업장 주소</li>
    <li>
        <input type="text" class="in_form2" value="<%= corp_addr != null ? corp_addr : "" %>" name="corp_addr"> 
    </li>
</ul>
<ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>정보관리책임자명</li>
    <li>
        <input type="text" class="in_form0" value="<%= info_mgr != null ? info_mgr : "" %>" name="info_mgr"> 
    </li>
    <li>정보책임자 E-mail</li>
    <li>
        <input type="text" class="in_form1" value="<%= info_mgr_email != null ? info_mgr_email : "" %>" name="info_mgr_email"> 
    </li>
</ul>
</div>
<p>결제 기본환경 설정</p>
<div class="subpage_view">  
<ul class="info_form2">
    <li>무통장 은행</li>
    <li>
        <input type="text" class="in_form0" value="<%= bank_name != null ? bank_name : "" %>" name="bank_name"> 
    </li>
    <li>은행계좌번호</li>
    <li>
        <input type="text" class="in_form1" value="<%= account_num != null ? account_num : "" %>" name="account_num"> 
    </li>
</ul>
<ul class="info_form">
    <li>신용카드 결제 사용</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" name="use_card" value="Y" <%= "Y".equals(use_card) ? "checked" : "" %>> 사용</label></em> 
        <em><label><input type="radio" class="ckclass" name="use_card" value="N" <%= "N".equals(use_card) ? "checked" : "" %>> 미사용</label></em> ※ 해당 PG사가 있을 경우 사용으로 변경합니다.
    </li>
</ul>
<ul class="info_form">
    <li>휴대폰 결제 사용</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" name="use_phone" value="Y" <%= "Y".equals(use_phone) ? "checked" : "" %>> 사용</label></em> 
        <em><label><input type="radio" class="ckclass" name="use_phone" value="N" <%= "N".equals(use_phone) ? "checked" : "" %>> 미사용</label></em> ※ 주문시 휴대폰 결제를 가능하게 할 것인지를 설정합니다.
    </li>
</ul>
<ul class="info_form">
    <li>도서상품권 결제사용</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" name="use_giftcard" value="Y" <%= "Y".equals(use_giftcard) ? "checked" : "" %>> 사용</label></em> 
        <em><label><input type="radio" class="ckclass" name="use_giftcard" value="N" <%= "N".equals(use_giftcard) ? "checked" : "" %>> 미사용</label></em> ※ 도서상품권 결제만 적용이 되며, 그 외에 상품권은 결제 되지 않습니다.
    </li>
</ul>
<ul class="info_form2">
    <li>결제 최소 포인트</li>
    <li>
        <input type="text" class="in_form0" maxlength="5" value="<%= min_use_point != 0 ? min_use_point : 1000 %>" id="numberInput" name="min_use_point"> 점
    </li>
    <li>결제 최대 포인트</li>
    <li>
        <input type="text" class="in_form0" maxlength="5" value="<%= max_use_point != 0 ? max_use_point : "" %>" id="numberInput" name="max_use_point"> 점
    </li>
</ul>
<ul class="info_form">
    <li>현금 영수증 발급사용</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" name="cash_receipt" value="Y" <%= "Y".equals(cash_receipt) ? "checked" : "" %>> 사용</label></em> 
        <em><label><input type="radio" class="ckclass" name="cash_receipt" value="N" <%= "N".equals(cash_receipt) ? "checked" : "" %>> 미사용</label></em> ※ 현금영수증 관련 사항은 PG사 가입이 되었을 경우 사용가능 합니다.
    </li>
</ul>
<ul class="info_form2">
    <li>배송업체명</li>
    <li>
        <input type="text" class="in_form0" value="<%= delivery_corp != null ? delivery_corp : "" %>" name="delivery_corp"> 
    </li>
    <li>배송비 가격</li>
    <li>
        <input type="text" class="in_form0" maxlength="7" value="<%= delivery_pay != 0 ? delivery_pay : "" %>" id="numberInput" name="delivery_pay"> 원
    </li>
</ul>
<ul class="info_form" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>희망배송일</li>
    <li class="checkcss">
        <em><label><input type="radio" class="ckclass" name="delivery_date" value="Y" <%= "Y".equals(delivery_date) ? "checked" : "" %>> 사용</label></em> 
        <em><label><input type="radio" class="ckclass" name="delivery_date" value="N" <%= "N".equals(delivery_date) ? "checked" : "" %>> 미사용</label></em> ※ 희망배송일 사용시 사용자가 직접 설정 할 수 있습니다.
    </li>
</ul>
</div>
<div class="btn_div">
    <button type="button" class="sub_btn1" title="설정 저장" onclick="save_site()">설정 저장</button>
    <button type="button" class="sub_btn2" title="저장 취소" onclick="cancel_site()">저장 취소</button>
</div>
</section>
</main>
</form>
<section></section>
<section></section>
<footer class="main_copyright">
    <div>
        Copyright ⓒ 2024 shopbag All rights reserved.
    </div>
</footer>