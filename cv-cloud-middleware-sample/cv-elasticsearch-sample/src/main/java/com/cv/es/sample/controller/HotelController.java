package com.cv.es.sample.controller;

import com.cv.es.sample.pojo.dto.HotelDTO;
import com.cv.es.sample.pojo.query.HotelQuery;
import com.cv.es.sample.service.impl.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author: xutu
 * @since: 2024/7/23 15:11
 */
@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/add")
    public String addHotel(@RequestBody HotelQuery hotel) throws IOException {
        return hotelService.addHotel(hotel);
    }

    @PostMapping("/batchAdd")
    public List<String> addHotelsBatch(@RequestBody List<HotelQuery> hotels) throws IOException {
        return hotelService.addHotelsBatch(hotels);
    }


    @GetMapping("/nearby")
    public List<HotelDTO> findNearbyHotels(
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam(defaultValue = "5.0") double distance) throws IOException {
        return hotelService.findNearbyHotels(lat, lon, distance);
    }

    @GetMapping("/nearbyExpensive")
    public List<HotelDTO> findNearbyExpensiveHotels(
            @RequestParam double lat,
            @RequestParam double lon,
            @RequestParam(defaultValue = "3.0") double distance,
            @RequestParam(defaultValue = "500.0") double minPrice) throws IOException {
        return hotelService.findNearbyExpensiveHotels(lat, lon, distance, minPrice);
    }


}

