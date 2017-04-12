package com.keeper.util.annotations;

/*
 * Created by @GoodforGod on 10.04.2017.
 */

import com.keeper.util.annotations.impl.PhoneValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * Default Comment
 */
@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Phone {
}
