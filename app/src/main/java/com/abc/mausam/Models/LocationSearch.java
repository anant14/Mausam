package com.abc.mausam.Models;

/**
 * Created by Nikhil Arora on 08-07-2017.
 */

public class LocationSearch {

    String title;
    String location_type;
    Integer woeid;

    public LocationSearch(String title, String location_type, Integer woeid) {
        this.title = title;
        this.location_type = location_type;
        this.woeid = woeid;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation_type() {
        return location_type;
    }

    public Integer getWoeid() {
        return woeid;
    }

}
