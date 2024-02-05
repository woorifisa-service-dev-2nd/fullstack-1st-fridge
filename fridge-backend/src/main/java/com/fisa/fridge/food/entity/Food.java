package com.fisa.fridge.food.entity;

import com.fisa.fridge.food.dto.FoodResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodId;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    private String food;
    private String img;

    private String detail;

    public FoodResponseDTO toDto () {
        return FoodResponseDTO.builder()
                .foodId(foodId)
                .food(food)
                .detail(detail)
                .img(img)
                .categoryName(category.getCategory())
                .build();
    }
}
