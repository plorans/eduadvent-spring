package edu.um.eduadventspring.Controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.um.eduadventspring.Manager.AsociacionManager;
import edu.um.eduadventspring.Manager.UnionManager;
import edu.um.eduadventspring.Model.Asociacion;
import edu.um.eduadventspring.Model.Union;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/catalogo")
@Slf4j
public class AsociacionController {

    @Autowired
    private UnionManager unionManager;

    @Autowired
    private AsociacionManager asociacionManager;

    @GetMapping("/asociacion")
    public ModelAndView getMethodName(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mnv = new ModelAndView();
        HttpSession session = request.getSession();
        List<Union> uniones = unionManager.getUnionList();
        String unionId = "";
        try {
            unionId = (String) request.getParameter("unionId");
        } catch (Exception e) {

        }
        List<Asociacion> asociaciones;

        if (unionId != null && !unionId.equals("")) {
            asociaciones = asociacionManager.getAsociacionesByUnion(Long.valueOf(unionId));
            mnv.addObject("unionId", "");
        }else{
            asociaciones = asociacionManager.getAsociacionesByUnion(uniones.get(0).getId());
            mnv.addObject("unionId", String.valueOf(uniones.get(0).getId()));

        }

        Collections.sort(asociaciones, new Comparator<Asociacion>() {
            @Override
            public int compare(Asociacion as1, Asociacion as2) {
                return as1.getId().compareTo(as2.getId());
            }
        });

        mnv.addObject("uniones", uniones);
        mnv.addObject("asociaciones", asociaciones);

        mnv.setViewName("escuela/catalogo/asociacion/asociacion");
        return mnv;
    }

}
