package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidNh;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNhValidator implements ConstraintValidator<ValidNh, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNh constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if(value.getN() != null && value.getH() != null && value.getN().equals("0") && !value.getH().equals("9")) {
            return false;
        } else if(value.getN() != null && value.getH() != null && value.getN().equals("9") && !value.getH().equals("/")) {
            return false;
        } else if(value.getN() != null && value.getH() != null && value.getN().equals("/") && !value.getH().equals("/")) {
            return false;
        } else {
            return true;
        }
    }
}