package br.eti.gadelha.exception.validator.observation;

import br.eti.gadelha.exception.annotation.observation.ValidNddff;
import br.eti.gadelha.exception.validator.GlobalValidation;
import br.eti.gadelha.persistence.dto.request.DTORequestSynopticObservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static br.eti.gadelha.exception.validator.GlobalValidation.isValidWithName;
import static br.eti.gadelha.exception.validator.GlobalValidation.isValidWithNumber;
import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

public class ValidNddffValidator implements ConstraintValidator<ValidNddff, DTORequestSynopticObservation> {

    @Override
    public void initialize(ValidNddff constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestSynopticObservation value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if ( isValidWithName(value.getDd()) && isValidWithName(value.getFf())) {
            if(value.getDd().equals("00") && !value.getFf().equals("00")) {
                return false;
            }
            if(value.getDd().equals("99") && value.getFf().equals("00")) {
                return false;
            }
            if (isValidWithNumber(value.getDd()) && isValidWithNumber(value.getFf())){
                if(Integer.parseInt(value.getDd()) >= 0 && Integer.parseInt(value.getDd()) <= 36 && value.getFf().equals("00")){
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }
}