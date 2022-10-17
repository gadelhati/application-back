package br.eti.gadelha.exception.validator.synopticObservation;

import br.eti.gadelha.exception.annotation.synopticObservation.ValidVVh;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidVVhValidator implements ConstraintValidator<ValidVVh, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidVVh constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if( value.getVv() != null && value.getH() != null
                && !value.getVv().isEmpty() && !value.getH().isEmpty()
                && Integer.parseInt(value.getVv()) >= 98 && Integer.parseInt(value.getVv()) <= 99 && !value.getH().equals("/") && Integer.parseInt(value.getH()) >= 0 && Integer.parseInt(value.getH()) <= 1 ) {
            return false;
        } else {
            return true;
        }
    }
}