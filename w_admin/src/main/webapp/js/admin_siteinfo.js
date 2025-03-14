function save_site() {
	if(frm.page_name.value == ""){
		alert("홈페이지 이름을 입력해주세요.");
		frm.page_name.focus();
	}else if (frm.admin_mail.value == "") {
		alert("관리자 메일 주소를 입력해주세요.");
		frm.admin_mail.focus();
	} else if (frm.user_level.value == "") {
		alert("회원 가입시 권한레벨을 입력해주세요.");
		frm.user_level.focus();
	} else if (frm.corp_name.value == "") {
		alert("회사명을 입력해주세요.");
		frm.corp_name.focus();
	} else if (frm.business_no.value == "") {
		alert("사업자등록번호를 입력해주세요.");
		frm.business_no.focus();
	} else if (frm.ceo_name.value == "") {
		alert("대표자명을 입력해주세요.");
		frm.ceo_name.focus();
	} else if (frm.ceo_tel.value == "") {
		alert("대표전화번호를 입력해주세요.");
		frm.ceo_tel.focus();
	} else if (frm.license_no.value == "") {
		alert("통신판매업 신고번호를 입력해주세요.");
		frm.license_no.focus();
	} else if (frm.vas_license_no.value == "") {
		alert("부가통신 사업자번호를 입력해주세요.");
		frm.vas_license_no.focus();
	} else if (frm.corp_post.value == "") {
		alert("사업장 우편번호를 입력해주세요.");
		frm.corp_post.focus();
	} else if (frm.corp_addr.value == "") {
		alert("사업장 주소를 입력해주세요.");
		frm.corp_addr.focus();
	} else if (frm.info_mgr.value == "") {
		alert("정보관리책임자명을 입력해주세요.");
		frm.info_mgr.focus();
	} else if (frm.info_mgr_email.value == "") {
		alert("정보관리책임자 이메일을 입력해주세요.");
		frm.info_mgr_email.focus();
	} else if (frm.bank_name.value == "") {
		alert("무통장 은행을 입력해주세요.");
		frm.bank_name.focus();
	} else if (frm.account_num.value == "") {
		alert("계좌번호를 입력해주세요.");
		frm.account_num.focus();
	} else if (frm.delivery_corp.value == "") {
		alert("배송업체명을 입력해주세요.");
		frm.delivery_corp.focus();
	} else if (frm.delivery_pay.value == "" || parseInt(frm.delivery_pay.value) < 0) {
		alert("배송비 가격을 올바르게 입력해주세요.");
		frm.delivery_pay.focus();
	} else if (frm.delivery_date.value == "") {
		alert("희망배송일을 선택해주세요.");
		frm.delivery_date.focus();
	} else {
		frm.submit();
	}
}

function cancel_site(){
	window.location.reload();
}
