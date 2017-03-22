package com.keeper.entity;

import java.io.Serializable;

/**
 * Created by AlexVasil on 22.03.2017.
 */
public interface IModel<ID extends Serializable> {
    ID getId();
}