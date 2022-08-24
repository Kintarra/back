package com.gek.micros.backend.core.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Extension of PagingAndSortingRepository to provide additional methods to retrieve entities using predicate, paging
 * and sorting abstraction.
 */
@NoRepositoryBean
public interface GekRepository  <E, ID extends Serializable> extends PagingAndSortingRepository<E, ID> {
}
