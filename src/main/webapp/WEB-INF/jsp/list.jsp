<%@ page language="java" contentType="text/html; charset=UTF-8"
                pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<c:import url="../common/head.jsp"/>
<body>

<c:import url="../common/menu.jsp"/>

<h1>멘토링 목록</h1>

<table class="table table-bordered table-hover">
    <thead>
    <tr>
        <th>멘토링 이름</th>
        <th>멘토</th>
        <th>주제</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="list" items="${list}">
        <tr style="cursor:hand;" data-url="room?a_id=${list.a_id}">
            <td>${list.a_name}</td>
            <td>${list.u_name}</td>
            <td>${list.a_title}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>