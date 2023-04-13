package io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.mapper;

import io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.entity.HotelEntity;
import io.github.sandersgutierrez.avoristech.hotel.domain.Hotel;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
    })
    public Hotel entityToDomain(HotelEntity hotelEntity);

    List<Hotel> toHotels(List<HotelEntity> hotelEntities);

    @InheritInverseConfiguration
    public HotelEntity domainToEntity(Hotel hotel);
}
