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
        <div id="invoice">
            <div id="header">
                <h2>MAS Transit</h2>
            </div>

            <form action="/confirmation" method="post">
                <input type="text" name="invoice_num" class="bubble"> :Invoice# <br>
                <input type="date" name="date_stamp" class="bubble"> :Date <br>

                <select name="client" id="client" class="bubble">
                    ${boxedClients}
                </select> :Client <br>

                <select name="driver" id="driver" class="bubble">
                    ${boxedDrivers}
                </select> :Chauffeur <br>

                <br>
                <select name="origin" id="origin">
                    ${boxedLocations}
                </select> :Origin<br>

                <input type="time" name="collection"> :Collection Time <br>

                <br>
                <select name="wait" id="wait">
                    ${boxedWaits}
                </select> :Waiting Time<br>

                <br>
                <select name="destination" id="destination">
                    ${boxedLocations}
                </select> :Destination<br>


                <input type="time" name="delivery"> :Delivery Time <br>

                <br>
                <input type="checkbox" name="retour"  > Aller/Retour <br>
                <input type="checkbox" name="wknd" > Nuit/Wknd <br>
                <input type="checkbox" name="human" > Personne <br>
                <input type="checkbox" name="prise" > Prise en charge <br>
                <input type="checkbox" name="interne" > Interne <br>
                <input type="checkbox" name="urgence" > Urgence Vitale <br>
                <input type="checkbox" name="abusive" > Abbusive Urgence <br>
                <br>

                <input type="submit" value="Submit">
                <input type="reset">
            </form>
        </div>

        <form action="/invoiceList" method="post">
            <br>
            <input type="submit" value="Show List">
        </form>
        <br><br>

    </div>
</body>
</html>