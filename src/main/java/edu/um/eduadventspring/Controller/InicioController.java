package edu.um.eduadventspring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class InicioController {

	@GetMapping("/inicio")
	public ModelAndView inicio(){
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("escuela/general/inicio/index");
		return modelAndView;
	}
}