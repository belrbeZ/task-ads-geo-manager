package com.keeper.util.validation.annotation;

/*
 * Created by @GoodforGod on 16.04.2017.
 */

import com.keeper.util.validation.annotation.impl.GeoListValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Default Comment
 */

@Documented
@Constraint(validatedBy = GeoListValidator.class)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface GeoList {
    String message() default "{GeoList}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
