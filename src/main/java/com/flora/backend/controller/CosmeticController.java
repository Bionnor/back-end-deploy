
package com.flora.backend.controller;

import com.flora.backend.dtos.Cosmetic.CosmeticSaveDTO;
import com.flora.backend.dtos.Cosmetic.CosmeticView;
import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.dtos.ResponsePageDTO;
import com.flora.backend.services.CosmeticService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
@RequestMapping("/cosmetics")
public class CosmeticController {
    @Autowired
    CosmeticService cosmeticService;

    @GetMapping
    public ResponsePageDTO<CosmeticView> getFilteredCosmetics(
            @RequestParam(required = false) String searchTerm,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "0") int pageNumber) {
        return cosmeticService.getFilteredCosmetics(searchTerm, categoryId, pageSize, pageNumber);
    }

    @GetMapping("/{id}")
    public CosmeticView getCosmetic(@PathVariable Long id) {
        return cosmeticService.getCosmetic(id);
    }


    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteCosmetic(@PathVariable Long productId) {
        boolean isDeleted = cosmeticService.deleteCosmetic(productId);

        if (isDeleted) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping("/")
    public CosmeticSaveDTO addCosmetic(@RequestBody CosmeticSaveDTO productSaveDTO) {
        return cosmeticService.addCosmetic(productSaveDTO);
    }
}

