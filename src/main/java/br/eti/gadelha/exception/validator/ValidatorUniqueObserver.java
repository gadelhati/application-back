package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniqueObserver;
import br.eti.gadelha.services.ServiceObserver;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueObserver implements ConstraintValidator<UniqueObserver, String> {

    @Autowired
    private ServiceObserver serviceObserver;

    @Override
    public void initialize(UniqueObserver constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value != null && !serviceObserver.existsByName(value)) {
            return true;
        } else {
            return false;
        }
    }
}