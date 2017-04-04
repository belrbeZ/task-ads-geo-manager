package com.keeper.model.dao;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.model.states.RouteType;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Route Location implementation
 */
@Entity
@Table(name = "Routes", schema = "entities")
public class Route {

    public static final Route empty = new Route();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)   private Long id;
    @Column(name = "type", nullable = false)                private RouteType type;
    @Column(name = "info")                                  private String info;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        return id != null ? id.equals(route.id) : route.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
