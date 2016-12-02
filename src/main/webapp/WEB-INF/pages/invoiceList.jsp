<html>
<head>
    <title>Invoice List</title>
    <link rel="stylesheet" type="text/css" href="resources/styles.css"/>
</head>
<body>
    <h1>Invoice List:</h1>

    <table border="1">
        <tr>
            <td>ID</td> <td>Invoice#</td> <td>Client</td> <td>Chauffeur</td> <td>Collection Time</td> <td>Origin</td> <td>Delivery Time</td>
            <td>Destination</td> <td>Retour</td> <td>Wknd/Nuit</td> <td>Human</td> <td>Prise</td> <td>Interne</td>
            <td>Urgence</td> <td>Abusive</td>
        </tr>
        ${boxedData}
    </table>

    ${userCount} total population.<br>
    Property of ${owner}, 2016 <br>

</body>
</html>