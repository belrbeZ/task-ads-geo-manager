package com.keeper.dto;

import java.io.Serializable;

/**
 * Created by Alexandr Vasiliev on 29.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */
public interface ModelDto<ID extends Serializable> {
    ID getId();
}
