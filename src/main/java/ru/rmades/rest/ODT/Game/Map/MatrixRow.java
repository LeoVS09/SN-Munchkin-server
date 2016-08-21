package ru.rmades.rest.ODT.Game.Map;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Администратор on 22.08.2016.
 */
@Entity
public class MatrixRow {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(unique = true)
    private long id;

    @ManyToOne
    private Map map;

    @OneToMany
    @JoinTable(name="Row_wall",
            joinColumns = @JoinColumn(name="row_id"),
            inverseJoinColumns = @JoinColumn(name="wall_id"))
    private List<Wall> row;

    public MatrixRow(){}

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

    public List<Wall> getRow() {
        return row;
    }

    public void setRow(List<Wall> row) {
        this.row = row;
    }
}
