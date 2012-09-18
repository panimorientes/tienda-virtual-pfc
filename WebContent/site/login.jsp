<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@page import="presentacion.WebUtils"%>
<%@page import="domino.*"%>
<head>
<%
	out.println(WebUtils.genHTMLMetaHeader());
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
	function david() {
		//document.getElementsByName("pass")[0].value = "111111";
	}
</script>

</head>
<body>
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
						out.println(presentacion.WebUtils.genMenu());
					%>
					<!--
					<ul>
						<li><a href="index.jsp">Inicio</a></li>
						<li><a href="profile.jsp">Perfil</a></li>
						
						<li class="last"><a href="#">Cerrar sesion</a></li>
					</ul>
					   -->
				</div>
			</div>
			<!-- End Header -->

			<!-- Slider -->
			<div id="slider">
				<div id="slider-holder">
					<ul>
						<li><a href="index.jsp"><img src="css/images/header.jpg"
								alt="" /></a></li>
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

			<!-- Content -->
			<div id="content">

				<!-- Tabs -->
				<div class="tabs">

					<ul>
						<li><a href="#" class="active"><span>Login /
									Registro</span></a></li>

					</ul>

				</div>


				<!-- Container -->
				<div id="container">
					<center>
						<div class="tab-content" style="display: block;">
							<table>
								<tr>
									<td valign="top">


										<div id="stylized" class="myform">
											<s:form action="Login">
												<h1>Inicie sesion</h1>
												<p>Introduzca sus datos de usuario para iniciar sesion.</p>

												<s:textfield type="input" label="email" name="correo" />
												<s:password label="Password" name="pass" />
												<%
													String fail = request.getParameter("fail");
														if (fail != null) {
															if (fail.equals("login")) {
																out.println("<p style=\"color: red;\">Datos incorrectos</p>");
															} else if (fail.equals("reg")) {

															}
														}
												%>
												<s:submit type="button">Entrar</s:submit>

												<div class="spacer"></div>
												<script type="text/javascript">
													david();
												</script>
											</s:form>

										</div>


									</td>
									<td>
										<div id="stylized" class="myform">
											<s:form id="form" name="form" method="post"
												action="CrearCliente">
												<h1>Registrarse</h1>
												<p>Rellene los siguientes campos para crear una cuenta</p>

												<s:textfield type="input" label="Email" name="correo" />
												<!-- 
												 <label>Password
													<span class="small">Min. size 6 chars</span>
												</label> 
												-->

												<s:password label="Password" name="pass" />
												<%
													String fail = request.getParameter("fail");
														if (fail != null) {
															if (fail.equals("registro1")) {
																out.println("<p style=\"color: red;\">Algún campo no ha sido rellenado correctamente.</p>");
															} else if (fail.equals("registro2")) {
																out.println("<p style=\"color: red;\">Email en uso.</p>");
															}
														}
												%>
												<s:submit type="button">Crear cuenta</s:submit>
												<div class="spacer"></div>

											</s:form>

											<!-- End First Tab Content -->


										</div>

									</td>
								</tr>
							</table>
						</div>
					</center>
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

</body>
</html>
