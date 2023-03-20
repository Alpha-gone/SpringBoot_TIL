package com.example.memorydb.db;

import com.example.memorydb.entity.Entity;

import java.util.*;

public abstract class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T, ID> {
    private List<T> dataList = new ArrayList<>();
    private static long index = 0;
    private Comparator<T> sort = Comparator.comparingLong(Entity::getId);

    //C, U
    @Override
    public T save(T data) {
        if (Objects.isNull(data)) throw new RuntimeException("Data is Null");

        var prevData = dataList.stream().filter(it -> it.getId().equals(data.getId())).findFirst();

        if (prevData.isPresent()){
            //기존 데이터 존재
            dataList.remove(prevData.get());
            dataList.add(data);
        }else{
            //기존 데이터 미존재

            data.setId(index++);
            dataList.add(data);

        }

        return data;
    }

    //R
    @Override
    public Optional<T> findById(ID id) {
        return dataList.stream().filter(it -> it.getId().equals(id)).findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList.stream().sorted(sort).toList();
    }

    //D

    @Override
    public void delete(ID id) {
        var deleteEntity = dataList.stream().filter(it -> it.getId().equals(id)).findFirst();

        if (deleteEntity.isPresent()) dataList.remove(deleteEntity.get());
    }
}
