package pagos;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import paypal.domain.Pago;
import paypal.excepciones.ImporteInvalidoException;
import paypal.excepciones.MesInvalidoException;
import paypal.excepciones.NoHayConexionesLibresException;
import paypal.excepciones.PagoRechazadoException;
import paypal.excepciones.TarjetaCaducadaException;
import paypal.excepciones.UsuarioIncorrectoException;
import presentacion.WebInterface;
import presentacion.WebUtils;

import com.opensymphony.xwork2.ActionSupport;

import domino.Carro;
import domino.Cliente;
import domino.FachadaPresentacionDominio;
import domino.Pedido;
import excepciones.*;

public class PagarConPayPal extends ActionSupport {
	private String correoUsuario;
	private String pwd;
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
			Pago.getPago().pagar(correoUsuario, pwd, importe, alumno);

			return SUCCESS;
		} catch (excepciones.NoHayConexionesLibresException e) {
			return "NoHayConexionesLibresException";
		} catch (NoHayConexionesLibresException e) {
			return "NoHayConexionesLibresException";
		} catch (SQLException e) {
			return "SQLException";
		} catch (ImporteInvalidoException e) {
			return "ImporteInvalidoException";
		} catch (UsuarioIncorrectoException e) {
			return "UsuarioIncorrectoException";
		}
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}

}
