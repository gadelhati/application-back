package br.eti.gadelha.exception.validator.synopticObservation;

import br.eti.gadelha.exception.annotation.synopticObservation.ValidNhCLCM;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNhCLCMValidator implements ConstraintValidator<ValidNhCLCM, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNhCLCM constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if( value.getNh() == null && value.getCl() == null && value.getCm() == null
            && !value.getNh().isEmpty() && !value.getCl().isEmpty() && !value.getCm().isEmpty()
            && !value.getNh().equals("/")
            && Integer.parseInt(value.getNh()) >=1 && Integer.parseInt(value.getNh()) <=8 && value.getCl().equals("0") || value.getCm().equals("0")) {
            return false;
        } else {
            return true;
        }
    }
}