package com.untalsanders.blog.shared.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public abstract class Identifier implements Serializable {
    final protected String value;

    protected Identifier(String value) {
        isValidUuid(value);
        this.value = value;
    }

    public Identifier() {
        /*this.value = null;*/
        this.value = UUID.randomUUID().toString();
    }

    public String value() {
        return value;
    }

    private void isValidUuid(String uuid) throws IllegalArgumentException {
        UUID.fromString(uuid);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
