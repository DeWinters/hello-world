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
           <input type="submit" value="EDIT">

    </form>

    <form action="/delete" method="post">
            ID: ${id} <br>
            NAME: ${name} <br>
            PASS: ${pass} <br>
            AGE: ${age} <br>
            <input type="submit" value="DELETE">
    </form>

</body>
<html>
