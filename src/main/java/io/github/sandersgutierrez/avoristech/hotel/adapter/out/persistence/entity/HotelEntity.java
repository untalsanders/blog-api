package io.github.sandersgutierrez.avoristech.hotel.adapter.out.persistence.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "hotel")
public class HotelEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    protected HotelEntity() {}

    public HotelEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("HotelEntity[id='%d', name='%s']", getId(), getName());
    }
}
