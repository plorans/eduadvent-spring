<%@ include file= "../../con_elias.jsp" %>
<%@ include file= "id.jsp" %>
<%@ include file= "../../seguro.jsp" %>
<%@ include file= "../../head.jsp" %>
<%@ include file= "../../menu.jsp" %>

<jsp:useBean id="Nivel" scope="page" class="edu.um.eduadventspring.Model.NivelEscuela"/>

<head>
<script>
	function borrar(nivelId){
		if(confirm("Esta seguro que desea eliminar este registro?")){
			location.href="nivel.jsp?Accion=1&nivelId="+nivelId;
		}
	}
</script>
<%
	edu.um.eduadventspring.Model.Escuela escuela = (edu.um.eduadventspring.Model.Escuela) request.getAttribute("escuelaN");
	
	

	ArrayList<edu.um.eduadventspring.Model.NivelEscuela> niveles = (ArrayList<edu.um.eduadventspring.Model.NivelEscuela>) request.getAttribute("niveles");
%>
</head>
<body>
<div id="content">
	<h2><fmt:message key="catalogo.Niveles" /><small>( <%=escuela.getNombre() %> )</small> </h2>

	<div class="well" style="overflow:hidden;">
 		<a class="btn btn-primary" href="accion.jsp?escuela=<%=escuela%>"><i class="icon-plus icon-white"></i>&nbsp;<fmt:message key="boton.Anadir" /></a>
	</div>

		<table class="table table-condensed table-bordered table-striped table-fontsmall">
			<tr>
				<th width="4%"><fmt:message key="aca.Operacion" /></th>
				<th><fmt:message key="catalogo.Nivel" /></th>
				<th><fmt:message key="aca.Nombre" /></th>
				<th><fmt:message key="aca.TituloPeriodo" /> </th>
				<th><fmt:message key="aca.Inicial" /></th>
				<th><fmt:message key="aca.Final" /></th>
				<th><fmt:message key="aca.NotaMin" /></th>
				<th><fmt:message key="aca.Funcion" /></th>
				<th><fmt:message key="aca.Director" /></th>
				<th><fmt:message key="aca.Registro" /></th>
			</tr>
			<%
	int cont = 0;
	for(edu.um.eduadventspring.Model.NivelEscuela nivel: niveles){
		cont++;
%>
			<tr>
				<td>&nbsp;&nbsp;
					<a href="accion.jsp?Accion=2&nivelId=<%=nivel.getNivelId()%>"><i class="icon-pencil"></i></a>		 	
					<%
					
					if(!nivel.getExisteNivel())
					{%>
					<a href="javascript:borrar('<%=nivel.getNivelId()%>');"><i class="icon-remove"></i></a>
					<%} 
					String nombre = "-";
					if(nivel.getDirector() != null){
						nombre = nivel.getDirector().getNombre() + " " + nivel.getDirector().getApaterno() + " " +nivel.getDirector().getAmaterno();
					}
					%> 
				</td>
				<td><%=nivel.getNivel().getId() %></td>
				<td><%=nivel.getNivelNombre() %></td>
				<td><%=nivel.getTitulo() %></td>
				<td><%=nivel.getGradoIni() %></td>
				<td><%=nivel.getGradoFin() %></td>
				<td><%=nivel.getNotaminima() %></td>
				<td><%=nivel.getFuncionId() %></td>
				<td><%=nombre%></td>
				<td><%=nivel.getRegistro()%></td>
			</tr>
			<%
	}
	if(niveles.size()==0){
%>
			<tr>
				<td style="text-align: center;" colspan="8" class="alert">
					<fmt:message key="aca.NoRegistros" />
				</td>
			</tr>
			<%
	}
%>
		</table>
	</div>
</body>
<%@ include file= "../../cierra_elias.jsp" %> 
