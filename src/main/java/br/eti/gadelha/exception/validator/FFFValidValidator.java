package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.FFFValid;
import br.eti.gadelha.persistence.dto.request.DTORequestObservation;
import br.eti.gadelha.services.ServiceObservation;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FFFValidValidator implements ConstraintValidator<FFFValid, String> {

    @Autowired
    private ServiceObservation serviceObservation;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return true;//value != null && value.getFf().equals("99") && !value.getFff().equals("") || value != null && value.getFff().equals("");
    }
}