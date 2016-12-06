package com.springapp.mvc;

import java.math.BigDecimal;

/**
 * Created by Administrator on 06/12/2016.
 */
public class Route {

    private long id;
    private int origin;
    private int destination;
    private BigDecimal dayTarif;
    private BigDecimal nightTarif;

    public long getId(){ return id; }
    public void setId(long id){ this.id = id; }

    public int getOrigin() { return origin; }
    public void setOrigin(int origin){ this.origin = origin; }

    public int getDestination() { return destination; }
    public void setDestination(int destination){ this.destination = destination; }

    public BigDecimal getDayTarif(){ return dayTarif; }
    public void setDayTarif(BigDecimal dayTarif){ this.dayTarif = dayTarif; }

    public BigDecimal getNightTarif(){ return nightTarif; }
    public void setNightTarif(BigDecimal nightTarif){ this.nightTarif = nightTarif;}

}
