package com.fisa.fridge.food.controller;

import com.fisa.fridge.food.dto.FoodResponseDTO;
import com.fisa.fridge.food.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @GetMapping("")
    public List<FoodResponseDTO> getFoodList (@RequestParam(required = false) String category) {
        System.out.println(category);
        return foodService.getFoodList(category);
    }

    @GetMapping("/{foodId}")
    public FoodResponseDTO getFood (@PathVariable Long foodId) {
        return foodService.getFood(foodId);
    }

}
