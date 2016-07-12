<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
    <head>
        <title>MainPage</title>
        	<link type="text/css" rel="stylesheet" href="styles.xsl">
    </head>

<body>
    <div id="frame">
        <h3>${greeting}</h3>
        <form action="/confirmation" method="post">
            First name: <br>
            <input type="text" name="username" > <br>
            Last name: <br>
            <input type="text" name="password" > <br>
            Age: <br>
            <input type="text" name="age"> <br>
            <input type="submit" value="Submit">
        </form>
        <br><br>

        <h3>Edit User details</h3>
        <form action="/editor" method="post">
            Member ID: <input type="text" name="editId"> <br>
            <input type="submit" value="Open">
        </form>
        <br><br>

        <h3>Add Numbers</h3>
        <form action="/addIt" method="post">
            Choose number <input type="text" name="cell1"> <br>
            Choose second <input type="text" name="cell2"> <br>
            <input type="submit" value="Add them">
        </form>

        <form action="/memberList" method="post">
            <br>
            <input type="submit" value="Skip">
        </form>

        <form action="/shelves" method="post">
            <br>
            <input type="submit" value="Shelves">
        </form>
    </div>
</body>
</html>