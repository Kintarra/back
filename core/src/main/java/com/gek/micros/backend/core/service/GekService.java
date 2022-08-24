package com.gek.micros.backend.core.service;


import com.gek.micros.backend.core.repository.GekRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Provides common methods to retrieve entities using predicate, paging and sorting abstraction.
 */
@NoRepositoryBean
public interface GekService<E, ID extends Serializable> extends GekRepository<E, ID> {
}
