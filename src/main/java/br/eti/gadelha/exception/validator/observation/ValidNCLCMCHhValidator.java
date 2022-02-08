package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidNCLCMCHh;
import br.eti.gadelha.persistence.dto.request.DTORequestObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNCLCMCHhValidator implements ConstraintValidator<ValidNCLCMCHh, DTORequestObservation> {

    @Override
    public void initialize(ValidNCLCMCHh constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObservation value, ConstraintValidatorContext context) {
        if ( value == null && value.getNh() == null && value.getCl() == null && value.getCm() == null && value.getCh() == null && value.getH() == null ) {
            return false;
        } else if(value.getNh().equals("9")
                && (!value.getCl().equals("/") && Integer.parseInt(value.getCl()) >= 0
                || !value.getCm().equals("/") && Integer.parseInt(value.getCm()) >= 0
                || !value.getCh().equals("/") && Integer.parseInt(value.getCh()) >= 0
                || !value.getH().equals("/") && Integer.parseInt(value.getH()) >= 0 )) {
            return false;
        } else {
            return true;
        }
    }
}