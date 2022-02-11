package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidW1W2;
import br.eti.gadelha.persistence.dto.request.DTORequestObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidW1W2Validator implements ConstraintValidator<ValidW1W2, DTORequestObservation> {

    @Override
    public void initialize(ValidW1W2 constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObservation value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if(value.getW1w2() != null && !value.getW1w2().substring(0,1).equals("/") && !value.getW1w2().substring(1).equals("/")
                && Integer.parseInt(value.getW1w2().substring(1)) > Integer.parseInt(value.getW1w2().substring(0,1)) ) {
            return false;
        } else {
            return true;
        }
    }
}