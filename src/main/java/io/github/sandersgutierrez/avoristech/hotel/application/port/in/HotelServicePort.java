package io.github.sandersgutierrez.avoristech.hotel.application.port.in;

import io.github.sandersgutierrez.avoristech.hotel.domain.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelServicePort {
    List<Hotel> getAll();
    Optional<Hotel> getById(Long id);
    Hotel save(Hotel hotel);
    boolean delete(Long id);
}
