package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.ValidatorUniqueResearcherEmail;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { ValidatorUniqueResearcherEmail.class })
@Documented
public @interface UniqueResearcherEmail {

    String message() default "{unique.researcher.email}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}