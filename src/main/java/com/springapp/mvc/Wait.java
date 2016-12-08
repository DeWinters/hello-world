package com.springapp.mvc;

import java.math.BigDecimal;

/**
 * Created by Administrator on 07/12/2016.
 */
public class Wait {

    private long id;
    private String name;
    private BigDecimal dayRate;
    private BigDecimal nightRate;
    private long minutes;

    public long getId(){ return id; }
    public void setId(long id){ this.id =id; }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public BigDecimal getDayRate(){ return dayRate; }
    public void setDayRate(BigDecimal dayRate){ this.dayRate = dayRate; }

    public BigDecimal getNightRate(){ return nightRate; }
    public void setNightRate(BigDecimal nightRate){ this.nightRate = nightRate;}

    public long InMinutes(){ return minutes; }
    public void setMinutes(long minutes){ this.minutes = minutes; }


}
