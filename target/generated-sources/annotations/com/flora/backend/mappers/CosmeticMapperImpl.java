package com.flora.backend.mappers;

import com.flora.backend.dtos.Category.CategoryView;
import com.flora.backend.dtos.Cosmetic.CosmeticSaveDTO;
import com.flora.backend.dtos.Cosmetic.CosmeticView;
import com.flora.backend.dtos.Property.AcideGrasSave;
import com.flora.backend.dtos.Property.AcideGrasView;
import com.flora.backend.dtos.Property.FormuleSave;
import com.flora.backend.dtos.Property.FormuleView;
import com.flora.backend.dtos.Property.OrganlopticSave;
import com.flora.backend.dtos.Property.OrganolepticView;
import com.flora.backend.entities.Category;
import com.flora.backend.entities.CosmeticIngredient;
import com.flora.backend.entities.properties.AcidesGras;
import com.flora.backend.entities.properties.Formule;
import com.flora.backend.entities.properties.Organoleptic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-17T15:20:26+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19 (Eclipse Adoptium)"
)
@Component
public class CosmeticMapperImpl implements CosmeticMapper {

    @Override
    public CosmeticView fromCosmeticToCosmeticView(CosmeticIngredient cosmeticIngredient) {
        if ( cosmeticIngredient == null ) {
            return null;
        }

        CosmeticView cosmeticView = new CosmeticView();

        if ( cosmeticIngredient.getOrganoleptic() != null ) {
            cosmeticView.setOrganoleptic( mapOrganolepticToView( cosmeticIngredient.getOrganoleptic() ) );
        }
        if ( cosmeticIngredient.getFormule() != null ) {
            cosmeticView.setFormule( mapFormuleToView( cosmeticIngredient.getFormule() ) );
        }
        if ( cosmeticIngredient.getAcidesGras() != null ) {
            cosmeticView.setAcideGras( mapAcidesGrasToView( cosmeticIngredient.getAcidesGras() ) );
        }
        if ( cosmeticIngredient.getId() != null ) {
            cosmeticView.setId( cosmeticIngredient.getId() );
        }
        if ( cosmeticIngredient.getName() != null ) {
            cosmeticView.setName( cosmeticIngredient.getName() );
        }
        if ( cosmeticIngredient.getDescription() != null ) {
            cosmeticView.setDescription( cosmeticIngredient.getDescription() );
        }
        cosmeticView.setPrice( cosmeticIngredient.getPrice() );
        cosmeticView.setQuantity( cosmeticIngredient.getQuantity() );
        if ( cosmeticIngredient.getCategory() != null ) {
            cosmeticView.setCategory( categoryToCategoryView( cosmeticIngredient.getCategory() ) );
        }
        if ( cosmeticIngredient.getImageUrl() != null ) {
            cosmeticView.setImageUrl( cosmeticIngredient.getImageUrl() );
        }
        if ( cosmeticIngredient.getCreatedAt() != null ) {
            cosmeticView.setCreatedAt( cosmeticIngredient.getCreatedAt() );
        }
        if ( cosmeticIngredient.getUpdatedAt() != null ) {
            cosmeticView.setUpdatedAt( cosmeticIngredient.getUpdatedAt() );
        }
        cosmeticView.setActive( cosmeticIngredient.isActive() );
        if ( cosmeticIngredient.getNombotanique() != null ) {
            cosmeticView.setNombotanique( cosmeticIngredient.getNombotanique() );
        }
        if ( cosmeticIngredient.getOrganepresse() != null ) {
            cosmeticView.setOrganepresse( cosmeticIngredient.getOrganepresse() );
        }
        if ( cosmeticIngredient.getObtention() != null ) {
            cosmeticView.setObtention( cosmeticIngredient.getObtention() );
        }
        if ( cosmeticIngredient.getPayorigine() != null ) {
            cosmeticView.setPayorigine( cosmeticIngredient.getPayorigine() );
        }
        int[] litrage = cosmeticIngredient.getLitrage();
        if ( litrage != null ) {
            cosmeticView.setLitrage( Arrays.copyOf( litrage, litrage.length ) );
        }

        return cosmeticView;
    }

