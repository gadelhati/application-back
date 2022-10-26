package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniqueFederativeUnit;
import br.eti.gadelha.services.ServiceFederativeUnit;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueFederativeUnit implements ConstraintValidator<UniqueFederativeUnit, String> {

    @Autowired
    private ServiceFederativeUnit serviceFederativeUnit;

    @Override
    public void initialize(UniqueFederativeUnit constraintAnnotation) {
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ( value != null && !serviceFederativeUnit.existsByName(value) && !serviceFederativeUnit.existsByInitials(value)) {
            return false;
        } else {
            return true;
        }
    }
}