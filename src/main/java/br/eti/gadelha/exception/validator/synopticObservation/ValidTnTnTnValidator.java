package br.eti.gadelha.exception.validator.synopticObservation;

import br.eti.gadelha.exception.annotation.synopticObservation.ValidTnTnTn;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidTnTnTnValidator implements ConstraintValidator<ValidTnTnTn, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidTnTnTn constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if(value.getTtt() != null && value.getTntntn() != null
                && !value.getTtt().isEmpty() && !value.getTntntn().isEmpty()
                && Integer.parseInt(value.getTtt()) < Integer.parseInt(value.getTntntn()) ) {
                return false;
        } else {
            return true;
        }
    }
}