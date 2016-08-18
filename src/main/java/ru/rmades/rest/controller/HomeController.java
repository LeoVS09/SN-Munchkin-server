package ru.rmades.rest.controller;

/**
 * Created by Администратор on 17.08.2016.
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rmades.rest.UserDAOWrapper;

//import ru.rmades.rest.User;
//import ru.rmades.rest.UserDAO;

@RestController
public class HomeController {

//    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

//    public String lol(){
//        return "lol";
//    }

//    @Autowired
//    private UserDAO userDao;
//
//    @RequestMapping("/create")
//    public String create(){
//        String text;
//        User user = new User("Troler", "loler");
//        try {
//            userDao.save(user);
//        }catch (Exception e){
//            text = "Exception: " + e.toString();
////            log.info(text);
//            return text;
//        }
//        text = "Save user";
////        log.info(text);
//        return text;
//    }

    @Autowired
    private UserDAOWrapper userDAO;

    @RequestMapping("/get-user/{userLogin}/{userPassword}")
    public String getByLogin(@PathVariable String userLogin, @PathVariable String userPassword){

        String text;
        try{
            UserForTransaction user = new UserForTransaction(userLogin,userPassword);
            return userDAO.isHave(user)?"true":"false";
        }catch (Exception e){
            text = "Exception: " + e.toString();
//            log.info(text);
            return text;
        }
//        text = "User: " + user.getLogin() + " --- " + user.getPassword();
//        log.info(text);
//        return text;
    }

}