    @Override
    public OrganolepticView mapOrganolepticToView(Organoleptic organoleptic) {
        if ( organoleptic == null ) {
            return null;
        }

        OrganolepticView organolepticView = new OrganolepticView();

        if ( organoleptic.getId() != null ) {
            organolepticView.setId( organoleptic.getId() );
        }
        if ( organoleptic.getAspect() != null ) {
            organolepticView.setAspect( organoleptic.getAspect() );
        }
        if ( organoleptic.getCouleur() != null ) {
            organolepticView.setCouleur( organoleptic.getCouleur() );
        }
        if ( organoleptic.getOdeur() != null ) {
            organolepticView.setOdeur( organoleptic.getOdeur() );
        }
        if ( organoleptic.getToucher() != null ) {
            organolepticView.setToucher( organoleptic.getToucher() );
        }

        return organolepticView;
    }

    @Override
    public FormuleView mapFormuleToView(Formule formule) {
        if ( formule == null ) {
            return null;
        }

        FormuleView formuleView = new FormuleView();

        if ( formule.getId() != null ) {
            formuleView.setId( formule.getId() );
        }
        if ( formule.getInsaponifiable() != null ) {
            formuleView.setInsaponifiable( formule.getInsaponifiable() );
        }
        if ( formule.getComedogenicite() != null ) {
            formuleView.setComedogenicite( formule.getComedogenicite() );
        }
        if ( formule.getSaponificationMoyenne() != null ) {
            formuleView.setSaponificationMoyenne( formule.getSaponificationMoyenne() );
        }
        if ( formule.getOxydation() != null ) {
            formuleView.setOxydation( formule.getOxydation() );
        }
        if ( formule.getStabiliteTemp() != null ) {
            formuleView.setStabiliteTemp( formule.getStabiliteTemp() );
        }
        if ( formule.getINCI() != null ) {
            formuleView.setINCI( formule.getINCI() );
        }

        return formuleView;
    }

    @Override
    public AcideGrasView mapAcidesGrasToView(AcidesGras acidesGras) {
        if ( acidesGras == null ) {
            return null;
        }

        AcideGrasView acideGrasView = new AcideGrasView();

        if ( acidesGras.getId() != null ) {
            acideGrasView.setId( acidesGras.getId() );
        }
        if ( acidesGras.getAcidepunicique() != null ) {
            acideGrasView.setAcidepunicique( acidesGras.getAcidepunicique() );
        }
        if ( acidesGras.getAcideoleique() != null ) {
            acideGrasView.setAcideoleique( acidesGras.getAcideoleique() );
        }
        if ( acidesGras.getAcidepalmitique() != null ) {
            acideGrasView.setAcidepalmitique( acidesGras.getAcidepalmitique() );
        }
        if ( acidesGras.getAcidestearique() != null ) {
            acideGrasView.setAcidestearique( acidesGras.getAcidestearique() );
        }
        if ( acidesGras.getAcidearachidique() != null ) {
            acideGrasView.setAcidearachidique( acidesGras.getAcidearachidique() );
        }
        if ( acidesGras.getAcidebehenique() != null ) {
            acideGrasView.setAcidebehenique( acidesGras.getAcidebehenique() );
        }
        if ( acidesGras.getAcidealphalinolenique() != null ) {
            acideGrasView.setAcidealphalinolenique( acidesGras.getAcidealphalinolenique() );
        }
        if ( acidesGras.getAcideeicosenoique() != null ) {
            acideGrasView.setAcideeicosenoique( acidesGras.getAcideeicosenoique() );
        }
        if ( acidesGras.getAcidelinoleique() != null ) {
            acideGrasView.setAcidelinoleique( acidesGras.getAcidelinoleique() );
        }
        if ( acidesGras.getAgs() != null ) {
            acideGrasView.setAgs( acidesGras.getAgs() );
        }
        if ( acidesGras.getAgmi() != null ) {
            acideGrasView.setAgmi( acidesGras.getAgmi() );
        }
        if ( acidesGras.getAgpi() != null ) {
            acideGrasView.setAgpi( acidesGras.getAgpi() );
        }

        return acideGrasView;
    }

