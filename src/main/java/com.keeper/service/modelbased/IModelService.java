package com.keeper.service.modelbased;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public interface IModelService<DAO> {

    boolean exists(Long id);

    Optional<DAO> get(Long id);

    Optional<List<DAO>> getAll();

    /** TRANSACTIONAL */
    Optional<DAO> save(DAO model);

    /** TRANSACTIONAL */
    Optional<DAO> update(DAO model);

    /** TRANSACTIONAL */
    void remove(Long id);
}
