package ru.rmades.rest.ODT.Game.Map;

import ru.rmades.rest.ODT.Game.Creatures.Creature;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Администратор on 14.08.2016.
 */

@Entity
@Table(name="rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(unique = true)
    private long id;

    @NotNull
    private String image;

//    @OneToMany
//    private List<Baff> baffs;

    @ManyToOne
    private Map map;

    @OneToMany
    @JoinTable(name="Room_Creatures",
            joinColumns = @JoinColumn(name="Room_id"),
            inverseJoinColumns = @JoinColumn(name="Creature_id"))
    private List<Creature> creatures;


    public Room(){super();}

    public Room(String image){this.image = image;}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public List<Baff> getBaffs() {
//        return baffs;
//    }
//
//    public void setBaffs(List<Baff> baffs) {
//        this.baffs = baffs;
//    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public void setCreatures(List<Creature> creatures) {
        this.creatures = creatures;
    }
}
