package com.keeper.managers;

/*
 * Created by Alexandr Vasiliev on 30.03.2017.
 */

import com.keeper.dto.TaskDto;
import com.keeper.dto.UserDto;
import com.keeper.service.ITaskService;

import java.util.List;

public interface ITaskDtoManager<T> extends IModelDtoManager<T, TaskDto>, ITaskService {

}
