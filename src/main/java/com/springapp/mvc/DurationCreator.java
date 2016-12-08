package com.springapp.mvc;

/**
 * Created by Administrator on 01/12/2016.
 */
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DurationCreator {

    private long elapsedHours;
    private long elapsedMinutes;

    DurationCreator(Date collection, Date delivery) {
        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long different = delivery.getTime() - collection.getTime();
        elapsedHours = different / hoursInMilli;
        if(this.elapsedHours < 0){
            different += 86400000;
            elapsedHours = different / hoursInMilli;
        }
        different = different % hoursInMilli;
        elapsedMinutes = different / minutesInMilli;
    }

    public long getElapsedHours() { return elapsedHours; }
    public long getElapsedMinutes() { return elapsedMinutes; }

    public String ToString(){
        String duration;
        duration = elapsedHours +"Hr "+ elapsedMinutes +"Mins";
        return duration;
    }

    public float InMinutes(){
        float inMinutes = getElapsedMinutes() + (getElapsedHours() * 60);
        return inMinutes;
    }

    public BigDecimal Calculator(BigDecimal tariff){
        BigDecimal calculation = new BigDecimal(InMinutes() / 60);
        calculation = calculation.multiply(tariff);
        return calculation;
    }

    // Special thanks to www.mykong.com for the formula for converting milliseconds
}
