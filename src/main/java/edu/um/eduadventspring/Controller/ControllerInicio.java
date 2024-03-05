package edu.um.eduadventspring.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.um.eduadventspring.Manager.AlumPersonalManager;
import edu.um.eduadventspring.Manager.CicloGrupoCursoManager;
import edu.um.eduadventspring.Manager.CicloManager;
import edu.um.eduadventspring.Manager.EmpPersonalManager;
import edu.um.eduadventspring.Manager.EscuelaManager;
import edu.um.eduadventspring.Manager.FinEjercicioManager;
import edu.um.eduadventspring.Manager.MenuManager;
import edu.um.eduadventspring.Manager.ModuloManager;
import edu.um.eduadventspring.Manager.ModuloOpcionManager;
import edu.um.eduadventspring.Manager.UserManager;
import edu.um.eduadventspring.Model.Ciclo;
import edu.um.eduadventspring.Model.EmpPersonal;
import edu.um.eduadventspring.Model.Menu;
import edu.um.eduadventspring.Model.Modulo;
import edu.um.eduadventspring.Model.ModuloOpcion;
import edu.um.eduadventspring.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControllerInicio {

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
	@Autowired
	private MenuManager menuManager;
	@Autowired
	private ModuloManager moduloManager;
	@Autowired
	private ModuloOpcionManager moduloOpcionManager;
	@Autowired
	private CicloGrupoCursoManager cicloGrupoCursoManager;
	@Autowired
	private CicloManager cicloManager;

	private String codigoId = "X";

	@GetMapping("/inicio")
	public ModelAndView inicio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ModelAndView modelAndView = new ModelAndView();

		doGet(request, response);

		modelAndView.setViewName("escuela/general/inicio/index");
		return modelAndView;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.info("Entro");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		// String paString = auth.getCredentials().toString();

		log.info("usuario: " + username);

		String escuela = "";
		String escuelaId = "";
		String estadoEscuela = "I";

		String nombreUsuario = "x";
		String admin = "";
		String opciones = "";
		String strOpcion = "";
		int intTipoUsuario = 0;
		Boolean activo;
		boolean esAdmin = false;
		boolean entrar = false;
		String idioma = "";
		List<Menu> menuPrincipal;
		List<Modulo> menu;
		List<ModuloOpcion> opcion;

		codigoId = userManager.getCodigoId(username, "");
		log.info("codigoId inicio: " + codigoId);
		if (!codigoId.equals("x")) {
			escuelaId = codigoId.substring(0, 3);
			log.info("escuelaId: " + escuelaId);
			estadoEscuela = escuelaManager.getEstadoEscuela(escuelaId).toString();
			log.info("estadoEscuela: " + estadoEscuela);
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

			String ejercicioId = finEjercicioManager.getEjercicioActual(escuelaId);
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

			if (userManager.esSuper(codigoId)) {
				menuPrincipal = menuManager.getMenu(codigoId);
				menu = moduloManager.getListUserSuper(codigoId);
				opcion = moduloOpcionManager.getListUserSuper(codigoId);
			} else {
				menuPrincipal = menuManager.getMenu(codigoId);
				menu = moduloManager.getListUser(codigoId);
				opcion = moduloOpcionManager.getListUser(codigoId);
			}

			for (int i = 0; i < opcion.size(); i++) {
				ModuloOpcion opc = opcion.get(i);
				strOpcion = strOpcion + "-" + opc.getOpcionId();
			}
			strOpcion = opciones + "-";

			if (intTipoUsuario == 2) {
				strOpcion += "-6-380";
			}

			session.setAttribute("lisMenuPrincipal", menuPrincipal);
			session.setAttribute("lisMenu", menu);
			session.setAttribute("lisOpcion", opcion);
			session.setAttribute("opciones", strOpcion);

			session.setAttribute("codigoAlumno", codigoId);
			session.setAttribute("codigoEmpleado", codigoId);
			session.setAttribute("codigoPadre", "00000000");

			log.info("codigoId: " + codigoId);

			String ciclo = cicloManager.getMejorCarga(codigoId);
			log.info("ciclo: " + ciclo);

			if (!ciclo.substring(0, 3).equals(escuela)) {
				ciclo = cicloManager.getCargaActual(escuelaId);
			}
			session.setAttribute("cicloId", ciclo);

			User usuario = userManager.getUser(codigoId);
			if (usuario.getDivision().equals('S')) {
				session.setAttribute("portalDivision", true);
			} else {
				session.setAttribute("portalDivision", false);
			}
			if (usuario.getAdministrador().equals("S") && usuario.getAsociacion().split("-").length != 0) {
				session.setAttribute("portalAdmin", true);
			} else {
				session.setAttribute("portalAdmin", false);
			}
			if (cicloGrupoCursoManager.existeMAestro(codigoId)) {
				session.setAttribute("portalMaestro", true);
			} else {
				session.setAttribute("portalMaestro", false);
			}
			if (alumPersonalManager.alumPersonalExist(codigoId)) {
				session.setAttribute("portalAlumno", true);
			} else {
				session.setAttribute("portalAlumno", false);
			}

			if (usuario.getAdministrador().equals("S") || usuario.getCotejador().equals('S')
					|| usuario.getContable().equals('S')) {
				session.setAttribute("buscador", true);
			} else {
				session.setAttribute("buscador", false);
			}

			if (empPersonalManager.existByCodigoId(codigoId) && codigoId.substring(3, 4).equals("P")) {
				session.setAttribute("portalPadre", true);
			} else {
				session.setAttribute("portalPadre", false);
			}

			entrar = true;
		}

	}

	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {

	// HttpSession session = request.getSession();
	// String sCodigoPersonal = session.getAttribute("codigoId").toString();
	// String cicloIdM = session.getAttribute("cicloId").toString();

	// List<Ciclo> lisCiclo = cicloManager.getListCiclosAlumno(sCodigoPersonal,
	// "CICLO_ID");

	// boolean encontro = false;
	// for (Ciclo c : lisCiclo) {
	// if (cicloIdM != null && c.getCicloId().equals(cicloIdM)) {
	// encontro = true;
	// break;
	// }
	// }

	// // Elige el mejor ciclo para el alumno.
	// if (encontro == false && lisCiclo.size() > 0) {
	// Ciclo ciclo = lisCiclo.get(lisCiclo.size() - 1);
	// cicloIdM = ciclo.getCicloId();

	// }

	// session.setAttribute("cicloId", cicloIdM);
	// }

}