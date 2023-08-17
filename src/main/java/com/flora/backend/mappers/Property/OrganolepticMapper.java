package com.flora.backend.mappers.Property;

import com.flora.backend.dtos.Property.OrganlopticSave;
import com.flora.backend.entities.properties.Organoleptic;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)

public interface OrganolepticMapper  {

    OrganlopticSave fromOrganolepticToOrganolepticSave(Organoleptic organloptic);
    Organoleptic fromOrganolepticSaveToOrganoleptic(OrganlopticSave organlopticSave);
}
