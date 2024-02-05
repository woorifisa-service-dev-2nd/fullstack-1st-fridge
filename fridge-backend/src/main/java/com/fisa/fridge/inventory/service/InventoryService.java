package com.fisa.fridge.inventory.service;

import com.fisa.fridge.food.entity.Food;
import com.fisa.fridge.food.repository.FoodRepository;
import com.fisa.fridge.global.exception.NotFoundException;
import com.fisa.fridge.global.exception.PasswordIncorrectException;
import com.fisa.fridge.global.util.PasswordEncrypt;
import com.fisa.fridge.inventory.dto.InventoryGetRequestDTO;
import com.fisa.fridge.inventory.dto.InventoryGetResponseDTO;
import com.fisa.fridge.inventory.dto.InventoryDeleteRequestDTO;
import com.fisa.fridge.inventory.entity.Inventory;
import com.fisa.fridge.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final FoodRepository foodRepository;
    private final PasswordEncrypt passwordEncrypt;

    public List<InventoryGetResponseDTO> getInventoryList() {
        List<InventoryGetResponseDTO> inventoryGetResponseDTOList = new ArrayList<>();
        inventoryRepository.findAll().forEach(inventory -> inventoryGetResponseDTOList.add(inventory.toDto()));
        return inventoryGetResponseDTOList;
    }

    public void addInventory (InventoryGetRequestDTO inventoryGetRequestDTO) {
        Food food = foodRepository.findById(inventoryGetRequestDTO.getFoodId()).get();

        String salt = passwordEncrypt.getSalt();
        String encrypt = passwordEncrypt.getEncrypt(inventoryGetRequestDTO.getOwnerPwd(), salt);

        inventoryGetRequestDTO.setOwnerPwd(encrypt);
        inventoryRepository.save(inventoryGetRequestDTO.toEntity(food,salt ));
    }

    public void deleteInventory(InventoryDeleteRequestDTO inventoryDeleteRequestDTO) {
        boolean checkPassword = checkPassword(inventoryDeleteRequestDTO);
        if (checkPassword==true) {
            Long inventoryId = inventoryDeleteRequestDTO.getInventoryId();
            inventoryRepository.deleteById(inventoryId);
        }
    }

    public boolean checkPassword (InventoryDeleteRequestDTO inventoryDeleteRequestDTO) {
        Long inventoryId = inventoryDeleteRequestDTO.getInventoryId();

        Optional<Inventory> optional = inventoryRepository.findById(inventoryId);
        if(optional.isPresent()) {
            Inventory inventory = optional.get();
            String salt = inventory.getOwnerPwdSalt();
            String inputPassword = passwordEncrypt.getEncrypt(inventoryDeleteRequestDTO.getOwnerPassword(), salt);

            String realPassword = inventory.getOwnerPwd();

            if(inputPassword.equals(realPassword))
                return true;
            else  //에러 던지기
                throw new PasswordIncorrectException("비밀번호가 일치하지 않습니다.");
        }
        else {
            throw new NotFoundException("inventoryId("+inventoryId+")가 유효하지 않습니다.");
        }
    }
}
