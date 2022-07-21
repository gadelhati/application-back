package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidAppp;
import br.eti.gadelha.persistence.dto.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidApppValidator implements ConstraintValidator<ValidAppp, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidAppp constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if (value.getA() != null) {
            if (value.getPpp() != null && !value.getPpp().isEmpty() && value.getA().equals("/") && !value.getPpp().equals("///") && Integer.parseInt(value.getPpp()) >= 0) {
                return false;
            } else if (!value.getA().isEmpty() && !value.getA().equals("/") && Integer.parseInt(value.getA()) >= 1 && Integer.parseInt(value.getA()) <= 8 && value.getPpp().equals("///")) {
                return false;
            } else if (!value.getA().isEmpty() && !value.getPpp().isEmpty() && !value.getA().equals("/") && Integer.parseInt(value.getA()) == 4 && !value.getPpp().equals("///") && Integer.parseInt(value.getPpp()) > 0) {
                return false;
            } else if (value.getPpp() != null && !value.getA().isEmpty() && !value.getPpp().isEmpty() && !value.getA().equals("/") && Integer.parseInt(value.getA()) >= 1 && Integer.parseInt(value.getA()) <= 3 && value.getPpp().equals("000")) {
                return false;
            } else if (!value.getA().isEmpty() && !value.getA().equals("/") && Integer.parseInt(value.getA()) >= 6 && Integer.parseInt(value.getA()) <= 8 && value.getPpp().equals("000")) {
                return false;
            } else {
                return true;
            }
        } else {
                return true;
        }
    }
}