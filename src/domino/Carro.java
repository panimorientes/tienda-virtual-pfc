package domino;

import java.util.LinkedList;
import java.util.List;

public class Carro {

	private List<PaqueteProducto> lista_productos;

	public List<PaqueteProducto> getLista_productos() {
		return lista_productos;
	}

	public void setLista_productos(List<PaqueteProducto> lista_productos) {
		this.lista_productos = lista_productos;
	}

	public Carro() {
		super();
		this.lista_productos = new LinkedList<PaqueteProducto>();
	}

	public Carro(List<PaqueteProducto> lista_productos) {
		super();
		this.lista_productos = lista_productos;
	}

	public double calcularPrecio() {
		double res = 0;
		for (PaqueteProducto p : lista_productos)
			res += p.getProducto().getPrecio() * p.getCantidad();
		return res;
	}

	public int getCantidad(int referencia) {
		int res = 0;
		PaqueteProducto paq = new PaqueteProducto(new Producto(referencia));

		if (lista_productos.contains(paq)) {
			int indice = lista_productos.indexOf(paq);
			PaqueteProducto paq2 = lista_productos.get(indice);
			res = paq2.getCantidad();
		}

		return res;
	}

	public void addProducto(Producto p, int unidades) {
		PaqueteProducto paq = new PaqueteProducto(p, unidades);

		if (lista_productos.contains(paq)) {
			int indice = lista_productos.indexOf(paq);
			lista_productos.get(indice).setCantidad(
					paq.getCantidad() + unidades);
		} else {
			lista_productos.add(new PaqueteProducto(p, unidades));
		}
	}

	public void eliminarProducto(int referencia) {
		Producto pro = new Producto(referencia);
		PaqueteProducto paq = new PaqueteProducto(pro);

		eliminarProducto(paq);
	}

	public void modificarProducto(int referencia, int unidades) {

		Producto pro = new Producto(referencia);
		PaqueteProducto paq = new PaqueteProducto(pro);

		if (lista_productos.contains(paq)) {
			int indice = lista_productos.indexOf(paq);
			PaqueteProducto paq2 = lista_productos.get(indice);
			paq2.setCantidad(unidades);
		}
	}

	public void modificarProducto(PaqueteProducto p) {
		if (lista_productos.contains(p)) {
			int indice_paquete = lista_productos.indexOf(p);
			PaqueteProducto p_new = lista_productos.get(indice_paquete);
			p_new.setCantidad(p.getCantidad());
		} else
			lista_productos.add(p);
	}

	public void eliminarProducto(PaqueteProducto p) {
		lista_productos.remove(p);
	}

	@Override
	public String toString() {
		return "Carro [lista_productos=" + lista_productos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((lista_productos == null) ? 0 : lista_productos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (lista_productos == null) {
			if (other.lista_productos != null)
				return false;
		} else if (!lista_productos.equals(other.lista_productos))
			return false;
		return true;
	}

}
