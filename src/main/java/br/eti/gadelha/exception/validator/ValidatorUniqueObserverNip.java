package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniqueObserverNip;
import br.eti.gadelha.services.ServiceObserver;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueObserverNip implements ConstraintValidator<UniqueObserverNip, String> {

    @Autowired
    private ServiceObserver serviceObserver;

    @Override
    public void initialize(UniqueObserverNip constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value != null && !serviceObserver.existsByNip(value)) {
            return true;
        } else {
            return false;
        }
    }
}