package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import vista.ViewSecondUser;

/**
 * 
 * @author Jonathan Lozano
 *
 */
public final class ChatSecondUser {

	private static final ChatSecondUser csu = new ChatSecondUser();
	private ViewSecondUser vsu = ViewSecondUser.getVsu();
	private ObjectOutputStream outputMessage;
	private ObjectInputStream inputMessage;

	/**
	 * Contructor privado de la clase
	 */
	private ChatSecondUser() {
		vsu.getBtnEnviar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				enviar();
			}
		});
		sendRun();
	}

	/**
	 * Metodo que escribe el mensaje que se va a enviar y se agrega a al text
	 * area de la ventana actual
	 */
	public void enviar() {
		try {
			while (vsu.getUser() == null)
				vsu.setUser(JOptionPane
						.showInputDialog("Ingresa tu nombre de usuario"));

			vsu.setTitle(vsu.getUser());

			outputMessage.writeObject(vsu.getTitle() + ":\n"
					+ vsu.getTxtMessage().getText() + "\n");

			vsu.getLtMessages().append(
					"Yo:\n" + vsu.getTxtMessage().getText() + "\n");

			vsu.getTxtMessage().setText("");
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * Metodo que se mantiene para recibir mensajes asi como agregar a un text
	 * area
	 */
	public void sendRun() {
		try {
			Socket s = new Socket("localhost", 4500);
			vsu.getBtnEnviar().setEnabled(true);

			outputMessage = new ObjectOutputStream(s.getOutputStream());

			inputMessage = new ObjectInputStream(s.getInputStream());

			while (true) {
				String messageReceived = (String) inputMessage.readObject();

				vsu.getLtMessages().append(messageReceived);
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Error 1 " + ex.getMessage());
		} catch (UnknownHostException ex) {
			System.out.println("Error 2 " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("Error en conexion: " + ex.getMessage());
			vsu.getBtnEnviar().setEnabled(false);
			System.exit(0);
		}
	}

	/**
	 * 
	 * @return Instancia de la clase
	 */
	public static ChatSecondUser getCsu() {
		return csu;
	}
}
