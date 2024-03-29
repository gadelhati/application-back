package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniqueObserverNip;
import br.eti.gadelha.persistence.payload.request.DTORequestObserver;
import br.eti.gadelha.services.ServiceObserver;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueObserverNip implements ConstraintValidator<UniqueObserverNip, DTORequestObserver> {

    @Autowired
    private ServiceObserver serviceObserver;

    @Override
    public void initialize(UniqueObserverNip constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObserver value, ConstraintValidatorContext context) {
        if (value != null && value.getId() == null && !serviceObserver.existsByNip(value.getNip()) ||
                value != null && value.getId() != null && value.getNip() != null && serviceObserver.existsByNipAndIdNot(value.getNip(), value.getId())) {
            return true;
        } else {
            return false;
        }
    }
}