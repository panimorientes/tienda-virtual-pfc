<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="presentacion.ProductCell"%>
<%@page import="domino.*"%>
<%@page import="presentacion.WebUtils"%>
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
					out.println(WebUtils.genHTMLMainBar((Carro)request.getSession().getAttribute("carro")));
				%>
			</div>
			<!-- End Search, etc -->

			<!-- Content -->
			<div id="content">

				<!-- Tabs -->
				<div class="tabs">
					<ul>

					</ul>
				</div>
				<!-- Tabs -->

				<!-- Container -->
				<div id="container">

					<div class="tabbed">

						<!-- First Tab Content -->
						<div class="tab-content" style="display: block;">
							<div class="product">
								<div class="cl">&nbsp;</div>
								<ul>
								
								<%
																	out.println(ProductCell.genUniqueProductCellHTML(new ProductCell("img/null-product.png", "Esto es una descripción del producto. Esto es una descripción del producto. Esto es una descripción del producto.", 324, -1, 345.1, 2.5, 1)));
																%>
								
								</ul>
								<div class="cl">&nbsp;</div>
							</div>
						</div>
						<!-- End First Tab Content -->

						<!-- Second Tab Content -->
						<div class="tab-content">
							<div class="items">
								<div class="cl">&nbsp;</div>
								<ul>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image2.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
										<p class="price">Otra cosa</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image2.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image2.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image2.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image1.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image1.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image1.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image1.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
								</ul>
								<div class="cl">&nbsp;</div>
							</div>
						</div>
						<!-- End Second Tab Content -->

						<!-- Third Tab Content -->
						<div class="tab-content">
							<div class="items">
								<div class="cl">&nbsp;</div>
								<ul>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image3.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image3.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image3.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image3.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image4.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image4.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image4.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image4.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>

									<li>
										<div class="image">
											<a href="#"><img src="css/images/image2.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image2.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image2.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image2.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image1.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image1.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image1.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
									<li>
										<div class="image">
											<a href="#"><img src="css/images/image1.jpg" alt="" /></a>
										</div>
										<p>
											Item Number: <span>125515</span><br /> Size List : <span>8/8.5/9.5/10/11</span><br />
											Brand Name: <a href="#">Adidas Shoes</a>
										</p>
										<p class="price">
											Wholesale Price: <strong>53 USD</strong>
										</p>
									</li>
								</ul>
								<div class="cl">&nbsp;</div>
							</div>
						</div>
						<!-- End Third Tab Content -->

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
