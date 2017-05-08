package com.keeper.service;

/*
 * Created by @GoodforGod on 08.05.2017.
 */

import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Default Comment
 */
public interface IModelDTOService<DAO, DTO> {

    /**
     * TRANSACTIONAL
     */
    @Transactional Optional<DAO> saveDTO(DTO model);

    /**
     * TRANSACTIONAL
     */
    @Transactional Optional<DAO> updateDTO(DTO model);
}
