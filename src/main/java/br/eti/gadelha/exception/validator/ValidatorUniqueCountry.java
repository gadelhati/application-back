package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniqueCountry;
import br.eti.gadelha.services.ServiceCountry;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueCountry implements ConstraintValidator<UniqueCountry, String> {

    @Autowired
    private ServiceCountry serviceCountry;

    @Override
    public void initialize(UniqueCountry constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value != null && !serviceCountry.existsByName(value)) {
            return false;
        } else {
            return true;
        }
    }
}