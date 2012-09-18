package presentacion;

import javax.servlet.http.HttpSession;

import domino.Carro;
import domino.Producto;
import domino.Usuario;
import domino.Administrador;

public abstract class WebUtils {

	private static HttpSession session = null;

	public static HttpSession getSession() {
		return session;
	}

	public static void setSession(HttpSession s) {
		session = s;
	}

	public static String genMenu() {
		Usuario u = (Usuario) getSession().getAttribute("user");
		if (u == null) {
			return genLoggedOutMenu();
		} else {
			System.out.println("Generando menú para:\n\tNombre: " + u.getNombre() + "\n\tApellido: " + u.getApellido() + "\n\tcorreo: "+ u.getCorreo());
			return genLoggedInMenu(u);
		}
	}

	private static String genLoggedOutMenu() {
		String s = ""
				+ "<ul>"
				+ "<li><a href=\"index.jsp\">Catálogo</a></li>"
				+ "<li class=\"last\"><a href=\"login.jsp\">Iniciar sesion / registrarse</a></li>"
				+ "</ul>";
		return s;
	}

	private static String genLoggedInMenu(Usuario u) {
		String s = ""
				+ "<ul>"
				+ "<li><a href=\"index.jsp\">Catálogo</a></li>"
				+ "<li>"
				+ u.getCorreo()
				+ " (<a href=\"index.jsp?action=logout\">salir</a>)</li>"
				+ ((u instanceof Administrador) ? ("<li><a href=\"administrar.jsp\">Administrar tienda</a></li>")
						: (""))
				+ "<li><a href=\"pedidos.jsp\">Historial</a></li><li class=\"last\"><a href=\"profile.jsp\">Perfil</a></li></ul>";
		return s;
	}

	public static String genHTMLMetaHeader() {
		String s = "<meta http-equiv=\"Content-type\" content=\"text/html; charset=ISO-8859-1\" />";
		return s;
	}

	public static String genHTMLLeftFooter() {
		String s = "<a href=\"about.jsp\">Acerca de</a> <span>|";
		return s;
	}

	public static String genHTMLRightFooter() {
		String s = "Prácticas de Ingeniería del Software II (2011-2012)";
		return s;
	}

	public static String genHTMLMainBar(Carro carro) {

		String s = ""
				+ "<div class=\"right\">"
				+ "	<span class=\"cart\"> <a href=\"carro.jsp\" class=\"cart-ico\">&nbsp;</a>"
				+ "		<strong>"
				+ ((carro != null) ? (carro.calcularPrecio()) : (0))
				+ " &#8364</strong>" + "	</span></div>";
		return s;
	}

	public static String genHTMLProductInCarro(Producto p) {
		String html = ""
				+ "<table width=670px><tr><td>"

				+ "<div class=\"image\">"
				+ "<a href=\"product.jsp\"><img src=\""
				+ p.getRuta_imagen()
				+ "\" style=\"height:100px;\" /></a></div>"

				+ "</td><td>"
				+ "<p>Ref: <span>"
				+ p.getReferencia()
				+ "</span></p>"
				+

				"<p>Nombre: <span>"
				+ p.getNombre()
				+ "</span></p>"

				+ "<div style=\"margin-top:10px\"/>"

				+ "<p class=\"price\">Valoracion de usuarios: <img src=\"img/rating-"
				+ ((int) p.getValoracion())
				+ ".png\" ></img></p></td>"
				+ "<td valign=\"top\" width=130px>"
				+ "<p class=\"price\">Precio: <strong>" + p.getPrecio()
				+ " &#8364</strong></p>"

				+ "<p class=\"price\">" + "Uds: ";

		return html;
	}

	public static String genHTMLProductInIndex(Producto p) {
		String html = ""
				+ "<p>Ref: <span>"
				+ p.getReferencia()
				+ "</span></p>"
				+

				"<p>Nombre: <span>"
				+ p.getNombre()
				+ "</span></p>"

				+ "<div style=\"margin-top:10px\"/>"

				+ "<div class=\"image\" >"
				+ "<img style=\"max-width: 200px; max-height: 150px;\" src=\""
				+ p.getRuta_imagen()
				+ "\" max-width=180px max-height=100px /></div>"

				+ "<div style=\"margin-top:10px\"/>"

				+ "<p style=\"text-align: left;\">Descripcion: <span>"
				+ p.getDescripcion()
				+ "</span></p>"

				+ "<p class=\"price\">Precio: <strong>"
				+ p.getPrecio()
				+ " &#8364</strong></p><p class=\"price\">Valoracion: <img src=\"img/rating-"
				+ ((int) p.getValoracion()) + ".png\" width=60px></img></p>"
				+ "<p class=\"price\">";

		return html;
	}

}
