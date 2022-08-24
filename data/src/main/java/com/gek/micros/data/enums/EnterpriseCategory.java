package com.gek.micros.data.enums;

public enum EnterpriseCategory implements GekEnum<String> {
    FIRST("1"),
    SECOND("2"),
    THIRD("3"),
    ;

    private final String caption;

    EnterpriseCategory(String caption) {
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
