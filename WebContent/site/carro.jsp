<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page session='true'%>
<%@page import="org.apache.struts2.components.ComboBox"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="presentacion.ProductCell"%>
<%@page import="domino.*"%>
<%@page import="java.util.*"%>
<%@page import="presentacion.WebUtils"%>

<%

	HttpSession sesion = request.getSession();
	if (sesion.getAttribute("carro") == null) {
		sesion.setAttribute("carro", new Carro());
	}
	WebUtils.setSession(sesion);
	
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="java.net.*,java.io.*"%>
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

<script language="javascript">
	function linkTo(combo, ref) {
		var v = document.getElementById(combo).value;
		if (combo == "")
			return false;
		window.location = 'carro.jsp?ref=' + ref + "&count=" + v;
	}
	
	function quitar(ref) {		
		if (combo == "")
			return false;
		window.location = 'carro.jsp?ref=' + ref + "&count=0";
	}
</script>

</head>
<body>
	<%
		try {
			int ref = Integer.parseInt(request.getParameter("ref"));
			int count = Integer.parseInt(request.getParameter("count"));
			System.out.println("Se llega al carro con ref=" + ref
					+ ", count=" + count);
			Carro carro = ((Carro) request.getSession().getAttribute(
					"carro"));
			if (count > 0) {
				carro.modificarProducto(ref, count);
			} else {
				carro.eliminarProducto(ref);
			}

		} catch (Exception ex) {
			System.out.println("Se llega al carro sin argumentos");
		}
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
					out.println(WebUtils.genHTMLMainBar(((Carro)request.getSession().getAttribute("carro"))));
				%>
			</div>
			<!-- End Search, etc -->

			<!-- Content -->
			<div id="content">

				<!-- Tabs -->
				<div class="tabs">
					<ul>
<li><a href="#" class="active"><span>Carro de compra</span></a></li>
					</ul>
				</div>
				<!-- Tabs -->

				<!-- Container -->
				<div id="container">

					<div class="tabbed">



						<div class="tab-content" style="display: block;">
							<table>
								<tr>
									<td>
										<div class="items-carro">
											<div class="cl">&nbsp;</div>
											<ul>
												<%
													List<PaqueteProducto> productos = ((Carro) (request.getSession()
															.getAttribute("carro"))).getLista_productos();
												if(productos.size() == 0){
													out.println("El carro está vacío.");
												}
													for (PaqueteProducto p : productos) {
														out.println("<li>"
																+ WebUtils.genHTMLProductInCarro(p
																		.getProducto()));
												%>

												<form>
													<p>
														<select id=<%out.print(p.getProducto().getReferencia());%>
															value=<%out.print("" + p.getCantidad());%>
															name=<%out.println(p.getProducto().getReferencia());%>
															onchange=<%out.println("\"linkTo(" + p.getProducto().getReferencia() + ","
						+ p.getProducto().getReferencia() + ")\";");%>>
															<%
																out.println("<option value=\"" + p.getCantidad() + "\">"
																			+ p.getCantidad() + "</option>");
																	for (int i = 1; i < 40; i++) {
																		out.println("<option value=\"" + i + "\">" + i
																				+ "</option>");
																	}
															%>
														</select>
													</p>
												</form>
												<div style="margin-top: 10px"></div>

												<a
													<%out.println("href=\"carro.jsp?ref="
						+ p.getProducto().getReferencia() + "&count=0\"");%>>Quitar
													del carro</a>
												<!-- 
												<s:form action="QuitarDelCarro">
													<s:submit type="button" name="Quitar"
														label="Quitar del carro">
														<img src="img/delete.gif" width=10> Quitar del carro</img>
													</s:submit>
												</s:form>
 -->
												<%
													out.println("</td></tr></table></li>");
													}
												%>
											</ul>
											<div class="cl">&nbsp;</div>
										</div>

									</td>
									<td valign="top">
										<div class="sidebar">
											<!-- <div class="sidebar-title">Contenido del carro</div>-->


											<table class="sidebar-box" border="0">
												<tr>
													<th>Producto</th>
													<th>&#8364</th>
												</tr>
												<tr>
													<td>
														<hr>
													</td>
													<td>
														<hr>
													</td>
												</tr>

												<%
													double sum = 0;
													for(PaqueteProducto p: productos){
														out.println("<tr><td style=\"text-align: left\">" + p.getProducto().getNombre() + " (x" + p.getCantidad() + ")" + "</td>" +
														"<td>" + p.getCantidad()*p.getProducto().getPrecio() + "</td></tr>");
														sum += p.getCantidad()*p.getProducto().getPrecio();
													}
												%>
												
												
												<tr>
													<td>
														<hr>
													</td>
													<td>
														<hr>
													</td>
												</tr>
												<tr>
													<td style="text-align: right"><strong>Total:</strong>
													</td>
													<td><strong><% out.println("" + sum); %></strong></td>
												</tr>
											</table>

											<div style="margin-top: 10px">
												<form action="pago.jsp">
													<button type="submit" style="width: 180px">Finalizar
														compra</button>
												</form>
											</div>
											<div class="cl">&nbsp;</div>
										</div>
									</td>
								</tr>
							</table>
						</div>

						<!-- End First Tab Content -->



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
	</div>
	<!-- End Main -->

</body>
</html>
