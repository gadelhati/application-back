package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniqueEmailAddress;
import br.eti.gadelha.services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailAddressValidator implements ConstraintValidator<UniqueEmailAddress, String> {

    @Autowired
    private ServiceUser serviceUser;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !serviceUser.isEmailValid(value);
    }
}