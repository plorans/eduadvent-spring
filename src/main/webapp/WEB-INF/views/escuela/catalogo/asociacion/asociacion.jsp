<%@ include file= "../../con_elias.jsp" %>
<%@ include file= "id.jsp" %>
<%@ include file= "../../seguro.jsp" %>
<%@ include file= "../../head.jsp" %>
<%@ include file= "../../menu.jsp" %>


<jsp:useBean id="asocL" scope="page" class="aca.catalogo.CatAsociacionLista"/>
<jsp:useBean id="CatUnionU" scope="page" class="aca.catalogo.CatUnionLista"/>
<jsp:useBean id="Union" scope="page" class="edu.um.eduadventspring.Model.Union"/>

<head>
	<script>
		function Borrar( AsocId ){
			if (confirm("<fmt:message key="js.Confirma" />") == true) {
		  		document.location="accion?Accion=3&AsocId="+AsocId;
		  	}
		}
	</script>

	<script>
		var unionId = '<%= request.getParameter("unionId") %>';
		
		function seleccionarOpcion() {
			var select = document.getElementById("unionId");
			
			for (var i = 0; i < select.options.length; i++) {
				if (select.options[i].value === unionId) {
					select.options[i].selected = true;
					break;
				}
			}
		}
		
		window.onload = seleccionarOpcion;
	</script>

</head>
<%
	
	String sColonia					="";
	String sEmail					="";
	ArrayList<edu.um.eduadventspring.Model.Union> uniones =  (ArrayList<edu.um.eduadventspring.Model.Union>) request.getAttribute("uniones");
	ArrayList<edu.um.eduadventspring.Model.Asociacion> asociaciones	= (ArrayList<edu.um.eduadventspring.Model.Asociacion>) request.getAttribute("asociaciones");
	String unionIdUrl	= (String) request.getParameter("unionId");
	String unionId	= (String) request.getAttribute("unionId");


	if(unionIdUrl != null && unionId != null && !unionId.equals(unionIdUrl)){
		unionId = unionIdUrl;
	}

	System.out.println("unionId: " + unionId);
	System.out.println("unionIdUrl: " + unionIdUrl);

	


%>
<body>

<div id="content">
    <form action="" name="forma">
    
    	<h2><fmt:message key="catalogo.ListadoDeAsoc" /></h2> 
   
	    <div class="well">
	    	<a class="btn btn-primary " href="accion?Accion=1&anadir=1&unionId=<%=unionId%>"><i class="icon-plus icon-white"></i>&nbsp;<fmt:message key="boton.Anadir" /></a>
	    	<select name="unionId" id="unionId" onchange="document.forma.submit()" style="float:right;">
	    	<%for(edu.um.eduadventspring.Model.Union union : uniones){%>
	    		<option value="<%=union.getId() %>"  <%if(union.getId().equals(unionId))out.print("selected"); %>><%=union.getNombre() %></option>	
	    	<%}%>
	    	</select>
	    </div>
   
   		<table class="table tabe-condensed">
  			<tr> 
    			<th width="2%">#</th>
			    <th width="5%"><fmt:message key="aca.Operacion" /></th>
			    <th width="2%"><fmt:message key="aca.Id" /></th>
			    <th width="30%"><fmt:message key="aca.Nombre" /></th>
			    <th width="30%"><fmt:message key="aca.NombreCorto" /></th>
			    <th width="30%"><fmt:message key="aca.Fondo" /></th>
			</tr>
  			<%
				for (int i=0; i< asociaciones.size(); i++){
					edu.um.eduadventspring.Model.Asociacion asoc = (edu.um.eduadventspring.Model.Asociacion) asociaciones.get(i);
					String nombre = asoc.getNombre();
					String nombreCorto = asoc.getNCorto();
			%>
  					<tr> 
    					<td><%=i+1%></td>
					    <td> 
					      <a class="icon-pencil" href="accion?Accion=4&AsocId=<%=asoc.getId()%>&unionId=<%=unionId%>"> </a> 
					      <a href="javascript:Borrar('<%=asoc.getId()%>')" class="icon-remove"></a> 
					    </td>
					    <td><%=asoc.getId() %></td>
					    <td><%=nombre%></td>
					    <td><%=nombreCorto%></td>
					    <td><%=asoc.getFondoId() %></td>
    				</tr>
  			<%
				}	
			%>
   		</table>

	</form>
</div>
<%@ include file= "../../cierra_elias.jsp" %> 
