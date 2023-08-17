package com.flora.backend.mappers.Property;

import com.flora.backend.dtos.Property.OrganlopticSave;
import com.flora.backend.entities.properties.Organoleptic;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-17T15:20:26+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19 (Eclipse Adoptium)"
)
@Component
public class OrganolepticMapperImpl implements OrganolepticMapper {

    @Override
    public OrganlopticSave fromOrganolepticToOrganolepticSave(Organoleptic organloptic) {
        if ( organloptic == null ) {
            return null;
        }

        OrganlopticSave organlopticSave = new OrganlopticSave();

        if ( organloptic.getId() != null ) {
            organlopticSave.setId( organloptic.getId() );
        }
        if ( organloptic.getAspect() != null ) {
            organlopticSave.setAspect( organloptic.getAspect() );
        }
        if ( organloptic.getCouleur() != null ) {
            organlopticSave.setCouleur( organloptic.getCouleur() );
        }
        if ( organloptic.getOdeur() != null ) {
            organlopticSave.setOdeur( organloptic.getOdeur() );
        }
        if ( organloptic.getToucher() != null ) {
            organlopticSave.setToucher( organloptic.getToucher() );
        }

        return organlopticSave;
    }

    @Override
    public Organoleptic fromOrganolepticSaveToOrganoleptic(OrganlopticSave organlopticSave) {
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
}
