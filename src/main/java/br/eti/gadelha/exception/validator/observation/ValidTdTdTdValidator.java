package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidTdTdTd;
import br.eti.gadelha.persistence.dto.request.DTORequestObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidTdTdTdValidator implements ConstraintValidator<ValidTdTdTd, DTORequestObservation> {

    @Override
    public void initialize(ValidTdTdTd constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObservation value, ConstraintValidatorContext context) {
        if ( value == null && value.getTtt() == null && value.getTdtdtd() == null ) {
            return false;
        } else if(value.getTtt() != null && value.getTdtdtd() != null && !value.getTtt().equals("") && !value.getTdtdtd().equals("") )
            if( Integer.parseInt(value.getTtt()) < Integer.parseInt(value.getTdtdtd()) ) {
                return false;
            } else {
                return true;
        } else {
            return true;
        }
    }
}