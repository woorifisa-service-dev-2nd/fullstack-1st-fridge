package com.fisa.fridge.food.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FoodResponseDTO {
    private Long foodId;
    private String categoryName;
    private String food;
    private String img;
    private String detail;

}
