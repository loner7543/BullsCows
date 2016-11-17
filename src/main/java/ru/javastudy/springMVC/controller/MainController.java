package ru.javastudy.springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.javastudy.springMVC.model.User;


@Controller
public class MainController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        int i = 4;
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
        ModelAndView modelAndView = new ModelAndView("GameBoard");
        return modelAndView;
    }

    @RequestMapping(value = "/showStat")
    public ModelAndView showStat(){
        ModelAndView modelAndView = new ModelAndView("Statistics");
        return modelAndView;
    }
}
