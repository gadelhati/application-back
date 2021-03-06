package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidTxTxTx;
import br.eti.gadelha.persistence.dto.request.DTORequestObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidTxTxTxValidator implements ConstraintValidator<ValidTxTxTx, DTORequestObservation> {

    @Override
    public void initialize(ValidTxTxTx constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObservation value, ConstraintValidatorContext context) {
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