package com.keeper.service.modelbased.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 14.05.2017
 */
public abstract class PrimeModelUtilService<T, ID> {

    protected static final Logger logger = LoggerFactory.getLogger(PrimeModelUtilService.class);

    protected T getEmpty() {
        return null;
    }

    protected List<T> getEmptyList() {
        return Collections.emptyList();
    }

    boolean invalidId(ID id, String msg) {
        if(id == null) {
            logger.warn(msg);
            return true;
        }
        return false;
    }

    boolean invalidModel(T model, String msg) {
        if(model == null) {
            logger.warn(msg);
            return true;
        }
        return false;
    }

    boolean invalidListModel(List<T> model, String msg) {
        if(model == null || model.isEmpty()) {
            logger.warn(msg);
            return true;
        }
        return false;
    }
}
