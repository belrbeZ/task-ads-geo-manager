package com.keeper.model.dao;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */


import com.keeper.model.states.RouteType;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Route Location implementation
 */
//@Entity
//@Table(name = DatabaseResolver.TABLE_ROUTES, schema = DatabaseResolver.SCHEMA)
public class Route {

    public static final Route empty = new Route();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)   private Long id;
    @Column(name = "type", nullable = false)                private RouteType type;
    @Column(name = "info")                                  private String info;

//    List<String> latitude;
//    List<String> longtitude;


    private Route() {}

    public Route(RouteType type, String info){
        this.type = type;
        this.info = info;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public RouteType getType() {
        return type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    //</editor-fold>
}
