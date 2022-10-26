package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniqueCompany;
import br.eti.gadelha.services.ServiceCompany;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueCompany implements ConstraintValidator<UniqueCompany, String> {

    @Autowired
    private ServiceCompany serviceCompany;

    @Override
    public void initialize(UniqueCompany constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value != null && !serviceCompany.existsByName(value)) {
            return false;
        } else {
            return true;
        }
    }
}