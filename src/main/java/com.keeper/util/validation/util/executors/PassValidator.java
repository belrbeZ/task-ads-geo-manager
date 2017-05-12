package com.keeper.util.validation.util.executors;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 12.05.2017
 */
public class PassValidator extends StringValidator {

    private static final Integer PASS_MIN_LENGTH = 6;

    @Override
    public boolean validate(String pass) {
        return (super.validate(pass) && pass.length() > PASS_MIN_LENGTH);
    }
}
