package ru.javastudy.springMVC.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.javastudy.springMVC.model.Game;
import ru.javastudy.springMVC.model.User;


@Controller
public class MainController {
    private Game game;
    private boolean firstLoad = true;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        game = new Game();
        ModelAndView modelAndView = new ModelAndView();
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
}
