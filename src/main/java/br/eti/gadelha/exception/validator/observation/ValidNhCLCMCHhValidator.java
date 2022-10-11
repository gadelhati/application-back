package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidNhCLCMCHh;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNhCLCMCHhValidator implements ConstraintValidator<ValidNhCLCMCHh, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNhCLCMCHh constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
//        if ( value == null && value.getNh() != null && value.getCl() == null && value.getCm() == null && value.getCh() == null && value.getH() == null ) {
//            return false;
//        } else if(value.getNh().equals("9")
//                && !value.getCl().equals("/") && Integer.parseInt(value.getCl()) >= 0
//                || !value.getCm().equals("/") && Integer.parseInt(value.getCm()) >= 0
//                || !value.getCh().equals("/") && Integer.parseInt(value.getCh()) >= 0
//                || !value.getH().equals("/") && Integer.parseInt(value.getH()) >= 0) {
//            return false;
//        } else {
            return true;
//        }
    }
}