
package com.flora.backend.controller;

import com.flora.backend.dtos.Cosmetic.CosmeticSaveDTO;
import com.flora.backend.dtos.Cosmetic.CosmeticView;
import com.flora.backend.dtos.Product.ProductSaveDTO;
import com.flora.backend.dtos.Product.ProductView;
import com.flora.backend.dtos.Property.AcideGrasSave;
import com.flora.backend.dtos.Property.FormuleSave;
import com.flora.backend.dtos.Property.OrganlopticSave;
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
@RequestMapping("api/v1/cosmetics")
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

    @PutMapping("/organoleptic/{id}")
    public CosmeticSaveDTO addOrganolepticToCosmeticIngredient(@PathVariable Long id,@RequestBody OrganlopticSave organlopticSave) {
        return cosmeticService.addOrganlopticToCometic(id,organlopticSave);
    }
    @PutMapping("/formule/{id}")
    public CosmeticSaveDTO addFormuleToCosmeticIngredient(@PathVariable Long id,@RequestBody FormuleSave formuleSave) {
        return cosmeticService.addFormuleToCometic(id,formuleSave);
    }
    @PutMapping("/acides/{id}")
    public CosmeticSaveDTO addAcidesToCosmeticIngredient(@PathVariable Long id,@RequestBody AcideGrasSave acideGrasSave) {
        return cosmeticService.addAcidesToCometic(id,acideGrasSave);
    }




    @PutMapping("/{productId}")
    public ResponseEntity<CosmeticSaveDTO> updateCosmetic(@PathVariable Long productId, @RequestBody CosmeticSaveDTO updatedProduct) {
        CosmeticSaveDTO result = cosmeticService.updateCosmetic(productId, updatedProduct);
        log.info(result.toString());
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

