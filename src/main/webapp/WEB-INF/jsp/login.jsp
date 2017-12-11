<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<head>
    <title>201232016</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="../res/common.js"></script>
</head>

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
        <li class="list-group-item"><a href="upload">회원 명단 업로드</a></li>
    </ul>
</div>
</body>
</html>
