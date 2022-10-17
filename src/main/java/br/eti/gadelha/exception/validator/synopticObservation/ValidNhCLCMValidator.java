package br.eti.gadelha.exception.validator.synopticObservation;

import br.eti.gadelha.exception.annotation.synopticObservation.ValidNhCLCM;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static br.eti.gadelha.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidNhCLCMValidator implements ConstraintValidator<ValidNhCLCM, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNhCLCM constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if (isValidWithNumber(value.getNh())) {
            if(Integer.parseInt(value.getNh()) >=1 && Integer.parseInt(value.getNh()) <= 8 &&
                value.getCl() != null && value.getCl().equals("0") &&
                value.getCm() != null && value.getCm().equals("0")) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}