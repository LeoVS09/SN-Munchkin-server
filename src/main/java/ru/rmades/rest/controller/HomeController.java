package ru.rmades.rest.controller;

/**
 * Created by Администратор on 17.08.2016.
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rmades.rest.ODT.Game.Game;
import ru.rmades.rest.ODT.Game.GameDAOWrapper;
import ru.rmades.rest.ODT.UserData;
import ru.rmades.rest.ODT.UserDAOWrapper;
import ru.rmades.rest.controller.mobile.model.GameForTransaction;
import ru.rmades.rest.controller.mobile.model.UserForTransaction;

//import ru.rmades.rest.User;
//import ru.rmades.rest.UserDAO;

@RestController
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping
    public String lol(){
        return "lol";
    }

    @Autowired
    private UserDAOWrapper userDao;

    @Autowired
    private GameDAOWrapper gameDao;

    @RequestMapping("/create/user/{login}/{password}")
    public String createUser(@PathVariable String login,@PathVariable String password){
        String text;
        UserForTransaction user = new UserForTransaction(login, password);
        try {
            userDao.save(user);
        }catch (Exception e){
            text = "Exception: " + e.toString();
            log.info(text);
            return text;
        }
        text = "Save user";
        log.info(text);
        return text;
    }

    @RequestMapping("/create/game/{name}/{password}")
    public String createGame(@PathVariable String name, @PathVariable String password){
        boolean open = true;
        GameForTransaction game = new GameForTransaction(name,password,open);
        String text;
        try{
            gameDao.save(game,"Trol");
        }catch (Exception e){
            text = "Error: " + e.toString();
            log.info(text);
            return text;
        }
        text = "Game save";
        log.info(text);
        return text;
    }

    @RequestMapping("/all-games")
    public String viewGames(){
        return gameDao.getAllGames();
    }

    @RequestMapping("/add-user-in-game/{name}/{password}/{login}")
    public String addUserInGame(@PathVariable String name, @PathVariable String password, @PathVariable String login){
        String text;
        try{
            gameDao.addUser(name,login,password);
            text = "User is added";
        }catch(Exception e) {
            text = "Error: " + e.toString();
        }
        log.info(text);
        return text;
    }

    @RequestMapping("/get/user/{login}")
    public String getUser(@PathVariable String login){
        String text = "";
        try{
            UserData user = userDao.findByLogin(login);
            text = user.toString();
            if(user.getGame() != null) text += "\nGame:\n" + user.getGame().toString();
        }catch (Exception e){
            text = "Error: " + e.toString();
        }
        log.info(text);
        return text;
    }

    @RequestMapping("/get/game/{name}")
    public String getGame(@PathVariable String name){
        String text = "";
        try{
            Game game = gameDao.findByName(name);
            text = game.toString() + "\nUsers:\n";
            for(UserData user: game.getUsers()){
                text += user.toString() + "\n";
            }
        }catch (Exception e){
            text = "Error: " + e.toString();
        }
        log.info(text);
        return text;
    }

    @RequestMapping("/user-is-have/{login}/{password}")
    public String UserIsHave(@PathVariable String login, @PathVariable String password){

        String text;
        try{
            UserForTransaction user = new UserForTransaction(login,password);
            text = userDao.isHave(user)?"true":"false";
            log.info(text);
            return text;
        }catch (Exception e){
            text = "Exception: " + e.toString();
            log.info(text);
            return text;
        }
//        text = "User: " + user.getLogin() + " --- " + user.getPassword();
//        log.info(text);
//        return text;
    }

}
