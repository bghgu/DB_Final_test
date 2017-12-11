<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<c:import url="../common/head.jsp"/>
<body>
<div>
    <h1>SM System</h1>
    <form method="post" action="/login-processing">
        <label>
            <input type="text" class="form-control" placeholder="id" name="id" autofocus="autofocus">
        </label>
        <label>
            <input type="password" class="form-control" placeholder="password" name="password">
        </label>
        <button type="submit" class="btn btn-default">Login</button>
    </form>
    <ul class="list-group">
        <li class="list-group-item"><a href="upload">upload</a></li>
    </ul>
</div>
</body>
</html>
