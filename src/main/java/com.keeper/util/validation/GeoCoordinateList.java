package com.keeper.util.validation;

/*
 * Created by @GoodforGod on 16.04.2017.
 */

import com.keeper.util.validation.impl.GeoCoordinateListValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Default Comment
 */

@Documented
@Constraint(validatedBy = GeoCoordinateListValidator.class)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface  GeoCoordinateList {
    String message() default "{GeoCoordinateList}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
