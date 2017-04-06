package com.keeper.repo;

/*
 * Created by GoodforGod on 26.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.entity.Picture;
import com.keeper.util.RepositoryResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Default Comment
 */
//@Repository
//@Qualifier(value = RepositoryResolver.QUALIFIER_PIC)
public interface PicRepository {//extends JpaRepository<Picture, Long> {

}
