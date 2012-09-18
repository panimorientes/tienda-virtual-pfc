<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page session='true'%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.util.*"%>
<%@page import="domino.*"%>
<%@page import="presentacion.*"%>
<%@page import="presentacion.ProductCell"%>

<%

	HttpSession sesion = request.getSession();
	if (sesion.getAttribute("carro") == null) {
		sesion.setAttribute("carro", new Carro());
	}
	WebUtils.setSession(sesion);

	String action = request.getParameter("action");
	if (action != null) {
		if (action.equals("logout")) {
			sesion.removeAttribute("user");
			sesion.setAttribute("carro", new Carro());

		}
	}

	Carro carro = (Carro) sesion.getAttribute("carro");
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
	function addToCarro(combo, ref) {
		var v = document.getElementById(combo).value;
		if (combo == "")
			return false;		
		window.location = 'index.jsp?ref=' + ref + "&count=" + v;
	}
	
	function borrar(){
		document.getElementsByName("query")[0].value="";
	}
	
	function poner(){
		document.getElementsByName("query")[0].value="Buscar...";
	}
</script>

</head>
<body>
	<%
		List<Producto> searchResult = null;
		WebInterface interfaz = new FachadaPresentacionDominio();
		List<Producto> productos = interfaz.getAllProducts();
		sesion.setAttribute("productos", productos);
		try {
			int ref = Integer.parseInt(request.getParameter("ref"));
			int count = Integer.parseInt(request.getParameter("count"));
			Producto pinc = productos.get(productos.indexOf(new Producto(
					ref)));
			if (count == 0) {
				carro.eliminarProducto(pinc.getReferencia());
			} else if (carro.getCantidad(pinc.getReferencia()) > 0) {
				carro.modificarProducto(pinc.getReferencia(), count);
			} else {
				carro.addProducto(pinc, count);
			}
		} catch (Exception ex) {

		}

		searchResult = (List<Producto>) (sesion
				.getAttribute("searchResult"));
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



				<div class="search">

					<s:form theme="simple" action="Search" value="Búsqueda">
						<span class="field"> <s:textfield name="query"
								styleClass="blink" value="Buscar..." onclick="borrar()" onmouseout="poner()"/>
						</span>

						<span style="margin-right: 10px"></span>
					</s:form>

				</div>

				<%
					Usuario u = (Usuario) sesion.getAttribute("user");
					if (u == null)
						out.println(WebUtils.genHTMLMainBar(carro));
					else if (u instanceof Cliente)
						out.println(WebUtils.genHTMLMainBar(carro));
				%>


			</div>

			<!-- End Search, etc -->

			<!-- Content -->
			<div id="content">



				<!-- Tabs -->
				<div class="tabs">
					<ul>
						<%
							String s = "";
							List<String> categorias = interfaz.getAllCategorias();
							boolean red = true;
							boolean hayBusqueda = searchResult != null;
							if (hayBusqueda) {
								s += "<li><a><span>Busqueda</span></a></li>";
								//System.out.println("HAY BUSQUEDA");
							} else {
								//System.out.println("NO HAY BUSQUEDA");
							}
							for (String c : categorias) {
								s += "<li><a href=\"#\"" + ((red) ? ("class=\"red\"") : (""))
										+ "><span>" + c + "</span></a></li>";
								red = !red;
							}
							out.print(s);
						%>

					</ul>
				</div>
				<!-- Tabs -->

				<!-- Container -->
				<div id="container">

					<div class="tabbed">

						<%
							if (hayBusqueda) {
								out.print("<div class=\"tab-content\" style=\"display: block;\">"
										+ "<div class =\"items\"> <div class=\"cl\">&nbsp;</div>");
								out.print("<ul>");
								sesion.removeAttribute("searchResult");
								if (searchResult.size() == 0) {
									out.print("La búsqueda no obtuvo resultados");
								}

								for (Producto p : searchResult) {
									out.println("<li>");
									out.println(WebUtils.genHTMLProductInIndex(p));
									if (!(u instanceof Administrador)) {
										out.print("Unidades en carrito:");
						%>



						<select id=<%out.print(p.getReferencia());%>
							name=<%out.println(p.getReferencia());%>
							onchange=<%out.println("\"addToCarro(" + p.getReferencia() + ","
								+ p.getReferencia() + ")\";");%>>
							<%
								out.println("<option value=\""
													+ carro.getCantidad(p.getReferencia()) + "\">"
													+ carro.getCantidad(p.getReferencia())
													+ "</option>");
											for (int i = 0; i < p.getUnidades(); i++) {
												out.println("<option value=\"" + i + "\">" + i
														+ "</option>");
											}
							%>
						</select>



						<%
							}
									out.println("</p></li>");
								}
								out.print("</ul><div class=\"cl\">&nbsp;</div>");
								out.print("</div></div>");
							}
							for (String cat : categorias) {
								out.print("<div class=\"tab-content\" style=\"display: block;\">"
										+ "<div class =\"items\"> <div class=\"cl\">&nbsp;</div>");
								out.print("<ul>");
								List<Producto> productosEstaCat = interfaz
										.getProductosCategoria(productos, cat);
								for (Producto p : productosEstaCat) {
									out.println("<li>");
									out.println(WebUtils.genHTMLProductInIndex(p));
									if (!(u instanceof Administrador)) {
										out.print("Unidades en carrito:");
						%>


						<!-- <form> -->
						<select id=<%out.print(p.getReferencia());%>
							name=<%out.println(p.getReferencia());%>
							onchange=<%out.println("\"addToCarro(" + p.getReferencia() + ","
								+ p.getReferencia() + ")\";");%>>
							<%
								out.println("<option value=\""
													+ carro.getCantidad(p.getReferencia()) + "\">"
													+ carro.getCantidad(p.getReferencia())
													+ "</option>");
											for (int i = 0; i < p.getUnidades(); i++) {
												out.println("<option value=\"" + i + "\">" + i
														+ "</option>");
											}
							%>
						</select>
						<!-- </form> -->



						<%
							}
									out.println("</p></li>");
								}
								out.print("</ul><div class=\"cl\">&nbsp;</div>");
								out.print("</div></div>");
							}
						%>

						<!-- First Tab Content -->

						<div class="tab-content" style="display: block;">
							<div class="items">
								<div class="cl">&nbsp;</div>
								<ul>

									<%
										try {

											for (Producto p : productos) {
												//carro.addProducto(p, 5);
												out.println("<li>" + WebUtils.genHTMLProductInIndex(p));
									%>

									<form>
										<p>
											<select id=<%out.print(p.getReferencia());%>
												name=<%out.println(p.getReferencia());%>
												onchange=<%out.println("\"addToCarro(" + p.getReferencia() + ","
							+ p.getReferencia() + ")\";");%>>
												<%
													out.println("<option value=\""
																	+ carro.getCantidad(p.getReferencia()) + "\">"
																	+ carro.getCantidad(p.getReferencia())
																	+ "</option>");
															for (int i = 0; i < p.getUnidades(); i++) {
																out.println("<option value=\"" + i + "\">" + i
																		+ "</option>");
															}
												%>
											</select>
										</p>
									</form>

									<%
										out.println("</p></li>");
											}
										} catch (Exception ex) {
											out.println("<li>"
													+ WebUtils
															.genHTMLProductInIndex(new Producto(
																	-1,
																	"Producto notificador de error",
																	"Esto es un producto que no se compra ni se vende. Que estés viendo esto es mala señal, y significa que no hay conexiones libres a la base de datos. Vuelve a intentarlo más tarde.",
																	3.5, "img/null-product2.png",
																	"Errores", 323)) + "</li>");
											ex.printStackTrace();

										}
									%>

								</ul>
								<div class="cl">&nbsp;</div>
							</div>
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
