package com.fisa.fridge.food.service;

import com.fisa.fridge.food.dto.FoodResponseDTO;
import com.fisa.fridge.food.entity.Food;
import com.fisa.fridge.food.repository.FoodRepository;
import com.fisa.fridge.global.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;
    public FoodResponseDTO getFood(Long foodId) {
        Optional<Food> optional = foodRepository.findById(foodId);
        if(optional.isPresent()) {
            return optional.get().toDto();
        }
        else
            throw new NotFoundException("foodId("+foodId+")가 유효하지 않습니다.");
    }

    public List<FoodResponseDTO> getFoodList (String category) {
        List<FoodResponseDTO> foodResponseDTOList = new ArrayList<>();
        if(category == null)
            foodRepository.findAll().forEach(food -> foodResponseDTOList.add(food.toDto()));
        else {
            Optional<List<Food>> optionalFoodByCategory = foodRepository.findFoodByCategoryCategory(category);
            if(optionalFoodByCategory.isPresent()) {
                optionalFoodByCategory.get().forEach(food -> foodResponseDTOList.add(food.toDto()));
            }
        }
        return foodResponseDTOList;
    }
}
