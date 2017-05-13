package com.keeper.service.modelbased;

/*
 * Created by @GoodforGod on 6.04.2017.
 */

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public interface IPrimeModelService<DAO> {

    boolean exists(Long id);

    Optional<DAO> get(Long id);

    Optional<List<DAO>> getAll();

    /** TRANSACTIONAL */
    Optional<DAO> save(DAO model);

    /** TRANSACTIONAL */
    Optional<List<DAO>> save(List<DAO> model);

    /** TRANSACTIONAL */
    Optional<DAO> update(DAO model);

    /** TRANSACTIONAL */
    void remove(Long id);
}
