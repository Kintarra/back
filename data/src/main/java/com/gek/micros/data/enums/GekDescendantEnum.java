package com.gek.micros.data.enums;

import java.io.Serializable;

public interface GekDescendantEnum<E> extends GekEnum<E>{
    GekEnum<Serializable> getParent();
}
