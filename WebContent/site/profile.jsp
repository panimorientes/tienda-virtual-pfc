<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="presentacion.WebUtils"%>
<%@page import="domino.*"%>
<html xmlns="http://www.w3.org/1999/xhtml">
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


<script type="text/javascript">
	function llenarProfile(correo, pass, nombre, apellido, direccion) {

		document.getElementsByName("correo")[0].value = correo;
		document.getElementsByName("pass")[0].value = pass;
		document.getElementsByName("apellido")[0].value = apellido;
		document.getElementsByName("nombre")[0].value = nombre;
		document.getElementsByName("direccion")[0].value = direccion;

	}
</script>

</head>
<body>
	<%
		if (us instanceof Cliente) {
	%>
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
					out.println(WebUtils.genHTMLMainBar((Carro) request
								.getSession().getAttribute("carro")));
				%>
			</div>
			<!-- End Search, etc -->

			<!-- Content -->
			<div id="content">

				<!-- Tabs -->
				<div class="tabs">
					<!-- 
					<ul>
						<li><a href="#" class="active"><span>Safety Shoes</span></a></li>
						<li><a href="#"><span>Sport Shoes</span></a></li>
						<li><a href="#" class="red"><span>More Shoes</span></a></li>
					</ul>
					 -->
				</div>


				<!-- Container -->
				<div align="center" id="container">

					<div class="tab-content" style="display: block;">



						<div id="stylized" class="myformwidth">
							<!-- <form id="form" name="form" method="post" action="index.html"> -->

							<h1>Perfil de usuario</h1>

							<p>A continuacion se muestra la informacion de su perfil. 
							Si lo desea, puede realizar cualquier cambio.</p>
								
								<%
								Cliente u = (Cliente) request.getSession().getAttribute("user");
								String nombre = u.getNombre();
								String apellido = u.getApellido();
								String correo = u.getCorreo();
								String pass = u.getPass();
								String direccion = ((Cliente) u).getDireccion();
									%>

							
								
							<center>
								<table style="width: 700px; text-align: left;">
									<tr>
										<td style="vertical-align: top;"><img
											src="img/profile.jpg" style="width: 200px;"></img></td>


										<td><s:form action="ModificarUsuario">
												<div class="spacer"></div>
												<s:textfield label="Correo" name="correo" disabled="true" />
												<s:password label="Password" name="pass" />

												<div class="spacer"></div>
												<s:textfield label="Nombre" name="nombre" />

												<div class="spacer"></div>
												<s:textfield label="Apellido" name="apellido" />

												<div class="spacer"></div>
												<s:textfield label="Direccion" name="direccion" />

												<s:submit type="button">Guardar cambios</s:submit>
												<div class="spacer"></div>

											</s:form></td>
									</tr>
								</table>
							</center>
							<script type="text/javascript" >
								llenarProfile("<%=correo%>", "<%=pass%>"," <%=nombre%>", "<%=apellido%>"," <%=direccion%>");
							</script>
							<!-- 	</form> -->

						</div>
						<div id="stylized" class="myformwidthsep">
							<center>
								<table style="width: 700px; text-align: left;">
									<tr>
										<td style="vertical-align: top; width: 328px">Si desea
											darse de baja de la tienda y eliminar los datos de su cuenta.</td>
										<td><s:form action="DarBaja">

												<s:submit type="button" name="DarBaja" value="Darse de Baja" />

											</s:form></td>
									</tr>
								</table>

							</center>
						</div>
					</div>


					<!-- 
					<div id="stylized" class="myform">
						<form id="form" name="form" method="post" action="index.html">
							<h1>Inicie sesion</h1>
							<p>Introduzca sus datos de usuario para iniciar sesion.</p>

							<label>Usuario <span class="small">Nombre de
									usuario</span>
							</label> <input type="text" name="name" id="name" /> <label>Password:
								<span class="small">Introduzca su clave</span>
							</label> <input type="password" name="password" id="password" />

							<button type="submit">Entrar</button>
							<div class="spacer"></div>

						</form>

					</div>
					<br>
					<div id="stylized" class="myform">
						<form id="form" name="form" method="post" action="index.html">
							<h1>o registrese</h1>
							<p>Rellene los siguientes campos para crear una cuenta</p>

							<label>Name <span class="small">Add your name</span>
							</label> <input type="text" name="name" id="name" /> <label>Email
								<span class="small">Add a valid address</span>
							</label> <input type="text" name="email" id="email" /> <label>Password
								<span class="small">Min. size 6 chars</span>
							</label> <input type="password" name="password" id="password" />

							<button type="submit">Crear cuenta</button>
							<div class="spacer"></div>

						</form>

						

-->
				</div>



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
			<!-- End Container -->

		</div>
		<!-- End Content -->

	</div>
	<!-- End Main -->
	<%
		}
	%>
</body>
</html>
