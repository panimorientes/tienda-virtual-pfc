package domino;

public class Pedido {

	private String fecha;
	private Carro carro;

	
	
	public Pedido(String fecha, Carro carro) {
		super();
		this.fecha = fecha;
		this.carro = carro;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	@Override
	public String toString() {
		return "Pedido [fecha=" + fecha + ", carro=" + carro + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((carro == null) ? 0 : carro.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
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
		Pedido other = (Pedido) obj;
		if (carro == null) {
			if (other.carro != null)
				return false;
		} else if (!carro.equals(other.carro))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		return true;
	}
}
