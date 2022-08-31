package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidNCLCMCH;
import br.eti.gadelha.persistence.dto.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNCLCMCHValidator implements ConstraintValidator<ValidNCLCMCH, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNCLCMCH constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
//        if ( value == null ) {
//            return false;
//        } else if(value.getN() != null && !value.getN().isEmpty() && !value.getN().equals("/") && Integer.parseInt(value.getN()) >=1 && Integer.parseInt(value.getN()) <=8
//                && value.getCl() != null && !value.getCl().isEmpty() && !value.getCl().equals("/") && Integer.parseInt(value.getCl()) == 0
//                && value.getCm() != null && !value.getCm().isEmpty() && !value.getCm().equals("/") && Integer.parseInt(value.getCm()) == 0
//                && value.getCh() != null && !value.getCh().isEmpty() && !value.getCh().equals("/") && Integer.parseInt(value.getCh()) == 0 ) {
//            return false;
//        } else {
            return true;
//        }
    }
}