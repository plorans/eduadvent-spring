<!doctype html>
<%@page errorPage="/src/main/webapp/WEB-INF/views/escuela/paginaerror.jsp" %>
<%@ include file= "idioma.jsp" %>
<%@ page buffer= "none" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css" />
<link rel="stylesheet" type="text/css" href="/css/print.css" media="print" />
<%
HttpServletResponse httpResponse = (HttpServletResponse) response;
httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
httpResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0
httpResponse.setDateHeader("Expires", 0); // Proxies.
%>

<meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- needed for mobile devices -->
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
     <meta http-equiv="Pragma" content="no-cache"/>
     <meta http-equiv="Expires" content="-1"/>
<script type="text/javascript" src="/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/bootstrap/js/bootstrap.js"></script>
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-90481892-1', 'auto');
  ga('send', 'pageview');

</script>
<link rel="shortcut icon" href="/imagenes/icoEs.png">
<title>Sistema Escolar</title>


<%
	
	// Sube a sesión el idJsp
	if ( !idJsp.equals("0") ){
		session.setAttribute("idJsp", idJsp);		
	}
	
%>



<script type="text/javascript" src="/js/onlyNumbers.js"></script>
<script>
	(function($){
		$('document').ready(function(){
			$('*[title]').tooltip({
				container: 'body'
			});
		});
	})(jQuery);
</script>