package com.fisa.fridge.inventory.dto;

import com.fisa.fridge.food.entity.Food;
import com.fisa.fridge.inventory.entity.Inventory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@Builder
@Setter
public class InventoryGetRequestDTO {

    @NotNull
    private Long foodId;

    @NotNull

    private String ownerName;
    @NotNull

    private String ownerPwd;

    public Inventory toEntity(Food food, String salt) {
        return Inventory.builder()
                .food(food)
                .ownerName(ownerName)
                .ownerPwd(ownerPwd)
                .ownerPwdSalt(salt)
                .build();
    }
}
