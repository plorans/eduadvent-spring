package edu.um.eduadventspring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerInicio {

	

	@GetMapping("/inicio")
	public ModelAndView inicio() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("escuela/general/inicio/index");


		return modelAndView;
	}


}