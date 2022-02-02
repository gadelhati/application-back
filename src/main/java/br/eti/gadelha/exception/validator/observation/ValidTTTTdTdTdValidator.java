package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidCLCM;
import br.eti.gadelha.persistence.dto.request.DTORequestObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidTTTTdTdTdValidator implements ConstraintValidator<ValidCLCM, DTORequestObservation> {

    @Override
    public void initialize(ValidCLCM constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObservation value, ConstraintValidatorContext context) {
        if ( value == null && value.getTtt() == null && value.getTdtdtd() == null ) {
            return false;
        } else if( Integer.parseInt(value.getTtt()) < Integer.parseInt(value.getTdtdtd()) ) {
            return false;
        } else {
            return true;
        }
    }
}