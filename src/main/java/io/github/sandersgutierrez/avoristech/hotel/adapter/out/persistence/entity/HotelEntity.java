package io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "hotel")
public class HotelEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    protected HotelEntity() {}

    public HotelEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("HotelEntity[id='%d', name='%s']", getId(), getName());
    }
}
