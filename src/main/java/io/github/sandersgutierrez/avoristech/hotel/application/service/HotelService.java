package io.github.sandersgutierrez.avoristech.hotel.application.service;

import io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.HotelRepository;
import io.github.sandersgutierrez.avoristech.hotel.application.exception.ResourceNotFoundException;
import io.github.sandersgutierrez.avoristech.hotel.application.port.in.HotelServicePort;
import io.github.sandersgutierrez.avoristech.hotel.domain.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public Hotel getById(Long hotelId) {
        Hotel hotel = hotelRepository.getById(hotelId);
        if (Objects.isNull(hotel)) {
            throw new RuntimeException("Hotel not found");
        }
        return hotel;
    }

    @Override
    public Hotel save(Hotel hotel) {
        Hotel hotelToSave = hotelRepository.getById(hotel.getId());
        if (Objects.nonNull(hotelToSave)) {
            throw new ResourceNotFoundException(String.format("Hotel: %s, it already exists", hotelToSave));
        }
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel update(Hotel hotel) {
        getById(hotel.getId());
        return hotelRepository.update(hotel);
    }

    @Override
    public void delete(Long hotelId) {
        getById(hotelId);
        hotelRepository.delete(hotelId);
    }
}
