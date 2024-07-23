package com.cv.es.sample.pojo.dto;

/**
 * @author: xutu
 * @since: 2024/7/23 15:13
 */
public class HotelDTO {
    private String name;
    private double lat;
    private double lon;
    private double price;
    private double rating;

    // Constructors, getters, and setters

    public HotelDTO(String name, double lat, double lon, double price, double rating) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
