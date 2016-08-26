package ru.rmades.rest.game.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rmades.rest.JSONWrapper;
import ru.rmades.rest.ODT.Game.Baffs.Card;
import ru.rmades.rest.ODT.Game.Baffs.CardDAO;
import ru.rmades.rest.ODT.Game.Creatures.Creature;
import ru.rmades.rest.ODT.Game.Creatures.Hero;
import ru.rmades.rest.ODT.Game.Creatures.HeroDAO;
import ru.rmades.rest.ODT.Game.Creatures.Monster;
import ru.rmades.rest.ODT.Game.Game;
import ru.rmades.rest.ODT.Game.GameDAOWrapper;
import ru.rmades.rest.ODT.Game.Map.Map;
import ru.rmades.rest.ODT.Game.Map.MapDAO;
import ru.rmades.rest.ODT.Game.Map.Room;
import ru.rmades.rest.ODT.Game.Map.RoomDAO;
import ru.rmades.rest.ODT.Game.Step;
import ru.rmades.rest.ODT.UserDAOWrapper;
import ru.rmades.rest.ODT.UserData;
import ru.rmades.rest.controller.mobile.firebase.message.TalkAll;
import ru.rmades.rest.controller.mobile.firebase.message.TalkTo;

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
    private RoomDAO roomDAO;

    @Autowired
    private CardDAO cardDAO;


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
                    new TalkAll(game,json.toString(heroes),"Hero[]").run();
                    Map map = new Map();
                    map.setRooms(new ArrayList<Room>());
                    Room centralRoom = new Room();
                    centralRoom.setCreatures(heroes);
                    map.getRooms().set(4+9*4,centralRoom);
                    centralRoom.setMap(map);
                    roomDAO.save(centralRoom);
                    map.setGame(game);
                    game.setMap(map);
                    mapDAO.save(map);
                    gameDAO.save(game);
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
                    Map map = game.getMap();
                    int index = user.getHero().getX() + step.getX() + 4*(user.getHero().getY()+step.getY());
                    List<Creature> creatures = game.getMap().getRooms()
                            .get(user.getHero().getX() + 4*user.getHero().getX())
                                .getCreatures();
                    boolean inFight = false;
                    for(Creature ex: creatures){
                        if(ex.getClass() == Monster.class) inFight = true;
                    }
                    if(!inFight) {
                        creatures.remove(user.getHero());
                        if (map.getRooms().get(index) == null) {
                            Room room = new Room();
                            room.setCreatures(new ArrayList<>());
                            Monster monster = new Monster();
                            room.getCreatures().add(monster);
                            user.getHero().setX((short) (user.getHero().getX() + step.getX()));
                            user.getHero().setY((short) (user.getHero().getY() + step.getY()));
                            room.getCreatures().add(user.getHero());
                            room.setMap(map);
                            map.getRooms().set(index, room);
                            roomDAO.save(room);
                            mapDAO.save(map);
                            new TalkAll(game, json.toString(room), "Room").run();
                            Card card = new Card();
                            user.getHero().setCards(new ArrayList<>());
                            user.getHero().getCards().add(card);
                            cardDAO.save(card);
                            new TalkTo(user, json.toString(card), "Card").run();
                        } else {
                            user.getHero().setX((short) (user.getHero().getX() + step.getX()));
                            user.getHero().setY((short) (user.getHero().getY() + step.getY()));
                            game.getMap().getRooms()
                                    .get(user.getHero().getX() + 4 * user.getHero().getX())
                                    .getCreatures().add(user.getHero());
                            new TalkTo(user, json.toString(game.getMap().getRooms()
                                    .get(user.getHero().getX() + 4 * user.getHero().getX())), "Room").run();
                        }
                    }
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
                    Hero hero = user.getHero();
                    Room room = game.getMap().getRooms().get(hero.getX() + 4*hero.getY());
                    Monster monster = null;
                    for(Creature ex: room.getCreatures()){
                        if(!ex.equals(hero)) monster = (Monster)ex;
                    }
                    if(monster == null) {
                        new TalkTo(user,"\"Not have enemy in room\"","String");
                        throw new Exception("Not have monster in room");
                    }
                    int win = -1;
                    int levelUp = 1;
                    int hit = -1;
                    if(hero.getLevel() >= monster.getLevel()) win = 1;
                    levelUp = win == 1 ? levelUp:0;
                    hit = win == -1 ? hit : 0;
                    String resultFight = "{\n" +
                                        " \"win\": " + Integer.toString(win) + ",\n" +
                                        " \"level\": " + Integer.toString(levelUp) + ",\n" +
                                        " \"hit\": " + Integer.toString(hit) +
                                        "\n}";
                    new TalkAll(game,resultFight,"ResultFight");
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
