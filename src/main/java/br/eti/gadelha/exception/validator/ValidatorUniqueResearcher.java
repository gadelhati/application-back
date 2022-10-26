package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniqueResearcher;
import br.eti.gadelha.services.ServiceResearcher;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueResearcher implements ConstraintValidator<UniqueResearcher, String> {

    @Autowired
    private ServiceResearcher serviceResearcher;

    @Override
    public void initialize(UniqueResearcher constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value != null && !serviceResearcher.existsByName(value)) {
            return false;
        } else {
            return true;
        }
    }
}