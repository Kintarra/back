package com.gek.micros.backend.core.service;

import com.gek.micros.backend.core.repository.GekJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface GekJpaService <E, ID extends Serializable> extends GekService<E, ID>, GekJpaRepository<E, ID> {
}
