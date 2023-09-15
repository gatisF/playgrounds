package io.swedbank.playgrounds.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.*;

@NotNull(message = "Given number is required")
@Min(value = 1, message = "Given number must be greater than 0")
@Constraint(validatedBy = {})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidNumber {
    String message() default "Number is required";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
