package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidTdTdTd;
import br.eti.gadelha.persistence.dto.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidTdTdTdValidator implements ConstraintValidator<ValidTdTdTd, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidTdTdTd constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if(value.getTtt() != null && value.getTdtdtd() != null && !value.getTtt().isEmpty() && !value.getTdtdtd().isEmpty()
            && Integer.parseInt(value.getTtt()) < Integer.parseInt(value.getTdtdtd()) ) {
                return false;
        } else {
            return true;
        }
    }
}