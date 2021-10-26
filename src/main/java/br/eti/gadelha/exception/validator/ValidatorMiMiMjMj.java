package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.ValidMiMiMjMj;
import br.eti.gadelha.services.ServiceRole;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public class ValidatorMiMiMjMj implements ConstraintValidator<ValidMiMiMjMj, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == "AAXX" || value == "BBXX";
    }
}