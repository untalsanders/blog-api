package io.github.sandersgutierrez.avoristech.hotel.util;

import io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.crud.HotelCrudRepository;
import io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.entity.HotelEntity;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PopulateDB implements InitializingBean {

    private final HotelCrudRepository hotelCrudRepository;

    @Autowired
    public PopulateDB(HotelCrudRepository hotelCrudRepository) {
        this.hotelCrudRepository = hotelCrudRepository;
    }

    @Override
    public void afterPropertiesSet() {
        hotelCrudRepository.save(new HotelEntity(1L, "Hotel #1"));
        hotelCrudRepository.save(new HotelEntity(2L, "Hotel #2"));
    }
}
