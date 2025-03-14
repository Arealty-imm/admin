function master_login(){
	var adm_id = frm.adm_id.value;
	var adm_pass = frm.adm_pass.value;
	
	var idPattern = /^[a-zA-Z0-9]{6,12}$/;
    if (!idPattern.test(adm_id)) {
        alert("아이디는 6~12자의 영문자와 숫자만 사용 가능합니다.");
        return;
    }
    // 비밀번호 확인 (8자 이상, 숫자, 문자, 특수문자 포함)
    var passPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&#])[A-Za-z\d@$!%*?&#+]{8,20}$/;

    if (!passPattern.test(adm_pass)) {
        alert("비밀번호는 8자 이상, 숫자, 문자, 특수문자를 포함해야 합니다.");
        return;
    }
    if (!adm_id || !adm_pass) {
        alert("아이디 또는 비밀번호를 입력하세요.");
        return;
    }
    else{
		frm.submit();
	}

}