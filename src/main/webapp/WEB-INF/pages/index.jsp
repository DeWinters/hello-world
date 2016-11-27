<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>MainPage</title>
        <link rel="stylesheet" type="text/css" href="/resources/styles.css"/>

    </head>

<body>
    <div id="frame">
        <h3>Login page</h3>
        <form action="/login" method="post">
           Username: <input type="text" name="username"><br>
           Password: <input type="password" name="password"><br>
            <input type="submit" value="Login">
        </form>
    </div>

    ${error}
</body>
</html>