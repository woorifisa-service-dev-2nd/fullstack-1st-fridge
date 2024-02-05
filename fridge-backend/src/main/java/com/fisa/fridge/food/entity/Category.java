package com.fisa.fridge.food.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Category {

    @Id
    private String categoryId;
    private String category;
}
