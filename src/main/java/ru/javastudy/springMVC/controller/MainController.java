package ru.javastudy.springMVC.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.javastudy.springMVC.model.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

//123
@Controller
public class MainController {
    private static final String JNDI_NAME="java:comp/env/jdbc/Bulls";
    private Context context;
    private Game game;
    private DataSource ds;
    private UserDAOImpl userDAO;
    private boolean firstLoad = true;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() throws NamingException, SQLException {
        context = new InitialContext();
        try {
            ds = (DataSource)context.lookup(JNDI_NAME);
        } catch (NamingException e) {
            e.printStackTrace();
        }
         userDAO =new UserDAOImpl(ds);
        //ArrayList<User> l = userDAO.getAllUser();
        //User user = new User(3,"gff","dfffsa");
        //userDAO.insertUser(user);
        game = new Game(new User());
        ModelAndView modelAndView = new ModelAndView();
        //PreparedStatement preparedStatement = (PreparedStatement) connection.createStatement();
        modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/check-user")
    public ModelAndView checkUser(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("secondPage");
        modelAndView.addObject("userJSP", user);

        return modelAndView;
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
    public @ResponseBody ModelAndView registration(@RequestBody String m){
        JSONObject jsonObject = new JSONObject(m);
        User user = new User(1,jsonObject.getString("login"),jsonObject.getString("pass"));
        ModelAndView modelAndView = new ModelAndView();
        return  modelAndView;
    }

    @RequestMapping(value = "/showRegistrationFom")
    public ModelAndView showReg(){
        ModelAndView modelAndView = new ModelAndView("Registration");
        return modelAndView;
    }
}
