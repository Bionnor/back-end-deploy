package com.flora.backend.mappers.Property;

import com.flora.backend.dtos.Property.FormuleSave;
import com.flora.backend.entities.properties.Formule;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-17T15:20:26+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19 (Eclipse Adoptium)"
)
@Component
public class FormuleMapperImpl implements FormuleMapper {

    @Override
    public FormuleSave fromFormuleToFormuleSave(Formule formule) {
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

    @Override
    public Formule fromFormuleSaveToFormule(FormuleSave formuleSave) {
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
}
