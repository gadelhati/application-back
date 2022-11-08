package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniqueManufacturer;
import br.eti.gadelha.services.ServiceManufacturer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueManufacturer implements ConstraintValidator<UniqueManufacturer, String> {

    @Autowired
    private ServiceManufacturer serviceManufacturer;

    @Override
    public void initialize(UniqueManufacturer constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value != null && !serviceManufacturer.existsByName(value)) {
            return true;
        } else {
            return false;
        }
    }
}