package com.gek.backend.data.enums;

public enum DirectoryEntryType implements GekDescendantCodeEnum<String> {
    // HARDWARE
    CPU("HW", "CPU", Directory.HARDWARE),
    RAM("HW", "RAM", Directory.HARDWARE),
    MOTHERBOARD("HW", "Motherboard", Directory.HARDWARE),


    // FIRMWARE
    DEVICE_FIRMWARE("SW", "Device firmware", Directory.FIRMWARE),
    BIOS("SW", "BIOS", Directory.FIRMWARE),
    UEFI("SW", "UEFI", Directory.FIRMWARE),

    // SYSTEM_SOFTWARE
    BOOTLOADER("SW", "Bootloader", Directory.SYSTEM_SOFTWARE),
    DRIVER("SW", "Driver", Directory.SYSTEM_SOFTWARE),
    OS("SW", "OS", Directory.SYSTEM_SOFTWARE),

    // APPLICATION_SOFTWARE
    SOFTWARE_SECURITY_TOOL("SW", "Software security tool", Directory.APPLICATION_SOFTWARE),
    GENERAL_PURPOSE_SOFTWARE("SW", "General purpose software", Directory.APPLICATION_SOFTWARE),

    // OTHER
    VENDOR("OTH", "Vendor", Directory.VENDOR),
    ORG_MEASURE("OTH", "Org measure", Directory.ORG_MEASURE),
    ;

    private final  String code;
    private final  String caption;
    private final  Directory parent;

    DirectoryEntryType(String code, String caption, Directory parent) {
        this.code = code;
        this.caption = caption;
        this.parent = parent;
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
    public GekEnum getParent() {
        return parent;
    }

    @Override
    public String getCode() {
        return code;
    }
}
