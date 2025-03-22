<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // request에서 adminList 가져오기
    ArrayList<ArrayList<String>> adml = (ArrayList<ArrayList<String>>) request.getAttribute("adminList");
	Integer result = (Integer)request.getAttribute("result"); //데이터 갯수 확인
	String id = (String)request.getAttribute("id");	 //master 유저만 승인 여부 검토.(master 일 경우만 핸들링)
	
%>     
    
<section>
    <p>신규등록 관리자</p>
    <ol class="new_admin_title2">
        <li>NO</li>
        <li>관리자명</li>
        <li>아이디</li>
        <li>전화번호</li>
        <li>이메일</li>
        <li>담당부서</li>
        <li>담당직책</li>
        <li>가입일자</li>
        <li>승인여부</li>
    </ol>
    	<%-- 데이터의 결과 값 갯수로 jsp 핸들링 --%>
    <%		
    	if(result <= 0 || result == null){		
	%>   
    <ol class="new_admin_none">
        <li>신규 등록된 관리자가 없습니다.</li>		
    </ol>    
    
    <%	
    	}
    else if(result > 0){
    	int w = 0;
    	int cnt = 0;
    	while(w < adml.size()){
    	
    %>    
        <form id="frm_<%= w %>" action="./login_approval.do" method="post">
    <ol class="new_admin_lists2">
        <li><%=adml.get(w).get(0) %></li>
        <li><%=adml.get(w).get(1) %></li>
        <li><%=adml.get(w).get(2) %></li>
        <li><%=adml.get(w).get(3) %></li>
        <li><%=adml.get(w).get(4) %></li>
        <li><%=adml.get(w).get(5) %></li>
        <li><%=adml.get(w).get(6) %></li>
        <li><%=((String)adml.get(w).get(7)).substring(0, 10)%></li>
        <li>
            <input type="hidden" id="master" value="<%=id%>">
            <input type="hidden" id="approval_status_<%= w %>" name="approval_status">
            <input type="hidden" id="approval_id_<%= w %>" name="approval_id" value="<%=adml.get(w).get(2) %>">
            <button type="button" class="new_addbtn1" title="승인" onclick="ok(<%= w %>, 'Y')">승인</button>
            <button type="button" class="new_addbtn2" title="미승인" onclick="no(<%= w %>, 'N')">미승인</button>
        </li>
    </ol>
	</form>

    <%
    w++;
    cnt++;
   	 }
    }
    %>
        
</section>
<section></section>
<section></section>