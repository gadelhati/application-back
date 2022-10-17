package br.eti.gadelha.exception.validator.auth;

import br.eti.gadelha.exception.annotation.auth.UserNameLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNameLengthValidator implements ConstraintValidator<UserNameLength, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean validator = false;
        if (value.length() == 8) {
            validator = true;
        }
        return validator;
    }
}