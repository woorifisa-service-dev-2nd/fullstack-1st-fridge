package com.fisa.fridge.inventory.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class InventoryDeleteRequestDTO {

    @NotNull
    private Long inventoryId;

    @NotNull
    private String ownerPassword;
}
