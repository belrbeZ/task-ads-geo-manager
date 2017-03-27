package com.keeper.service.jpa;

/**
 * Created by AlexVasil on 26.03.2017.
 */

import com.keeper.dao.repo.LocationRepository;
import com.keeper.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.util.List;


/**
 * Repository to work with Locations
 */

@Service("jpaLocationService")
@Transactional
public class JpaLocationService {

    //    @Autowired
    @Autowired(required = false) // set to false to remove conflicts with other configurations
    private EntityManagerFactory entityManagerFactory;


    @Transactional
    public void printLocations() {
        List<Location> locations = entityManagerFactory.createEntityManager().createQuery("select p from Locations p").getResultList();
        for (Location location : locations) {
            System.out.println(location);
        }
    }


    @Autowired(required = false)
    private LocationRepository locationRepository;

    @Transactional
    public void printLocationsStartingWith(String start) {
        for (Location location : locationRepository.findByOwnerId(start)) {
            System.out.println(location);
        }
    }


}
