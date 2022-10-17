package br.eti.gadelha.exception.validator.synopticObservation;

import br.eti.gadelha.exception.annotation.synopticObservation.ValidCMCH;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidCMCHValidator implements ConstraintValidator<ValidCMCH, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidCMCH constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if (value.getCm() != null && value.getCh() != null) {
            if(value.getCm().equals("0") && value.getCh().equals("/")) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}