package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidNW2;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNW2Validator implements ConstraintValidator<ValidNW2, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNW2 constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if( value.getN() != null
                && !value.getN().isEmpty() && !value.getN().equals("/") && Integer.parseInt(value.getN()) >= 5 && Integer.parseInt(value.getN()) <= 8
                && !value.getW1w2().isEmpty() && !value.getW1w2().substring(1).equals("/") && Integer.parseInt(value.getW1w2().substring(1)) == 0 ) {
            return false;
        } else if( value.getN() != null
                && !value.getN().isEmpty() && !value.getN().equals("/") && Integer.parseInt(value.getN()) >= 0 && Integer.parseInt(value.getN()) <= 4
                && !value.getW1w2().isEmpty() && !value.getW1w2().substring(1).equals("/") && Integer.parseInt(value.getW1w2().substring(1)) == 2 ) {
            return false;
        } else {
            return true;
        }
    }
}