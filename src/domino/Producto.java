package domino;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Producto implements Serializable{
	private int referencia;
	private String nombre;
	private String descripcion;
	private double precio;
	private String ruta_imagen;
	private String categoria;
	private int stock;
	private double valoracion = 0.0;
	
	public Producto(int referencia) {
		super();
		this.referencia = referencia;
	}
	public Producto(int referencia, String nombre, String descripcion,
			double precio, String ruta_imagen, String categoria, int unidades) {
		super();
		this.referencia = referencia;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.ruta_imagen = ruta_imagen;
		this.categoria = categoria;
		this.stock = unidades;
	}
	
	public Producto (int referencia, int unidades)
	{
		this.referencia = referencia;
		this.stock = unidades;
	}
	
	public Producto(int referencia,String nombre){
		this.referencia=referencia;
		this.nombre=nombre;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + referencia;
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
		Producto other = (Producto) obj;
		if (referencia != other.referencia)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Producto [referencia=" + referencia + ", precio=" + precio
				+ ", categoria=" + categoria + "]";
	}
	public int getReferencia() {
		return referencia;
	}
	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getRuta_imagen() {
		return ruta_imagen;
	}
	public void setRuta_imagen(String ruta_imagen) {
		this.ruta_imagen = ruta_imagen;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public int getUnidades() {
		return stock;
	}
	public void setUnidades(int unidades) {
		this.stock = unidades;
	}
	public double getValoracion() {
		//return valoracion;
		return 3.5;
	}
	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}
	
	
	
	
	//////////////////////////////////////////////////////////////////////
	
	public static List<Producto> genRandomProducts(int count){
		List<Producto> productos = new LinkedList<Producto>();
		for(int i=0; i < count; i++){
			productos.add(new Producto(1234, "Macho ibérico tradicional del monte salvaje", "Personaje muy particular, al que se le atribuyen expresiones como \"una interrupción hardware es una interrupción hardware\"", 3.5, "img/null-product2.png", "Personos", 323));
		}
		return productos;
	}
	

}
