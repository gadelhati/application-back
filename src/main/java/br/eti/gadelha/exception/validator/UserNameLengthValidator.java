package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UserNameLength;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

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