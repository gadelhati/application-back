package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidAppp;
import br.eti.gadelha.persistence.dto.request.DTORequestObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidApppValidator implements ConstraintValidator<ValidAppp, DTORequestObservation> {

    @Override
    public void initialize(ValidAppp constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObservation value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if( value.getA().equals("/") && !value.getPpp().equals("///") && Integer.parseInt(value.getPpp()) >= 0 ) {
            return false;
        } else if( !value.getA().equals("/") && Integer.parseInt(value.getA()) >= 1 && Integer.parseInt(value.getA()) <= 8 && value.getPpp().equals("///")) {
            return false;
        } else if( !value.getA().equals("/") && Integer.parseInt(value.getA()) == 4 && !value.getPpp().equals("///") && Integer.parseInt(value.getPpp()) > 0 ) {
            return false;
        } else if( !value.getA().equals("/") && Integer.parseInt(value.getA()) >= 1 && Integer.parseInt(value.getA()) <= 3 && value.getPpp().equals("000")) {
            return false;
        } else if( !value.getA().equals("/") && Integer.parseInt(value.getA()) >= 6 && Integer.parseInt(value.getA()) <= 8 && value.getPpp().equals("000")) {
            return false;
        } else {
            return true;
        }
    }
}