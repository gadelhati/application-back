package br.eti.gadelha.exception.validator.synopticObservation;

import br.eti.gadelha.exception.annotation.synopticObservation.ValidTTTTdTdTd;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static br.eti.gadelha.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidTTTTdTdTdValidator implements ConstraintValidator<ValidTTTTdTdTd, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidTTTTdTdTd constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if(isValidWithNumber(value.getTdtdtd()) && isValidWithNumber(value.getTtt())) {
            if(Integer.parseInt(value.getTdtdtd()) > Integer.parseInt(value.getTtt())) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}