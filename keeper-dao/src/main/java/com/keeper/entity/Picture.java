package com.keeper.entity;

/*
 * Created by GoodforGod on 20.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */



import com.keeper.entity.states.PicType;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Picture model
 */
@Entity
@Table(name = "Pictures", schema = "entities")
public class Picture {

    public static final Picture empty = new Picture();

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "ownerId", nullable = false)
    private Long ownerId;

    @Column(name = "type", nullable = false)
    private PicType type = PicType.TASK;

    @Column(name = "value", nullable = false)
    private String pic;

    private Picture() {}

    public Picture(Long ownerId, String pic) {
        this.ownerId = ownerId;
        this.pic = pic;
    }

    //<editor-fold desc="GetterAndSetter">

    public Long getId() {
        return id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public PicType getType() {
        return type;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    //</editor-fold>
}
