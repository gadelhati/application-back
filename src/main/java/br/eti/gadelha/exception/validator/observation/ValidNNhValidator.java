package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidNNh;
import br.eti.gadelha.persistence.dto.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNNhValidator implements ConstraintValidator<ValidNNh, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNNh constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
//        if ( value == null ) {
//            return false;
//        } else if(value.getN() != null && value.getNh() != null && !value.getN().isEmpty() && !value.getNh().isEmpty() && !value.getN().equals("/") && Integer.parseInt(value.getN()) < Integer.parseInt(value.getNh())) {
//            return false;
//        } else if(value.getN() != null && value.getNh() != null && !value.getN().isEmpty() && !value.getN().equals("/") && Integer.parseInt(value.getN()) >= 1 && Integer.parseInt(value.getN()) <= 8 && value.getNh().equals("0")) {
//            return false;
//        } else if(value.getN() != null && value.getNh() != null && !value.getN().isEmpty() && !value.getN().equals("/") && Integer.parseInt(value.getN()) >= 1 && Integer.parseInt(value.getN()) <= 8 && value.getNh().equals("/")) {
//            return false;
//        } else {
            return true;
//        }
    }
}