package io.github.sandersgutierrez.avoristech.hotel.util;

import io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.crud.HotelCrudRepository;
import io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.entity.HotelEntity;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class PopulateDB implements InitializingBean {

    private HotelCrudRepository hotelCrudRepository;

    public PopulateDB(HotelCrudRepository hotelCrudRepository) {
        this.hotelCrudRepository = hotelCrudRepository;
    }

    @Override
    public void afterPropertiesSet() {
        hotelCrudRepository.save(new HotelEntity(1L, "Hotel #1"));
        hotelCrudRepository.save(new HotelEntity(2L, "Hotel #2"));
    }
}
