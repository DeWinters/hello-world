package com.springapp.mvc;

public class Invoice {

    private long id;
    private String invoiceName;
    private String password;
    private int age;

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

    private float tarif;    // Collect hourly tarif by comparing origin & destination to funwithspring.tarif (stop1 & stop2) tarif_rate
    private String region;  // Also collect region from funwithspring.tarif region

    /** Time Lord's Dilemma **/
    // DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); ????????
    //private Date date_stamp;
    //private Time collection;
    //private Time delivery;
    //private TimeSpan wait_time
    //private TimeSpan voyage = (delivery - collection) - wait_time
    /** Dr Who **/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInvoiceName() {
        return invoiceName;
    }

    public void setInvoiceName(String invoiceName) {
        this.invoiceName = invoiceName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() { return age;}

    public void setAge(int age) {this.age = age;}

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




    /** Calling Dr Who **/
    //public Date getDateStamp() { return date_stamp; }
    //public void setDateStamp(Date date_stamp) {this.date_stamp = date_stamp; }
    /** TimeLord Dilemma **/

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invoiceName='" + invoiceName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age + '\'' +
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
                '}';
    }
}