    @Override
    public CosmeticIngredient fromCosmeticViewToCosmetic(CosmeticView cosmeticView) {
        if ( cosmeticView == null ) {
            return null;
        }

        CosmeticIngredient cosmeticIngredient = new CosmeticIngredient();

        if ( cosmeticView.getId() != null ) {
            cosmeticIngredient.setId( cosmeticView.getId() );
        }
        if ( cosmeticView.getName() != null ) {
            cosmeticIngredient.setName( cosmeticView.getName() );
        }
        int[] litrage = cosmeticView.getLitrage();
        if ( litrage != null ) {
            cosmeticIngredient.setLitrage( Arrays.copyOf( litrage, litrage.length ) );
        }
        if ( cosmeticView.getDescription() != null ) {
            cosmeticIngredient.setDescription( cosmeticView.getDescription() );
        }
        cosmeticIngredient.setPrice( cosmeticView.getPrice() );
        cosmeticIngredient.setQuantity( cosmeticView.getQuantity() );
        if ( cosmeticView.getCategory() != null ) {
            cosmeticIngredient.setCategory( categoryViewToCategory( cosmeticView.getCategory() ) );
        }
        if ( cosmeticView.getImageUrl() != null ) {
            cosmeticIngredient.setImageUrl( cosmeticView.getImageUrl() );
        }
        if ( cosmeticView.getCreatedAt() != null ) {
            cosmeticIngredient.setCreatedAt( cosmeticView.getCreatedAt() );
        }
        if ( cosmeticView.getUpdatedAt() != null ) {
            cosmeticIngredient.setUpdatedAt( cosmeticView.getUpdatedAt() );
        }
        cosmeticIngredient.setActive( cosmeticView.isActive() );
        if ( cosmeticView.getNombotanique() != null ) {
            cosmeticIngredient.setNombotanique( cosmeticView.getNombotanique() );
        }
        if ( cosmeticView.getOrganepresse() != null ) {
            cosmeticIngredient.setOrganepresse( cosmeticView.getOrganepresse() );
        }
        if ( cosmeticView.getObtention() != null ) {
            cosmeticIngredient.setObtention( cosmeticView.getObtention() );
        }
        if ( cosmeticView.getPayorigine() != null ) {
            cosmeticIngredient.setPayorigine( cosmeticView.getPayorigine() );
        }
        if ( cosmeticView.getOrganoleptic() != null ) {
            cosmeticIngredient.setOrganoleptic( organolepticViewToOrganoleptic( cosmeticView.getOrganoleptic() ) );
        }
        if ( cosmeticView.getFormule() != null ) {
            cosmeticIngredient.setFormule( formuleViewToFormule( cosmeticView.getFormule() ) );
        }

        return cosmeticIngredient;
    }

    @Override
    public List<CosmeticView> getCosmeticsPage(Page<CosmeticIngredient> pages) {
        if ( pages == null ) {
            return null;
        }

        List<CosmeticView> list = new ArrayList<CosmeticView>();
        for ( CosmeticIngredient cosmeticIngredient : pages ) {
            list.add( fromCosmeticToCosmeticView( cosmeticIngredient ) );
        }

        return list;
    }

    @Override
    public CosmeticSaveDTO fromCosmeticToCosmeticSave(CosmeticIngredient cosmeticIngredient) {
        if ( cosmeticIngredient == null ) {
            return null;
        }

        CosmeticSaveDTO cosmeticSaveDTO = new CosmeticSaveDTO();

        if ( cosmeticIngredient.getOrganoleptic() != null ) {
            cosmeticSaveDTO.setOrganoleptic( organolepticToOrganlopticSave( cosmeticIngredient.getOrganoleptic() ) );
        }
        if ( cosmeticIngredient.getFormule() != null ) {
            cosmeticSaveDTO.setFormule( formuleToFormuleSave( cosmeticIngredient.getFormule() ) );
        }
        if ( cosmeticIngredient.getAcidesGras() != null ) {
            cosmeticSaveDTO.setAcideGras( acidesGrasToAcideGrasSave( cosmeticIngredient.getAcidesGras() ) );
        }
        if ( cosmeticIngredient.getId() != null ) {
            cosmeticSaveDTO.setId( cosmeticIngredient.getId() );
        }
        if ( cosmeticIngredient.getName() != null ) {
            cosmeticSaveDTO.setName( cosmeticIngredient.getName() );
        }
        if ( cosmeticIngredient.getDescription() != null ) {
            cosmeticSaveDTO.setDescription( cosmeticIngredient.getDescription() );
        }
        cosmeticSaveDTO.setPrice( cosmeticIngredient.getPrice() );
        cosmeticSaveDTO.setQuantity( cosmeticIngredient.getQuantity() );
        if ( cosmeticIngredient.getImageUrl() != null ) {
            cosmeticSaveDTO.setImageUrl( cosmeticIngredient.getImageUrl() );
        }
        cosmeticSaveDTO.setActive( cosmeticIngredient.isActive() );
        if ( cosmeticIngredient.getNombotanique() != null ) {
            cosmeticSaveDTO.setNombotanique( cosmeticIngredient.getNombotanique() );
        }
        if ( cosmeticIngredient.getOrganepresse() != null ) {
            cosmeticSaveDTO.setOrganepresse( cosmeticIngredient.getOrganepresse() );
        }
        if ( cosmeticIngredient.getObtention() != null ) {
            cosmeticSaveDTO.setObtention( cosmeticIngredient.getObtention() );
        }
        if ( cosmeticIngredient.getPayorigine() != null ) {
            cosmeticSaveDTO.setPayorigine( cosmeticIngredient.getPayorigine() );
        }

        return cosmeticSaveDTO;
    }

