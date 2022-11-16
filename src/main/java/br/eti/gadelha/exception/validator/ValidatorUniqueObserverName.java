package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniqueObserverName;
import br.eti.gadelha.persistence.payload.request.DTORequestObserver;
import br.eti.gadelha.services.ServiceObserver;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorUniqueObserverName implements ConstraintValidator<UniqueObserverName, DTORequestObserver> {

    @Autowired
    private ServiceObserver serviceObserver;

    @Override
    public void initialize(UniqueObserverName constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObserver value, ConstraintValidatorContext context) {
        if (value != null && value.getId() == null && !serviceObserver.existsByName(value.getName()) ||
                value != null && value.getId() != null && value.getName() != null && serviceObserver.existsByNameAndIdNot(value.getName(), value.getId())) {
            return true;
        } else {
            return false;
        }
    }
}