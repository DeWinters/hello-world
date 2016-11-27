<html>
<head>
    <title>MemberList Outputs</title>
</head>
<body>
    <h1>Membership List:</h1>

    Java solution: <br>
    ${roleCall}
    <br><br><br>

    Query solution: <br>
    ${theDraft} <br>
    ${eligible} eligible voters.<br>
    ${userCount} total population.<br>
    <br><br><br>

    Property of ${owner}, 2016
    <br><br><br>


        <forEach item=${allUsers} var="member">
        ${allUsers} <br>
        </forEach>


</body>
</html>