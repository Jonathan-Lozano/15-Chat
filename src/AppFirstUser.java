import modelo.Server;

/**
 * 
 * @author Jonathan Lozano
 *
 */
public class AppFirstUser {

	/**
	 * Metodo principal que llama a la instancia
	 */
	public static void main(String[] args) {
		Server server = Server.getServer();
		server.runServices();
	}
}
