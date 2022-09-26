package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidW1W2;
import br.eti.gadelha.persistence.dto.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static br.eti.gadelha.exception.validator.GlobalValidation.isValidWithName;
import static br.eti.gadelha.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidW1W2Validator implements ConstraintValidator<ValidW1W2, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidW1W2 constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        try {
            if ( value.getW1w2().substring(0,1).equals("/") && value.getW1w2().substring(1).equals("/")) {
                if (Integer.parseInt(value.getW1w2().substring(1)) > Integer.parseInt(value.getW1w2().substring(0, 1))) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }

//        if ( value == null ) {
//            return false;
//        } else if ( isValidWithName(value.getW1w2()) && value.getW1w2().substring(0,1).equals("/") && value.getW1w2().substring(1).equals("/")){
//            if(isValidWithNumber(value.getW1w2()) && Integer.parseInt(value.getW1w2().substring(1)) > Integer.parseInt(value.getW1w2().substring(0,1)) ) {
//                return false;
//            }
//            return true;
//        } else {
//            return true;
//        }
    }
}