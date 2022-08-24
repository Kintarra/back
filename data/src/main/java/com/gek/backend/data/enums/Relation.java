package com.gek.backend.data.enums;

public enum Relation implements GekEnum<String> {
    INTERNAL("INTERNAL"),
    EXTERNAL("EXTERNAL"),
    ;

    private final String caption;

    Relation(String caption) {
        this.caption = caption;
    }

    @Override
    public String getId() {
        return name();
    }

    @Override
    public String getCaption() {
        return caption;
    }

    @Override
    public String toString() {
        return getCaption();
    }
}
