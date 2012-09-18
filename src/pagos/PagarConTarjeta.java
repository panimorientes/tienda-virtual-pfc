package pagos;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpSession;

import paypal.domain.Pago;
import paypal.excepciones.ImporteInvalidoException;
import paypal.excepciones.MesInvalidoException;
import paypal.excepciones.NoHayConexionesLibresException;
import paypal.excepciones.PagoRechazadoException;
import paypal.excepciones.TarjetaCaducadaException;
import presentacion.WebInterface;
import presentacion.WebUtils;

import com.opensymphony.xwork2.ActionSupport;

import domino.Carro;
import domino.Cliente;
import domino.FachadaPresentacionDominio;
import domino.Pedido;

public class PagarConTarjeta extends ActionSupport {
	private String numeroDeTarjeta;
	private int mesCaducidad, anioCaducidad;
	private String titular;
	private double importe = 0;
	private String alumno = "Grupo4";

	public String execute() {
		try {
			Carro c = ((Carro) WebUtils.getSession().getAttribute("carro"));
			Cliente cl = ((Cliente) WebUtils.getSession().getAttribute("user"));
			Calendar cal = new GregorianCalendar();
			String fecha = "" + cal.get(Calendar.YEAR) + "-"
					+ cal.get(Calendar.MONTH) + "-"
					+ cal.get(Calendar.DAY_OF_MONTH);
			Pedido p = new Pedido(fecha, c);
			WebInterface interfaz = new FachadaPresentacionDominio();

			interfaz.guardarPedido(p, cl);

			Pago.getPago().pagar(numeroDeTarjeta, mesCaducidad, anioCaducidad,
					titular, importe, alumno);

			return SUCCESS;
		} catch (excepciones.NoHayConexionesLibresException e) {
			return "NoHayConexionesLibresException";
		} catch (NoHayConexionesLibresException e) {
			return "NoHayConexionesLibresException";
		} catch (SQLException e) {
			System.out.println("BD error - " + e.toString());
			return "SQLException";
		} catch (TarjetaCaducadaException e) {
			return "TarjetaCaducadaException";
		} catch (MesInvalidoException e) {
			return "MesInvalidoException";
		} catch (PagoRechazadoException e) {
			return "PagoRechazadoException";
		} catch (ImporteInvalidoException e) {
			return "ImporteInvalidoException";
		}
	}

	public void setNumeroDeTarjeta(String numeroDeTarjeta) {
		this.numeroDeTarjeta = numeroDeTarjeta;
	}

	public void setMesCaducidad(int mesCaducidad) {
		this.mesCaducidad = mesCaducidad;
	}

	public void setAnioCaducidad(int anioCaducidad) {
		this.anioCaducidad = anioCaducidad;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}

}
