package com.gek.micros.backend.core.controller;

import java.io.Serializable;
import java.util.List;
import java.util.function.Predicate;
import javax.servlet.http.HttpServletRequest;

public interface CrudApi <E, ID extends Serializable> {

    public <T extends  E> List<T> getAllByPredicate (Predicate predicate);

    public E getById(ID id);

    public E create (E e, HttpServletRequest request);

    public E update (ID id, E e, HttpServletRequest request);

    public void delete (ID id, HttpServletRequest request);
}
