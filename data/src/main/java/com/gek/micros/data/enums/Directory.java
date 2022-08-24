package com.gek.micros.data.enums;

public enum Directory implements GekCodeEnum<String> {
    HARDWARE("HW", "Hardware"),
    FIRMWARE("SW", "Firmware"),
    SYSTEM_SOFTWARE("SW", "System software"),
    APPLICATION_SOFTWARE("SW", "Application softwarE"),

    VENDOR("OTH", "Vendor"),
    ORG_MEASURE("OTH", "Org measure"),
    ;

    private final  String code;
    private final  String caption;

    Directory(String code, String caption) {
        this.code = code;
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

    @Override
    public String getCode() {
        return code;
    }
}
