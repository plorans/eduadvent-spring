<%@ include file= "../../con_elias.jsp" %>
<%@ include file= "id.jsp" %>
<%@ include file= "../../seguro.jsp" %>
<%@ include file= "../../head.jsp" %>
<%@ include file= "../../menu.jsp" %>

<jsp:useBean id="AsociacionU" scope="page" class="aca.catalogo.CatAsociacionLista"/>
<jsp:useBean id="EscuelaU" scope="page" class="aca.catalogo.CatEscuelaLista"/>

<head>
	<script>
		
		function Grabar(){			
			if(document.forma.AsocNombre.value!=""){			
				document.forma.accion.value="2";				
				document.forma.submit();			
			}else{
				alert("<fmt:message key="js.Completar" />");
			}
		}
	</script>
</head>
<%
	// Declaracion de variables	
	String sResultado		= "";   
	String accion			= request.getParameter("accion")==null?"":request.getParameter("accion");
	String unionId 			= request.getParameter("unionId");
	ArrayList<edu.um.eduadventspring.Model.Union>  lisUnion		= new ArrayList<edu.um.eduadventspring.Model.Union>();
	String salto			= "X";
	//String a�adir 			= request.getParameter("a�adir");
	
	edu.um.eduadventspring.Model.Asociacion asociacion = (edu.um.eduadventspring.Model.Asociacion) request.getAttribute("asociacion");
	pageContext.setAttribute("resultado", sResultado);
	
%>
<body>
<div id="content">
   	<h2><fmt:message key="catalogo.AnadirAsoc" /></h2>
   	<% if (sResultado.equals("Eliminado") || sResultado.equals("Modificado") || sResultado.equals("Guardado")){%>
   		<div class='alert alert-success'></div>
  	<% }else if(!sResultado.equals("")){%>
  		<div class='alert alert-danger'></div>
  	<%} %>
  
   <div class="well" style="overflow:hidden;">
  	<a class="btn btn-primary" href="/catalogo/asociacion?unionId=<%=unionId%>"><i class="icon-list icon-white"></i>&nbsp;<fmt:message key="boton.Listado" /></a>
  </div>

<form action="accion" method="post" name="forma" target="_self">
<input type="hidden" name="accion">
<input name="Pec" type="hidden">
<input type="hidden" name="unionId" value="<%=unionId %>" />
	<fieldset>
		<div class="control-group ">
	    	<label for="asocId">
	        	<fmt:message key="aca.Id" />:
	         
	        </label>
	        <input name="asocId" type="text" id="asocId" size="2" maxlength="2" value="<%=asociacion.getId()%>">     
	    </div>
	        
	    <div class="control-group ">
	    	<label for="AsocNombre">
	        	<fmt:message key="aca.Nombre" />:
	        </label>
	        <input name="AsocNombre" type="text" id="AsocNombre" value="<%=asociacion.getNombre()%>" size="40" maxlength="70">        
	    </div>
	        
	    <div class="control-group ">
	    	<label for="unionId">
	        	<fmt:message key="catalogo.Union" />:
	        </label>
	           <select name="unionId" id="unionId"  tabindex="7">
			     <%	lisUnion = (ArrayList<edu.um.eduadventspring.Model.Union>) request.getAttribute("unionL");
				 	
					for(int i=0; i<lisUnion.size(); i++){
						edu.um.eduadventspring.Model.Union union = (edu.um.eduadventspring.Model.Union) lisUnion.get(i);
				   	   		if(union.getId().equals(asociacion.getUnion().getId())){
								out.print(" <option value='"+union.getId()+"' Selected>"+ union.getNombre()+"</option>");
							}else if (unionId.equals(union.getId())){
								out.print(" <option value='"+union.getId()+"' Selected>"+ union.getNombre()+"</option>");
							}else{
								out.print(" <option value='"+union.getId()+"'>"+ union.getNombre()+"</option>");
					 		}
					}	
					%>
			  	</select>
	    </div>
	    
	    <div class="control-group ">
	    	<label for="fondoId">
	        	<fmt:message key="aca.Fondo" />:
	        </label>
	        <input name="fondoId" type="text" id="fondoId" value="<%=asociacion.getFondoId() %>" size="40" maxlength="10">
	                
	    </div>
	    
	   	<div class="control-group ">
	    	<label for="asocNombreCorto">
	        	<fmt:message key="aca.NombreCorto" />:
	        </label>
	        <input name="asocNombreCorto" type="text" id="asocNombreCorto" value="<%=asociacion.getNCorto() %>" size="40" maxlength="24">
	                
	    </div>
		
	</fieldset>
    <div class="well" style="overflow:hidden;">
    	<button class="btn btn-primary" onclick="Grabar();" ><i class="icon-ok icon-white"></i> <fmt:message key="boton.Guardar" /></button>
    </div>

</form>
</div>
</body>
<% 	if (!salto.equals("X")){%>
		<meta http-equiv="refresh" content="0; url=<%=salto%>" />
<% 	}%>
<%@ include file= "../../cierra_elias.jsp" %>
