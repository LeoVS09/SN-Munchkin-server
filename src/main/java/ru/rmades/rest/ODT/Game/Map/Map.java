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
    @JoinTable(name="Maps_Rows",
            joinColumns = @JoinColumn(name="Maps_id"),
            inverseJoinColumns = @JoinColumn(name="rows_id"))
    private List<MatrixRow> walls;

    public Map() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<MatrixRow> getWalls() {
        return walls;
    }

    public void setWalls(List<MatrixRow> walls) {
        this.walls = walls;
    }

    public boolean isOpen(int x, int y){
        return true;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}

