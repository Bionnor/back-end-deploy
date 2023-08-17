package com.flora.backend.mappers.Property;

import com.flora.backend.dtos.Property.FormuleSave;
import com.flora.backend.dtos.Property.OrganlopticSave;
import com.flora.backend.entities.properties.Formule;
import com.flora.backend.entities.properties.Formule;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)

public interface FormuleMapper {

    FormuleSave fromFormuleToFormuleSave(Formule formule);
    Formule fromFormuleSaveToFormule(FormuleSave formuleSave);
}
