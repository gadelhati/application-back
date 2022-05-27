package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.ValidUserName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public class ValidUserNameValidator implements ConstraintValidator<ValidUserName, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean validator = true;
//        for (char c : value.toCharArray()) {
//            if (!Character.isDigit(c)) {
//                validator = false;
//            }
//        }
        for(int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i))) {
                validator = false;
            }
        }
        return validator;
    }
}