package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniqueInstitution;
import br.eti.gadelha.services.ServiceInstitution;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueInstitution implements ConstraintValidator<UniqueInstitution, String> {

    @Autowired
    private ServiceInstitution serviceInstitution;

    @Override
    public void initialize(UniqueInstitution constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value != null && !serviceInstitution.existsByName(value)) {
            return true;
        } else {
            return false;
        }
    }
}