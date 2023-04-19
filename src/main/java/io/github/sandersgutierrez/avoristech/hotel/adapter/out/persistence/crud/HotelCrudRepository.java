package io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.crud;

import io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelCrudRepository extends JpaRepository<HotelEntity, Long> {
}
