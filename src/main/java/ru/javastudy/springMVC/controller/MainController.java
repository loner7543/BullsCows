package ru.javastudy.springMVC.controller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.javastudy.springMVC.model.Game;
import ru.javastudy.springMVC.model.StatisticsData;
import ru.javastudy.springMVC.model.User;
import ru.javastudy.springMVC.model.UserDAOImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

@Controller
public class MainController {
    private static final String JNDI_NAME="java:comp/env/jdbc/Bulls";
    private Context context;
    private Game game;
    private DataSource ds;
    private UserDAOImpl userDAO;
    private boolean firstLoad = true;
    private boolean f = true;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() throws NamingException, SQLException {
        context = new InitialContext();
        ds = (DataSource)context.lookup(JNDI_NAME);
         userDAO =new UserDAOImpl(ds);

        //game = new Game(new User(),userDAO);
        ModelAndView modelAndView = new ModelAndView();
        //modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/check-user",method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity<Object> checkUser(@RequestBody String m){
        JSONObject object = new JSONObject(m);
        User user = new User(object.getString("login"),object.getString("password"));
        ModelAndView modelAndView = new ModelAndView();
        User check = userDAO.checkUser(user);
        if (check==null) { //негативный кейс - нужна регистрация - пользователя с таккими данными  нет в бд
            return   ResponseEntity.status(HttpStatus.UNAUTHORIZED ).body(null);
        }
        else {
            game = new Game(check,userDAO);
            game.generateNumber();
            return   ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }

    @RequestMapping(value = "/show")
    public ModelAndView showGameBoard(){
        if (firstLoad){
            game.generateNumber();
            game.getLog().clear();
            firstLoad = false;
        }
        //game.getLog().clear();
        ModelAndView modelAndView = new ModelAndView("GameBoard");
        if (game.getLog().size()!=0)
        {
            modelAndView.addObject("Log",game.getLog());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/showStat")
    public ModelAndView showStat(){
        ModelAndView modelAndView = new ModelAndView("Statistics");
        ArrayList<StatisticsData> allStat = userDAO.getStat();
        modelAndView.addObject("statistics",allStat);
        return modelAndView;
    }

    @RequestMapping(value = "/Attempt",method = RequestMethod.POST,consumes = "application/json")
    public @ResponseBody ModelAndView newAttempt(@RequestBody String m){
        JSONObject jsonObject = new JSONObject(m);
        String digits = jsonObject.getString("userDigit");
        game.compare(digits);
        ModelAndView modelAndView = new ModelAndView("GameBoard");
        return modelAndView;
    }

    @RequestMapping(value = "/registration",method = RequestMethod.POST,consumes = "application/json")
    public ResponseEntity<Object>registration(@RequestBody String m){
        JSONObject jsonObject = new JSONObject(m);
        User user = new User(jsonObject.getString("login"),jsonObject.getString("pass"));
        User newUser = userDAO.insertUser(user);
        game = new Game(newUser,userDAO);
        return  ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @RequestMapping(value = "/showRegistrationFom")
    public ModelAndView showReg(){
        ModelAndView modelAndView = new ModelAndView("Registration");
        return modelAndView;
    }
}
