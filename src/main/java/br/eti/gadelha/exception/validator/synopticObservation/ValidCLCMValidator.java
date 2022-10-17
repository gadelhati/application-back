package br.eti.gadelha.exception.validator.synopticObservation;

import br.eti.gadelha.exception.annotation.synopticObservation.ValidCLCM;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidCLCMValidator implements ConstraintValidator<ValidCLCM, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidCLCM constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if (value != null && value.getCl() != null && value.getCm() != null) {
            if(value.getCl().equals("0") && value.getCm().equals("/")) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}