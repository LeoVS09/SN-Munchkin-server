package ru.rmades.rest.ODT.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rmades.rest.ODT.User;
import ru.rmades.rest.ODT.UserDAO;
import ru.rmades.rest.ODT.UserDAOWrapper;
import ru.rmades.rest.controller.GameForTransaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 20.08.2016.
 */


@Component
public class GameDAOWrapper {

    @Autowired
    private GameDAO gameDao;

    @Autowired
    private UserDAOWrapper userDao;

    public GameDAOWrapper(){}

    public void save(GameForTransaction game,User user) throws Exception{
        if(game.isEmpty()) throw new Exception("Name is empty");
        Game gameForBD = new Game(game.getName(),game.getPassword(),game.isOpen());
        List<User> playng = new ArrayList<User>();
        playng.add(user);
        gameForBD.setUsers(playng);
        user.setGame(gameForBD);
        gameDao.save(gameForBD);
        userDao.save(user);
    }

    public void save(GameForTransaction game, String login) throws Exception{
        save(game,userDao.findByLogin(login));
    }

    public void addUser(String nameOfGame,User user,String password)throws Exception{
        Game game = gameDao.findByName(nameOfGame);
        if(!game.isOpen()) throw new Exception("Game is close");
        if(!game.getPassword().equals(password)) throw new Exception("Password is incorrect");
        game.getUsers().add(user);
        user.setGame(game);
        gameDao.save(game);
        userDao.save(user);
    }

    public void addUser(String nameOfGame,User user)throws Exception{
        addUser(nameOfGame, user,"");
    }

    public void addUser(String nameOfGame,String login,String password) throws Exception{
        addUser(nameOfGame,userDao.findByLogin(login),password);
    }

    public String getAllGames(){
        String text = "";
        for(Game game: gameDao.findAll()){
            text += game.toString() + "\n";
        }
        return text;
    }

    public Game findByName(String name){
        return gameDao.findByName(name);
    }

    public Iterable<Game> findAll(){
        return gameDao.findAll();
    }
}