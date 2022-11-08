package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniqueResearcher;
import br.eti.gadelha.services.ServiceStationOnShore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueStationOnShore implements ConstraintValidator<UniqueResearcher, String> {

    @Autowired
    private ServiceStationOnShore stationOnShore;

    @Override
    public void initialize(UniqueResearcher constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value != null && !stationOnShore.existsByName(value)) {
            return true;
        } else {
            return false;
        }
    }
}