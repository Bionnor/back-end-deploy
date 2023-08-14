
package com.flora.backend.services;

import com.flora.backend.dtos.Cosmetic.CosmeticSaveDTO;
import com.flora.backend.dtos.Cosmetic.CosmeticView;
import com.flora.backend.dtos.ResponsePageDTO;

public interface CosmeticService {
    ResponsePageDTO<CosmeticView> getFilteredCosmetics(String searchTerm, Long categoryId, int pageSize, int pageNumber);

    CosmeticView getCosmetic(Long id);

    boolean deleteCosmetic(Long productId);

    CosmeticSaveDTO addCosmetic(CosmeticSaveDTO productSaveDTO);
}
