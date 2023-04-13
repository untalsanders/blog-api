package io.github.sandersgutierrez.avoristech.hotel.domain;

public final class Hotel {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return String.format("Hotel[id='%d', name='%s']", getId(), getName());
    }
}
