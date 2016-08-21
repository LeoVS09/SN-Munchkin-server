package ru.rmades.rest.ODT.Game.Map;

import ru.rmades.rest.ODT.Game.Baffs.Baff;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Администратор on 14.08.2016.
 */
@Entity
@Table(name="Walls")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Wall {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(unique = true)
    private long id;

    @NotNull
    private String image;

    @OneToMany
    private List<Baff> baffs;

    public Wall(){}

    public Wall(String image){
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Baff> getBaffs() {
        return baffs;
    }

    public void setBaffs(List<Baff> baffs) {
        this.baffs = baffs;
    }
}
