package com.fisa.fridge.food.repository;

import com.fisa.fridge.food.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food,Long> {
    Optional<List<Food>> findFoodByCategoryCategory (String category);
}
