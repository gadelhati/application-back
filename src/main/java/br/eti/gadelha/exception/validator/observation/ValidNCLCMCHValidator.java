package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidNCLCMCH;
import br.eti.gadelha.persistence.dto.request.DTORequestObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNCLCMCHValidator implements ConstraintValidator<ValidNCLCMCH, DTORequestObservation> {

    @Override
    public void initialize(ValidNCLCMCH constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObservation value, ConstraintValidatorContext context) {
        if ( value == null && value.getN() != null && value.getCl() == null && value.getCm() == null && value.getCh() == null ) {
            return false;
        } else if(!value.getN().equals("/") && Integer.parseInt(value.getN()) >=1 && Integer.parseInt(value.getN()) <=8
                && !value.getCl().equals("/") && Integer.parseInt(value.getCl()) == 0
                && !value.getCm().equals("/") && Integer.parseInt(value.getCm()) == 0
                && !value.getCh().equals("/") && Integer.parseInt(value.getCh()) == 0 ) {
            return false;
        } else {
            return true;
        }
    }
}