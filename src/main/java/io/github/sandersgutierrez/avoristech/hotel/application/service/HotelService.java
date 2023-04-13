package io.github.sandersgutierrez.avoristech.hotel.application.service;

import io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.HotelRepository;
import io.github.sandersgutierrez.avoristech.hotel.application.port.in.HotelServicePort;
import io.github.sandersgutierrez.avoristech.hotel.domain.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService implements HotelServicePort {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.getAll();
    }

    @Override
    public Optional<Hotel> getById(Long id) {
        return hotelRepository.getById(id);
    }

    @Override
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public boolean delete(Long id) {
        return getById(id).map(hotel -> {
            hotelRepository.delete(id);
            return  true;
        }).orElse(false);
    }
}
