package com.gek.micros.backend.core.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Extension of QuerydslPredicateExecutor to provide additional methods to retrieve entities using predicate
 * and sorting abstraction.
 */
@Primary
@NoRepositoryBean
public interface GekJpaRepository<E, ID extends Serializable> extends GekRepository<E, ID>, JpaRepository<E, ID> {
}
