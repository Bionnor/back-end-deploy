package com.flora.backend.mappers.Property;

import com.flora.backend.dtos.Property.AcideGrasSave;
import com.flora.backend.entities.properties.AcidesGras;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)

public interface AcideMapper {
    AcideGrasSave fromAcideGrasToAcideGrasSave( AcidesGras acideGrasSave);
    AcidesGras fromAcideGrasSaveToAcideGras(AcideGrasSave acideGrasSave);
}
