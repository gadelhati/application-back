package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidCMCH;
import br.eti.gadelha.persistence.dto.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidCMCHValidator implements ConstraintValidator<ValidCMCH, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidCMCH constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if( value.getCm() != null && value.getCh() != null && value.getCm().equals("0") && value.getCh().equals("/") ) {
            return false;
        } else {
            return true;
        }
    }
}