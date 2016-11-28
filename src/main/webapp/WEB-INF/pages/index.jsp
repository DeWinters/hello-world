<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>LoginPage</title>
        <link rel="stylesheet" type="text/css" href="resources/styles.css"/>

    </head>

<body>
    <div id="loginframe">
        <div id="header">
          <h1><em>MAS</em></h1>
        </div>
        <h3>Login page</h3>
        <form action="/login" method="post">
            Username: <input type="text" name="username" class="bubble"><br>
            Password: <input type="password" name="password" class="bubble"><br>
            <input type="submit" value="Login" class="bubble">
        </form>
    </div>

    ${error}
</body>
</html>