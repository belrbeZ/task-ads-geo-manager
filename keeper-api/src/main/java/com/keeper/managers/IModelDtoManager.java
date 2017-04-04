package com.keeper.managers;

import java.util.List;

/**
 * Created by Alexandr Vasiliev on 30.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */
public interface IModelDtoManager<TDao, TDto> {
    TDao parseDtoToDao(TDto dtoMode);

    TDto parseDaoToDto(TDao daoModel);

    List<TDao> parseDtoToDao(List<TDto> dtoModelList);

    List<TDto> parseDaoToDto(List<TDao> daoModelList);
}
