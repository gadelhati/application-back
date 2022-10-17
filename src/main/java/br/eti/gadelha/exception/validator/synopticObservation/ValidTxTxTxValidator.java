package br.eti.gadelha.exception.validator.synopticObservation;

import br.eti.gadelha.exception.annotation.synopticObservation.ValidTxTxTx;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static br.eti.gadelha.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidTxTxTxValidator implements ConstraintValidator<ValidTxTxTx, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidTxTxTx constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if(isValidWithNumber(value.getTxtxtx()) && isValidWithNumber(value.getTtt()) && Integer.parseInt(value.getTxtxtx()) < Integer.parseInt(value.getTtt())) {
            return false;
        } else {
            return true;
        }
    }
}