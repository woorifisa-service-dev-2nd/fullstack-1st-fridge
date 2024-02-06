package com.fisa.fridge.inventory.entity;

import com.fisa.fridge.food.entity.Food;
import com.fisa.fridge.inventory.dto.InventoryGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    @ManyToOne
    @JoinColumn(name = "foodId")
    private Food food;

    @Column
    private String ownerName;

    @Column
    private String ownerPwd;

    @Column
    private String ownerPwdSalt;


    public InventoryGetResponseDTO toDto () {
        return InventoryGetResponseDTO.builder()
                .inventoryId(inventoryId)
                .foodName(food.getFood())
                .ownerName(ownerName)
                .category(food.getCategory().getCategory())
                .img(food.getImg())
                .build();
    }

}
