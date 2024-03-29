package br.eti.gadelha.exception.validator.synopticObservation;

import br.eti.gadelha.exception.annotation.synopticObservation.ValidTTT;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static br.eti.gadelha.exception.validator.GlobalValidation.isValidWithNumber;

public class ValidTTTValidator implements ConstraintValidator<ValidTTT, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidTTT constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if (isValidWithNumber(value.getTtt()) && isValidWithNumber(value.getWw())) {
            if(value.getSn1_1().equals("0")){
                if (Integer.parseInt(value.getTtt()) > 50 && Integer.parseInt(value.getWw()) >= 70 && Integer.parseInt(value.getWw()) >= 79 ||
                        Integer.parseInt(value.getTtt()) > 50 && Integer.parseInt(value.getWw()) >= 85 && Integer.parseInt(value.getWw()) >= 88 ||
                        Integer.parseInt(value.getTtt()) > 120 && Integer.parseInt(value.getWw()) >= 68 && Integer.parseInt(value.getWw()) >= 69 ||
                        Integer.parseInt(value.getTtt()) > 120 && Integer.parseInt(value.getWw()) >= 83 && Integer.parseInt(value.getWw()) >= 85 ||
                        Integer.parseInt(value.getTtt()) > 30 && Integer.parseInt(value.getWw()) >= 48 && Integer.parseInt(value.getWw()) >= 49 ||
                        Integer.parseInt(value.getTtt()) > 30 && Integer.parseInt(value.getWw()) >= 56 && Integer.parseInt(value.getWw()) >= 57 ||
                        Integer.parseInt(value.getTtt()) > 30 && Integer.parseInt(value.getWw()) >= 66 && Integer.parseInt(value.getWw()) >= 67) {
                    return false;
                } else {
                    return true;
                }
            } else if (value.getSn1_1().equals("1")) {
                if (Integer.parseInt(value.getTtt()) > 20 && Integer.parseInt(value.getWw()) >= 50 && Integer.parseInt(value.getWw()) >= 55 ||
                        Integer.parseInt(value.getTtt()) > 20 && Integer.parseInt(value.getWw()) >= 58 && Integer.parseInt(value.getWw()) >= 65 ||
                        Integer.parseInt(value.getTtt()) > 20 && Integer.parseInt(value.getWw()) >= 80 && Integer.parseInt(value.getWw()) >= 82 ||
                        Integer.parseInt(value.getTtt()) > 50 && Integer.parseInt(value.getWw()) >= 68 && Integer.parseInt(value.getWw()) >= 69 ||
                        Integer.parseInt(value.getTtt()) > 50 && Integer.parseInt(value.getWw()) >= 83 && Integer.parseInt(value.getWw()) >= 84 ||
                        Integer.parseInt(value.getTtt()) > 100 && Integer.parseInt(value.getWw()) >= 56 && Integer.parseInt(value.getWw()) >= 57 ||
                        Integer.parseInt(value.getTtt()) > 100 && Integer.parseInt(value.getWw()) >= 66 && Integer.parseInt(value.getWw()) >= 67) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}