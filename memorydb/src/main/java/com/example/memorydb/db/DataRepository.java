package com.example.memorydb.db;

import java.util.List;
import java.util.Optional;

public interface DataRepository<T, ID> extends Repository<T, ID>{
    //C, U
    T save(T data);

    //R
    Optional<T> findById(ID id);
    List<T> findAll();

    //D
    void delete(ID id);
}
