package br.eti.gadelha.exception.validator.auth;

import br.eti.gadelha.exception.annotation.auth.UniqueEmail;
import br.eti.gadelha.persistence.payload.request.DTORequestUser;
import br.eti.gadelha.services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, DTORequestUser> {

    @Autowired
    private ServiceUser serviceUser;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestUser value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if(!serviceUser.existsByEmail(value.getEmail())) {
            return false;
        } else {
            return true;
        }
    }
}