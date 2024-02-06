package com.fisa.fridge.inventory.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class InventoryDeleteRequestDTO {

    @NotNull(message = "inventoryId는 null이어서는 안됩니다.")
    private Long inventoryId;

    @NotNull(message = "ownerPassword는 null이어서는 안됩니다.")
    private String ownerPassword;
}
