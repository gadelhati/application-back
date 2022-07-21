package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidVVWW;
import br.eti.gadelha.persistence.dto.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidVVWWValidator implements ConstraintValidator<ValidVVWW, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidVVWW constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if( value.getWw() != null && value.getVv() != null
                && !value.getWw().isEmpty() && !value.getVv().isEmpty() && Integer.parseInt(value.getVv()) < Integer.parseInt(value.getWw())) {
            return false;
        } else if( value.getWw() != null && value.getVv() != null
                && !value.getWw().isEmpty() && !value.getVv().isEmpty() && Integer.parseInt(value.getVv()) >= 94 && Integer.parseInt(value.getVv()) <= 99
                && Integer.parseInt(value.getWw()) >= 40 && Integer.parseInt(value.getWw()) <= 49) {
            return false;
        } else if( value.getWw() != null && value.getVv() != null
                && !value.getWw().isEmpty() && !value.getVv().isEmpty() && Integer.parseInt(value.getVv()) >= 90 && Integer.parseInt(value.getVv()) <= 93
                && value.getWw().equals("10")) {
            return false;
        } else if( value.getWw() != null && value.getVv() != null
                && !value.getWw().isEmpty() && !value.getVv().isEmpty() && Integer.parseInt(value.getVv()) >= 90 && Integer.parseInt(value.getVv()) <= 96
                && Integer.parseInt(value.getWw()) >= 10 && Integer.parseInt(value.getWw()) <= 16) {
            return false;
        } else {
            return true;
        }
    }
}