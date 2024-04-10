<%@ include file="../../con_elias.jsp"%>
<%@ include file="id.jsp"%>
<%@ include file="../../seguro.jsp"%>
<%@ include file="../../head.jsp"%>
<%@ include file="../../menu.jsp"%>

<head>
<script>
	function Borrar(ClasfinId) {
    if (confirm("<fmt:message key='js.Confirma' />")) {
        $.post("accion", { accion: '4', clasfinId: ClasfinId })
            .done(function() {
                location.reload();
            });
    }
}


</script>
</head>
<%
	String escuelaId = (String) session.getAttribute("escuela");
	ArrayList<edu.um.eduadventspring.Model.Clasificacion> lisClasfin = (ArrayList<edu.um.eduadventspring.Model.Clasificacion>) request.getAttribute("lisClasfin");
		
%>
<body>
	<div id="content">

		<h2><fmt:message key="catalogo.ListadoDeClas" /></h2>

		<div class="well" style="overflow: hidden;">
			<a class="btn btn-primary" href="accion?accion=1"><i class="icon-plus icon-white"></i> <fmt:message key="boton.Anadir" /></a>
		</div>

		<table width="40%" class="table table-nohover" align="center">
			<tr>
				<th width="5%"><fmt:message key="aca.Operacion" /></th>
				<th width="5%">#</th>
				<th width="25%"><fmt:message key="aca.Nombre" /></th>
				<th width="10%"><fmt:message key="aca.Estado" /></th>
				
			</tr>
			<%
				for (int i = 0; i < lisClasfin.size(); i++) {
						edu.um.eduadventspring.Model.Clasificacion clasif = (edu.um.eduadventspring.Model.Clasificacion) lisClasfin.get(i);						
			%>			
			<tr>
				<td align="center"><a
					href="accion?accion=5&clasfinId=<%=clasif.getClasfinId()%>&nombre=<%=clasif.getNombre()%>"										
					class="icon-pencil"></a> <a
					href="javascript:Borrar('<%=clasif.getClasfinId()%>')"
					class="icon-remove"></a></td>
					
				<td align="center"><%=clasif.getClasfinId()%></td>
				<td><%=clasif.getNombre()%></td>
				<td><%=clasif.getEstado()%></td>
				
			</tr>
			<%
				}
			%>
		</table>

	</div>
</body>
<%@ include file="../../cierra_elias.jsp"%>
