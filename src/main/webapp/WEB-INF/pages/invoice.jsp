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
                <select name="origin" id="origin" class="bubble">
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
                <input type="time" name="collection" class="bubble"> :Collection Time <br>

                <br>
                <select name="wait" id="wait" class="bubble">
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
                <select name="destination" id="destination" class="bubble">
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
                <input type="time" name="delivery" class="bubble"> :Delivery Time <br>

                <br>
                    <input type="checkbox" name="retour"  > Aller/Retour <br>
                    <input type="checkbox" name="wknd" > Nuit/Wknd <br>
                    <input type="checkbox" name="human" > Personne <br>
                    <input type="checkbox" name="prise" > Prise en charge <br>
                    <input type="checkbox" name="interne" > Interne <br>
                    <input type="checkbox" name="urgence" > Urgence Vitale <br>
                    <input type="checkbox" name="abusive" > Abbusive Urgence <br>
                <br>
                <input type="submit" value="Submit" class="bubble">
                <input type="reset" class="bubble">
            </form>
        </div>

        <form action="/invoiceList" method="post">
            <br>
            <input type="submit" value="Show List" class="bubble">
        </form>
        <br><br>


    </div>
</body>
</html>