package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniquePlatform;
import br.eti.gadelha.services.ServicePlatform;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniquePlatform implements ConstraintValidator<UniquePlatform, String> {

    @Autowired
    private ServicePlatform servicePlatform;

    @Override
    public void initialize(UniquePlatform constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value != null &&
                !servicePlatform.existsByName(value) &&
                !servicePlatform.existsByTelegraphicCallsign(value) ||
                !servicePlatform.existsByInternationalCallsign(value) ||
                !servicePlatform.existsByInternationalName(value)
        ) {
            return false;
        } else {
            return true;
        }
    }
}