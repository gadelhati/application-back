package br.eti.gadelha.exception.validator.synopticObservation;

import br.eti.gadelha.exception.annotation.synopticObservation.ValidTxTxTx;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidTxTxTxValidator implements ConstraintValidator<ValidTxTxTx, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidTxTxTx constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if(value.getTtt() != null && value.getTxtxtx() != null
                && !value.getTtt().isEmpty() && !value.getTxtxtx().isEmpty() && !value.getTtt().equals("") && !value.getTxtxtx().equals("")
                && Integer.parseInt(value.getTtt()) > Integer.parseInt(value.getTxtxtx()) ) {
                return false;
        } else {
            return true;
        }
    }
}