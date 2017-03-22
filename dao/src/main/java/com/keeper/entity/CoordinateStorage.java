package com.keeper.entity;

/*
 * Created by GoodforGod on 21.03.2017.
 */

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Used in Location and Route to work with coord set
 */
public class CoordinateStorage {

    private Set<Coordinate> coordinates = new HashSet<Coordinate>();

    public Set<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Set<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinate addCoordinate(Coordinate coord) {
        this.coordinates.add(coord);
        return coord;
    }

    public Coordinate removeCoordinate(Coordinate coord) {
        this.coordinates.remove(coord);
        return coord;
    }

    public Coordinate removeCoordinate(final Integer coordId) {
        Coordinate coord = this.coordinates.stream().filter(coordinate -> Objects.equals(coordinate.getId(), coordId)).findFirst().get();

        return coord;
    }

}
