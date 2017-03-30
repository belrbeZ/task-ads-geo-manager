package com.keeper.managers.contracts;

/**
 * Created by Alexandr Vasiliev on 30.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */
public interface ModelDtoManager <T, K> {

    T parseDtoToDao(K geoPointDto);

    K parseDaoToDto(T geoPoint);

}
