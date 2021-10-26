package br.eti.gadelha.exception.annotation;

import br.eti.gadelha.exception.validator.UniqueRoleNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueRoleNameValidator.class)
public @interface UniqueRoleName {
    public String message() default "{unique}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}