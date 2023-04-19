package io.github.sandersgutierrez.avoristech.hotel.application.port.in;

import io.github.sandersgutierrez.avoristech.hotel.domain.Hotel;

import java.util.List;

public interface HotelServicePort {
    List<Hotel> getAll();
    Hotel getById(Long hotelId);
    Hotel save(Hotel hotel);
    Hotel update(Hotel hotel);
    void delete(Long hotelId);
}
