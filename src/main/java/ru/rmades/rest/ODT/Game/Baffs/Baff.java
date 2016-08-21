package ru.rmades.rest.ODT.Game.Baffs;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Администратор on 14.08.2016.
 */

@Entity
@Table(name="baffs")
public class Baff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private long id;

    @NotNull
    private String type;

    @NotNull
    private int arg;

    public Baff(){}

    public Baff(String type, int arg) {
        this.type = type;
        this.arg = arg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getArg() {
        return arg;
    }

    public void setArg(int arg) {
        this.arg = arg;
    }
}
