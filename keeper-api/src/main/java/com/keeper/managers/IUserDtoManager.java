package com.keeper.managers;

/*
 * Created by Alexandr Vasiliev on 30.03.2017.
 */

import com.keeper.dto.UserDto;
import com.keeper.service.IUserService;

import java.util.List;

/**
 * Default Comment
 */
public interface IUserDtoManager<T> extends IModelDtoManager<T,UserDto>, IUserService {

}
