package ru.javastudy.springMVC.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.javastudy.springMVC.model.Game;
import ru.javastudy.springMVC.model.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//123
@Controller
public class MainController {
    private static final String JNDI_NAME="java:comp/env/jdbc/Bulls";
    private Context context;
    private Game game;
    private DataSource ds;
    private Connection connection;
    private boolean firstLoad = true;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() throws NamingException, SQLException {
        context = new InitialContext();
        try {
            ds = (DataSource)context.lookup(JNDI_NAME);
            connection = ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        game = new Game();
        int i  =5;
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
        User user = new User(jsonObject.getString("login"),jsonObject.getString("pass"),0);
        ModelAndView modelAndView = new ModelAndView();
        return  modelAndView;
    }

    @RequestMapping(value = "/showRegistrationFom")
    public ModelAndView showReg(){
        ModelAndView modelAndView = new ModelAndView("Registration");
        return modelAndView;
    }
}
