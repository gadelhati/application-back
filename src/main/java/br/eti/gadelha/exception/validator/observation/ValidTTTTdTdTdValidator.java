package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidTTTTdTdTd;
import br.eti.gadelha.persistence.dto.request.DTORequestObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidTTTTdTdTdValidator implements ConstraintValidator<ValidTTTTdTdTd, DTORequestObservation> {

    @Override
    public void initialize(ValidTTTTdTdTd constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObservation value, ConstraintValidatorContext context) {
        if ( value == null && value.getTtt() == null || value.getTdtdtd() == null || value.getTtt().equals("///") || value.getTdtdtd().equals("///") ) {
            return false;
        } else if( Integer.parseInt(value.getTtt()) <= Integer.parseInt(value.getTdtdtd()) ) {
            return false;
        } else {
            return true;
        }
    }
}