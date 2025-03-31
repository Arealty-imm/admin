<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%
	//Controller에서 1차 클래스 배열값을 JSP에서 받아서 출력하는 방식
	ArrayList<String> views = (ArrayList)request.getAttribute("notice_v");
	if(views == null){ //데이터가 없을 경우 script 발동 후 리스트 페이지로 이동
		out.print("<script> alert ('올바른 접근이 아닙니다.'); location.href='./notice_list.do'; </script>");
	}
	else{ //null이 아닐경우 HTML을 활성화
%>
<main class="maincss">
<section>
    <p>공지사항 확인 페이지</p>
<div class="write_view">
<ul>
    <li>공지사항 제목</li>
    <li>
    <%=views.get(2)%>
    </li>
</ul>
<ul>
    <li>글쓴이</li>
    <li>
         <%=views.get(3)%>
    </li>
</ul>

<ul>
    <li>첨부파일</li>
    <li>
 <% 
if(views.get(5) != null){ //첨부파일이 있을 경우만 해당 태그가 작동되도록 설정함 (없으면 이 코드가 안보임)
%>
<%@ page import="java.net.URLEncoder" %>
<%
String fileName = views.get(6); // 실제 파일명
String encodedFile = URLEncoder.encode(fileName, "UTF-8").replace("+", "%20");
%>
<a href="<%= request.getContextPath() %>/notice_file/<%= encodedFile %>" target="_blank">
    <%= fileName %>
</a>
    </li>
<%
}
%>
</ul>
<ul class="ul_height">
    <li>공지내용</li>
    <li>
        <div class="notice_input3" style="overflow-y: auto;">    <%=views.get(2)%></div>
    </li>
</ul>
</div>
<form id="actionForm" method="post">
    <input type="hidden" name="nidx" value="<%=views.get(0)%>">
    <div class="board_btn">
        <button type="button" class="border_del" onclick="location.href='./notice_list.do'">공지목록</button>
        <button type="button" class="border_add" onclick="goUpdate()">공지수정</button>
        <button type="button" class="border_modify" style="margin-left: 8px;" onclick="goDelete()">공지삭제</button>
    </div>
</form>
</section>
</main>

<script>
function goUpdate() {
    var nidx = document.querySelector('input[name="nidx"]').value;
    location.href = './notice_update.jsp?nidx=' + nidx;
}

function goDelete() {
    if (confirm("해당 게시물을 삭제하시겠습니까? 복구되지 않습니다.")) {
        const form = document.getElementById('actionForm');
        form.action = './notice_delete.do';
        form.submit(); 
    }
}
</script>

<%
	}
%>

