
package com.flora.backend.services;

import com.flora.backend.dtos.Cosmetic.CosmeticSaveDTO;
import com.flora.backend.dtos.Cosmetic.CosmeticView;
import com.flora.backend.dtos.Product.ProductSaveDTO;
import com.flora.backend.dtos.ResponsePageDTO;
import com.flora.backend.entities.Category;
import com.flora.backend.entities.CosmeticIngredient;

import com.flora.backend.entities.FinalProduct;
import com.flora.backend.entities.properties.AcidesGras;
import com.flora.backend.entities.properties.Formule;
import com.flora.backend.entities.properties.Organoleptic;
import com.flora.backend.mappers.CosmeticMapper;
import com.flora.backend.repository.CosmeticIngredientRepository;
import com.flora.backend.repository.FoodIngredientRepository;
import com.flora.backend.repository.properties.AcideGrasRepository;
import com.flora.backend.repository.properties.FormuleRepository;
import com.flora.backend.repository.properties.OrganolepticRepository;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
@NoArgsConstructor
@Slf4j
public class CosmeticServiceImp implements  CosmeticService{
    @Autowired
    private CosmeticIngredientRepository cosmeticIngredientRepository;
    @Autowired
    private FormuleRepository formuleRepository;
    @Autowired
    private AcideGrasRepository acideGrasRepository;
    @Autowired
    private OrganolepticRepository organolepticRepository;

    @Autowired
    private CosmeticMapper cosmeticMapper;



    @Transactional(readOnly = true)
    @Override
    public ResponsePageDTO<CosmeticView> getFilteredCosmetics(String searchTerm, Long categoryId, int pageSize, int pageNumber) {

        Specification<CosmeticIngredient> specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (searchTerm != null && !searchTerm.isEmpty()) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + searchTerm.toLowerCase() + "%"));
            }

            if (categoryId != null) {
                Join<CosmeticIngredient, Category> categoryJoin = root.join("category");
                predicates.add(criteriaBuilder.equal(categoryJoin.get("id"), categoryId));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
        Page<CosmeticIngredient> pages=  cosmeticIngredientRepository.findAll(specification, PageRequest.of(pageNumber, pageSize));
        ResponsePageDTO<CosmeticView> productViewResponsePageDTO= new ResponsePageDTO();
        productViewResponsePageDTO.setResponseList(cosmeticMapper.getCosmeticsPage(pages));
        productViewResponsePageDTO.setTotalPages(pages.getTotalPages());
        productViewResponsePageDTO.setCurrentPage(pageNumber);
        productViewResponsePageDTO.setPageSize(pageSize);
        return productViewResponsePageDTO;
    }

    @Override
    public CosmeticView getCosmetic(Long id) {

        return cosmeticMapper.fromCosmeticToCosmeticView(cosmeticIngredientRepository.findById(id).orElseThrow(()->new RuntimeException("not found")));

    }

    @Override
    public boolean deleteCosmetic(Long productId) {

            // Check if the product with the given ID exists
            CosmeticIngredient existingProduct = cosmeticIngredientRepository.findById(productId).orElse(null);
            if (existingProduct != null) {
                cosmeticIngredientRepository.delete(existingProduct);
                return true;
            }
            return false;
    }

    @Override
    public CosmeticSaveDTO addCosmetic(CosmeticSaveDTO productSaveDTO) {

        // Set associations
        CosmeticIngredient product=cosmeticMapper.fromCosmeticSaveToCosmetic(productSaveDTO);
        product.setCreatedAt(new Date());
        log.info(productSaveDTO.toString());
        // Save related entities first
        organolepticRepository.save(product.getOrganoleptic());
        formuleRepository.save(product.getFormule());
        acideGrasRepository.save(product.getAcidesGras());

        return cosmeticMapper.fromCosmeticToCosmeticSave(cosmeticIngredientRepository.save(product));
    }


}

