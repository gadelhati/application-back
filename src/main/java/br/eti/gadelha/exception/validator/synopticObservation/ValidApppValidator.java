package br.eti.gadelha.exception.validator.synopticObservation;

import br.eti.gadelha.exception.annotation.synopticObservation.ValidAppp;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static br.eti.gadelha.exception.validator.GlobalValidation.isValidWithName;
import static br.eti.gadelha.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidApppValidator implements ConstraintValidator<ValidAppp, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidAppp constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if (value.getA() != null) {
            if (isValidWithName(value.getPpp())) {
                if (isValidWithNumber(value.getPpp())) {
                    if (value.getA().equals("/") && !value.getPpp().equals("///") && Integer.parseInt(value.getPpp()) >= 0) {
                        return false;
                    }
                }
                if (isValidWithNumber(value.getA())) {
                    if (!value.getA().equals("/")) {
                        if (Integer.parseInt(value.getA()) >= 1 && Integer.parseInt(value.getA()) <= 8 && value.getPpp().equals("///")) {
                            return false;
                        }
                        if (Integer.parseInt(value.getA()) == 4 && !value.getPpp().equals("///") && Integer.parseInt(value.getPpp()) > 0) {
                            return false;
                        }
                        if (Integer.parseInt(value.getA()) >= 1 && Integer.parseInt(value.getA()) <= 3 && value.getPpp().equals("000")) {
                            return false;
                        }
                        if (Integer.parseInt(value.getA()) >= 6 && Integer.parseInt(value.getA()) <= 8 && value.getPpp().equals("000")) {
                            return false;
                        }
                    }
                }
            } else {
                return true;
            }
            return true;
        } else {
                return true;
        }
    }
}