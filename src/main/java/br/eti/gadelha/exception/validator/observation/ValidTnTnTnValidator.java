package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidTnTnTn;
import br.eti.gadelha.persistence.dto.request.DTORequestObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidTnTnTnValidator implements ConstraintValidator<ValidTnTnTn, DTORequestObservation> {

    @Override
    public void initialize(ValidTnTnTn constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObservation value, ConstraintValidatorContext context) {
        if ( value == null && value.getTtt() != null && value.getTntntn() == null ) {
            return false;
        } else if(value.getTtt() != null && value.getTntntn() != null && !value.getTtt().equals("") && !value.getTntntn().equals("") )
            if( Integer.parseInt(value.getTtt()) < Integer.parseInt(value.getTntntn()) ) {
                return false;
            } else {
                return true;
        } else {
            return true;
        }
    }
}