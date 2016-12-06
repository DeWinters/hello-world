package com.springapp.mvc;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


public class Invoice {

    private long id;
    private String invoice_num;
    private String client;
    private String driver;
    private int origin;
    private int destination;
    private Boolean retour;
    private Boolean wknd;
    private Boolean human;
    private Boolean prise;
    private Boolean interne;
    private Boolean urgence;
    private Boolean abusive;

    private Timestamp collectionTime;
    private Timestamp deliveryTime;
    private String duration;


    /** Tarif Table Methods **/
    private BigDecimal dayTarif;    // Collect hourly tarif by comparing origin & destination to funwithspring.tarif (stop1 & stop2) tarif_rate

    /** and then **/
    private String region;  // Also collect region from funwithspring.tarif region


    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getInvoiceNum() { return invoice_num; }
    public void setInvoiceNum(String invoice_num) {this.invoice_num = invoice_num; }

    public String getClient() { return client; }
    public void setClient(String client) { this.client = client; }

    public String getDriver() { return driver; }
    public void setDriver(String driver) { this.driver = driver; }

    public int getOrigin() { return origin; }
    public void setOrigin(int origin) { this.origin = origin; }

    public int getDestination() { return destination; }
    public void setDestination(int destination) { this.destination = destination; }

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

    public Timestamp getCollectionTime() { return collectionTime; }
    public void setCollectionTime(Timestamp collectionTime) { this.collectionTime = collectionTime; }

    public Timestamp getDeliveryTime() { return deliveryTime; }
    public void setDeliveryTime( Timestamp deliveryTime) { this.deliveryTime = deliveryTime; }

    public String getDuration(){ return duration; }
    public void setDuration(String duration){ this.duration = duration; }

    public BigDecimal getDayTarif(){ return dayTarif; }
    public void setDayTarif(BigDecimal dayTarif){ this.dayTarif = dayTarif; }


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
