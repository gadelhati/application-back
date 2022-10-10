package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.PasswordLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordLengthValidator implements ConstraintValidator<PasswordLength, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean validator = false;
        if (value.length() >= 10) {
            validator = true;
        }
        return validator;
    }
}