package com.gek.micros.data.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Revision implements GekEnum<Integer> {
    INITIAL(0),
    DRAFT(1),
    FINAL(2),
    ;

    private final Integer id;

    Revision(Integer caption) {
        this.id = caption;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    @JsonValue
    public String getCaption() {
        return name();
    }

    @Override
    public String toString() {
        return name();
    }

    public Revision next() {
        return values()[(this.ordinal()+1) % values().length];
    }
}
