package com.keeper.dto;

import com.keeper.entity.states.RouteType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Alexandr Vasiliev on 30.03.2017.
 *
 * @author Alexandr Vasiliev
 *
 */
public class RouteDto extends GeoPointStorageDto implements ModelDto<Long> {



    public static final RouteDto empty = new RouteDto();

    private Long id;

    private Long userId;

    private RouteType type;

    private MarkDto mark = MarkDto.empty;

    private String about;

    private RouteDto() {}

    public RouteDto(Long userId, RouteType type, String about){
        this.userId = userId;
        this.type = type;
        this.about = about;
    }

    public RouteDto(Long userId, RouteType type, String about, List<GeoPointDto> geoPoints) {
        this(userId, type, about);
        setGeoPoints(new HashSet<>(geoPoints));
    }

    public RouteDto(Long userId, RouteType type, String about, Set<GeoPointDto> geoPoints) {
        this(userId, type, about);
        setGeoPoints(new HashSet<>(geoPoints));
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public RouteType getType() {
        return type;
    }

    public MarkDto getMark() {
        return mark;
    }

    public void setMark(MarkDto mark) {
        this.mark = mark;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    //</editor-fold>

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteDto route = (RouteDto) o;

        return id != null ? id.equals(route.id) : route.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


}
