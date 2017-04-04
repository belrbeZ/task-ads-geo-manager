package com.keeper.entity;

/*
 * Created by @GoodforGod on 4.04.2017.
 */

import com.keeper.util.DatabaseResolver;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Default Comment
 */
@Entity
@Table(name = DatabaseResolver.TABLE_GEOMANAGER, schema = DatabaseResolver.SCHEMA)
public class GeoManager {

}
