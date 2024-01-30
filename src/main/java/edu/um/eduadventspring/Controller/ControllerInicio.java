package edu.um.eduadventspring.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerInicio {

	@GetMapping("/inicio")
	public ModelAndView inicio() {
		System.out.println("Inicio");
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		modelAndView.addObject("username", username);
        modelAndView.setViewName("Inicio");


		return modelAndView;
	}

}