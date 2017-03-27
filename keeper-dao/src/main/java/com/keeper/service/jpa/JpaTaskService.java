package com.keeper.service.jpa;

import com.keeper.dao.repo.TaskRepository;
import com.keeper.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by AlexVasil on 26.03.2017.
 */

/**
 * Repository to work with User with Tasks
 */


@Service("jpaTaskService")
@Transactional
public class JpaTaskService {

//    @Autowired
    @Autowired(required = false) // set to false to remove conflicts with other configurations
    private EntityManagerFactory entityManagerFactory;



    @Transactional
    public void printTasks() {
        List<Task> tasks = entityManagerFactory.createEntityManager().createQuery("select t from Tasks t").getResultList();
        for (Task task : tasks) {
            System.out.println(task);
        }
    }


//    @Autowired(required = false)
    private TaskRepository taskRepository;
    //Or can use Dao

    @Transactional
    public void printTasksStartingWith(String start) {
        for (Task task : taskRepository.findAll()) {
            System.out.println(task);
        }
    }
}