    @Override
    public CosmeticIngredient fromCosmeticSaveToCosmetic(CosmeticSaveDTO cosmeticSaveDTO) {
        if ( cosmeticSaveDTO == null ) {
            return null;
        }

        CosmeticIngredient cosmeticIngredient = new CosmeticIngredient();

        if ( cosmeticSaveDTO.getOrganoleptic() != null ) {
            cosmeticIngredient.setOrganoleptic( organlopticSaveToOrganoleptic( cosmeticSaveDTO.getOrganoleptic() ) );
        }
        if ( cosmeticSaveDTO.getFormule() != null ) {
            cosmeticIngredient.setFormule( formuleSaveToFormule( cosmeticSaveDTO.getFormule() ) );
        }
        if ( cosmeticSaveDTO.getAcideGras() != null ) {
            cosmeticIngredient.setAcidesGras( acideGrasSaveToAcidesGras( cosmeticSaveDTO.getAcideGras() ) );
        }
        if ( cosmeticSaveDTO.getId() != null ) {
            cosmeticIngredient.setId( cosmeticSaveDTO.getId() );
        }
        if ( cosmeticSaveDTO.getName() != null ) {
            cosmeticIngredient.setName( cosmeticSaveDTO.getName() );
        }
        if ( cosmeticSaveDTO.getDescription() != null ) {
            cosmeticIngredient.setDescription( cosmeticSaveDTO.getDescription() );
        }
        cosmeticIngredient.setPrice( cosmeticSaveDTO.getPrice() );
        cosmeticIngredient.setQuantity( cosmeticSaveDTO.getQuantity() );
        if ( cosmeticSaveDTO.getImageUrl() != null ) {
            cosmeticIngredient.setImageUrl( cosmeticSaveDTO.getImageUrl() );
        }
        cosmeticIngredient.setActive( cosmeticSaveDTO.isActive() );
        if ( cosmeticSaveDTO.getNombotanique() != null ) {
            cosmeticIngredient.setNombotanique( cosmeticSaveDTO.getNombotanique() );
        }
        if ( cosmeticSaveDTO.getOrganepresse() != null ) {
            cosmeticIngredient.setOrganepresse( cosmeticSaveDTO.getOrganepresse() );
        }
        if ( cosmeticSaveDTO.getObtention() != null ) {
            cosmeticIngredient.setObtention( cosmeticSaveDTO.getObtention() );
        }
        if ( cosmeticSaveDTO.getPayorigine() != null ) {
            cosmeticIngredient.setPayorigine( cosmeticSaveDTO.getPayorigine() );
        }

        return cosmeticIngredient;
    }

    protected List<CategoryView> categoryListToCategoryViewList(List<Category> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryView> list1 = new ArrayList<CategoryView>( list.size() );
        for ( Category category : list ) {
            list1.add( categoryToCategoryView( category ) );
        }

        return list1;
    }

