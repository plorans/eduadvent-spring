<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../../con_elias.jsp"%>
<%@ include file="id.jsp"%>
<%@ include file="../../seguro.jsp"%>
<%@ include file="../../head.jsp"%>
<%@ include file="../../menu.jsp"%>

<head>
<script>
	function Nuevo() {
		window.location.href = "/clasfin/accion?accion=1";
	}

	function Grabar() {
		if (document.frmClas.clasfinId.value != ""
				&& document.frmClas.nombre.value != "") {
			document.frmClas.accion.value = "2";
			document.frmClas.submit();
		} else {
			alert("Complete el formulario! ");
		}
	}

	function Modificar() {
		document.frmClas.Accion.value = "3";
		document.frmClas.submit();
	}


	function Borrar(ClasfinId) {
		console.log(ClasfinId);
		if (confirm("<fmt:message key='js.Confirma' />")) {
			$.post("accion", { accion: '4', clasfinId: ClasfinId })
				.done(function() {
					window.location.href = "/clasfin/clasificacion"
				});
		}
	}
	

	function Consultar() {
		document.frmClas.Accion.value = "5";
		document.frmClas.submit();
	}
</script>
</head>
<%
	// Declaracion de variables		
	String escuelaId 		= (String) session.getAttribute("escuela");
	String stAccion = (String) request.getAttribute("Accion");
	String sResultado = (String) request.getAttribute("resultado");
	String salto = (String) request.getAttribute("salto");


	edu.um.eduadventspring.Model.Clasificacion clasificacion = (edu.um.eduadventspring.Model.Clasificacion) request.getAttribute("clasificacion");

	pageContext.setAttribute("resultado", sResultado);
%>
<body>
	<div id="content">
		<h2><fmt:message key="catalogo.AnadirClas" /></h2>
		<% if (!sResultado.equals("") && (sResultado.equals("Guardado") || sResultado.equals("Modificado") || sResultado.equals("Eliminado"))){%>
	   		<div class='alert alert-success'><fmt:message key="aca.Consulta" /></div>
	  	<% }else if(!sResultado.equals("")){ %>
	  		<div class='alert alert-error'><fmt:message key="aca.Consulta" /></div>
	  	<% }%>

		<div class="well" style="overflow: hidden;">
			<a class="btn btn-primary" href="clasificacion"><i class="icon-list icon-white"></i> <fmt:message key="boton.Listado" /></a>
		</div>
		<form:form action="/clasfin/accion" method="POST" modelAttribute="clasificacion" name="frmClas" target="_self">
			<form:input path="accion" type="hidden" name="accion" id="accion"/> 
			
		<div class="row">
			<div class="span4">

			<fieldset>
					<form:label path="clasfinId" for="clasfinId"> <fmt:message key="aca.Id" />: </form:label> 
					<form:input path="clasfinId" name="clasfinId" type="text" id="clasfinId" size="3" maxlength="3" value="<%=clasificacion.getClasfinId()%>"/>
			</fieldset>
			<fieldset>
					<form:label path="nombre" for="nombre"> <fmt:message key="aca.Clasificacion" />: </form:label>
					<form:input path="nombre" name="nombre" type="text" id="nombre" value="<%=clasificacion.getNombre()%>" size="40" maxlength="40"/>
			</fieldset>
			<fieldset>
					<form:label path="Estado" for="Estado"> <fmt:message key="aca.Estado" />: </form:label>
					<select name="Estado" id="Estado" tabindex="4">
		            <%	if(clasificacion.getEstado() != null && clasificacion.getEstado().equals("A")){%>
			        	<option value='A' selected><fmt:message key="aca.Activo"/></option>
			            <option value='I' ><fmt:message key="aca.Inactivo"/></option>
			        <%	}else{%>
			            <option value='A'><fmt:message key="aca.Activo"/></option>
			            <option value='I' selected><fmt:message key="aca.Inactivo"/></option>
			        <%	}%>
			        </select>							
			</fieldset>

			
			</div>
			</div>
		</form:form>

		<div class="well" style="overflow: hidden;">
			<button class="btn btn-primary" onclick="Nuevo()"><i class="icon-file icon-white"></i> <fmt:message key="boton.Nuevo" /></button>
			&nbsp; &nbsp;<button class="btn btn-primary" onclick="Grabar()"><i class="icon-ok icon-white"></i> <fmt:message key="boton.Guardar" /></button>
			&nbsp; &nbsp; <button class="btn btn-primary" onclick="Borrar(document.getElementById('clasfinId').value)"><i class="icon-remove icon-white"></i> <fmt:message key="boton.Eliminar" /></button>
		</div>
	</div>
</body>

<% 	if (!salto.equals("X")){%>
		<meta http-equiv="refresh" content="0; url=<%=salto%>" />
<% 	}%>
<%@ include file="../../cierra_elias.jsp"%>