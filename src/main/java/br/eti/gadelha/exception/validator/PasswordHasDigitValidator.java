package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.PasswordHasDigit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordHasDigitValidator implements ConstraintValidator<PasswordHasDigit, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean validator = false;
        for (char c : value.toCharArray()) {
            if (Character.isDigit(c)) {
                validator = true;
            }
        }
        return validator;
    }
}