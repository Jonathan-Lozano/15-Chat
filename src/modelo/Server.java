package modelo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jonathan Lozano
 *
 */
public final class Server {

	private static final Server server = new Server();

	/**
	 * Iniciar servidor y mantener en verdadero para conseguir conexiones
	 * (servidor)
	 */
	public void runServices() {
		try {
			Socket s = null;
			ServerSocket ss = new ServerSocket(4500, 100);
			JOptionPane
					.showMessageDialog(null,
							"Esperando conexion...\nUna vez iniciada una conexion el chat se abrira");
			while (true) {
				s = ss.accept();
				new ChatFirstUser(s).start();
			}
		} catch (IOException e) {
			System.out.println("Error de conexion: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @return Instancia de la clase
	 */
	public static Server getServer() {
		return server;
	}

}
