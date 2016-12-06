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
                    <option selected="selected">CSO Stg</option>
                    <option>HUS</option>
                    <option>Adassa</option>
                    <option>PUI GCSM</option>
                    <option>Diac</option>
                    <option>EFS</option>
                    <option>Interne</option>
                    <option>Neant</option>
                </select> :Client <br>

                <select name="driver" id="driver" class="bubble">
                    <option>Albisser Pierre-Jean</option>
                    <option>Fehr Romain</option>
                    <option>Froehlicher Brandon</option>
                    <option selected="selected">Mege Charley</option>
                    <option>Mercier Marine</option>
                </select> :Chauffeur <br>

                <br>
                <select name="origin" id="origin">
                    ${boxedLocations}
                </select> :Origin<br>

                <input type="time" name="collection"> :Collection Time <br>

                <br>
                <select name="wait" id="wait">
                    <option selected="selected"> None</option>
                    <option>15min</option>
                    <option>30min</option>
                    <option>45min</option>
                    <option>1hr</option>
                    <option>1hr 15min</option>
                    <option>1hr 30min</option>
                    <option>1hr 45min</option>
                    <option>2hr</option>
                    <option>2hr 15min</option>
                    <option>2hr 30min</option>
                    <option>2hr 45min</option>
                    <option>3hr</option>
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