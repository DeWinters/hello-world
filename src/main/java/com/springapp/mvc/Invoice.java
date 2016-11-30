package com.springapp.mvc;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class Invoice {

    private long id;
    private String invoice_num;
    private String client;
    private String driver;
    private String origin;
    private String destination;
    private Boolean retour;
    private Boolean wknd;
    private Boolean human;
    private Boolean prise;
    private Boolean interne;
    private Boolean urgence;
    private Boolean abusive;
    //private Date dateStamp;

    private Date collectionTime;
    private Date deliveryTime;

    /** Time Lord's Dilemmas **/
    //private Time collection;      //learn to collect Time, and append it to date_stamp ( date_stamp can be removed from database once this is operation if functional.)
    //private Time delivery;        //test if delivery Time is earlier than collection Time, append delivery to date or date.Day++ as required
    //private TimeSpan wait_time    //convert timespan string from view into a timespan variable
    //private TimeSpan voyage = (delivery - collection) - wait_time

    /** Tarif Table Methods **/
    private float tarif;    // Collect hourly tarif by comparing origin & destination to funwithspring.tarif (stop1 & stop2) tarif_rate
    private String region;  // Also collect region from funwithspring.tarif region


    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getInvoiceNum() { return invoice_num; }
    public void setInvoiceNum(String invoice_num) {this.invoice_num = invoice_num; }

    public String getClient() { return client; }
    public void setClient(String client) { this.client = client; }

    public String getDriver() { return driver; }
    public void setDriver(String driver) { this.driver = driver; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public Boolean getRetour() { return retour; }
    public void setRetour(Boolean retour) { this.retour = retour; }

    public Boolean getWknd() { return wknd; }
    public void setWknd(Boolean wknd) { this.wknd = wknd; }

    public Boolean getHuman() { return human; }
    public void setHuman(Boolean human) { this.human = human; }

    public Boolean getPrise() { return prise; }
    public void setPrise(Boolean prise) { this.prise = prise; }

    public Boolean getInterne() { return interne; }
    public void setInterne(Boolean interne) { this.interne = interne; }

    public Boolean getAbusive() { return abusive; }
    public void setAbusive(Boolean abusive) { this.abusive = abusive; }

    public Boolean getUrgence() { return urgence; }
    public void setUrgence(Boolean urgence) { this.urgence = urgence; }

    //public Date getDateStamp() { return dateStamp; }
    //public void setDateStamp(Date dateStamp){ this.dateStamp = dateStamp; }

    public Date getCollectionTime() { return collectionTime; }
    public void setCollectionTime(Date collectionTime) { this.collectionTime = collectionTime; }

    public Date getDeliveryTime() { return deliveryTime; }
    public void setDeliveryTime( Date deliveryTime) { this.deliveryTime = deliveryTime; }


    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invoice_num='" + invoice_num + '\'' +
                ", client='" + client + '\'' +
                ", driver='" + driver + '\'' +
                ", origin='" + origin + '\'' +
                ", destination'" + destination + '\'' +
                ", retour='" + retour + '\'' +
                ", wknd='" + wknd + '\'' +
                ", human'" + human + '\'' +
                ", prise'" + prise + '\'' +
                ", interne'" + interne + '\'' +
                ", urgence'" + urgence + '\'' +
                ", abusive'" + abusive + '\'' +
                ", collectionTime'" + collectionTime + '\'' +
                ", deliveryTime'" + deliveryTime + '\'' +
                '}';
    }
}
