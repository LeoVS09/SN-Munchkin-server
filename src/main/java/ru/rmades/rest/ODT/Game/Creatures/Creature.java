package ru.rmades.rest.ODT.Game.Creatures;

import ru.rmades.rest.ODT.Game.Baffs.Baff;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Администратор on 14.08.2016.
 */
@Entity
@Table(name="Creatures")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Creature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private long            id;
    private Color           color;
    @NotNull
    private short           level;
    private short           x;
    private short           y;

    public static enum Color{
        Blue, Red, Green
    }

    @OneToMany
    @JoinTable(name="Creatures_Baffs",
            joinColumns = @JoinColumn(name="Creature_id"),
            inverseJoinColumns = @JoinColumn(name="Baffs_id"))
    private List<Baff> baffs;

    public Creature(){}

    public Creature(short level,short x, short y, Color color){
        this.level = level;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public short getX() {
        return x;
    }

    public void setX(short x) {
        this.x = x;
    }

    public short getY() {
        return y;
    }

    public void setY(short y) {
        this.y = y;
    }

    public List<Baff> getBaffs() {
        return baffs;
    }

    public void setBaffs(List<Baff> baffs) {
        this.baffs = baffs;
    }
}
