package com.springapp.mvc;

/**
 * Created by Administrator on 05/12/2016.
 */
public class Location {

    private long locationId;
    private String locationName;

    public long getLocationId(){ return locationId;}
    public void setLocationId(long locationId){ this.locationId = locationId; }

    public String getLocationName(){ return locationName; }
    public void setLocationName(String locationName){ this.locationName = locationName;}
}
