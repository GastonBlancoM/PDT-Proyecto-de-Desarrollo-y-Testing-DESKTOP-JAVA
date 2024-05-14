package com.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.entities.Estudiante;
import com.entities.Usuario;
import com.enums.EstadoEstudiante;
import com.enums.EstadoUsuario;
import com.enums.TipoUsuario;
import com.exception.ServiciosException;
import com.servicios.AnalistaBeanCliente;
import com.servicios.AnalistaBeanImp;
import com.servicios.EstudianteBeanCliente;
import com.servicios.EstudianteBeanImp;
import com.servicios.UsuarioBeanCliente;
import com.servicios.UsuarioBeanImp;

import java.awt.event.MouseMotionAdapter;
import java.util.List;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtIngresarUsuario;
	private JPasswordField passwordField;
	private Long idRol;
	private int error = 0;
	private String nombreUsuario;
	private String contraseniaa;
	private EstudianteBeanCliente estudianteBean = new EstudianteBeanImp();
	private AnalistaBeanCliente analistaBean = new AnalistaBeanImp();
	private UsuarioBeanCliente usuarioBean = new UsuarioBeanImp();
	private static long idLoginUsuario;

	JRadioButton rbtnVerContra = new JRadioButton("");

	int xMouse, yMouse;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();

					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setUndecorated(true);
		setResizable(false);
		setBounds(100, 100, 568, 412);
		getContentPane().setLayout(null);

		JPanel fondo = new JPanel();
		fondo.setBackground(Color.WHITE);
		fondo.setBounds(0, 0, 569, 412);
		getContentPane().add(fondo);
		fondo.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setIcon(
				new ImageIcon(Login.class.getResource("/com/imagenes/Simbologo_Utec_con_letras_en_blanco.png")));
		lblNewLabel_6.setBounds(333, 323, 236, 90);
		fondo.add(lblNewLabel_6);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon(Login.class.getResource("/com/imagenes/UTEC-LOGO.png")));
		lblNewLabel_5.setBounds(10, 38, 313, 100);
		fondo.add(lblNewLabel_5);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/com/imagenes/ITR_2.jpg")));
		lblNewLabel.setBounds(333, 0, 236, 413);
		fondo.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Inicio de Sesión");
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 149, 313, 26);
		fondo.add(lblNewLabel_1);
		// HOLA

		JLabel lblNewLabel_1_1 = new JLabel("Usuario\r\n");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(new Color(30, 144, 255));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(10, 194, 313, 14);
		fondo.add(lblNewLabel_1_1);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(169, 169, 169));
		separator.setBackground(new Color(169, 169, 169));
		separator.setBounds(10, 239, 313, 2);
		fondo.add(separator);

		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 250, 313, 14);
		fondo.add(lblNewLabel_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(169, 169, 169));
		separator_1.setBackground(new Color(169, 169, 169));
		separator_1.setBounds(10, 289, 274, 2);
		fondo.add(separator_1);

		txtIngresarUsuario = new JTextField();
		txtIngresarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtIngresarUsuario.getText().equals("Ingrese su nombre de usuario")) {
					txtIngresarUsuario.setText("");
					txtIngresarUsuario.setForeground(Color.BLACK);
				}
				if (passwordField.getText().isEmpty()) {
					passwordField.setText("Ingresar contraseña");
					passwordField.setForeground(Color.GRAY);
				}
			}
		});
		txtIngresarUsuario.setForeground(new Color(211, 211, 211));
		txtIngresarUsuario.setText("Ingrese su nombre de usuario");
		txtIngresarUsuario.setBackground(new Color(255, 255, 255));
		txtIngresarUsuario.setBorder(null);
		txtIngresarUsuario.setColumns(10);
		txtIngresarUsuario.setBounds(10, 219, 313, 20);
		fondo.add(txtIngresarUsuario);

		passwordField = new JPasswordField();
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (passwordField.getText().equals("Ingresar contraseña")) {
					passwordField.setText("");
					passwordField.setForeground(Color.BLACK);
				}
				if (txtIngresarUsuario.getText().isEmpty()) {
					txtIngresarUsuario.setText("Ingrese su nombre de usuario");
					txtIngresarUsuario.setForeground(Color.GRAY);
				}
			}
		});
		passwordField.setForeground(new Color(211, 211, 211));
		passwordField.setToolTipText("");
		passwordField.setText("Ingresar contraseña");
		passwordField.setBorder(null);
		passwordField.setBounds(10, 269, 274, 20);
		fondo.add(passwordField);

		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setFocusable(false);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					loginPrueba();
					dispose();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEntrar.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnEntrar.setBorderPainted(false);
		btnEntrar.setBackground(new Color(30, 144, 255));
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEntrar.setBackground(new Color(0, 191, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnEntrar.setBackground(new Color(30, 144, 255));
			}
		});

		btnEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEntrar.setMnemonic(KeyEvent.VK_ENTER);
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnEntrar.setBounds(10, 311, 89, 23);
		fondo.add(btnEntrar);

		JLabel lblNewLabel_3 = new JLabel("¿No estas registrado?");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setForeground(new Color(128, 128, 128));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(182, 345, 141, 14);
		fondo.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Registrate!");
		lblNewLabel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_4.setForeground(new Color(218, 165, 32));
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_4.setForeground(new Color(255, 215, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_4.setForeground(new Color(218, 165, 32));
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				RegistroLoginUsuario frame;
				dispose();
				frame = new RegistroLoginUsuario();
				frame.main(null);
				

			}
		});
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_4.setBounds(253, 372, 70, 14);
		fondo.add(lblNewLabel_4);

		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent evt) {
				int x = evt.getXOnScreen();
				int y = evt.getYOnScreen();
				setLocation(x - xMouse, y - yMouse);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent evt) {
				xMouse = evt.getX();
				yMouse = evt.getY();
//asd
			}
		});
		panel.setBorder(null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 569, 27);
		fondo.add(panel);
		panel.setLayout(null);

		JButton exitBtn = new JButton("X");
		exitBtn.setFocusable(false);
		exitBtn.setBounds(0, 0, 27, 27);
		panel.add(exitBtn);
		exitBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		exitBtn.setBackground(Color.WHITE);

		textField = new JTextField();
		textField.setBounds(10, 30, -6, -4);
		fondo.add(textField);
		textField.setColumns(10);
		rbtnVerContra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		rbtnVerContra.setToolTipText("Mostrar contraseña");
		rbtnVerContra.setBackground(Color.WHITE);
		rbtnVerContra.setIcon(new ImageIcon(PDU_Actualizar.class.getResource("/com/iconos/ojo.png")));
		rbtnVerContra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				verContrasenia();
			}

		});
		rbtnVerContra.setBounds(290, 268, 33, 20);
		fondo.add(rbtnVerContra);

		exitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitBtn.setBackground(Color.RED);
				exitBtn.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitBtn.setBackground(Color.WHITE);
				exitBtn.setForeground(Color.BLACK);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// System.exit(JFrame.DISPOSE_ON_CLOSE);
				// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				System.exit(0);
				// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			}
		});

	}

	protected void verContrasenia() {
		if (rbtnVerContra.isSelected()) {
			passwordField.setEchoChar((char) 0);
			rbtnVerContra.setIcon(new ImageIcon(PDU_Actualizar.class.getResource("/com/iconos/ojos-cruzados.png")));
			rbtnVerContra.setToolTipText("Ocultar contraseña");
		} else {
			passwordField.setEchoChar('*');
			rbtnVerContra.setIcon(new ImageIcon(PDU_Actualizar.class.getResource("/com/iconos/ojo.png")));
			rbtnVerContra.setToolTipText("Mostrar contraseña");
		}

	}

	void loginPrueba() throws ServiciosException {
		nombreUsuario = txtIngresarUsuario.getText();
		contraseniaa = String.valueOf(passwordField.getText());

		List<Usuario> usu = usuarioBean.obtenerTodosUsuarios();

		String usuario = txtIngresarUsuario.getText();
		String contrasenia = String.valueOf(passwordField.getText());

		if (usuario.equals("admin") && contrasenia.equals("admin")) {
			MenuPrincipalAnalista frame = new MenuPrincipalAnalista();
			frame.setVisible(true);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			error = 1;

		}

		else {
			for (Usuario usuariolista : usu) {
				if (usuariolista.getNombreUsuario().equals(nombreUsuario)
						&& usuariolista.getContrasenia().equals(contraseniaa)
						&& usuariolista.getEstadoUsuario().equals(EstadoUsuario.Validado)
						&& usuariolista.getTipoUsuario().equals(TipoUsuario.Analista)) {
					error = 2;
					setIdLoginUsuario(usuariolista.getIdUsuario());
				}
			}

		}
		for (Usuario usuariolista : usu) {
			if (usuariolista.getNombreUsuario().equals(nombreUsuario)
					&& usuariolista.getContrasenia().equals(contraseniaa)
					&& usuariolista.getTipoUsuario().equals(TipoUsuario.Estudiante)
					&& usuariolista.getEstadoUsuario().equals(EstadoUsuario.Validado)) {
				error = 3;
				setIdLoginUsuario(usuariolista.getIdUsuario());
			}

		}

		for (Usuario usuariolista : usu) {
			if (usuariolista.getNombreUsuario().equals(nombreUsuario)
					&& usuariolista.getContrasenia().equals(contraseniaa)
					&& usuariolista.getTipoUsuario().equals(TipoUsuario.Tutor)
					&& usuariolista.getEstadoUsuario().equals(EstadoUsuario.Validado)) {
				error = 4;
				setIdLoginUsuario(usuariolista.getIdUsuario());
			}

		}

		if (error == 0) {

			JOptionPane.showMessageDialog(null, "Mail o Contraseña incorrecto o Usuario Pendiente de verificacion");
			Login frame = new Login();

			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		}
		if (error == 2) {
			MenuPrincipalAnalista frame1 = new MenuPrincipalAnalista();
			frame1.setVisible(true);
			frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}
		if (error == 3) {
			MenuPrincipalEstudiante frame = new MenuPrincipalEstudiante();
			frame.setVisible(true);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		}
		if (error == 4) {
			MenuPrincipalTutor frame = new MenuPrincipalTutor();
			frame.setVisible(true);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		}
	}

	void loginAdmin() throws ServiciosException {

		String usuario = txtIngresarUsuario.getText();
		String contrasenia = String.valueOf(passwordField.getText());

		if (usuario.contains("admin") && contrasenia.contains("admin")) {
			MenuPrincipalAnalista frame = new MenuPrincipalAnalista();
			frame.setVisible(true);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		} else {
			JOptionPane.showMessageDialog(null, "Usuario no Encontrado, intente nuevamente", "Advertencia",
					JOptionPane.WARNING_MESSAGE);

			txtIngresarUsuario.setText("");
			passwordField.setText("");

		}
	}

	public static long getIdLoginUsuario() {
		return idLoginUsuario;
	}

	public static void setIdLoginUsuario(long idLoginUsuario) {
		Login.idLoginUsuario = idLoginUsuario;
	}
}
