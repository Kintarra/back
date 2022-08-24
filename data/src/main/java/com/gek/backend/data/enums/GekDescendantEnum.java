package com.gek.backend.data.enums;

import java.io.Serializable;

public interface GekDescendantEnum<E> extends GekEnum<E>{
    GekEnum<Serializable> getParent();
}
