package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidNddff;
import br.eti.gadelha.persistence.dto.request.DTORequestObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidNddffValidator implements ConstraintValidator<ValidNddff, DTORequestObservation> {

    @Override
    public void initialize(ValidNddff constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestObservation value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if(value.getDd().equals("00") && !value.getFf().equals("00")) {
            return false;
//            return value.getDdddddd() == null && value.getIii() != null || value.getDdddddd().equals("") && !value.getIii().equals("")
//                    || value.getDdddddd() != null && value.getIii() == null || !value.getDdddddd().equals("") && value.getIii().equals("");
        } else if(!value.getDd().isEmpty() && Integer.parseInt(value.getDd()) >= 0 && Integer.parseInt(value.getDd()) <= 36 && value.getFf().equals("00")){
            return false;
        } else if(value.getDd().equals("99") && value.getFf().equals("00")) {
            return false;
        } else {
            return true;
        }
    }
}