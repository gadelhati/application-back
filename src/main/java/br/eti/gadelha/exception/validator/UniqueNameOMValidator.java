package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.UniqueNameOM;
import br.eti.gadelha.services.ServiceOM;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameOMValidator implements ConstraintValidator<UniqueNameOM, String> {

    @Autowired
    private ServiceOM serviceOM;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
//        if(value != null) {
//            if(serviceOM.isNameValid(value)) {
//                return false;
//            } else {
//                return true;
//            }
//        } else {
//            return false;
//        }
        return value != null && !serviceOM.isNameValid(value);
    }
}