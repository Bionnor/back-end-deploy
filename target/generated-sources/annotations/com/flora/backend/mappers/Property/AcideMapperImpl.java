package com.flora.backend.mappers.Property;

import com.flora.backend.dtos.Property.AcideGrasSave;
import com.flora.backend.entities.properties.AcidesGras;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-17T15:20:26+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19 (Eclipse Adoptium)"
)
@Component
public class AcideMapperImpl implements AcideMapper {

    @Override
    public AcideGrasSave fromAcideGrasToAcideGrasSave(AcidesGras acideGrasSave) {
        if ( acideGrasSave == null ) {
            return null;
        }

        AcideGrasSave acideGrasSave1 = new AcideGrasSave();

        if ( acideGrasSave.getId() != null ) {
            acideGrasSave1.setId( acideGrasSave.getId() );
        }
        if ( acideGrasSave.getAcidepunicique() != null ) {
            acideGrasSave1.setAcidepunicique( acideGrasSave.getAcidepunicique() );
        }
        if ( acideGrasSave.getAcideoleique() != null ) {
            acideGrasSave1.setAcideoleique( acideGrasSave.getAcideoleique() );
        }
        if ( acideGrasSave.getAcidepalmitique() != null ) {
            acideGrasSave1.setAcidepalmitique( acideGrasSave.getAcidepalmitique() );
        }
        if ( acideGrasSave.getAcidestearique() != null ) {
            acideGrasSave1.setAcidestearique( acideGrasSave.getAcidestearique() );
        }
        if ( acideGrasSave.getAcidearachidique() != null ) {
            acideGrasSave1.setAcidearachidique( acideGrasSave.getAcidearachidique() );
        }
        if ( acideGrasSave.getAcidebehenique() != null ) {
            acideGrasSave1.setAcidebehenique( acideGrasSave.getAcidebehenique() );
        }
        if ( acideGrasSave.getAcidealphalinolenique() != null ) {
            acideGrasSave1.setAcidealphalinolenique( acideGrasSave.getAcidealphalinolenique() );
        }
        if ( acideGrasSave.getAcideeicosenoique() != null ) {
            acideGrasSave1.setAcideeicosenoique( acideGrasSave.getAcideeicosenoique() );
        }
        if ( acideGrasSave.getAcidelinoleique() != null ) {
            acideGrasSave1.setAcidelinoleique( acideGrasSave.getAcidelinoleique() );
        }
        if ( acideGrasSave.getAgs() != null ) {
            acideGrasSave1.setAgs( acideGrasSave.getAgs() );
        }
        if ( acideGrasSave.getAgmi() != null ) {
            acideGrasSave1.setAgmi( acideGrasSave.getAgmi() );
        }
        if ( acideGrasSave.getAgpi() != null ) {
            acideGrasSave1.setAgpi( acideGrasSave.getAgpi() );
        }

        return acideGrasSave1;
    }

    @Override
    public AcidesGras fromAcideGrasSaveToAcideGras(AcideGrasSave acideGrasSave) {
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
