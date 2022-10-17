package br.eti.gadelha.exception.validator.synopticObservation;

import br.eti.gadelha.exception.annotation.synopticObservation.ValidNCLCMCHh;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static br.eti.gadelha.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidNCLCMCHhValidator implements ConstraintValidator<ValidNCLCMCHh, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNCLCMCHh constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if(value.getN() != null && isValidWithNumber(value.getCl()) && isValidWithNumber(value.getCm()) && isValidWithNumber(value.getCh()) && value.getH() != null) {
            if(value.getN().equals("0") && Integer.parseInt(value.getCl()) > 0 || Integer.parseInt(value.getCm()) > 0 || Integer.parseInt(value.getCh()) > 0 || !value.getH().equals("9") ) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}