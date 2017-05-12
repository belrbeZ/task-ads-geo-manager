package com.keeper.util.validation.util;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 12.05.2017
 */
public interface IValid<T> {
    boolean validate(T t);

    void support(Class<? extends IValidator>[] classes);
}
