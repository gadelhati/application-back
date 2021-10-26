package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.ValidGG;
import br.eti.gadelha.services.ServiceRole;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public class ValidatorGG implements ConstraintValidator<ValidGG, String> {

    @Autowired
    private ServiceRole serviceRole;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches("[0-9]{1,2}");
    }
}