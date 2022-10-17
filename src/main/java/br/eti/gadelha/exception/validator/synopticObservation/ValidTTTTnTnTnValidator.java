package br.eti.gadelha.exception.validator.synopticObservation;

import br.eti.gadelha.exception.annotation.synopticObservation.ValidTTTTnTnTn;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static br.eti.gadelha.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidTTTTnTnTnValidator implements ConstraintValidator<ValidTTTTnTnTn, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidTTTTnTnTn constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if (isValidWithNumber(value.getTntntn()) && isValidWithNumber(value.getTtt())){
            if(Integer.parseInt(value.getTntntn()) > Integer.parseInt(value.getTtt()) ) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}