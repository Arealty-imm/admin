function ok(index, value) {
    var master = document.getElementById("master").value;
    var approvalId = document.getElementById("approval_id_" + index).value;
    var approvalStatus = document.getElementById("approval_status_" + index);
    var form = document.getElementById("frm_" + index);

    console.log("승인 ID:", approvalId); // 선택한 행의 ID가 정확히 출력되는지 확인

    if (master !== "master") {
        alert("최고 관리자만 승인할 수 있습니다.");
        return;
    }

    approvalStatus.value = value;
    form.submit();
}

function no(index, value) {
    var master = document.getElementById("master").value;
    var approvalId = document.getElementById("approval_id_" + index).value;
    var approvalStatus = document.getElementById("approval_status_" + index);
    var form = document.getElementById("frm_" + index);

    console.log("미승인 ID:", approvalId); // 선택한 행의 ID가 정확히 출력되는지 확인

    if (master !== "master") {
        alert("최고 관리자만 미승인할 수 있습니다.");
        return;
    }

    approvalStatus.value = value;
   	form.submit();
}
