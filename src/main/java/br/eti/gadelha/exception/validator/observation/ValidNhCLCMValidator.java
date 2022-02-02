package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidNhCLCM;
import br.eti.gadelha.persistence.dto.request.DTORequestObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNhCLCMValidator implements ConstraintValidator<ValidNhCLCM, DTORequestObservation> {

    @Override
    public void initialize(ValidNhCLCM constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObservation value, ConstraintValidatorContext context) {
        if ( value == null && value.getNh() != null && value.getCl() == null && value.getCm() == null ) {
            return false;
        } else if(!value.getNh().equals("/") && Integer.parseInt(value.getNh()) >=1 && Integer.parseInt(value.getNh()) <=8 && value.getCl().equals("0") && value.getCm().equals("0")) {
            return false;
        } else {
            return true;
        }
    }
}