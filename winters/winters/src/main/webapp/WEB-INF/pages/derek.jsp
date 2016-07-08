<html>
<head>
    <title></title>
</head>
<body>
    <h1>Membership List:</h1>
    <br>
    ${userCount} total members.

    <br><br><br>
    Property of ${owner}, 2016
    <br><br><br>

    ${roleCall} <br>

        <forEach item=${allUsers} var="member">
        ${allUsers} <br>
        </forEach>

</body>
</html>