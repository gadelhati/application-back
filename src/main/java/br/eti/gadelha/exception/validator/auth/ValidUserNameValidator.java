package br.eti.gadelha.exception.validator.auth;

import br.eti.gadelha.exception.annotation.auth.ValidUserName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidUserNameValidator implements ConstraintValidator<ValidUserName, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean validator = true;
        for(int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i))) {
                validator = false;
            }
        }
        return validator;
    }
}