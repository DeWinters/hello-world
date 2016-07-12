<html>
    <head></head>

    <body>
        <h3>Stock List</h3>
        ${stockList}

        <h3>Stock Shelves</h3>
        <form action="/addItem" method="post">
            Item ID:    <input type="text" name="itemId"><br>
            Item Name:  <input type="text" name="itemName"><br>
            Item Price: <input type="text" name="itemPrice"><br>
            <input type="submit" value="Store Item">
        </form>


        <h3>Find Item</h3>
        <form action="/findItem" method="post">
            Item ID:    <input type="text" name="findId"   value="This cell works"><br>
            Item Name:  <input type="text" name="findName" value="coming soon"><br>
            Max Price:  <input type="text" name="maxPrice" value="0"><br>
            <input type="submit" value="Search">
        </form>

        <h3>Sell item</h3>
        <form action="/sellItem" method="post">
            Item ID:   <input type="text" name="itemId"><br>
            Member ID: <input type="text" name="memberId"><br>
            <input type="submit" value="Sell">
        </form>

        <h3>Sales History</h3>
        <form action="/salesLog" method="post">
            <input type="submit" value="Sales Report">
        </form>

    </body>

</html>