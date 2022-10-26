package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniquePlatformCategory;
import br.eti.gadelha.services.ServicePlatformCategory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniquePlatformCategory implements ConstraintValidator<UniquePlatformCategory, String> {

    @Autowired
    private ServicePlatformCategory servicePlatformCategory;

    @Override
    public void initialize(UniquePlatformCategory constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value != null && servicePlatformCategory.existsByNameContainingIgnoreCase(value)) {
            return false;
        } else {
            return true;
        }
    }
}