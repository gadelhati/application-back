package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniqueResearcherEmail;
import br.eti.gadelha.services.ServiceResearcher;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueResearcherEmail implements ConstraintValidator<UniqueResearcherEmail, String> {

    @Autowired
    private ServiceResearcher serviceResearcher;

    @Override
    public void initialize(UniqueResearcherEmail constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value != null && !serviceResearcher.existsByEmail(value)) {
            return true;
        } else {
            return false;
        }
    }
}