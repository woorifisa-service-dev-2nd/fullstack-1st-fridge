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

    @NotNull(message = "foodId는 null이어서는 안됩니다.")
    private Long foodId;

    @NotNull(message = "ownerName는 null이어서는 안됩니다.")

    private String ownerName;
    @NotNull(message = "ownerPwd는 null이어서는 안됩니다.")

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
