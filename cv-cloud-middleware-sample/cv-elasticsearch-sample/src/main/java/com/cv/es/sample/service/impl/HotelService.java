package com.cv.es.sample.service.impl;

import com.cv.es.sample.pojo.dto.HotelDTO;
import com.cv.es.sample.pojo.query.HotelQuery;
import com.cv.es.sample.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author: xutu
 * @since: 2024/7/23 15:12
 */


@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public String addHotel(HotelQuery hotel) throws IOException {
        return hotelRepository.saveHotel(hotel);
    }

    public List<String> addHotelsBatch(List<HotelQuery> hotels) throws IOException {
        return hotelRepository.saveHotelsBatch(hotels);
    }

    public List<HotelDTO> getAllHotels() throws IOException {
        return hotelRepository.findAllHotels();
    }

    public List<HotelDTO> findNearbyHotels(double lat, double lon, double distance) throws IOException {
        return hotelRepository.findHotelsByLocation(lat, lon, distance);
    }

    public List<HotelDTO> findNearbyExpensiveHotels(double lat, double lon, double distance, double minPrice) throws IOException {
        return hotelRepository.findExpensiveHotelsByLocation(lat, lon, distance, minPrice);
    }


}


