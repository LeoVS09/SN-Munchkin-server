package ru.rmades.rest.controller.mobile;

/**
 * Created by Администратор on 16.08.2016.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rmades.rest.JSONWrapper;
import ru.rmades.rest.ODT.Game.Game;
import ru.rmades.rest.ODT.Game.GameDAOWrapper;
import ru.rmades.rest.ODT.UserDAOWrapper;
import ru.rmades.rest.ODT.UserData;
import ru.rmades.rest.controller.Encoder;
import ru.rmades.rest.controller.mobile.firebase.message.TalkAll;
import ru.rmades.rest.controller.mobile.model.GameForTransaction;
import ru.rmades.rest.controller.mobile.model.UserForTransaction;
import ru.rmades.rest.game.core.GameCore;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/mobile/game")
public class MobileGameController {
    private static final Logger log = LoggerFactory.getLogger(MobileGameController.class);
    private static final JSONWrapper json = new JSONWrapper();
    private static final Encoder encode = new Encoder();
    @Autowired
    GameDAOWrapper gameDao;

    @Autowired
    private UserDAOWrapper userDAO;

    @Autowired
    GameCore gameCore;

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public ResponseEntity<String> gameCreate(@RequestHeader HttpHeaders headers, @RequestBody GameForTransaction game){
        try{
            log.info("------->" + game.getName() + ": " + game.getPassword());
            gameDao.save(game,getUser(headers));
            return new ResponseEntity<String>(json.toString("Success"),HttpStatus.OK);
        }catch (Exception e){
            log.info(e.toString());
            return new ResponseEntity<String>(json.toString("Error: " + e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/all-games",method = RequestMethod.GET)
    public ResponseEntity<GameForTransaction[]> viewGames(@RequestHeader HttpHeaders headers){

            ArrayList<GameForTransaction> games = new ArrayList<GameForTransaction>();
        try{
            getUser(headers);
            for(Game game: gameDao.findAll()){
                GameForTransaction gameSend = new GameForTransaction(game.getName(),"",game.isOpen());
                games.add(gameSend);
            }
            return ResponseEntity.ok(games.toArray(new GameForTransaction[0]));
        }catch (Exception e){
            log.info(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(games.toArray(new GameForTransaction[0]));
        }
    }

    @RequestMapping(value="/join", method = RequestMethod.POST)
    public ResponseEntity<String> joinToGame(@RequestHeader HttpHeaders headers, @RequestBody GameForTransaction game){
        List<UserForTransaction> users = new ArrayList<UserForTransaction>();
        try{
            UserData userData = getUser(headers);
            Game gameInBase = gameDao.findByName(game.getName());
            if(gameInBase == null) throw new Exception("Invalid game");
            if(!gameInBase.getPassword().equals(game.getPassword())) throw new Exception("Incorrect password");
            for(UserData user: gameInBase.getUsers()){
                if(userData == user) throw new Exception("User already is the game");
                UserForTransaction userSend = new UserForTransaction(user.getLogin());
                users.add(userSend);
            }

            gameDao.addUser(gameInBase,userData);
            users.add(new UserForTransaction(userData.getLogin()));
            Thread myThread = new Thread(new TalkAll(gameInBase,json.toString(users)));
            myThread.start();
            return ResponseEntity.ok("Success");
        }catch (Exception e){
            log.info(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.toString());
        }
    }

    @RequestMapping(value = "/begin", method = RequestMethod.POST)
    public ResponseEntity<String> startGame(@RequestHeader HttpHeaders headers){
        try{
            UserData userData = getUser(headers);
            userData.StartGame();
            userDAO.save(userData);
            Game gameInBase = userData.getGame();
            if(!gameDao.isStartGame(gameInBase)) return ResponseEntity.ok("Success");


            new Thread(gameCore.begin(gameInBase));
            return ResponseEntity.ok("Success");
        }catch (Exception e){
            log.info(e.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.toString());
        }
    }

    private UserData getUser(HttpHeaders headers) throws Exception{
        String token = headers.get("Authorization").get(0);
        if(token == null || token.equals("")) throw new Exception("Invalid token");
        UserData user = userDAO.findById(encode.getUserId(token));
        if(user == null) throw new Exception("User is not exist");
        return user;
    }


}
