package br.eti.gadelha.exception.validator.synopticObservation;

import br.eti.gadelha.exception.annotation.synopticObservation.ValidNCLCMCH;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static br.eti.gadelha.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidNCLCMCHValidator implements ConstraintValidator<ValidNCLCMCH, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNCLCMCH constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if (isValidWithNumber(value.getN()) && value.getCl() != null && value.getCm() != null && value.getCh() != null) {
            if(Integer.parseInt(value.getN()) >= 1 && Integer.parseInt(value.getN()) <= 8 &&
                    value.getCl().equals("0") && value.getCm().equals("0") && value.getCh().equals("0")) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}