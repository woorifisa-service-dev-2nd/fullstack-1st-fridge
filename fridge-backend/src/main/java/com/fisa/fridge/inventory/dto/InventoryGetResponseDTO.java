package com.fisa.fridge.inventory.dto;

import com.fisa.fridge.inventory.entity.Inventory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class InventoryGetResponseDTO {
    private Long inventoryId;

    private String foodName;

    private String category;

    private String ownerName;

    private String img;


}
