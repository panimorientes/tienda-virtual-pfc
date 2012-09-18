// Esta clase va a ser borrada

package presentacion;

import java.util.LinkedList;
import java.util.List;

public class ProductCell {

	private String image = "img/null-product.jpg";
	private String description = "Esto es la descripción del producto. Con un par de lineas es suficiente.";
	private int id = -1;
	private int type = -1;
	private double cost = 3.5;
	private double puntuation = 8.2;
	private int count = -1;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getPuntuation() {
		return puntuation;
	}

	public void setPuntuation(double puntuation) {
		this.puntuation = puntuation;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public ProductCell(String image, String description, int id, int type,
			double cost, double puntuation, int count) {
		super();
		this.image = image;
		this.description = description;
		this.id = id;
		this.type = type;
		this.cost = cost;
		this.puntuation = puntuation;
		this.count = count;
	}

	public static List<ProductCell> genRandomProductsList(int count) {
		List<ProductCell> lista = new LinkedList<ProductCell>();
		for (int i = 0; i < count; i++) {
			lista.add(new ProductCell("./img/null-product.png",
					"Esto es la descripcion del producto X", 1234, 6, 188.3, 2,
					3));
		}
		return lista;
	}

	public static String genUniqueProductCellHTML(ProductCell p) {

		String html = "";

		html += 
				 "<table><tr><td><div class=\"image\">"
				+ "<a href=\"product.jsp\"><img src=\""
				+ p.getImage()
				+ "\" height=256px /></a>"
				+ "</div></td><td>"
				+ "<p>ID: <span>"
				+ p.getId()
				+ "</span><br>Descripcion: <span>"
				+ p.getDescription()
				+ "</span></p><p class=\"price\">Precio: <strong>"
				+ p.getCost()
				+ " euros</strong></p><p class=\"price\">Valoracion de usuarios: <img src=\"img/rating-"
				+ ((int) p.getPuntuation())
				+ ".png\" width=60px></img><br><br height=20>" +
				"<form id=\"form\" name=\"form\" method=\"post\" action=\"#\">" +
				"<button type=\"submit\" width=300>Añadir al carrito</button></form>" + 
				"</p></td></tr></table>";

		return html;
	}

	public static String genRandomProductsHTML(int count) {
		List<ProductCell> lista = genRandomProductsList(count);
		String html = "";
		for (ProductCell p : lista) {
			html += "<li>"
					+ "<div class=\"image\">"
					+ "<a href=\"product.jsp\"><img src=\""
					+ p.getImage()
					+ "\" height=180px /></a>"
					+ "</div>"
					+ "<p>ID: <span>"
					+ p.getId()
					+ "</span><br>Descripcion: <span>"
					+ p.getDescription()
					+ "</span></p><p class=\"price\">Precio: <strong>"
					+ p.getCost()
					+ " euros</strong></p><p class=\"price\">Numero de unidades: <select name=\"selCombo\" size=1>";
			for (int i = 0; i < 100; i++) {
				html += "<OPTION VALUE=\"link pagina 1\">" + i + "</OPTION>";
			}
			html += "</select></p><p class=\"price\">Valoracion de usuarios: <img src=\"img/rating-"
					+ ((int) p.getPuntuation())
					+ ".png\" width=60px></img></p></li>";
		}
		return html;
	}
	
	public static String genMainProductsListHTML(int count) {
		List<ProductCell> lista = genRandomProductsList(count);
		String html = "";
		for (ProductCell p : lista) {
			html += "<li>"
					+ "<p>ID: <span>"
					+ p.getId()
					+ "</span><br>Descripcion: <span>"
					+ p.getDescription()
					+ "</span></p><div class=\"image\">"
					+ "<a href=\"product.jsp\"><img src=\""
					+ p.getImage()
					+ "\" height=180px /></a>"
					+ "</div><p class=\"price\">Precio: <strong>"
					+ p.getCost()
					+ " euros</strong></p>"
					+ "<p class=\"price\">Añadir al carro: <select name=\"selCombo\" size=1>";
			for (int i = 0; i < 100; i++) {
				html += "<OPTION VALUE=\"link pagina 1\">" + i + "</OPTION>";
			}
			html += "</select><button type=\"submit\">Añadir</button></p><p class=\"price\">Valoracion de usuarios: <img src=\"img/rating-"
					+ ((int) p.getPuntuation())
					+ ".png\" width=60px></img></p></li>";
		}
		return html;
	}

}
