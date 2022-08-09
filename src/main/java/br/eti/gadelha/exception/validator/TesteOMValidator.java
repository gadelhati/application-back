package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.TesteOM;
import br.eti.gadelha.persistence.dto.request.DTORequestOM;
import br.eti.gadelha.services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TesteOMValidator implements ConstraintValidator<TesteOM, DTORequestOM> {

    @Autowired
    private ServiceUser serviceUser;

    @Override
    public void initialize(TesteOM constraintAnnotation) {
    }
    @Override
    public boolean isValid(DTORequestOM value, ConstraintValidatorContext context) {
        if ( value == null ) {
            return false;
        } else if(value.getName().equals("")) {
            return false;
        } else {
            return true;
        }
    }
}