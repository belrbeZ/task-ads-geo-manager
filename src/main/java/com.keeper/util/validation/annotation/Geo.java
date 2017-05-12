package com.keeper.util.validation.annotation;

/*
 * Created by @GoodforGod on 10.04.2017.
 */

import com.keeper.util.validation.annotation.impl.GeoValidatorConstraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Default Comment
 */

@Documented
@Constraint(validatedBy = GeoValidatorConstraint.class)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Geo {
    String message() default "{Not a Geo Coordinate!}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
