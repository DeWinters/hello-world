<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>LoginPage</title>
        <link rel="stylesheet" type="text/css" href="resources/styles.css"/>
        <script
                src="https://code.jquery.com/jquery-3.2.1.min.js"
                integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
                crossorigin="anonymous">
        </script>
        <!--
        <script>
            $.post( "/insertGuest", { name: "John", time: "2pm" })
                .done(function( data ) {
                    alert( "Data Loaded: " + data );
                });
        </script>
        -->
    </head>

<body>
    <div id="App">
        <div id="loginframe">
            <div class="header">
              <h1><em>MAS</em></h1>
            </div>

            <h3>Login page</h3>
            <form action="/insertGuest" method="post">
                FirstName: <input type="text" name="firstname" class="bubble"><br>
                LastName: <input type="text" name="lastname" class="bubble"><br>
                <input type="submit" value="Login" class="bubble">
            </form>
        </div>

        <div id="dataframe">
            <div class="header">
                <h1>Database</h1>
            </div>

            <div>
                ${guestlist}

            </div>
        </div>

        <div>
            <div class="header">
                <h1>Delete</h1>
                <form action="/deleteById" method="post">
                    GuestID: <input type="text" name="id" class="bubble"><br>
                    <input type="submit" value="Login" class="bubble">
                </form>
            </div>
        </div>

        <div>
            ${jsonlist}
        </div>
    </div>

    ${error}
</body>
</html>