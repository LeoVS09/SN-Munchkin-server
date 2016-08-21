package ru.rmades.rest.ODT.Game.Baffs;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Администратор on 14.08.2016.
 */

@Entity
@Table(name="cards")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(unique = true)
    private Long id;

    @NotNull
    private String name;

    private String image;
    private String description;

    @OneToMany
    @JoinTable(name="Cards_Baffs",
                joinColumns = @JoinColumn(name="Cards_id"),
                inverseJoinColumns = @JoinColumn(name="Baffs_id"))
    private List<Baff> baffs;

    public Card(){}

    public Card(String name, String image, String description){
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Baff> getBaffs(){
        return baffs;
    }

    public void setBaffs(List<Baff> baffs){
        this.baffs = baffs;
    }
}
