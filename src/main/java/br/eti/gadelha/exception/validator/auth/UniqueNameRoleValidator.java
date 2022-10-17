package br.eti.gadelha.exception.validator.auth;

import br.eti.gadelha.exception.annotation.auth.UniqueNameRole;
import br.eti.gadelha.services.ServiceRole;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameRoleValidator implements ConstraintValidator<UniqueNameRole, String> {

    @Autowired
    private ServiceRole serviceRole;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !serviceRole.existsByName(value);
    }
}