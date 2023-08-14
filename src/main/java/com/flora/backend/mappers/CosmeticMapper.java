package com.flora.backend.mappers;

import com.flora.backend.dtos.Cosmetic.CosmeticSaveDTO;
import com.flora.backend.dtos.Cosmetic.CosmeticView;
import com.flora.backend.dtos.Property.AcideGrasView;
import com.flora.backend.dtos.Property.FormuleView;
import com.flora.backend.dtos.Property.OrganolepticView;
import com.flora.backend.entities.CosmeticIngredient;
import com.flora.backend.entities.properties.AcidesGras;
import com.flora.backend.entities.properties.Formule;
import com.flora.backend.entities.properties.Organoleptic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CosmeticMapper {

    @Mapping(target="organoleptic", source="organoleptic")
    @Mapping(target="formule", source="formule")
    @Mapping(target="acideGras", source="acidesGras")
    CosmeticView fromCosmeticToCosmeticView(CosmeticIngredient cosmeticIngredient);

    OrganolepticView mapOrganolepticToView(Organoleptic organoleptic);
    FormuleView mapFormuleToView(Formule formule);
    AcideGrasView mapAcidesGrasToView(AcidesGras acidesGras);
    CosmeticIngredient fromCosmeticViewToCosmetic(CosmeticView cosmeticView);
    List<CosmeticView> getCosmeticsPage(Page<CosmeticIngredient> pages);

    @Mapping(target="organoleptic.id", source="organoleptic.id")
    @Mapping(target="formule.id", source="formule.id")
    @Mapping(target="acideGras.id", source="acidesGras.id")
    CosmeticSaveDTO fromCosmeticToCosmeticSave(CosmeticIngredient cosmeticIngredient);
    @Mapping(target="organoleptic.id", source="organoleptic.id")
    @Mapping(target="formule.id", source="formule.id")
    @Mapping(target="acidesGras.id", source="acideGras.id")
    CosmeticIngredient fromCosmeticSaveToCosmetic(CosmeticSaveDTO cosmeticSaveDTO);
}