    protected CategoryView categoryToCategoryView(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryView categoryView = new CategoryView();

        if ( category.getId() != null ) {
            categoryView.setId( category.getId() );
        }
        if ( category.getName() != null ) {
            categoryView.setName( category.getName() );
        }
        if ( category.getDescription() != null ) {
            categoryView.setDescription( category.getDescription() );
        }
        if ( category.getCreatedAt() != null ) {
            categoryView.setCreatedAt( category.getCreatedAt() );
        }
        if ( category.getUpdatedAt() != null ) {
            categoryView.setUpdatedAt( category.getUpdatedAt() );
        }
        categoryView.setActive( category.isActive() );
        if ( category.getParentCategory() != null ) {
            categoryView.setParentCategory( categoryToCategoryView( category.getParentCategory() ) );
        }
        List<CategoryView> list = categoryListToCategoryViewList( category.getSubcategories() );
        if ( list != null ) {
            categoryView.setSubcategories( list );
        }

        return categoryView;
    }

    protected List<Category> categoryViewListToCategoryList(List<CategoryView> list) {
        if ( list == null ) {
            return null;
        }

        List<Category> list1 = new ArrayList<Category>( list.size() );
        for ( CategoryView categoryView : list ) {
            list1.add( categoryViewToCategory( categoryView ) );
        }

        return list1;
    }

    protected Category categoryViewToCategory(CategoryView categoryView) {
        if ( categoryView == null ) {
            return null;
        }

        Category category = new Category();

        if ( categoryView.getId() != null ) {
            category.setId( categoryView.getId() );
        }
        if ( categoryView.getName() != null ) {
            category.setName( categoryView.getName() );
        }
        if ( categoryView.getDescription() != null ) {
            category.setDescription( categoryView.getDescription() );
        }
        if ( categoryView.getCreatedAt() != null ) {
            category.setCreatedAt( categoryView.getCreatedAt() );
        }
        if ( categoryView.getUpdatedAt() != null ) {
            category.setUpdatedAt( categoryView.getUpdatedAt() );
        }
        category.setActive( categoryView.isActive() );
        if ( categoryView.getParentCategory() != null ) {
            category.setParentCategory( categoryViewToCategory( categoryView.getParentCategory() ) );
        }
        List<Category> list = categoryViewListToCategoryList( categoryView.getSubcategories() );
        if ( list != null ) {
            category.setSubcategories( list );
        }

        return category;
    }

    protected Organoleptic organolepticViewToOrganoleptic(OrganolepticView organolepticView) {
        if ( organolepticView == null ) {
            return null;
        }

        Organoleptic organoleptic = new Organoleptic();

        if ( organolepticView.getId() != null ) {
            organoleptic.setId( organolepticView.getId() );
        }
        if ( organolepticView.getAspect() != null ) {
            organoleptic.setAspect( organolepticView.getAspect() );
        }
        if ( organolepticView.getCouleur() != null ) {
            organoleptic.setCouleur( organolepticView.getCouleur() );
        }
        if ( organolepticView.getOdeur() != null ) {
            organoleptic.setOdeur( organolepticView.getOdeur() );
        }
        if ( organolepticView.getToucher() != null ) {
            organoleptic.setToucher( organolepticView.getToucher() );
        }

        return organoleptic;
    }

    protected Formule formuleViewToFormule(FormuleView formuleView) {
        if ( formuleView == null ) {
            return null;
        }

        Formule formule = new Formule();

        if ( formuleView.getId() != null ) {
            formule.setId( formuleView.getId() );
        }
        if ( formuleView.getInsaponifiable() != null ) {
            formule.setInsaponifiable( formuleView.getInsaponifiable() );
        }
        if ( formuleView.getComedogenicite() != null ) {
            formule.setComedogenicite( formuleView.getComedogenicite() );
        }
        if ( formuleView.getSaponificationMoyenne() != null ) {
            formule.setSaponificationMoyenne( formuleView.getSaponificationMoyenne() );
        }
        if ( formuleView.getOxydation() != null ) {
            formule.setOxydation( formuleView.getOxydation() );
        }
        if ( formuleView.getStabiliteTemp() != null ) {
            formule.setStabiliteTemp( formuleView.getStabiliteTemp() );
        }
        if ( formuleView.getINCI() != null ) {
            formule.setINCI( formuleView.getINCI() );
        }

        return formule;
    }

