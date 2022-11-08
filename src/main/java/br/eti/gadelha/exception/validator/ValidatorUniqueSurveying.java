package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniqueSurveying;
import br.eti.gadelha.services.ServiceSurveying;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueSurveying implements ConstraintValidator<UniqueSurveying, String> {

    @Autowired
    private ServiceSurveying serviceSurveying;

    @Override
    public void initialize(UniqueSurveying constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value != null && !serviceSurveying.existsByName(value)) {
            return true;
        } else {
            return false;
        }
    }
}