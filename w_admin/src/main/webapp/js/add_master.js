// 아이디 중복 체크 함수
function idck() {
    var admId = frm.adm_id.value;
    if (!admId) {
        alert("아이디를 입력하세요.");
        return;
    }
    console.log("아이디 중복 체크 요청: " + admId);

    // 서버 응답에 따라 처리 (예시)
    // 성공 시: alert("사용 가능한 아이디입니다.");
    // 실패 시: alert("이미 사용 중인 아이디입니다.");
}

// 관리자 등록 함수
function admin_add() {
    
    
    var admId = frm.adm_id.value;
    var admPass = frm.adm_pass.value;
    var admPass2 = frm.adm_pass2.value;  // 수정된 부분
    var admName = frm.adm_name.value;  // 수정된 부분
    var admMail = frm.adm_emails.value;  // 수정된 부분
    var admTel1 = frm.adm_tel1.value;
    var admTel2 = frm.adm_tel2.value;
    var admTel3 = frm.adm_tel3.value;

    // 아이디 정규식 (영문자, 숫자, 길이 6~12자)
    var idPattern = /^[a-zA-Z0-9]{6,12}$/;
    if (!idPattern.test(admId)) {
        alert("아이디는 6~12자의 영문자와 숫자만 사용 가능합니다.");
        return;
    }

    // 비밀번호 확인 (8자 이상, 숫자, 문자, 특수문자 포함)
    var passPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&#])[A-Za-z\d@$!%*?&#+]{8,20}$/;

    if (!passPattern.test(admPass)) {
        alert("비밀번호는 8자 이상, 숫자, 문자, 특수문자를 포함해야 합니다.");
        return;
    }

    if (admPass !== admPass2) {
        alert("비밀번호가 일치하지 않습니다.");
        return;
    }

    // 이메일 정규식
    var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailPattern.test(admMail)) {
        alert("올바른 이메일 주소를 입력해주세요.");
        return;
    }

    // 전화번호 정규식 (예시: 010-1234-5678 형태)
    var telPattern = /^(\d{3})-(\d{4})-(\d{4})$/;
    if (!telPattern.test(admTel1 + "-" + admTel2 + "-" + admTel3)) {
        alert("전화번호는 010-XXXX-XXXX 형태로 입력해주세요.");
        return;
    }

    // 필수 입력값 체크
    if (!admId || !admPass || !admName || !admMail || !admTel1 || !admTel2 || !admTel3) {
        alert("모든 필수 정보를 입력해주세요.");
        return;
    }
    else {
        frm.submit();  // 폼 제출
    }
}

// 관리자 등록 취소 함수
function addmin_cancel() {
    if (confirm("정말 취소하시겠습니까? 입력한 정보가 사라집니다.")) {
        document.querySelector("#frm").reset();  // 폼 초기화
    }
}
