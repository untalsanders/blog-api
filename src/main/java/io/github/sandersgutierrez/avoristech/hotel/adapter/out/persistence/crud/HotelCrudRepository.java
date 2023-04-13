package io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.crud;

import io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.entity.HotelEntity;
import org.springframework.data.repository.CrudRepository;

public interface HotelCrudRepository extends CrudRepository<HotelEntity, Long> {
}
