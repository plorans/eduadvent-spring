package edu.um.eduadventspring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.um.eduadventspring.Model.User;


@Controller
public class ControllerLogin {

    
    
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Login");
        

        return modelAndView;
    }

    
    
}
