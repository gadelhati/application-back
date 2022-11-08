package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniqueIndividual;
import br.eti.gadelha.services.ServiceIndividual;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueIndividual implements ConstraintValidator<UniqueIndividual, String> {

    @Autowired
    private ServiceIndividual serviceIndividual;

    @Override
    public void initialize(UniqueIndividual constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value != null && !serviceIndividual.existsByName(value)) {
            return true;
        } else {
            return false;
        }
    }
}