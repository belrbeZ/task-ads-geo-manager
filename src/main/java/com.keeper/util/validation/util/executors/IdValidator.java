package com.keeper.util.validation.util.executors;

import com.keeper.model.types.UserType;
import com.keeper.util.validation.util.IValidator;
import org.springframework.stereotype.Component;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 12.05.2017
 */
@Component
public class IdValidator implements IValidator<Long> {

    private static final Long ID_MIN_VALUE = UserType.EMPTY.getValue();

    @Override
    public boolean validate(Long id) {
        return (id != null && id > ID_MIN_VALUE);
    }
}
