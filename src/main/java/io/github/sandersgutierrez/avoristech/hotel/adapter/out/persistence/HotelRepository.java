package io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence;

import io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.crud.HotelCrudRepository;
import io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.entity.HotelEntity;
import io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.mapper.HotelMapper;
import io.github.sandersgutierrez.avoristech.hotel.application.port.out.HotelRepositoryPort;
import io.github.sandersgutierrez.avoristech.hotel.domain.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        List<HotelEntity> hotelEntityList = hotelCrudRepository.findAll();
        return hotelMapper.toHotels(hotelEntityList);
    }

    @Override
    public Hotel getById(Long hotelId) {
        return hotelCrudRepository.findById(hotelId).map(hotelMapper::entityToDomain).orElse(null);
    }

    @Override
    public Hotel save(Hotel hotel) {
        HotelEntity hotelEntity = hotelMapper.domainToEntity(hotel);
        return hotelMapper.entityToDomain(hotelCrudRepository.save(hotelEntity));
    }

    @Override
    public Hotel update(Hotel hotel) {
        HotelEntity hotelEntity = hotelMapper.domainToEntity(getById(hotel.getId()));
        hotelEntity.setId(hotel.getId());
        hotelEntity.setName(hotel.getName());
        return save(hotelMapper.entityToDomain(hotelEntity));
    }

    @Override
    public void delete(Long hotelId) {
        Hotel hotel = getById(hotelId);
        hotelCrudRepository.deleteById(hotel.getId());
    }
}
