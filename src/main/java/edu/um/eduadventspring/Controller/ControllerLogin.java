package edu.um.eduadventspring.Controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.um.eduadventspring.Manager.AlumPersonalManager;
import edu.um.eduadventspring.Manager.EscuelaManager;
import edu.um.eduadventspring.Manager.FinEjercicioManager;
import edu.um.eduadventspring.Manager.EmpPersonalManager;
import edu.um.eduadventspring.Manager.UserManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class ControllerLogin {

    @Autowired
    private UserManager userManager;

    @Autowired
    private EscuelaManager escuelaManager;

    @Autowired
    private EmpPersonalManager empPersonalManager;

    @Autowired
    private FinEjercicioManager finEjercicioManager;

    @Autowired
    private AlumPersonalManager alumPersonalManager;

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Login");
        doGet(request, response);
        return "Login";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Object credentials = auth.getCredentials();

        String escuela = "";
        String escuelaId = "";
        String estadoEscuela = "I";
        String codigoId = "X";
        String nombreUsuario = "x";
        String admin = "";
        String opciones = "";
        int intTipoUsuario = 0;
        Boolean activo;
        boolean esAdmin = false;
        String idioma = "";

        codigoId = userManager.getCodigoId(username, credentials.toString());

        if (!codigoId.equals("x")) {
            escuelaId = codigoId.substring(0, 3);
            estadoEscuela = escuelaManager.getEstadoEscuela(codigoId).toString();
            idioma = userManager.getIdioma(codigoId);
        }

        activo = empPersonalManager.getEstadoEmp(codigoId);
        if (!codigoId.equals("x") && estadoEscuela.equals("A") && activo) {
            if (userManager.esAdministrador(codigoId)) {
                admin = codigoId;
                esAdmin = true;
            } else {
                admin = "-------";
            }

            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);
            session.setAttribute("user", codigoId);
            session.setAttribute("certificado", "true");
            session.setAttribute("codigoId", codigoId);
            session.setAttribute("codigoReciente", codigoId);
            session.setAttribute("lenguaje", idioma);

            String ejercicioId = finEjercicioManager.getEjercicioActual(escuelaId, null, null);
            session.setAttribute("ejercicioId", ejercicioId);

            int tipoUsuario = userManager.getTipo(codigoId);
            if (tipoUsuario == 1) {
                nombreUsuario = alumPersonalManager.getNombre(codigoId, "NOMBRE");
                opciones = "-PAL-PPA-PMO";
            } else if (tipoUsuario == 2 || tipoUsuario == 3) {
                nombreUsuario = empPersonalManager.getNombre(codigoId, "NOMBRE");
                if (intTipoUsuario == 2) {
                    opciones = "-PEM-203";
                }
                if (intTipoUsuario == 3) {
                    opciones = "-PPA-PMO";
                }
            }
            if (esAdmin) {
                opciones = "-PAL-PEM-PPA-203-PMO";
            }

            session.setAttribute("nombreUsuario", nombreUsuario);

            escuela = codigoId.substring(0, 3);
            session.setAttribute("escuela", escuela);

            session.setAttribute("escuelaNombre", escuela);

            if(userManager.esSuper(codigoId)){
                
            }
        }

    }

}
