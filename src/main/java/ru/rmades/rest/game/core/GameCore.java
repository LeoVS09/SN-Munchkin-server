package ru.rmades.rest.game.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rmades.rest.JSONWrapper;
import ru.rmades.rest.ODT.Game.Creatures.Hero;
import ru.rmades.rest.ODT.Game.Creatures.HeroDAO;
import ru.rmades.rest.ODT.Game.Game;
import ru.rmades.rest.ODT.Game.GameDAOWrapper;
import ru.rmades.rest.ODT.Game.Map.*;
import ru.rmades.rest.ODT.Game.Step;
import ru.rmades.rest.ODT.UserDAOWrapper;
import ru.rmades.rest.ODT.UserData;
import ru.rmades.rest.controller.mobile.firebase.message.TalkAll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Администратор on 24.08.2016.
 */

@Service
public class GameCore {

    private static final Logger log = LoggerFactory.getLogger(GameCore.class);
    private static final JSONWrapper json = new JSONWrapper();

    @Autowired
    private GameDAOWrapper gameDAO;

    @Autowired
    private MapDAO mapDAO;

    @Autowired
    private UserDAOWrapper userDAO;

    @Autowired
    private HeroDAO heroDAO;

    @Autowired
    private WallDAO wallDAO;

    public Runnable begin(Game game){
        return new Runnable() {
            @Override
            public void run() {
                try {
                    List users = game.getUsers();
                    users.sort(new Comparator<UserData>() {
                        @Override
                        public int compare(UserData u1, UserData u2) {
                            return (int) (u1.getId() - u2.getId());
                        }
                    });
                        short color = 1;
                    List heroes = new ArrayList<Hero>();
                    for (UserData user : game.getUsers()) {
                        Hero hero = new Hero();
                        hero.setColor(color);
                        color += 1;
                        heroDAO.save(hero);
                        user.setHero(hero);
                        heroes.add(hero);
                        userDAO.save(user);
                    }
                    new TalkAll(game,json.toString(heroes)).run();
                    Map map = new Map();
                    map.setGame(game);
                    game.setMap(map);
                    mapDAO.save(map);
                    gameDAO.save(game);
                    map.setWalls(new ArrayList<Wall>());
                    map.setRooms(new ArrayList<Room>());
                    map.getRooms().set(4+9*4,new Room());
                    List<Wall> walls = new ArrayList<>();
                    Wall wall = new Wall();
                    walls.add(wall);
                    wallDAO.save(wall);
                    map.getWalls().set(2*4 + 2*9*(2*4+1),wall);
                    wall = new Wall();
                    walls.add(wall);
                    wallDAO.save(wall);
                    map.getWalls().set(2*4 + 1 + 2*9*2*4,wall);
                     wall = new Wall();
                    walls.add(wall);
                    wallDAO.save(wall);
                    map.getWalls().set(2*4 + 2*9*(2*4-1),wall);
                    wall = new Wall();
                    walls.add(wall);
                    wallDAO.save(wall);
                    map.getWalls().set(2*4 - 1 + 2*9*2*4,wall);
                    new TalkAll(game,walls.toString()).run();
                }catch (Exception e){
                    log.info("Error: " + e.toString());
                }
            }
        };
    }

    public Runnable step(Game game,UserData user,Step step){
        return new Runnable() {
            @Override
            public void run() {
                try{
                    log.info("Step: -------->" + game.getName() + ":: " + user.getLogin() + ": " + step.toString());
                }catch (Exception e){
                    log.info("Error: " + e.toString());
                }
            }
        };
    }

    public Runnable fight(Game game,UserData user){
        return new Runnable() {
            @Override
            public void run() {
                try{
                    log.info("Fight: -------->" + game.getName() + ":: " + user.getLogin());
                }catch (Exception e){
                    log.info("Error: " + e.toString());
                }
            }
        };
    }

//    private ArrayList<Wall> getWallsAboutRoom(short x, short y){
//        ArrayList<Position> posits = new ArrayList<>();
//        posits.add(new Position(cordinat.x))
//    }
}

class Position{
    public short x;
    public short y;
    public Position(short x, short y){
        this.x = x;
        this.y = y;
    }
}
