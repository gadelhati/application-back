package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidCMCH;
import br.eti.gadelha.persistence.dto.request.DTORequestObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidCMCHValidator implements ConstraintValidator<ValidCMCH, DTORequestObservation> {

    @Override
    public void initialize(ValidCMCH constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObservation value, ConstraintValidatorContext context) {
        if ( value == null && value.getCm() == null && value.getCh() == null ) {
            return false;
        } else if( value.getCm().equals("0") && value.getCh().equals("/") ) {
            return false;
        } else {
            return true;
        }
    }
}