package com.example.memorydb.entity;

import lombok.Data;
import lombok.Getter;

@Data
public abstract class Entity implements PrimaryKey{

    private Long id;
}
