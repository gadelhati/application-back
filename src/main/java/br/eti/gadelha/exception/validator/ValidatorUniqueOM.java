package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniqueOM;
import br.eti.gadelha.services.ServiceOM;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueOM implements ConstraintValidator<UniqueOM, String> {

    @Autowired
    private ServiceOM serviceOM;

    @Override
    public void initialize(UniqueOM constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value != null && !serviceOM.existsByName(value)) {
            return true;
        } else {
            return false;
        }
    }
}