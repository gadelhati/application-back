package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidVVh;
import br.eti.gadelha.persistence.dto.request.DTORequestObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidVVhValidator implements ConstraintValidator<ValidVVh, DTORequestObservation> {

    @Override
    public void initialize(ValidVVh constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObservation value, ConstraintValidatorContext context) {
        if ( value == null && value.getVv() != null && value.getH() == null ) {
            return false;
        } else if(Integer.parseInt(value.getVv()) >= 98 && Integer.parseInt(value.getVv()) <= 99 && !value.getH().equals("/") && Integer.parseInt(value.getH()) >= 0 && Integer.parseInt(value.getH()) >= 1 ) {
            return false;
        } else {
            return true;
        }
    }
}