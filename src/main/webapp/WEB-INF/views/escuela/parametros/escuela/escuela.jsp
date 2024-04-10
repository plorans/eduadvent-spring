<%@ include file="../../con_elias.jsp"%>
<%@ include file="id.jsp"%>
<%@ include file= "../../head.jsp" %>
<%@ include file= "../../menu.jsp" %>
<%@ include file="../../seguro.jsp"%>

<%@ page import="java.util.*" %>

<jsp:useBean id="usuario" scope="page" class="aca.usuario.Usuario"/>

<head>
<%		
	String escuelaId			= "00"; 
	String resultado			= "";
	
	
	/* Lista completa de escuela */
	List<edu.um.eduadventspring.Model.Escuela> lisEscuela = (List<edu.um.eduadventspring.Model.Escuela>) request.getAttribute("escuelas");	

	
    pageContext.setAttribute("resultado", request.getParameter("resultado"));	

	
%>
</head>
<body>

<div id="content">

	<h2><fmt:message key="escuelas.Escuelas" /> </h2>

	<div class="well">
		<input type="text" class="input-medium search-query" placeholder="<fmt:message key="boton.Buscar" />" id="buscar">
	</div>

        <table id="table" class="table table-condensed table-bordered" >
			<thead>
				<tr> 
				    <th width="5%"><fmt:message key="aca.Id" /></th>
				    <th width="30%"><fmt:message key="aca.Escuela" /></th>
				    <th width="20%"><fmt:message key="catalogo.Asociacion" /></th>
				    <th width="20%"><fmt:message key="aca.Ciudad" />, <fmt:message key="aca.Estado" />, <fmt:message key="aca.Pais" /></th>
				    <th width="30%"><fmt:message key="aca.Direccion" /></th>
				    <th width="10%"><fmt:message key="aca.Telefono" /></th>
				</tr>
			</thead>
			<%
			for (int i=0; i< lisEscuela.size(); i++){
				edu.um.eduadventspring.Model.Escuela escuela = (edu.um.eduadventspring.Model.Escuela) lisEscuela.get(i);							
				
			%>
				<tr>
					<td align="center"><%=escuela.getEscuelaId()%></td>
				    <td>
						<a href="javascript:void(0);" onclick="SubirEscuela('<%=escuela.getEscuelaId()%>')"><%=escuela.getNombre()%></a>

				    </td>
				    <td><%=escuela.getAsociacionId().getNombre()%></td>
				    <td>
				    	<%= escuela.getCiudadId().getNombre() %>, <%= escuela.getEstadoId().getNombre() %>, <%= escuela.getPaisId().getNombre() %>
				    </td>
				    <td><%=escuela.getDireccion()%></td>
				    <td><%=escuela.getTelefono()%></td>
				</tr>
			<%
			}	
			lisEscuela			= null;
			%>
		  </table>
</div>	

<script>
    function SubirEscuela(EscuelaId) {
        $.post('/parametros/escuela/subir', {
            Accion: '2',
            EscuelaId: EscuelaId
        }, function(data) {
			window.location.href = '/inicio';
        });
    }
</script>


	
	<script src="../../js/search.js"></script>
	<script>
		$('#buscar').focus().search({table:$("#table")});
	</script>
</body>


<%@ include file= "../../cierra_elias.jsp" %> 