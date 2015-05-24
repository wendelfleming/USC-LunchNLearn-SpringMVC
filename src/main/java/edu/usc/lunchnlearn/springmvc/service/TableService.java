package edu.usc.lunchnlearn.springmvc.service;

import java.util.List;

/**
 * Created by wfleming on 5/23/15.
 */
public interface TableService<T, ID> {

    List<T> findAll();
    T findOne(ID id);
    void delete(T entity);
    void save(T entity);


}
