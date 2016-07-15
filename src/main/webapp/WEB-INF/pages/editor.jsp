<html>
<head>
    <title></title>
</head>
<body>
    <h1>Edit User: ID${id}</h1>
    <br>
    <form action="/changed" method="post">
           Name: <input type="text" name="newName" value= ${name}> <br>
           Pass: <input type="text" name="newPass" value= ${pass}> <br>
           Age: <input type="text" name="newAge" value= ${age}> <br>
           <input type="submit" value="Change">
    </form>

</body>
<html>
