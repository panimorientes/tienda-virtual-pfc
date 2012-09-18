<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="presentacion.WebUtils"%>
<%@page import="presentacion.ProductCell"%>
<%@page import="domino.*"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="java.net.*,java.io.*"%>
<head>
<%
	out.println(WebUtils.genHTMLMetaHeader());

	Usuario us = (Usuario) request.getSession().getAttribute("user");
	if (!(us instanceof Cliente)) {
		out.print("<meta HTTP-EQUIV=\"REFRESH\" content=\"0; url=login.jsp\">\"");
	}
%>
<title>ISO-2 2011-2012</title>
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />

<!--[if lte IE 6]>
		<style type="text/css" media="screen">
			.tabbed { height:420px; }
		</style>
	<![endif]-->

<script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
<script src="js/jquery.jcarousel.pack.js" type="text/javascript"></script>
<script src="js/jquery.slide.js" type="text/javascript"></script>
<script src="js/jquery-func.js" type="text/javascript"></script>
</head>

<body>
<% if(us instanceof Cliente){ %>
	<!-- Top -->
	<div id="top">

		<div class="shell">

			<!-- Header -->
			<div id="header">
				<h1 id="logo">
					<a href="#">Urgan Gear</a>
				</h1>
				<div id="navigation">
					<%
						out.println(WebUtils.genMenu());
					%>
				</div>
				<!-- 
				<div id="navigation">
					<ul>
						<li><a href="index.jsp">Inicio</a></li>
						<li class="last"><a href="login.jsp">Iniciar sesion / registrarse</a></li>
						<li><a href="#">Mi perfil</a></li> 
						<li class="last"><a href="#">Contact</a></li>
					</ul>
				</div>
				-->
			</div>
			<!-- End Header -->

			<!-- Slider -->
			<div id="slider">
				<div id="slider-holder">
					<ul>
						<li><a href="index.jsp"><img src="css/images/header.jpg" alt="" /></a></li>
						<!-- 
				    <li><a href="#"><img src="css/images/slide2.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/slide1.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/slide2.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/slide1.jpg" alt="" /></a></li>
				    <li><a href="#"><img src="css/images/slide2.jpg" alt="" /></a></li>
				     -->
					</ul>
				</div>
				<div id="slider-nav">
					<a href="#" class="prev">Previous</a> <a href="#" class="next">Next</a>
				</div>
			</div>
			<!-- End Slider -->

		</div>
	</div>
	<!-- Top -->
	<!-- Main -->
	<div id="main">
		<div class="shell">

			<!-- Search, etc -->
			<div class="options">
				<%
					out.println(WebUtils.genHTMLMainBar(((Carro) (request.getSession()
							.getAttribute("carro")))));
				%>
			</div>
			<!-- End Search, etc -->
		</div>
	</div>

	<div id="container">
		<center>
			<div class="tab-content" style="display: block;">
				<table>
					<tr>
						<td valign="top">
							<div id="stylized" class="myform">
								<!-- <form id="form" name="form" method="post" action="index.jsp"> -->

								<h1>Pago con Tarjeta</h1>
								<s:form action="PagarConTarjeta">
									<s:param name="importe">
										<%
											Carro c = (Carro) request.getSession()
															.getAttribute("carro");
													if (c != null)
														out.print("" + c.calcularPrecio());
													else
														out.print("0.0");
										%>
									</s:param>
									<s:param name="alumno">
										<%
											Cliente cl = (Cliente) request.getSession().getAttribute(
															"cliente");
													if (cl != null)
														out.print("" + cl.getNombre());
													else
														out.print("Visitante");
										%>
										</s:param>
										<s:textfield name="numeroDeTarjeta" label="Número de tarjeta"
											maxlength="16" />
										<s:textfield name="mesCaducidad" label="Mes de caducidad"
											maxlength="2" />
										<s:textfield name="anioCaducidad" label="Año de caducidad"
											maxlength="4" />
										<s:textfield name="titular" label="Titular" />
										<s:submit type="button" name="Aceptar" label="Aceptar" />
										
									</s:form>
								<div class="spacer"></div>
								<!-- </form>  -->
							</div>
						</td>
						<td valign="top">
							<div id="stylized" class="myform">
								<!--  </!><form id="form" name="form" method="post" action="index.jsp">-->
								<h1>Pago con PayPal</h1>
								<s:form action="PagarConPayPal">
									<s:param name="importe">
										<%
											Carro c = (Carro) request.getSession()
															.getAttribute("carro");
													if (c != null)
														out.print("" + c.calcularPrecio());
													else
														out.print("0.0");
										%>
									</s:param>
									<s:param name="alumno">
										<%
											Cliente cl = (Cliente) request.getSession().getAttribute(
															"cliente");
													if (cl != null)
														out.print("" + cl.getNombre());
													else
														out.print("Visitante");
										%>
										</s:param>
										<s:textfield name="correoUsuario"
											label="Dirección de correo electrónico" />
										<s:password name="pwd" label="Contraseña" />
										<s:submit type="button" name="Aceptar" label="Aceptar" />
									</s:form>
								<div class="spacer"></div>
								<!-- </form> -->
							</div>
						</td>
					</tr>
				</table>
			</div>
		</center>

		<!-- Footer -->
		<div id="footer">
			<div class="left">
				<%
					out.print(WebUtils.genHTMLLeftFooter());
				%>
			</div>
			<div class="right">
				<%
					out.print(WebUtils.genHTMLRightFooter());
				%>
			</div>
		</div>
		<!-- End Footer -->
	</div>

	<!-- End Main -->


<%} %>
</body>
</html>