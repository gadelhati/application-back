package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.ValidIw;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public class ValidatorIw implements ConstraintValidator<ValidIw, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches("[0|1|3|4]{1}");
    }
}