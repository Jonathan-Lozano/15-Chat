package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import vista.ViewFirstUser;

/**
 * 
 * @author Jonathan Lozano
 *
 */
public class ChatFirstUser extends Thread {

	private static Socket s;
	private ViewFirstUser vfu = ViewFirstUser.getVfu();
	private ObjectOutputStream outputMessage;
	private ObjectInputStream inputMessage;

	/**
	 * Contructor de la clase
	 * 
	 * @param s
	 *            Socket parala conexion
	 */
	public ChatFirstUser(Socket s) {
		this.s = s;
		vfu.getBtnEnviar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				while (vfu.getUser() == null)
					vfu.setUser(JOptionPane
							.showInputDialog("Ingresa tu nombre de usuario"));
				vfu.setTitle(vfu.getUser());
				enviar();
			}
		});
	}

	/**
	 * Metodo que escribe el mensaje que se va a enviar y se agrega a al text
	 * area de la ventana actual
	 */
	public void enviar() {
		try {
			outputMessage.writeObject(vfu.getTitle() + ":\n"
					+ vfu.getTxtMessage().getText() + "\n");

			vfu.getLtMessages().append(
					"Yo:\n" + vfu.getTxtMessage().getText() + "\n");

			vfu.getTxtMessage().setText("");
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * Metodo que se mantiene para recibir mensajes asi como agregar a un text
	 * area
	 */
	public void run() {
		try {
			inputMessage = new ObjectInputStream(s.getInputStream());
			outputMessage = new ObjectOutputStream(s.getOutputStream());
			while (true) {

				String messageReceived = (String) inputMessage.readObject();

				vfu.getLtMessages().append(messageReceived);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Error 5 " + e.getMessage());
		} catch (IOException ex) {
			System.out.print("Error 6 " + ex.getMessage());
		}
	}
}
