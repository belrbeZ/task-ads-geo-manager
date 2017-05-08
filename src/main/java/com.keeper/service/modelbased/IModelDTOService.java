package com.keeper.service.modelbased;

/*
 * Created by @GoodforGod on 08.05.2017.
 */

import java.util.Optional;

/**
 * Default Comment
 */
public interface IModelDTOService<DAO, DTO> {

    /** TRANSACTIONAL */
    Optional<DAO> saveDTO(DTO model);

    /** TRANSACTIONAL */
    Optional<DAO> updateDTO(DTO model);
}
