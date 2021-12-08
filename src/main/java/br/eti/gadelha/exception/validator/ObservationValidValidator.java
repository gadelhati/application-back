package br.eti.gadelha.exception.validator;

import br.eti.gadelha.exception.annotation.ObservationValid;
import br.eti.gadelha.persistence.dto.request.DTORequestObservation;
import br.eti.gadelha.services.ServiceObservation;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ObservationValidValidator implements ConstraintValidator<ObservationValid, DTORequestObservation> {

//    private String field;
//    private String fieldMatch;
    @Autowired
    private ServiceObservation serviceObservation;

//    public void initialize(ObservationValid constraintAnnotation) {
//        this.field = constraintAnnotation.field();
//        this.fieldMatch = constraintAnnotation.fieldMatch();
//    }
    public boolean isValid(DTORequestObservation value, ConstraintValidatorContext context) {
//        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
//        Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);
//        if (fieldValue != null) {
                    return value != null && value.getDdddddd().equals("") || value.getIii().equals("");
//            return fieldValue.equals(fieldMatchValue);
//        } else {
//            return fieldMatchValue == null;
//        }
    }
}

//reference: https://www-baeldung-com.translate.goog/spring-mvc-custom-validator?_x_tr_sl=en&_x_tr_tl=pt&_x_tr_hl=pt-BR&_x_tr_pto=sc