package io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence;

import io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.crud.HotelCrudRepository;
import io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.entity.HotelEntity;
import io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.mapper.HotelMapper;
import io.github.sandersgutierrez.avoristech.hotel.application.port.out.HotelRepositoryPort;
import io.github.sandersgutierrez.avoristech.hotel.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HotelRepository implements HotelRepositoryPort {

    private final HotelCrudRepository hotelCrudRepository;

    private final HotelMapper hotelMapper;

    @Autowired
    public HotelRepository(HotelCrudRepository hotelCrudRepository, HotelMapper hotelMapper) {
        this.hotelCrudRepository = hotelCrudRepository;
        this.hotelMapper = hotelMapper;
    }

    @Override
    public List<Hotel> getAll() {
        List<HotelEntity> hotelList = (List<HotelEntity>) hotelCrudRepository.findAll();
        return hotelMapper.toHotels(hotelList);
    }

    @Override
    public Optional<Hotel> getById(Long id) {
        return hotelCrudRepository.findById(id).map(hotelMapper::entityToDomain);
    }

    @Override
    public Hotel save(Hotel hotel) {
        HotelEntity hotelEntity = hotelMapper.domainToEntity(hotel);
        return hotelMapper.entityToDomain(hotelCrudRepository.save(hotelEntity));
    }

    @Override
    public void delete(Long id) {
        hotelCrudRepository.deleteById(id);
    }
}
