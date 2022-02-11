package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidTTT;
import br.eti.gadelha.persistence.dto.request.DTORequestObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidTTTValidator implements ConstraintValidator<ValidTTT, DTORequestObservation> {

    @Override
    public void initialize(ValidTTT constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObservation value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if(value.getSn1_1() != null) {
            if (value.getTntntn() == null || value.getWw() == null) {
                return false;
            }
            else {
                if (value.getSn1_1().equals("0")) {
                    if (!value.getTtt().isEmpty() && Integer.parseInt(value.getTtt()) > 50 && !value.getWw().isEmpty() && Integer.parseInt(value.getWw()) >= 70 && Integer.parseInt(value.getWw()) <= 79) {
                        return false;
                    } else if (!value.getTtt().isEmpty() && Integer.parseInt(value.getTtt()) > 50 && !value.getWw().isEmpty() && Integer.parseInt(value.getWw()) >= 85 && Integer.parseInt(value.getWw()) <= 85) {
                        return false;
                    } else if (!value.getTtt().isEmpty() && Integer.parseInt(value.getTtt()) > 120 && !value.getWw().isEmpty() && Integer.parseInt(value.getWw()) >= 68 && Integer.parseInt(value.getWw()) <= 69) {
                        return false;
                    } else if (!value.getTtt().isEmpty() && Integer.parseInt(value.getTtt()) > 120 && !value.getWw().isEmpty() && Integer.parseInt(value.getWw()) >= 83 && Integer.parseInt(value.getWw()) <= 85) {
                        return false;
                    } else if (!value.getTtt().isEmpty() && Integer.parseInt(value.getTtt()) > 30 && !value.getWw().isEmpty() && Integer.parseInt(value.getWw()) >= 48 && Integer.parseInt(value.getWw()) <= 49) {
                        return false;
                    } else if (!value.getTtt().isEmpty() && Integer.parseInt(value.getTtt()) > 30 && !value.getWw().isEmpty() && Integer.parseInt(value.getWw()) >= 56 && Integer.parseInt(value.getWw()) <= 57) {
                        return false;
                    } else if (!value.getTtt().isEmpty() && Integer.parseInt(value.getTtt()) > 30 && !value.getWw().isEmpty() && Integer.parseInt(value.getWw()) >= 66 && Integer.parseInt(value.getWw()) <= 67) {
                        return false;
                    } else {
                        return true;
                    }
                } else if (value.getSn1_1().equals("1")) {
                    if (!value.getTtt().isEmpty() && Integer.parseInt(value.getTtt()) > 20 && Integer.parseInt(value.getWw()) >= 70 && Integer.parseInt(value.getWw()) <= 79) {
                        return false;
                    } else if (!value.getTtt().isEmpty() && Integer.parseInt(value.getTtt()) > 20 && !value.getWw().isEmpty() && Integer.parseInt(value.getWw()) >= 50 && Integer.parseInt(value.getWw()) <= 55) {
                        return false;
                    } else if (!value.getTtt().isEmpty() && Integer.parseInt(value.getTtt()) > 20 && !value.getWw().isEmpty() && Integer.parseInt(value.getWw()) >= 80 && Integer.parseInt(value.getWw()) <= 82) {
                        return false;
                    } else if (!value.getTtt().isEmpty() && Integer.parseInt(value.getTtt()) > 50 && !value.getWw().isEmpty() && Integer.parseInt(value.getWw()) >= 68 && Integer.parseInt(value.getWw()) <= 69) {
                        return false;
                    } else if (!value.getTtt().isEmpty() && Integer.parseInt(value.getTtt()) > 50 && !value.getWw().isEmpty() && Integer.parseInt(value.getWw()) >= 83 && Integer.parseInt(value.getWw()) <= 84) {
                        return false;
                    } else if (!value.getTtt().isEmpty() && Integer.parseInt(value.getTtt()) > 100 && !value.getWw().isEmpty() && Integer.parseInt(value.getWw()) >= 56 && Integer.parseInt(value.getWw()) <= 57) {
                        return false;
                    } else if (!value.getTtt().isEmpty() && Integer.parseInt(value.getTtt()) > 100 && !value.getWw().isEmpty() && Integer.parseInt(value.getWw()) >= 66 && Integer.parseInt(value.getWw()) <= 67) {
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }else {
            return true;
        }
    }
}