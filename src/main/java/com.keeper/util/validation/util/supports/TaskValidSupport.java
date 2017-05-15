package com.keeper.util.validation.util.supports;

import com.keeper.model.dao.Task;
import com.keeper.util.validation.util.IValid;
import com.keeper.util.validation.util.IValidator;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 15.05.2017
 */
public class TaskValidSupport implements IValid<Task> {

    @Override
    public boolean validate(Task task) {
        return false;
    }

    @Override
    public boolean validate(Task task, Class<? extends IValidator> executor) {
        return false;
    }

    @Override
    public void support(Class<? extends IValidator>[] classes) {

    }
}