    protected OrganlopticSave organolepticToOrganlopticSave(Organoleptic organoleptic) {
        if ( organoleptic == null ) {
            return null;
        }

        OrganlopticSave organlopticSave = new OrganlopticSave();

        if ( organoleptic.getId() != null ) {
            organlopticSave.setId( organoleptic.getId() );
        }
        if ( organoleptic.getAspect() != null ) {
            organlopticSave.setAspect( organoleptic.getAspect() );
        }
        if ( organoleptic.getCouleur() != null ) {
            organlopticSave.setCouleur( organoleptic.getCouleur() );
        }
        if ( organoleptic.getOdeur() != null ) {
            organlopticSave.setOdeur( organoleptic.getOdeur() );
        }
        if ( organoleptic.getToucher() != null ) {
            organlopticSave.setToucher( organoleptic.getToucher() );
        }

        return organlopticSave;
    }

    protected FormuleSave formuleToFormuleSave(Formule formule) {
        if ( formule == null ) {
            return null;
        }

        FormuleSave formuleSave = new FormuleSave();

        if ( formule.getId() != null ) {
            formuleSave.setId( formule.getId() );
        }
        if ( formule.getInsaponifiable() != null ) {
            formuleSave.setInsaponifiable( formule.getInsaponifiable() );
        }
        if ( formule.getComedogenicite() != null ) {
            formuleSave.setComedogenicite( formule.getComedogenicite() );
        }
        if ( formule.getSaponificationMoyenne() != null ) {
            formuleSave.setSaponificationMoyenne( formule.getSaponificationMoyenne() );
        }
        if ( formule.getOxydation() != null ) {
            formuleSave.setOxydation( formule.getOxydation() );
        }
        if ( formule.getStabiliteTemp() != null ) {
            formuleSave.setStabiliteTemp( formule.getStabiliteTemp() );
        }
        if ( formule.getINCI() != null ) {
            formuleSave.setINCI( formule.getINCI() );
        }

        return formuleSave;
    }

    protected AcideGrasSave acidesGrasToAcideGrasSave(AcidesGras acidesGras) {
        if ( acidesGras == null ) {
            return null;
        }

        AcideGrasSave acideGrasSave = new AcideGrasSave();

        if ( acidesGras.getId() != null ) {
            acideGrasSave.setId( acidesGras.getId() );
        }
        if ( acidesGras.getAcidepunicique() != null ) {
            acideGrasSave.setAcidepunicique( acidesGras.getAcidepunicique() );
        }
        if ( acidesGras.getAcideoleique() != null ) {
            acideGrasSave.setAcideoleique( acidesGras.getAcideoleique() );
        }
        if ( acidesGras.getAcidepalmitique() != null ) {
            acideGrasSave.setAcidepalmitique( acidesGras.getAcidepalmitique() );
        }
        if ( acidesGras.getAcidestearique() != null ) {
            acideGrasSave.setAcidestearique( acidesGras.getAcidestearique() );
        }
        if ( acidesGras.getAcidearachidique() != null ) {
            acideGrasSave.setAcidearachidique( acidesGras.getAcidearachidique() );
        }
        if ( acidesGras.getAcidebehenique() != null ) {
            acideGrasSave.setAcidebehenique( acidesGras.getAcidebehenique() );
        }
        if ( acidesGras.getAcidealphalinolenique() != null ) {
            acideGrasSave.setAcidealphalinolenique( acidesGras.getAcidealphalinolenique() );
        }
        if ( acidesGras.getAcideeicosenoique() != null ) {
            acideGrasSave.setAcideeicosenoique( acidesGras.getAcideeicosenoique() );
        }
        if ( acidesGras.getAcidelinoleique() != null ) {
            acideGrasSave.setAcidelinoleique( acidesGras.getAcidelinoleique() );
        }
        if ( acidesGras.getAgs() != null ) {
            acideGrasSave.setAgs( acidesGras.getAgs() );
        }
        if ( acidesGras.getAgmi() != null ) {
            acideGrasSave.setAgmi( acidesGras.getAgmi() );
        }
        if ( acidesGras.getAgpi() != null ) {
            acideGrasSave.setAgpi( acidesGras.getAgpi() );
        }

        return acideGrasSave;
    }

