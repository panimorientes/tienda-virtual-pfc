package pruebas;

import java.sql.SQLException;

import excepciones.NoHayConexionesLibresException;
import persistencia.AgenteBD;

class Hilo extends Thread {
	int identificador, maximo;
	GeneradorHilos gen;

	public Hilo(int id, int max, GeneradorHilos gen) {
		maximo = max;
		identificador = id;
		this.gen = gen;
	}

	@Override
	public void run() {
		try {
			AgenteBD a = new AgenteBD();

			a.getConexionLibre();
			if (identificador == (maximo - 1)) {
				gen.despierta();
			}
		} catch (NoHayConexionesLibresException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class GeneradorHilos extends Thread {

	static boolean seguir = true;

	public GeneradorHilos() {
		for (int i = 0; i < AgenteBD.numero_conexiones; i++) {
			Hilo h = new Hilo(i, AgenteBD.numero_conexiones, this);
			h.start();
		}

	}

	public synchronized void despierta() {
		notify();
	}

	public synchronized void duerme() {
		try {
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
