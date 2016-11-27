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
            <h3>${greeting}</h3>
            <form action="/confirmation" method="post">
                <h3>Old</h3>
                <input type="text" name="invoiceName" > :First name <br>
                <input type="text" name="invoiceLast" > :Last name <br>
                <input type="text" name="age"> :Age <br>

                <h2>MAS Transit</h2>
                <input type="text" name="invoice_num" > :Invoice# <br>
                <input type="date" name="date_stamp"> :Date <br>
                <select name="client" id="client">
                    <option selected="selected">CSO Stg</option>
                    <option>HUS</option>
                    <option>Adassa</option>
                    <option>PUI GCSM</option>
                    <option>Diac</option>
                    <option>EFS</option>
                    <option>Interne</option>
                    <option>Neant</option>
                </select> :Client <br>

                <select name="driver" id="driver">
                    <option>Albisser Pierre-Jean</option>
                    <option>Fehr Romain</option>
                    <option>Froehlicher Brandon</option>
                    <option selected="selected">Mege Charley</option>
                    <option>Mercier Marine</option>
                </select> :Chauffeur <br>

                <br>
                <select name="origin" id="origin">
                    <option>Aéroport de Strasbourg</option>
                    <option>CCOM</option>
                    <option>Centre Paul Schtrauss</option>
                    <option>CH de Haguenau</option>
                    <option>CH de Sarrebourg</option>
                    <option>CH de Wissembourg</option>
                    <option>CH d'Erstein</option>
                    <option>CH Pasteur de Colmar</option>
                    <option>CH Sainte Catherine de Saverne</option>
                    <option>CHD Bischwiller</option>
                    <option>CHRU Hautepierre</option>
                    <option>Clinique Adassa</option>
                    <option>Clinique de la Toussaint</option>
                    <option>Clinique de l'Orangerie</option>
                    <option>Clinique des Diaconnesses</option>
                    <option>Clinique Saint Luc</option>
                    <option>Clinique Sainte Anne</option>
                    <option>Clinique Sainte Barbe</option>
                    <option>Clinique Sainte Odile de Haguenau</option>
                    <option>Clinique Sainte Odile de Strasbourg</option>
                    <option>CMCO</option>
                    <option>EFS de Colmar</option>
                    <option>EFS de Mulhouse</option>
                    <option>EFS Hautepierre Strasbourg</option>
                    <option selected="selected">EFS Spielmann Strasbourg</option>
                    <option>EPSAN</option>
                    <option>Hopital Civil de Colmar</option>
                    <option>Hopital de la Robertsau</option>
                    <option>Hopital de l'Elsau</option>
                    <option>Hopital du Neuhof</option>
                    <option>Hopitaux Universitaires de Strasbourg</option>
                    <option>Maison d'Arrêt de Strasbourg</option>
                    <option>NHC</option>
                    <option>Pôle Logistique HUS</option>
                    <option>PTB</option>
                    <option>PTM</option>
                    <option>Domicile</option>
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
                    <option>Aéroport de Strasbourg</option>
                    <option>CCOM</option>
                    <option>Centre Paul Schtrauss</option>
                    <option>CH de Haguenau</option>
                    <option>CH de Sarrebourg</option>
                    <option>CH de Wissembourg</option>
                    <option>CH d'Erstein</option>
                    <option>CH Pasteur de Colmar</option>
                    <option>CH Sainte Catherine de Saverne</option>
                    <option>CHD Bischwiller</option>
                    <option>CHRU Hautepierre</option>
                    <option>Clinique Adassa</option>
                    <option>Clinique de la Toussaint</option>
                    <option>Clinique de l'Orangerie</option>
                    <option>Clinique des Diaconnesses</option>
                    <option>Clinique Saint Luc</option>
                    <option>Clinique Sainte Anne</option>
                    <option>Clinique Sainte Barbe</option>
                    <option>Clinique Sainte Odile de Haguenau</option>
                    <option selected="selected" >Clinique Sainte Odile de Strasbourg</option>
                    <option>CMCO</option>
                    <option>EFS de Colmar</option>
                    <option>EFS de Mulhouse</option>
                    <option>EFS Hautepierre Strasbourg</option>
                    <option>EFS Spielmann Strasbourg</option>
                    <option>EPSAN</option>
                    <option>Hopital Civil de Colmar</option>
                    <option>Hopital de la Robertsau</option>
                    <option>Hopital de l'Elsau</option>
                    <option>Hopital du Neuhof</option>
                    <option>Hopitaux Universitaires de Strasbourg</option>
                    <option>Maison d'Arrêt de Strasbourg</option>
                    <option>NHC</option>
                    <option>Pôle Logistique HUS</option>
                    <option>PTB</option>
                    <option>PTM</option>
                    <option>Domicile</option>
                </select> :Destination<br>
                <input type="time" name="delivery"> :Delivery Time <br>

                <br>
                <input type="checkbox" name="retour"> Aller/Retour <br>
                <input type="checkbox" name="wknd"> Nuit/Wknd <br>
                <input type="checkbox" name="human"> Personne <br>
                <input type="checkbox" name="prise"> Prise en charge <br>
                <input type="checkbox" name="interne"> Interne <br>
                <input type="checkbox" name="urgence"> Urgence Vitale <br>
                <input type="checkbox" name="abusive"> Abbusive Urgence <br>
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

        <h3>Old</h3>
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

        <form action="/shelves" method="post">
            <br>
            <input type="submit" value="Shelves">
        </form>
    </div>
</body>
</html>