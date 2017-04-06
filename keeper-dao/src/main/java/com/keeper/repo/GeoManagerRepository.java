package com.keeper.repo;

/*
 * Created by @GoodforGod on 5.04.2017.
 */

import com.keeper.entity.GeoManager;
import com.keeper.util.RepositoryResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Default Comment
 */
//@Repository
//@Qualifier(value = RepositoryResolver.QUALIFIER_GEOMANAGER)
public interface GeoManagerRepository{//} extends JpaRepository<GeoManager, Long> {

}
