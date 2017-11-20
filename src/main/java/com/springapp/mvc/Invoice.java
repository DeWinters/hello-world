package com.springapp.mvc;

import java.math.BigDecimal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Invoice {

    private long id;
    private String invoice_num;
    private String client;
    private String driver;
    private String origin;
    private String collection;
    private String destination;
    private String delivery;
    private BigDecimal tarif;
    private BigDecimal tax_rate;
    private BigDecimal wait_fee;

    private String retour;
    private String wknd;
    private String human;
    private String prise;
    private String interne;
    private String abusive;
    private String urgent;
    private String active;
    private String paid;
    //private String region;  // collect region from ???

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

    public String getCollection() { return collection; }
    public void setCollectionTime(String timestamp) { this.collection = timestamp; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public String getDelivery() { return delivery; }
    public void setDeliveryTime( String deliveryTime) { this.delivery = deliveryTime; }

    public BigDecimal getTarif(){ return tarif; }
    public void setDayTarif(BigDecimal dayTarif){ this.tarif = dayTarif; }

    public BigDecimal getTaxRate(){ return tax_rate; }
    public void setTaxRate(BigDecimal taxRate){ this.tax_rate = taxRate; }

    public BigDecimal getWaitFee(){ return wait_fee; }
    public void setWaitFee(BigDecimal waitFee){ this.wait_fee = waitFee; }

    public Boolean getRetour() { return retour == "true" ? true : false; }
    public void setRetour(Boolean retour) { this.retour = retour == true ? "true" : "false"; }

    public Boolean getWknd() { return wknd == "true" ? true : false; }
    public void setWknd(Boolean wknd) { this.wknd = wknd == true ? "true" : "false"; }

    public Boolean getHuman() { return human == "true" ? true : false;}
    public void setHuman(Boolean human) {this.human = human == true ? "true" : "false";}

    public Boolean getPrise() { return human == "true" ? true : false; }
    public void setPrise(Boolean prise) { this.prise = prise == true ? "true" : "false"; }

    public Boolean getInterne() { return interne == "true" ? true : false; }
    public void setInterne(Boolean interne) { this.interne = interne == true ? "true" : "false"; }

    public Boolean getAbusive() { return abusive == "true" ? true : false; }
    public void setAbusive(Boolean abusive) { this.abusive = abusive == true ? "true" : "false"; }

    public Boolean getUrgent() { return urgent == "true" ? true : false; }
    public void setUrgent(Boolean urgent) { this.urgent = urgent == true ? "true" : "false"; }

    public Boolean getActive(){ return active == "true" ? true : false; }
    public void setActive(Boolean active){ this.active = active == true ? "true" : "false"; }

    public Boolean getPaid(){ return paid == "true" ? true : false; }
    public void setPaid(Boolean paid){ this.paid = paid == true ? "true" : "false"; }

}

