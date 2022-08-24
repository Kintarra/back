package com.gek.backend.data.enums;

public interface GekEnum <E> {

    static <T extends GekEnum> T valueOf(Class<? extends T> enumType, Object id) {
        for (T t :enumType.getEnumConstants()) {
            if (t.getId().equals(id)){
                return t;
            }
        }
        throw new IllegalArgumentException(String.format("No value exists for enumType: %s and id: %s", enumType, id));
    }

    String name();

    E getId();

    String getCaption();
}
