package com.keeper.util.validation.util.executors;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 12.05.2017
 */
public class GeoValidator extends StringValidator {

    @Override
    public boolean validate(String geo) {
        return (super.validate(geo)
                && geo.matches("^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?),\\s*[-+]" +
                "?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)$"));
    }
}
