<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<main class="maincss">
<form id="frm" method="post" action="./notice_writeok.do" enctype="multipart/form-data">
<section>
    <p>공지사항 등록페이지</p>
<div class="write_view">
<ul>
    <li>공지사항 여부</li>
    <li>
        <label class="label_notice"><em class="cbox"><input type="checkbox" name ="ncheck" value="Y"></em> 공지 출력</label> ※ 공지출력을 체크할 시 해당 글 내용은 최상단에 노출 되어 집니다.
    </li>
</ul>
<ul>
    <li>공지사항 제목</li>
    <li>
        <input type="text" name="subject" class="notice_input1"> ※ 최대 150자까지 입력이 가능
    </li>
</ul>
<ul>
    <li>글쓴이</li>
    <li>
        <input type="text" name="writer" value="관리자" class="notice_input2" readonly> ※ 관리자 이름이 노출 됩니다.       
    </li>
</ul>
<ul>
    <li>첨부파일</li>
    <li>
        <input type="file" name="nfile"> ※ 첨부파일 최대 용량은 2MB 입니다.       
    </li>
</ul>
<ul class="ul_height">
    <li>공지내용</li>
    <li>
        <textarea class="notice_input3" name="texts" placeholder="공지내용을 입력하세요!"></textarea>
    </li>
</ul>
</div>
<div class="board_btn">
    <button class="border_del" onclick="writech(1)">공지목록</button>
    <button class="border_add" onclick="writech(2)">공지등록</button>
</div>
</section>
</form>
</main>