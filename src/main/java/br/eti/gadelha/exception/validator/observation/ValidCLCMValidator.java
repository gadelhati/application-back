package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidCLCM;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidCLCMValidator implements ConstraintValidator<ValidCLCM, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidCLCM constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if( value.getCl() != null && value.getCm() != null && value.getCl().equals("0") && value.getCm().equals("/") ) {
            return false;
        } else {
            return true;
        }
    }
}