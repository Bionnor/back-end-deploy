
package com.flora.backend.services;

import com.flora.backend.dtos.Cosmetic.CosmeticSaveDTO;
import com.flora.backend.dtos.Cosmetic.CosmeticView;
import com.flora.backend.dtos.Property.AcideGrasSave;
import com.flora.backend.dtos.Property.FormuleSave;
import com.flora.backend.dtos.Property.OrganlopticSave;
import com.flora.backend.dtos.ResponsePageDTO;

public interface CosmeticService {
    ResponsePageDTO<CosmeticView> getFilteredCosmetics(String searchTerm, Long categoryId, int pageSize, int pageNumber);

    CosmeticView getCosmetic(Long id);

    boolean deleteCosmetic(Long productId);

    CosmeticSaveDTO addCosmetic(CosmeticSaveDTO productSaveDTO);

    CosmeticSaveDTO addOrganlopticToCometic(Long id, OrganlopticSave organlopticSave);
    CosmeticSaveDTO addFormuleToCometic(Long id, FormuleSave formuleSave);
    CosmeticSaveDTO addAcidesToCometic(Long id, AcideGrasSave acideGrasSave);

    CosmeticSaveDTO updateCosmetic(Long productId, CosmeticSaveDTO updatedProduct);
}
