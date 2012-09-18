package presentacion.actions;

import java.sql.SQLException;
import java.util.List;

import presentacion.WebInterface;
import presentacion.WebUtils;

import com.opensymphony.xwork2.ActionSupport;

import domino.FachadaPresentacionDominio;
import domino.Producto;

public class Search extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String query;

	public String execute() {
		System.out.println("Query: " + query);
		WebInterface interfaz = new FachadaPresentacionDominio();
		try {
			Object o = WebUtils.getSession().getAttribute("productos");
			if (o != null && o instanceof List<?>) {
				List<Producto> productos = (List<Producto>) o;
				List<Producto> result = interfaz.getProductosBusqueda(query,
						productos);
				WebUtils.getSession().setAttribute("searchResult", result);
				System.out.println(result.size()
						+ " products found from search.");
			} else {
				throw new Exception();
			}
			return SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
			return "SQLException";
		} catch (Exception e) {
			return "Exception";
		}

	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
