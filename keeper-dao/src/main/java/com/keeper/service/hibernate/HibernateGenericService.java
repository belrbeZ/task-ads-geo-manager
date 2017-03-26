package com.keeper.service.hibernate;

import com.keeper.entity.IModel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by AlexVasil on 26.03.2017.
 */

@Service
public class HibernateGenericService <MODEL extends IModel<ID>, ID extends Serializable> {

//    @Autowired
    // set to false to remove conflicts with other configurations
    private final SessionFactory sessionFactory;

    @Autowired(required = false)
    public HibernateGenericService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void printItems() {
//        List<MODEL> items = sessionFactory.getCurrentSession().createQuery("select from" + MODEL).list();
//        for (MODEL item : items) {
//            System.out.println(item);
//        }
    }


}
