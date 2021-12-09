package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidCLCM;
import br.eti.gadelha.persistence.dto.request.DTORequestObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidCLCMValidator implements ConstraintValidator<ValidCLCM, DTORequestObservation> {

    @Override
    public void initialize(ValidCLCM constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObservation value, ConstraintValidatorContext context) {
        if ( value == null && value.getCl() == null && value.getCm() == null ) {
            return false;
        } else if( value.getCl().equals("0") && value.getCm().equals("/") ) {
            return false;
        } else {
            return true;
        }
    }
}