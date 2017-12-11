<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<c:import url="../common/head.jsp"/>
<body>

<c:import url="../common/menu.jsp"/>

<h1>멘토링 신청</h1>

<h3>멘토 정보</h3>
<h4>멘토이름 : ${mentolist.u_name}</h4>
<h4>학번 : ${mentolist.u_id}</h4>
<h4>학과 : ${mentolist.d_id1} ${mentolist.u_grade}학년</h4>
<h4>연락처: ${mentolist.u_email}</h4>

<h3>멘토링 내용</h3>
<h4>멘토링 주제 : ${mentolist.a_title} / ${mentolist.a_sub}</h4>
<h4>멘토링 이름 : ${mentolist.a_name}</h4>
<h4>멘토링 목적</h4>
${mentolist.a_aim}
<h4>멘토링 내용</h4>
${mentolist.a_contents}
<h4>멘토링 방법</h4>
${mentolist.a_method}
<h4>멘토링 시간 : ${mentolist.a_hours}</h4>
<h4>멘토링 인원수 : ${mentolist.a_num}</h4>
<h4>해당과목 성적 : ${mentolist.a_rank}</h4>
<c:if test="${mentolist.a_fileUrl ne null}">
    <a href="${mentolist.a_fileUrl}">멘토 포트폴리오 다운로드</a>
</c:if>

<h3>신청현황</h3>
<div class="progress">
    <div class="progress-bar progress-bar-danger"
         role="progressbar" aria-valuenow="${percent}" aria-valuemin="0"
         aria-valuemax="100" style="width: ${percent}%;">${percent}%
    </div>
</div>

<form method="post">
    <input type="hidden" name="a_id" value="${mentolist.a_id}"/>
    <c:if test="${check}">
        <center>
            <button type="submit" class="btn btn-light">신청하기</button>
        </center>
    </c:if>
</form>

</body>
</html>
