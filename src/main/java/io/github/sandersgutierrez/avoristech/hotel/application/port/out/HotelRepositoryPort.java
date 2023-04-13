package io.github.sandersgutierrez.avoristech.hotel.application.port.out;

import io.github.sandersgutierrez.avoristech.hotel.domain.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelRepositoryPort {
    List<Hotel> getAll();
    Optional<Hotel> getById(Long id);
    Hotel save(Hotel hotel);
    void delete(Long id);
}
