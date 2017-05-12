package com.keeper.util.validation.util.executors;

import com.keeper.util.validation.util.IValidator;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 12.05.2017
 */
public class StringValidator implements IValidator<String> {

    @Override
    public boolean validate(String s) {
        return (s == null || s.trim().isEmpty());
    }
}
