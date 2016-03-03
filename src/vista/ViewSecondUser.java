package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 * @author Jonathan Lozano
 *
 */
public final class ViewSecondUser extends JFrame {

	private static final ViewSecondUser vsu = new ViewSecondUser();

	private Container content = getContentPane();
	private JTextField txtMessage = new JTextField();
	private JButton btnEnviar = new JButton("Enviar");
	private JScrollPane scMessages = new JScrollPane();
	private JTextArea ltMessages = new JTextArea();
	private String user;

	/**
	 * Consutructor privado que inicializa la ventana con los controles
	 * necesarios
	 */
	private ViewSecondUser() {
		super("Segundo usuario");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(350, 350);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		cargarControles();
	}

	/**
	 * Metodo que agrega los controles necesarios
	 */
	public void cargarControles() {
		content.setLayout(null);

		txtMessage.setBounds(0, 290, 275, 30);
		txtMessage.setFont(new Font("Tahoma", 0, 18));
		content.add(txtMessage);

		btnEnviar.setBounds(272, 290, 70, 29);
		btnEnviar.setBackground(Color.white);
		content.add(btnEnviar);

		scMessages.setViewportView(ltMessages);
		scMessages.setBounds(0, 0, 342, 290);
		ltMessages.setFont(new Font("Tahoma", 0, 20));
		ltMessages.setEnabled(false);
		content.add(scMessages);

	}

	/*
	 * Getters and Setters de los elementos de la ventana
	 */

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Container getContent() {
		return content;
	}

	public void setContent(Container content) {
		this.content = content;
	}

	public JTextField getTxtMessage() {
		return txtMessage;
	}

	public void setTxtMessage(JTextField txtMessage) {
		this.txtMessage = txtMessage;
	}

	public JButton getBtnEnviar() {
		return btnEnviar;
	}

	public void setBtnEnviar(JButton btnEnviar) {
		this.btnEnviar = btnEnviar;
	}

	public JScrollPane getScMessages() {
		return scMessages;
	}

	public void setScMessages(JScrollPane scMessages) {
		this.scMessages = scMessages;
	}

	public JTextArea getLtMessages() {
		return ltMessages;
	}

	public void setLtMessages(JTextArea ltMessages) {
		this.ltMessages = ltMessages;
	}

	/**
	 * Metodo que devuelve la instancia de la clase
	 */
	public static ViewSecondUser getVsu() {
		return vsu;
	}
}
