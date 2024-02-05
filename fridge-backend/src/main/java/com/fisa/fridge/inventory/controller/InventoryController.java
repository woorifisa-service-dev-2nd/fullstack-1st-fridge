package com.fisa.fridge.inventory.controller;

import com.fisa.fridge.inventory.dto.InventoryGetRequestDTO;
import com.fisa.fridge.inventory.dto.InventoryGetResponseDTO;
import com.fisa.fridge.inventory.dto.InventoryDeleteRequestDTO;
import com.fisa.fridge.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("")
    public List<InventoryGetResponseDTO> getInventoryList () {
        return inventoryService.getInventoryList();
    }

    @PostMapping("")
    public void addInventory (@RequestBody @Valid InventoryGetRequestDTO inventoryGetRequestDTO) {
        inventoryService.addInventory(inventoryGetRequestDTO);
    }

    @DeleteMapping("")
    public void deleteInventory (@RequestBody @Valid InventoryDeleteRequestDTO inventoryDeleteRequestDTO) {
        inventoryService.deleteInventory(inventoryDeleteRequestDTO);
    }

}
