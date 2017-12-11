<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<c:import url="../../res/common/head.jsp"/>
<body>

<c:import url="../../res/common/menu.jsp"/>

<h1>멘토링</h1>

<c:if test="${auth}"><a class="btn btn-default" href="mentor-apply?a_id=${a_id}" role="button">멘토링 정보 수정</a></c:if>

</body>
</html>
