package br.eti.gadelha.exception.validator.synopticObservation;

import br.eti.gadelha.exception.annotation.synopticObservation.ValidNW2;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static br.eti.gadelha.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidNW2Validator implements ConstraintValidator<ValidNW2, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNW2 constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if(isValidWithNumber(value.getN())) {
            if(value.getW1w2().substring(1).equals("2") && Integer.parseInt(value.getN()) >= 0 && Integer.parseInt(value.getN()) <= 4 ||
                    value.getW1w2().substring(1).equals("0") && Integer.parseInt(value.getN()) >= 5 && Integer.parseInt(value.getN()) <= 8) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}