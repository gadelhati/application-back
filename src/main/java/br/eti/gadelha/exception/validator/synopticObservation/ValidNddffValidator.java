package br.eti.gadelha.exception.validator.synopticObservation;

import br.eti.gadelha.exception.annotation.synopticObservation.ValidNddff;
import br.eti.gadelha.persistence.payload.request.DTORequestSynopticObservation;

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
        if( isValidWithNumber(value.getDd()) && isValidWithNumber(value.getFf())) {
            if (Integer.parseInt(value.getDd()) == 0 && Integer.parseInt(value.getFf()) != 0 ||
                    Integer.parseInt(value.getDd()) >= 0 && Integer.parseInt(value.getDd()) <= 36 && Integer.parseInt(value.getFf()) == 0 ||
                    Integer.parseInt(value.getDd()) == 99 && Integer.parseInt(value.getFf()) == 0) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}