package ru.rmades.rest.ODT.Game.Map;

import ru.rmades.rest.ODT.Game.Game;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Администратор on 15.08.2016.
 */
@Entity
@Table(name="Maps")
public class Map{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(unique = true)
    private long id;

    @OneToOne
    private Game game;


    @OneToMany
    @JoinTable(name="Maps_Rooms",
            joinColumns = @JoinColumn(name="Maps_id"),
            inverseJoinColumns = @JoinColumn(name="Rooms_id"))
    private List<Room> rooms;

    public Map() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isOpen(int x, int y){
        return true;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}

