package com.gek.micros.data.enums;

public enum UserRole implements GekEnum<String> {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER"),
    ;

    private final String caption;

    UserRole(String caption) {
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
