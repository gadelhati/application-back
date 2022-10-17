package br.eti.gadelha.exception.validator.synopticObservation;

import br.eti.gadelha.exception.annotation.synopticObservation.ValidW1W2;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static br.eti.gadelha.exception.validator.GlobalValidation.isValidWithName;
import static br.eti.gadelha.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidW1W2Validator implements ConstraintValidator<ValidW1W2, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidW1W2 constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if(isValidWithNumber(value.getW1w2()) && Integer.parseInt(value.getW1w2().substring(1)) > Integer.parseInt(value.getW1w2().substring(0,1))) {
            return false;
        } else {
            return true;
        }
    }
}