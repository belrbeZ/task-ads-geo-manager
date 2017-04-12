package com.keeper.util.annotations;

/*
 * Created by @GoodforGod on 10.04.2017.
 */

import com.keeper.util.annotations.impl.GeoPointValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;


/**
 * Default Comment
 */
@Documented
@Constraint(validatedBy = GeoPointValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GeoPoint {
}
