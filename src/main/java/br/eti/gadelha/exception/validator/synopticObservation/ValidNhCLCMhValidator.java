package br.eti.gadelha.exception.validator.synopticObservation;


import br.eti.gadelha.exception.annotation.synopticObservation.ValidNhCLCMh;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNhCLCMhValidator implements ConstraintValidator<ValidNhCLCMh, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNhCLCMh constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if(
                value.getNh() != null && value. getCl() != null && value.getCm() != null && value.getCh() != null
                && value.getNh().equals("0") && !value.getCl().equals("0") && !value.getCm().equals("0") && !value.getH().equals("9")) {
            return false;
        } else {
            return true;
        }
    }
}