    protected Organoleptic organlopticSaveToOrganoleptic(OrganlopticSave organlopticSave) {
        if ( organlopticSave == null ) {
            return null;
        }

        Organoleptic organoleptic = new Organoleptic();

        if ( organlopticSave.getId() != null ) {
            organoleptic.setId( organlopticSave.getId() );
        }
        if ( organlopticSave.getAspect() != null ) {
            organoleptic.setAspect( organlopticSave.getAspect() );
        }
        if ( organlopticSave.getCouleur() != null ) {
            organoleptic.setCouleur( organlopticSave.getCouleur() );
        }
        if ( organlopticSave.getOdeur() != null ) {
            organoleptic.setOdeur( organlopticSave.getOdeur() );
        }
        if ( organlopticSave.getToucher() != null ) {
            organoleptic.setToucher( organlopticSave.getToucher() );
        }

        return organoleptic;
    }

    protected Formule formuleSaveToFormule(FormuleSave formuleSave) {
        if ( formuleSave == null ) {
            return null;
        }

        Formule formule = new Formule();

        if ( formuleSave.getId() != null ) {
            formule.setId( formuleSave.getId() );
        }
        if ( formuleSave.getInsaponifiable() != null ) {
            formule.setInsaponifiable( formuleSave.getInsaponifiable() );
        }
        if ( formuleSave.getComedogenicite() != null ) {
            formule.setComedogenicite( formuleSave.getComedogenicite() );
        }
        if ( formuleSave.getSaponificationMoyenne() != null ) {
            formule.setSaponificationMoyenne( formuleSave.getSaponificationMoyenne() );
        }
        if ( formuleSave.getOxydation() != null ) {
            formule.setOxydation( formuleSave.getOxydation() );
        }
        if ( formuleSave.getStabiliteTemp() != null ) {
            formule.setStabiliteTemp( formuleSave.getStabiliteTemp() );
        }
        if ( formuleSave.getINCI() != null ) {
            formule.setINCI( formuleSave.getINCI() );
        }

        return formule;
    }

    protected AcidesGras acideGrasSaveToAcidesGras(AcideGrasSave acideGrasSave) {
        if ( acideGrasSave == null ) {
            return null;
        }

        AcidesGras acidesGras = new AcidesGras();

        if ( acideGrasSave.getId() != null ) {
            acidesGras.setId( acideGrasSave.getId() );
        }
        if ( acideGrasSave.getAcidepunicique() != null ) {
            acidesGras.setAcidepunicique( acideGrasSave.getAcidepunicique() );
        }
        if ( acideGrasSave.getAcideoleique() != null ) {
            acidesGras.setAcideoleique( acideGrasSave.getAcideoleique() );
        }
        if ( acideGrasSave.getAcidepalmitique() != null ) {
            acidesGras.setAcidepalmitique( acideGrasSave.getAcidepalmitique() );
        }
        if ( acideGrasSave.getAcidestearique() != null ) {
            acidesGras.setAcidestearique( acideGrasSave.getAcidestearique() );
        }
        if ( acideGrasSave.getAcidearachidique() != null ) {
            acidesGras.setAcidearachidique( acideGrasSave.getAcidearachidique() );
        }
        if ( acideGrasSave.getAcidebehenique() != null ) {
            acidesGras.setAcidebehenique( acideGrasSave.getAcidebehenique() );
        }
        if ( acideGrasSave.getAcidealphalinolenique() != null ) {
            acidesGras.setAcidealphalinolenique( acideGrasSave.getAcidealphalinolenique() );
        }
        if ( acideGrasSave.getAcideeicosenoique() != null ) {
            acidesGras.setAcideeicosenoique( acideGrasSave.getAcideeicosenoique() );
        }
        if ( acideGrasSave.getAcidelinoleique() != null ) {
            acidesGras.setAcidelinoleique( acideGrasSave.getAcidelinoleique() );
        }
        if ( acideGrasSave.getAgs() != null ) {
            acidesGras.setAgs( acideGrasSave.getAgs() );
        }
        if ( acideGrasSave.getAgmi() != null ) {
            acidesGras.setAgmi( acideGrasSave.getAgmi() );
        }
        if ( acideGrasSave.getAgpi() != null ) {
            acidesGras.setAgpi( acideGrasSave.getAgpi() );
        }

        return acidesGras;
    }
}
