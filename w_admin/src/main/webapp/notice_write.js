function writech(){
	if(frm.subject.value==""){
		alert("제목을 입력하셔야 합니다.");
		frm.subject.focus();
	}
	else{
		frm.submit();
	}
}