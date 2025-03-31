<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<ArrayList<String>> notice = (ArrayList<ArrayList<String>>)request.getAttribute("result");

String total_page = notice.get(0).get(5);
int pg = 1;
if(total_page != null || !total_page.equals(null)){
	float pg2 = Integer.parseInt(total_page)/10f;
	pg = (int)Math.ceil(pg2);
}

String pno = request.getParameter("pageno");
if(pno == null || pno.equals("1")){
	pno = "1";
}
%>
<main class="maincss">
<section>
    <p>공지사항 관리페이지</p>
<form name="delfrm" method="post" action="./notice_delete.do">
    <div class="subpage_view">
    <ul>
        <li><input type="checkbox" onclick="selectAll(this)"></li>
        <li>NO</li>
        <li>제목</li>
        <li>글쓴이</li>
        <li>날짜</li>
        <li>조회</li>
    </ul>
    <% int total = Integer.parseInt(total_page) -((Integer.parseInt(pno)-1)*10);
    for(int f=0; f<notice.size(); f++){ %>
    <ol>
        <li><input type="checkbox" name="nidx" value="<%=notice.get(f).get(0)%>"></li>
        <li><%=total%></li>					<!-- NO -->
        <li onclick="notice_view('<%=notice.get(f).get(0)%>')"><%=notice.get(f).get(1)%></li>			<!-- 제목 -->
        <li><%=notice.get(f).get(2)%></li>			<!-- 글쓴이 -->
        <li><%=notice.get(f).get(4).substring(0,10)%></li> <!-- 날짜 -->
        <li><%=notice.get(f).get(3)%></li>		<!-- 조회 -->
    </ol>
    <%
    total--;
    }
    %>
    <%
    if (notice == null){
    %>
    <ol class="none_text">
        <li>등록된 공지 내용이 없습니다.</li>
    </ol>
    <%    	
    }
    %>
    </div>
    <div class="board_btn">
        <button class="border_del" onclick="notice_info(1)">공지삭제</button>
        <button class="border_add" onclick="notice_info(2)">공지등록</button>
    </div>
    </form>
    <div class="border_page">
        <ul class="pageing">
            <li><img src="./ico/double_left.svg"></li>
            <li><img src="./ico/left.svg"></li>
            <li>1</li>
            <li><img src="./ico/right.svg"></li>
            <li><img src="./ico/double_right.svg"></li>
        </ul>
    </div>
</section>
</main>
<script>
function notice_view(no){
	//해당 게시물의 내용 및 첨부파일을 확인할수 있는 view페이지
	location.href='./notice_view.do?nidx='+no //./do로 경로변경
}
function notice_info(p){
    switch(p){
    case 1: // 삭제
        var frm = document.delfrm;
        var checked = document.querySelectorAll('input[name="nidx"]:checked');
        if (checked.length == 0) {
            alert("삭제할 공지를 선택해주세요.");
            return;
        }
        if (confirm("해당 게시물을 삭제시 복구 되지 않습니다.")) {
            frm.submit();
        }
        break;
    case 2: // 등록
        location.href='./notice_write.jsp';
        break;
	}
}
function selectAll(s) {
    var checkboxes = document.getElementsByName('nidx');
    for (var i = 0; i < checkboxes.length; i++) {
        checkboxes[i].checked = s.checked;
    }
}
</script>