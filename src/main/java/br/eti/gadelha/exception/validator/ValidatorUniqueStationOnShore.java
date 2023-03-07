package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniqueStationOnShore;
import br.eti.gadelha.services.ServiceStationOffShore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueStationOnShore implements ConstraintValidator<UniqueStationOnShore, String> {

    @Autowired
    private ServiceStationOffShore stationOnShore;

    @Override
    public void initialize(UniqueStationOnShore constraintAnnotation) {
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