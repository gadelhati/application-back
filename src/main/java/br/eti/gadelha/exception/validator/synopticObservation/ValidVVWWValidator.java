package br.eti.gadelha.exception.validator.synopticObservation;

import br.eti.gadelha.exception.annotation.synopticObservation.ValidVVWW;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static br.eti.gadelha.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidVVWWValidator implements ConstraintValidator<ValidVVWW, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidVVWW constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if(isValidWithNumber(value.getWw()) && isValidWithNumber(value.getWw())) {
            if (Integer.parseInt(value.getVv()) < Integer.parseInt(value.getWw())) {
                return false;
            } else if (Integer.parseInt(value.getVv()) >= 94 && Integer.parseInt(value.getVv()) <= 99 &&
                    Integer.parseInt(value.getWw()) >= 40 && Integer.parseInt(value.getWw()) <= 49) {
                return false;
            } else if (Integer.parseInt(value.getVv()) >= 90 && Integer.parseInt(value.getVv()) <= 93 &&
                    value.getWw().equals("10")) {
                return false;
            } else if (Integer.parseInt(value.getVv()) >= 90 && Integer.parseInt(value.getVv()) <= 96 &&
                    Integer.parseInt(value.getWw()) >= 10 && Integer.parseInt(value.getWw()) <= 16) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}