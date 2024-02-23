<html>
<head>	
	<script>
		function muestraPagina(){
			var pagina = document.getElementById("pagina");			
			pagina.style.visibility="visible";
			var temp = document.getElementById("temp");			
			temp.innerHTML ="";
			temp.style.visibility="hidden";
		}
		
		function limpiar(){
			document.getElementById("temp").style.visibility = "hidden";
		}
	</script>
	<style>
		.fuente {
			font-size:10px;
		}
		#pagina {
			position:absolute;
			top:0px;
		}
		#temp {
			position:absolute;
			top:0px;
		}
	</style>
<%
	String tmcolorPortal = (String)session.getAttribute("colorPortal");
	if(tmcolorPortal==null)tmcolorPortal="";
	String pagina=request.getParameter("pagina");
	if(pagina==null)pagina="";
%>
	<link href="css/pa<%=tmcolorPortal%>.css" rel="STYLESHEET" type="text/css">
</head>
<body onload="limpiar();">
<div id="temp" >
<table border='0' cellpadding="0" cellspacing="0">
	<tr><td valign='top' height="10" class="fuente">
		&nbsp;&nbsp; Cargando <%=pagina.substring(0,pagina.length()-4)%>...
	</td></tr>
</table>
</div>
<div id="pagina" style="width: 100%;">
	<jsp:include page="<%=pagina%>" flush="true"/>
</div>
</body>