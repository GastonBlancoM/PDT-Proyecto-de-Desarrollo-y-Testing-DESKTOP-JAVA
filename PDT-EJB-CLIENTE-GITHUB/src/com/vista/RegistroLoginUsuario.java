package com.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import com.dto.AnalistaDTO;
import com.dto.EstudianteDTO;
import com.dto.TutorDTO;
import com.entities.Analista;
import com.entities.Estudiante;
import com.entities.ITR;
import com.entities.Tutor;
import com.entities.Usuario;
import com.enums.EstadoEstudiante;
import com.enums.EstadoITR;
import com.enums.EstadoUsuario;
import com.enums.TipoRol;
import com.enums.TipoUsuario;
import com.exception.ServiciosException;
import com.servicios.AnalistaBeanCliente;
import com.servicios.AnalistaBeanImp;
import com.servicios.EstudianteBeanCliente;
import com.servicios.EstudianteBeanImp;
import com.servicios.EstudianteBeanRemote;
import com.servicios.ITRBeanCliente;
import com.servicios.ITRBeanImp;
import com.servicios.ITRBeanRemote;
import com.servicios.TutorBeanCliente;
import com.servicios.TutorBeanImp;
import com.servicios.UsuarioBeanCliente;
import com.servicios.UsuarioBeanImp;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import com.toedter.calendar.JYearChooser;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroLoginUsuario extends JFrame {
	int xMouse, yMouse;

	private JPanel contentPane;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDocumento;
	private JTextField txtEmail_Institucional;
	private JPanel panel;
	private JLabel primer_Nombre;
	private JLabel primer_Apellido;
	private JLabel cedula_identidad;
	private JLabel email_personal;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JLabel telefono_de_contacto;
	private JLabel departamento;
	private JLabel lblTipoDeUsuario;
	private JComboBox comboTipoUsuario;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2;
	private JPanel panel_2;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_3;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JSeparator separator_8;
	private JSeparator separator_9;
	private JSeparator separator_10;
	private JSeparator separator_7_1_1 = new JSeparator();
	private JButton exitBtn;
	private JButton btnRegistrarse;
	private JPasswordField pwdIngresarContrasea;
	private JLabel lblLocalidad;
	private JTextField txtIngreseLocalidad;
	private Long idItr;
	private Long idEstudiante;
	private JLabel lblDominio = new JLabel();
	private JComboBox comboDep = new JComboBox();
	private JYearChooser yearChooser = new JYearChooser();
	private JDateChooser dateFec_Nac = new JDateChooser();
	private JComboBox comboITR = new JComboBox();
	private JComboBox comboGenero = new JComboBox();
	private EstudianteBeanCliente estudianteBean = new EstudianteBeanImp();
	private ITRBeanCliente itrBean = new ITRBeanImp();
	private AnalistaBeanCliente analistaBean = new AnalistaBeanImp();
	private TutorBeanCliente tutorBean = new TutorBeanImp();
	private JRadioButton rdbtnEncargado = new JRadioButton("Encargado");
	private JRadioButton rdbtnTutor = new JRadioButton("Tutor");
	private JLabel lblArea = new JLabel("Área");
	private JTextField txtIngreseArea = new JTextField();
	private TipoRol tipoRol;
	private JTextField textField;
	private JRadioButton rbtnVerContra = new JRadioButton("");
	private static final String PASSWORD_REGEX = "^(?=.[0-9])(?=.[A-Z])(?=\\S+$).{8,64}$";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);
	private UsuarioBeanCliente usuarioBean = new UsuarioBeanImp();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroLoginUsuario frame = new RegistroLoginUsuario();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RegistroLoginUsuario() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);
		setLocationByPlatform(true);

		setBounds(100, 100, 725, 574);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setOpaque(false);
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
			}
		});

		separator_10 = new JSeparator();
		separator_10.setForeground(new Color(230, 230, 250));
		separator_10.setBounds(10, 113, 502, 3);
		contentPane.add(separator_10);

		separator_9 = new JSeparator();
		separator_9.setForeground(Color.GRAY);
		separator_9.setBackground(Color.GRAY);
		separator_9.setBounds(394, 425, 118, 3);
		contentPane.add(separator_9);

		separator_8 = new JSeparator();
		separator_8.setForeground(Color.GRAY);
		separator_8.setBackground(Color.GRAY);
		separator_8.setBounds(138, 425, 231, 3);
		contentPane.add(separator_8);

		separator_6 = new JSeparator();
		separator_6.setForeground(Color.GRAY);
		separator_6.setBackground(Color.GRAY);
		separator_6.setBounds(10, 315, 118, 2);
		contentPane.add(separator_6);

		separator_7 = new JSeparator();
		separator_7.setForeground(Color.GRAY);
		separator_7.setBackground(Color.GRAY);
		separator_7.setBounds(138, 315, 118, 2);
		contentPane.add(separator_7);

		separator_5 = new JSeparator();
		separator_5.setForeground(Color.GRAY);
		separator_5.setBackground(Color.GRAY);
		separator_5.setBounds(10, 259, 118, 2);
		contentPane.add(separator_5);

		separator_1 = new JSeparator();
		separator_1.setBackground(new Color(128, 128, 128));
		separator_1.setForeground(new Color(128, 128, 128));
		separator_1.setBounds(10, 201, 118, 2);
		contentPane.add(separator_1);

		separator_3 = new JSeparator();
		separator_3.setBackground(new Color(128, 128, 128));
		separator_3.setForeground(new Color(128, 128, 128));
		separator_3.setBounds(138, 200, 118, 3);
		contentPane.add(separator_3);

		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setIcon(new ImageIcon(
				RegistroLoginUsuario.class.getResource("/com/imagenes/Simbologo_Utec_con_letras_en_blanco.png")));
		lblNewLabel_6.setBounds(522, 481, 203, 93);
		contentPane.add(lblNewLabel_6);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setVerticalTextPosition(SwingConstants.TOP);
		lblNewLabel_1.setIcon(new ImageIcon(RegistroLoginUsuario.class.getResource("/com/imagenes/FGM_UTEC_666.jpg")));
		lblNewLabel_1.setBounds(522, 0, 203, 574);
		contentPane.add(lblNewLabel_1);
		panel.setBounds(0, 0, 725, 27);
		contentPane.add(panel);
		panel.setLayout(null);

		exitBtn = new JButton("X");
		exitBtn.setFocusable(false);
		exitBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exitBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		exitBtn.setBackground(Color.WHITE);
		exitBtn.setBounds(0, 0, 27, 27);
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

				dispose();

				Login frame = new Login();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		panel.add(exitBtn);

		txtNombres = new JTextField();
		txtNombres.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtNombres.getText().equals("Ingrese Nombres")) {
					txtNombres.setText("");
					txtNombres.setForeground(Color.BLACK);
				}
				if (txtApellidos.getText().isEmpty()) {
					txtApellidos.setText("Ingrese Apellidos");
					txtApellidos.setForeground(Color.GRAY);
				}
				if (txtDocumento.getText().isEmpty()) {
					txtDocumento.setText("Ingrese Documento");
					txtDocumento.setForeground(Color.GRAY);
				}
				if (txtEmail.getText().isEmpty()) {
					txtEmail.setText("Ingrese Email");
					txtEmail.setForeground(Color.GRAY);
				}
				if (txtTelefono.getText().isEmpty()) {
					txtTelefono.setText("Ingrese Teléfono");
					txtTelefono.setForeground(Color.GRAY);
				}
				if (txtEmail_Institucional.getText().isEmpty()) {
					txtEmail_Institucional.setText("Email Institucional");
					txtEmail_Institucional.setForeground(Color.GRAY);
				}
				if (pwdIngresarContrasea.getText().isEmpty()) {
					pwdIngresarContrasea.setText("Contraseña");
					pwdIngresarContrasea.setForeground(Color.GRAY);
				}
				if (txtIngreseLocalidad.getText().isEmpty()) {
					txtIngreseLocalidad.setText("Ingrese Localidad");
					txtIngreseLocalidad.setForeground(Color.GRAY);
				}
				if (txtIngreseArea.getText().isEmpty()) {
					txtIngreseArea.setText("Ingrese Área");
					txtIngreseArea.setForeground(Color.GRAY);
				}
			}
		});
		txtNombres.setBorder(null);

		txtNombres.setForeground(new Color(102, 102, 102));
		txtNombres.setDisabledTextColor(Color.LIGHT_GRAY);
		txtNombres.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNombres.setText("Ingrese Nombres");
		txtNombres.setBounds(10, 176, 118, 20);
		contentPane.add(txtNombres);
		txtNombres.setColumns(10);

		txtApellidos = new JTextField();
		txtApellidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if (txtApellidos.getText().equals("Ingrese Apellidos")) {
					txtApellidos.setText("");
					txtApellidos.setForeground(Color.BLACK);
				}
				if (txtNombres.getText().isEmpty()) {
					txtNombres.setText("Ingrese Nombres");
					txtNombres.setForeground(Color.GRAY);
				}
				if (txtDocumento.getText().isEmpty()) {
					txtDocumento.setText("Ingrese Documento");
					txtDocumento.setForeground(Color.GRAY);
				}
				if (txtEmail.getText().isEmpty()) {
					txtEmail.setText("Ingrese Email");
					txtEmail.setForeground(Color.GRAY);
				}
				if (txtTelefono.getText().isEmpty()) {
					txtTelefono.setText("Ingrese Teléfono");
					txtTelefono.setForeground(Color.GRAY);
				}
				if (txtEmail_Institucional.getText().isEmpty()) {
					txtEmail_Institucional.setText("Email Institucional");
					txtEmail_Institucional.setForeground(Color.GRAY);
				}
				if (pwdIngresarContrasea.getText().isEmpty()) {
					pwdIngresarContrasea.setText("Contraseña");
					pwdIngresarContrasea.setForeground(Color.GRAY);
				}
				if (txtIngreseLocalidad.getText().isEmpty()) {
					txtIngreseLocalidad.setText("Ingrese Localidad");
					txtIngreseLocalidad.setForeground(Color.GRAY);
				}
				if (txtIngreseArea.getText().isEmpty()) {
					txtIngreseArea.setText("Ingrese Área");
					txtIngreseArea.setForeground(Color.GRAY);
				}
			}
		});
		txtApellidos.setBorder(null);
		txtApellidos.setText("Ingrese Apellidos");
		txtApellidos.setForeground(new Color(102, 102, 102));
		txtApellidos.setFont(new Font("Arial", Font.PLAIN, 11));
		txtApellidos.setDisabledTextColor(Color.LIGHT_GRAY);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(138, 175, 118, 20);
		contentPane.add(txtApellidos);

		txtDocumento = new JTextField();
		txtDocumento.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtDocumento.getText().equals("Ingrese Documento")) {
					txtDocumento.setText("");
					txtDocumento.setForeground(Color.BLACK);
				}
				if (txtNombres.getText().isEmpty()) {
					txtNombres.setText("Ingrese Nombres");
					txtNombres.setForeground(Color.GRAY);
				}
				if (txtApellidos.getText().isEmpty()) {
					txtApellidos.setText("Ingrese Apellidos");
					txtApellidos.setForeground(Color.GRAY);
				}
				if (txtEmail.getText().isEmpty()) {
					txtEmail.setText("Ingrese Email");
					txtEmail.setForeground(Color.GRAY);
				}
				if (txtTelefono.getText().isEmpty()) {
					txtTelefono.setText("Ingrese Teléfono");
					txtTelefono.setForeground(Color.GRAY);
				}
				if (txtEmail_Institucional.getText().isEmpty()) {
					txtEmail_Institucional.setText("Email Institucional");
					txtEmail_Institucional.setForeground(Color.GRAY);
				}
				if (pwdIngresarContrasea.getText().isEmpty()) {
					pwdIngresarContrasea.setText("Contraseña");
					pwdIngresarContrasea.setForeground(Color.GRAY);
				}
				if (txtIngreseLocalidad.getText().isEmpty()) {
					txtIngreseLocalidad.setText("Ingrese Localidad");
					txtIngreseLocalidad.setForeground(Color.GRAY);
				}
				if (txtIngreseArea.getText().isEmpty()) {
					txtIngreseArea.setText("Ingrese Área");
					txtIngreseArea.setForeground(Color.GRAY);
				}
			}
		});
		txtDocumento.setBorder(null);
		txtDocumento.setText("Ingrese Documento");
		txtDocumento.setForeground(new Color(102, 102, 102));
		txtDocumento.setFont(new Font("Arial", Font.PLAIN, 11));
		txtDocumento.setDisabledTextColor(Color.LIGHT_GRAY);
		txtDocumento.setColumns(10);
		txtDocumento.setBounds(10, 234, 118, 20);
		contentPane.add(txtDocumento);

		txtEmail_Institucional = new JTextField();
		txtEmail_Institucional.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtEmail_Institucional.getText().equals("Email Institucional")) {
					txtEmail_Institucional.setText("");
					txtEmail_Institucional.setForeground(Color.BLACK);
				}
				if (txtNombres.getText().isEmpty()) {
					txtNombres.setText("Ingrese Nombres");
					txtNombres.setForeground(Color.GRAY);
				}
				if (txtApellidos.getText().isEmpty()) {
					txtApellidos.setText("Ingrese Apellidos");
					txtApellidos.setForeground(Color.GRAY);
				}
				if (txtDocumento.getText().isEmpty()) {
					txtDocumento.setText("Ingrese Documento");
					txtDocumento.setForeground(Color.GRAY);
				}
				if (txtTelefono.getText().isEmpty()) {
					txtTelefono.setText("Ingrese Teléfono");
					txtTelefono.setForeground(Color.GRAY);
				}
				if (txtEmail.getText().isEmpty()) {
					txtEmail.setText("Ingrese Email");
					txtEmail.setForeground(Color.GRAY);
				}
				if (pwdIngresarContrasea.getText().isEmpty()) {
					pwdIngresarContrasea.setText("Contraseña");
					pwdIngresarContrasea.setForeground(Color.GRAY);
				}
				if (txtIngreseLocalidad.getText().isEmpty()) {
					txtIngreseLocalidad.setText("Ingrese Localidad");
					txtIngreseLocalidad.setForeground(Color.GRAY);
				}
				if (txtIngreseArea.getText().isEmpty()) {
					txtIngreseArea.setText("Ingrese Área");
					txtIngreseArea.setForeground(Color.GRAY);
				}
			}
		});
		txtEmail_Institucional.setBorder(null);
		txtEmail_Institucional.setText("Email Institucional");
		txtEmail_Institucional.setForeground(new Color(102, 102, 102));
		txtEmail_Institucional.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtEmail_Institucional.setDisabledTextColor(Color.LIGHT_GRAY);
		txtEmail_Institucional.setColumns(10);
		txtEmail_Institucional.setBounds(138, 401, 95, 20);
		contentPane.add(txtEmail_Institucional);

		primer_Nombre = new JLabel("Nombres");
		primer_Nombre.setFont(new Font("Arial", Font.BOLD, 13));
		primer_Nombre.setForeground(new Color(30, 144, 255));
		primer_Nombre.setBounds(10, 157, 86, 14);
		contentPane.add(primer_Nombre);

		primer_Apellido = new JLabel("Apellidos");
		primer_Apellido.setFont(new Font("Arial", Font.BOLD, 13));
		primer_Apellido.setForeground(new Color(30, 144, 255));
		primer_Apellido.setBounds(138, 158, 118, 14);
		contentPane.add(primer_Apellido);

		cedula_identidad = new JLabel("C.I");
		cedula_identidad.setFont(new Font("Arial", Font.BOLD, 13));
		cedula_identidad.setForeground(new Color(30, 144, 255));
		cedula_identidad.setBounds(10, 214, 118, 14);
		contentPane.add(cedula_identidad);

		email_personal = new JLabel("Email personal");
		email_personal.setFont(new Font("Arial", Font.BOLD, 13));
		email_personal.setForeground(new Color(30, 144, 255));
		email_personal.setBounds(10, 272, 118, 14);
		contentPane.add(email_personal);

		JLabel fecha_nacimiento = new JLabel("Fec. Nacimiento");
		fecha_nacimiento.setFont(new Font("Arial", Font.BOLD, 13));
		fecha_nacimiento.setForeground(new Color(30, 144, 255));
		fecha_nacimiento.setBounds(138, 214, 118, 14);
		contentPane.add(fecha_nacimiento);

		dateFec_Nac.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateFec_Nac.setBorder(null);
		dateFec_Nac.setBounds(138, 239, 118, 22);
		contentPane.add(dateFec_Nac);

		txtEmail = new JTextField();
		txtEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtEmail.getText().equals("Ingrese Email")) {
					txtEmail.setText("");
					txtEmail.setForeground(Color.BLACK);
				}
				if (txtNombres.getText().isEmpty()) {
					txtNombres.setText("Ingrese Nombres");
					txtNombres.setForeground(Color.GRAY);
				}
				if (txtApellidos.getText().isEmpty()) {
					txtApellidos.setText("Ingrese Apellidos");
					txtApellidos.setForeground(Color.GRAY);
				}
				if (txtDocumento.getText().isEmpty()) {
					txtDocumento.setText("Ingrese Documento");
					txtDocumento.setForeground(Color.GRAY);
				}
				if (txtTelefono.getText().isEmpty()) {
					txtTelefono.setText("Ingrese Teléfono");
					txtTelefono.setForeground(Color.GRAY);
				}
				if (txtEmail_Institucional.getText().isEmpty()) {
					txtEmail_Institucional.setText("Email Institucional");
					txtEmail_Institucional.setForeground(Color.GRAY);
				}
				if (pwdIngresarContrasea.getText().isEmpty()) {
					pwdIngresarContrasea.setText("Contraseña");
					pwdIngresarContrasea.setForeground(Color.GRAY);
				}
				if (txtIngreseLocalidad.getText().isEmpty()) {
					txtIngreseLocalidad.setText("Ingrese Localidad");
					txtIngreseLocalidad.setForeground(Color.GRAY);
				}
				if (txtIngreseArea.getText().isEmpty()) {
					txtIngreseArea.setText("Ingrese Área");
					txtIngreseArea.setForeground(Color.GRAY);
				}
			}
		});
		txtEmail.setBorder(null);
		txtEmail.setText("Ingrese Email");
		txtEmail.setForeground(new Color(102, 102, 102));
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 11));
		txtEmail.setDisabledTextColor(Color.LIGHT_GRAY);
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 290, 118, 20);
		contentPane.add(txtEmail);

		txtTelefono = new JTextField();
		txtTelefono.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtTelefono.getText().equals("Ingrese Teléfono")) {
					txtTelefono.setText("");
					txtTelefono.setForeground(Color.BLACK);
				}
				if (txtNombres.getText().isEmpty()) {
					txtNombres.setText("Ingrese Nombres");
					txtNombres.setForeground(Color.GRAY);
				}
				if (txtApellidos.getText().isEmpty()) {
					txtApellidos.setText("Ingrese Apellidos");
					txtApellidos.setForeground(Color.GRAY);
				}
				if (txtDocumento.getText().isEmpty()) {
					txtDocumento.setText("Ingrese Documento");
					txtDocumento.setForeground(Color.GRAY);
				}
				if (txtEmail_Institucional.getText().isEmpty()) {
					txtEmail_Institucional.setText("Email Institucional");
					txtEmail_Institucional.setForeground(Color.GRAY);
				}
				if (txtEmail.getText().isEmpty()) {
					txtEmail.setText("Ingrese Email");
					txtEmail.setForeground(Color.GRAY);
				}
				if (pwdIngresarContrasea.getText().isEmpty()) {
					pwdIngresarContrasea.setText("Contraseña");
					pwdIngresarContrasea.setForeground(Color.GRAY);
				}
				if (txtIngreseLocalidad.getText().isEmpty()) {
					txtIngreseLocalidad.setText("Ingrese Localidad");
					txtIngreseLocalidad.setForeground(Color.GRAY);
				}
				if (txtIngreseArea.getText().isEmpty()) {
					txtIngreseArea.setText("Ingrese Área");
					txtIngreseArea.setForeground(Color.GRAY);
				}
			}
		});
		txtTelefono.setBorder(null);
		txtTelefono.setText("Ingrese Teléfono");
		txtTelefono.setForeground(new Color(102, 102, 102));
		txtTelefono.setFont(new Font("Arial", Font.PLAIN, 11));
		txtTelefono.setDisabledTextColor(Color.LIGHT_GRAY);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(138, 290, 118, 20);
		contentPane.add(txtTelefono);

		telefono_de_contacto = new JLabel("Teléfono");
		telefono_de_contacto.setFont(new Font("Arial", Font.BOLD, 13));
		telefono_de_contacto.setForeground(new Color(30, 144, 255));
		telefono_de_contacto.setBounds(138, 272, 118, 14);
		contentPane.add(telefono_de_contacto);

		departamento = new JLabel("Departamento");
		departamento.setFont(new Font("Arial", Font.BOLD, 13));
		departamento.setForeground(new Color(30, 144, 255));
		departamento.setBounds(266, 270, 118, 14);
		contentPane.add(departamento);

		comboDep.setFont(new Font("Arial", Font.PLAIN, 11));
		comboDep.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar", "Artigas", "Canelones", "Cerro Largo",
				"Colonia", "Durazno", "Flores", "Florida", "Lavalleja", "Maldonado", "Montevideo", "Paysandú",
				"Río Negro", "Rivera", "Rocha", "Salto", "San José", "Soriano", "Tacuarembó", "Treinta y Tres" }));
		comboDep.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboDep.setBorder(null);
		comboDep.setBounds(266, 296, 118, 21);
		contentPane.add(comboDep);

		JLabel email_institucional = new JLabel("Email institucional");
		email_institucional.setFont(new Font("Arial", Font.BOLD, 13));
		email_institucional.setForeground(new Color(30, 144, 255));
		email_institucional.setBounds(138, 381, 118, 14);
		contentPane.add(email_institucional);

		JLabel contrasenia = new JLabel("Contraseña");
		contrasenia.setFont(new Font("Arial", Font.BOLD, 13));
		contrasenia.setForeground(new Color(30, 144, 255));
		contrasenia.setBounds(394, 381, 118, 14);
		contentPane.add(contrasenia);

		comboITR.addItem("Seleccionar");

		for (String itr : RellenarITR()) {
			comboITR.addItem(itr);
		}
		comboITR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboITR.setBorder(null);
		comboITR.setBounds(138, 468, 183, 22);
		contentPane.add(comboITR);

		JLabel itr = new JLabel("ITR");
		itr.setFont(new Font("Arial", Font.BOLD, 13));
		itr.setForeground(new Color(30, 144, 255));
		itr.setBounds(138, 440, 118, 14);
		contentPane.add(itr);

		lblTipoDeUsuario = new JLabel("Tipo de usuario");
		lblTipoDeUsuario.setFont(new Font("Arial", Font.BOLD, 13));
		lblTipoDeUsuario.setForeground(new Color(30, 144, 255));
		lblTipoDeUsuario.setBounds(10, 381, 118, 14);
		contentPane.add(lblTipoDeUsuario);

		JLabel lblAoDeIngreso = new JLabel("Año ingreso");
		lblAoDeIngreso.setFont(new Font("Arial", Font.BOLD, 13));
		lblAoDeIngreso.setForeground(new Color(30, 144, 255));
		lblAoDeIngreso.setBounds(10, 439, 118, 14);
		contentPane.add(lblAoDeIngreso);

		JLabel lblRol = new JLabel("Rol");
		lblRol.setFont(new Font("Arial", Font.BOLD, 13));
		lblRol.setForeground(new Color(30, 144, 255));
		lblRol.setBounds(10, 439, 35, 14);
		contentPane.add(lblRol);

		rdbtnEncargado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnTutor.setSelected(false);
				tipoRol = TipoRol.Encargado;
			}
		});
		rdbtnEncargado.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnEncargado.setBackground(new Color(255, 255, 255));
		rdbtnEncargado.setBounds(51, 441, 86, 23);
		contentPane.add(rdbtnEncargado);

		rdbtnTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnEncargado.setSelected(false);
				tipoRol = TipoRol.Tutor;

			}
		});
		rdbtnTutor.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnTutor.setBackground(new Color(255, 255, 255));
		rdbtnTutor.setBounds(51, 467, 77, 23);
		contentPane.add(rdbtnTutor);

		yearChooser.setBounds(80, 467, 48, 23);
		contentPane.add(yearChooser);

		// lblDominio.setText("@estudiante.utec.edu.uy");
		// lblDominio.setFont(new Font("Arial", Font.PLAIN, 11));
		// lblDominio.setToolTipText("");
		// lblDominio.setBounds(243, 401, 126, 20);
		// contentPane.add(lblDominio);

		comboTipoUsuario = new JComboBox();
		comboTipoUsuario.setFont(new Font("Arial", Font.PLAIN, 11));

		rdbtnEncargado.setVisible(false);
		rdbtnTutor.setVisible(false);
		yearChooser.setVisible(false);
		lblAoDeIngreso.setVisible(false);
		lblRol.setVisible(false);
		lblDominio.setText("@ejemplo.utec.edu.uy");
		lblArea.setVisible(false);
		txtIngreseArea.setVisible(false);
		separator_7_1_1.setVisible(false);

		comboTipoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = (String) comboTipoUsuario.getSelectedItem();

				rdbtnEncargado.setVisible(false);
				rdbtnTutor.setVisible(false);
				yearChooser.setVisible(false);
				lblAoDeIngreso.setVisible(false);
				lblRol.setVisible(false);
				lblDominio.setText("@ejemplo.utec.edu.uy");
				lblArea.setVisible(false);
				txtIngreseArea.setVisible(false);
				separator_7_1_1.setVisible(false);

				if (item.equals("Tutor")) {
					lblRol.setVisible(true);
					rdbtnEncargado.setVisible(true);
					rdbtnTutor.setVisible(true);
					lblDominio.setText("@utec.edu.uy");
					lblArea.setVisible(true);
					txtIngreseArea.setVisible(true);
					separator_7_1_1.setVisible(true);
					lblAoDeIngreso.setVisible(false);
					yearChooser.setVisible(false);
				} else if (item.equals("Estudiante")) {
					lblAoDeIngreso.setVisible(true);
					yearChooser.setVisible(true);
					lblRol.setVisible(false);
					rdbtnEncargado.setVisible(false);
					rdbtnTutor.setVisible(false);
					lblArea.setVisible(false);
					txtIngreseArea.setVisible(false);
					separator_7_1_1.setVisible(false);
					lblDominio.setText("@estudiante.utec.edu.uy");
				} else if (item.equals("Analista")) {
					lblDominio.setText("@utec.edu.uy");
				}
			}
		});

		comboTipoUsuario
				.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar", "Analista", "Tutor", "Estudiante" }));
		comboTipoUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboTipoUsuario.setBorder(null);
		comboTipoUsuario.setBounds(10, 404, 118, 24);
		contentPane.add(comboTipoUsuario);

		lblNewLabel_3 = new JLabel("Datos personales");
		lblNewLabel_3.setForeground(new Color(128, 128, 128));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 124, 160, 22);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_2 = new JLabel("Datos institucionales");
		lblNewLabel_2.setForeground(new Color(128, 128, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 340, 160, 14);
		contentPane.add(lblNewLabel_2);

		panel_1 = new JPanel();
		panel_1.setBounds(212, 78, 300, 24);
		contentPane.add(panel_1);
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(30, 144, 255));
		panel_2.setBounds(10, 38, 322, 24);
		contentPane.add(panel_2);

		textField = new JTextField();
		textField.setBounds(0, 0, -25, -14);
		panel_2.add(textField);
		textField.setColumns(10);

		lblNewLabel_4 = new JLabel("Registro de usuario");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_4.setBackground(Color.DARK_GRAY);
		lblNewLabel_4.setBounds(10, 78, 198, 24);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon(RegistroLoginUsuario.class
				.getResource("/com/imagenes/Logo Utec con simbolo a la derecha 128x128.png")));
		lblNewLabel_5.setBounds(342, 34, 170, 44);
		contentPane.add(lblNewLabel_5);

		comboGenero.setFont(new Font("Arial", Font.PLAIN, 11));
		comboGenero.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar", "Masculino", "Femenino", "Otro" }));
		comboGenero.setBorder(null);
		comboGenero.setBounds(266, 240, 118, 21);
		contentPane.add(comboGenero);

		separator = new JSeparator();
		separator.setForeground(new Color(230, 230, 250));
		separator.setBounds(10, 326, 502, 3);
		contentPane.add(separator);

		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.setFocusable(false);
		btnRegistrarse.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {

					if (comboTipoUsuario.getSelectedItem().equals("Seleccionar")) {

						JOptionPane.showMessageDialog(null, "Seleccione el tipo de Usuario a registrar",
								"Tipo de Usuario no seleccionado!", JOptionPane.WARNING_MESSAGE);
					}

					if (comboTipoUsuario.getSelectedItem().equals("Estudiante")) {

						UsuarioUniqueEstudiante();
					}

					if (comboTipoUsuario.getSelectedItem().equals("Analista")) {

						UsuarioUniqueAnalista();;
					}

					if (comboTipoUsuario.getSelectedItem().equals("Tutor")) {

						UsuarioUniqueTutor();
					}

				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		btnRegistrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarse.setMnemonic(KeyEvent.VK_ENTER);
		btnRegistrarse.setForeground(Color.WHITE);
		btnRegistrarse.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistrarse.setBackground(new Color(0, 191, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistrarse.setBackground(new Color(30, 144, 255));
			}
		});
		btnRegistrarse.setFont(new Font("Arial", Font.BOLD, 11));
		btnRegistrarse.setBorderPainted(false);
		btnRegistrarse.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnRegistrarse.setBackground(new Color(30, 144, 255));
		btnRegistrarse.setBounds(394, 540, 118, 23);
		contentPane.add(btnRegistrarse);

		pwdIngresarContrasea = new JPasswordField();
		pwdIngresarContrasea.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (pwdIngresarContrasea.getText().equals("Contraseña")) {
					pwdIngresarContrasea.setText("");
					pwdIngresarContrasea.setForeground(Color.BLACK);
				}
				if (txtNombres.getText().isEmpty()) {
					txtNombres.setText("Ingrese Nombres");
					txtNombres.setForeground(Color.GRAY);
				}
				if (txtApellidos.getText().isEmpty()) {
					txtApellidos.setText("Ingrese Apellidos");
					txtApellidos.setForeground(Color.GRAY);
				}
				if (txtDocumento.getText().isEmpty()) {
					txtDocumento.setText("Ingrese Documento");
					txtDocumento.setForeground(Color.GRAY);
				}
				if (txtEmail_Institucional.getText().isEmpty()) {
					txtEmail_Institucional.setText("Email Institucional");
					txtEmail_Institucional.setForeground(Color.GRAY);
				}
				if (txtEmail.getText().isEmpty()) {
					txtEmail.setText("Ingrese Email");
					txtEmail.setForeground(Color.GRAY);
				}
				if (txtTelefono.getText().isEmpty()) {
					txtTelefono.setText("Ingrese Teléfono");
					txtTelefono.setForeground(Color.GRAY);
				}
				if (txtIngreseLocalidad.getText().isEmpty()) {
					txtIngreseLocalidad.setText("Ingrese Localidad");
					txtIngreseLocalidad.setForeground(Color.GRAY);
				}
				if (txtIngreseArea.getText().isEmpty()) {
					txtIngreseArea.setText("Ingrese Área");
					txtIngreseArea.setForeground(Color.GRAY);
				}
			}
		});
		pwdIngresarContrasea.setBorder(null);
		pwdIngresarContrasea.setText("Contraseña");
		pwdIngresarContrasea.setBounds(394, 401, 79, 20);
		contentPane.add(pwdIngresarContrasea);

		lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setForeground(new Color(30, 144, 255));
		lblLocalidad.setFont(new Font("Arial", Font.BOLD, 13));
		lblLocalidad.setBounds(394, 270, 118, 14);
		contentPane.add(lblLocalidad);

		JLabel lblGnero = new JLabel("Género");
		lblGnero.setForeground(new Color(30, 144, 255));
		lblGnero.setFont(new Font("Arial", Font.BOLD, 13));
		lblGnero.setBounds(266, 214, 118, 14);
		contentPane.add(lblGnero);

		txtIngreseLocalidad = new JTextField();
		txtIngreseLocalidad.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtIngreseLocalidad.getText().equals("Ingrese Localidad")) {
					txtIngreseLocalidad.setText("");
					txtIngreseLocalidad.setForeground(Color.BLACK);
				}
				if (txtNombres.getText().isEmpty()) {
					txtNombres.setText("Ingrese Nombres");
					txtNombres.setForeground(Color.GRAY);
				}
				if (txtApellidos.getText().isEmpty()) {
					txtApellidos.setText("Ingrese Apellidos");
					txtApellidos.setForeground(Color.GRAY);
				}
				if (txtDocumento.getText().isEmpty()) {
					txtDocumento.setText("Ingrese Documento");
					txtDocumento.setForeground(Color.GRAY);
				}
				if (txtEmail_Institucional.getText().isEmpty()) {
					txtEmail_Institucional.setText("Email Institucional");
					txtEmail_Institucional.setForeground(Color.GRAY);
				}
				if (txtEmail.getText().isEmpty()) {
					txtEmail.setText("Ingrese Email");
					txtEmail.setForeground(Color.GRAY);
				}
				if (txtTelefono.getText().isEmpty()) {
					txtTelefono.setText("Ingrese Teléfono");
					txtTelefono.setForeground(Color.GRAY);
				}
				if (pwdIngresarContrasea.getText().isEmpty()) {
					pwdIngresarContrasea.setText("Contraseña");
					pwdIngresarContrasea.setForeground(Color.GRAY);
				}
				if (txtIngreseArea.getText().isEmpty()) {
					txtIngreseArea.setText("Ingrese Área");
					txtIngreseArea.setForeground(Color.GRAY);
				}
			}
		});
		txtIngreseLocalidad.setText("Ingrese Localidad");
		txtIngreseLocalidad.setForeground(new Color(102, 102, 102));
		txtIngreseLocalidad.setFont(new Font("Arial", Font.PLAIN, 11));
		txtIngreseLocalidad.setDisabledTextColor(Color.LIGHT_GRAY);
		txtIngreseLocalidad.setColumns(10);
		txtIngreseLocalidad.setBorder(null);
		txtIngreseLocalidad.setBounds(394, 290, 118, 20);
		contentPane.add(txtIngreseLocalidad);

		JSeparator separator_7_1 = new JSeparator();
		separator_7_1.setForeground(Color.GRAY);
		separator_7_1.setBackground(Color.GRAY);
		separator_7_1.setBounds(394, 315, 118, 2);
		contentPane.add(separator_7_1);

		JLabel lblNewLabel = new JLabel("@utec.edu.uy");
		lblNewLabel.setBounds(273, 401, 143, 20);
		contentPane.add(lblNewLabel);

		lblArea.setForeground(new Color(30, 144, 255));
		lblArea.setFont(new Font("Arial", Font.BOLD, 13));
		lblArea.setBounds(10, 497, 118, 14);
		contentPane.add(lblArea);

		txtIngreseArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtIngreseArea.getText().equals("Ingrese Área")) {
					txtIngreseArea.setText("");
					txtIngreseArea.setForeground(Color.BLACK);
				}
				if (txtNombres.getText().isEmpty()) {
					txtNombres.setText("Ingrese Nombres");
					txtNombres.setForeground(Color.GRAY);
				}
				if (txtApellidos.getText().isEmpty()) {
					txtApellidos.setText("Ingrese Apellidos");
					txtApellidos.setForeground(Color.GRAY);
				}
				if (txtDocumento.getText().isEmpty()) {
					txtDocumento.setText("Ingrese Documento");
					txtDocumento.setForeground(Color.GRAY);
				}
				if (txtEmail_Institucional.getText().isEmpty()) {
					txtEmail_Institucional.setText("Email Institucional");
					txtEmail_Institucional.setForeground(Color.GRAY);
				}
				if (txtEmail.getText().isEmpty()) {
					txtEmail.setText("Ingrese Email");
					txtEmail.setForeground(Color.GRAY);
				}
				if (txtTelefono.getText().isEmpty()) {
					txtTelefono.setText("Ingrese Teléfono");
					txtTelefono.setForeground(Color.GRAY);
				}
				if (pwdIngresarContrasea.getText().isEmpty()) {
					pwdIngresarContrasea.setText("Contraseña");
					pwdIngresarContrasea.setForeground(Color.GRAY);
				}
				if (txtIngreseLocalidad.getText().isEmpty()) {
					txtIngreseLocalidad.setText("Ingrese Localidad");
					txtIngreseLocalidad.setForeground(Color.GRAY);
				}
			}
		});
		txtIngreseArea.setText("Ingrese Área");
		txtIngreseArea.setForeground(new Color(102, 102, 102));
		txtIngreseArea.setFont(new Font("Arial", Font.PLAIN, 11));
		txtIngreseArea.setDisabledTextColor(Color.LIGHT_GRAY);
		txtIngreseArea.setColumns(10);
		txtIngreseArea.setBorder(null);
		txtIngreseArea.setBounds(10, 517, 118, 20);
		contentPane.add(txtIngreseArea);

		separator_7_1_1.setForeground(Color.GRAY);
		separator_7_1_1.setBackground(Color.GRAY);
		separator_7_1_1.setBounds(10, 542, 118, 2);
		contentPane.add(separator_7_1_1);
		rbtnVerContra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		rbtnVerContra.setBackground(Color.WHITE);
		rbtnVerContra.setToolTipText("Mostrar contraseña");
		rbtnVerContra.setIcon(new ImageIcon(PDU_Actualizar.class.getResource("/com/iconos/ojo.png")));
		rbtnVerContra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				verContrasenia();
			}

		});
		rbtnVerContra.setBounds(479, 401, 33, 23);
		contentPane.add(rbtnVerContra);

	}

	protected void verContrasenia() {
		if (rbtnVerContra.isSelected()) {
			pwdIngresarContrasea.setEchoChar((char) 0);
			rbtnVerContra.setIcon(new ImageIcon(PDU_Actualizar.class.getResource("/com/iconos/ojos-cruzados.png")));
			rbtnVerContra.setToolTipText("Ocultar contraseña");
		} else {
			pwdIngresarContrasea.setEchoChar('*');
			rbtnVerContra.setIcon(new ImageIcon(PDU_Actualizar.class.getResource("/com/iconos/ojo.png")));
			rbtnVerContra.setToolTipText("Mostrar contraseña");
		}

	}

	protected void registrarEstudiante() throws ServiciosException {

		if (txtNombres.getText().equals("Ingrese Nombres")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Nombre'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}
		
		else if (!PASSWORD_PATTERN.matcher(pwdIngresarContrasea.getText()).matches()) {
			JOptionPane.showMessageDialog(null, " 'Contraseña' no anda         ",
					"Contraseña' no anda           ", JOptionPane.WARNING_MESSAGE);
		}

		else if (txtApellidos.getText().equals("Ingrese Apellidos")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Apellido'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (txtDocumento.getText().equals("Ingrese Documento")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Documento C.I' ", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (dateFec_Nac.getDate()==null) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Fecha' ", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}	

		else if (comboGenero.getSelectedItem().equals("Seleccionar")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Género'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (txtEmail.getText().equals("Ingrese Email")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Email personal'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (txtTelefono.getText().equals("Ingrese Teléfono")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Teléfono'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (comboDep.getSelectedItem().equals("Seleccionar")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Departamento'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (txtIngreseLocalidad.getText().equals("Ingrese Localidad")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Localidad'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (txtEmail_Institucional.getText().equals("Email Institucional")) {
			JOptionPane.showMessageDialog(null, "Falta completar campo 'Email institucional'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (!txtEmail_Institucional.getText().contains("@estudiantes.utec.edu.uy")) {
			JOptionPane.showMessageDialog(null, "El correo debe contener el dominio de @estudiantes.utec.edu.uy",
					"Datos incompletos!", JOptionPane.WARNING_MESSAGE);
		}

		else if (pwdIngresarContrasea.getText().equals("Contraseña")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Contraseña'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (comboITR.getSelectedItem().equals("Seleccionar")) {
			JOptionPane.showMessageDialog(null, "Seleccione un ITR para registrar el usuario", "ITR no seleccionado",
					JOptionPane.WARNING_MESSAGE);
		}

		// Específico de Estudiante

		else if (yearChooser.getYear() > 2022) {
			JOptionPane.showMessageDialog(null, "La fecha de ingreso del estudiante no puede ser mayor al año actual",
					"Fecha de ingreso no disponible", JOptionPane.WARNING_MESSAGE);
		}

		// Control caracteres mínimos y máximos

		else if (txtNombres.getText().length() > 30 || txtNombres.getText().length() < 4) {
			JOptionPane.showMessageDialog(null,
					" Largo del campo Nombre debe estar comprendido entre 4 y 30 caracteres.",
					"Nombre no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);
		}

		else if (txtDocumento.getText().length() > 8 || txtDocumento.getText().length() <7) {
			JOptionPane.showMessageDialog(null, " Documento / C.I debe contener 7 u 8 números  =(   ",
					"Documento no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);

		}

		else if (txtTelefono.getText().length() > 20 || txtTelefono.getText().length() < 8) {
			JOptionPane.showMessageDialog(null, " 'Teléfono' debe contener entre 8 - 20 números ",
					"Teléfono no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);

		}

		else if (txtIngreseLocalidad.getText().length() > 30 || txtIngreseLocalidad.getText().length() < 3) {
			JOptionPane.showMessageDialog(null, " 'Localidad' debe contener entre 3 - 30 caracteres ",
					"Localidad no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);

		}

		else if (txtEmail.getText().length() > 500 || txtEmail.getText().length() < 6) {
			JOptionPane.showMessageDialog(null, " 'Email personal' debe contener entre 5 - 500 caracteres ",
					"Email personal no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);

		}

		else if (txtEmail_Institucional.getText().length() > 500 || txtEmail_Institucional.getText().length() < 6) {
			JOptionPane.showMessageDialog(null, " 'Email institucional' debe contener entre 5 - 500 caracteres ",
					"Email institucional no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);

		}

		else if (pwdIngresarContrasea.getText().length() > 100 || pwdIngresarContrasea.getText().length() < 7) {
			JOptionPane.showMessageDialog(null, " 'Contraseña' debe contener entre 6 - 100 caracteres ",
					"Contraseña no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);
		}

		else if (PASSWORD_PATTERN.matcher(pwdIngresarContrasea.getText()).matches()) {
				JOptionPane.showMessageDialog(null, " 'Contraseña' no anda         ",
						"Contraseña' no anda           ", JOptionPane.WARNING_MESSAGE);
			}
			
			
		

		// // Control caracteres mínimos y máximos //

		else {
			String CI = txtDocumento.getText(); // "12345672"

			if (CI.length() == 7) {
				CI = "0" + CI;
			}

			int d = CI.charAt(CI.length() - 1);
			int digitoVerificar = Character.getNumericValue(d);

			String codigoMultiplicador = "2987634";
			int acumulador = 0; // 2 -> 20

			for (int i = 0; i < CI.length() - 1; i++) {//
				acumulador += Character.getNumericValue(CI.charAt(i))
						* Character.getNumericValue(codigoMultiplicador.charAt(i));

			}

			int digitoVerificador = (10 - (acumulador % 10)) % 10;

			if (digitoVerificar == digitoVerificador) {

				ITR itrs = itrBean.obtenerTodosITRPorNombre((String) comboITR.getSelectedItem());
				String mailInsti = txtEmail_Institucional.getText();

				if (mailInsti.contains("utec.edu.uy")) {

				} else {

					// Falta arreglar esto
					// JOptionPane.showMessageDialog(null,
					// "El correo debe contener el dominio correspondiente al tipo de usuario");

				}
				String[] parte = txtEmail_Institucional.getText().split("@");
				String parte1 = parte[0];

				EstudianteDTO estudiante = new EstudianteDTO();

				estudiante.setNombre(txtNombres.getText());
				estudiante.setApellido(txtApellidos.getText());
				estudiante.setDocumento(Integer.parseInt(txtDocumento.getText()));
				estudiante.setDepartamento((String) comboDep.getSelectedItem());
				estudiante.setTelefono(txtTelefono.getText());
				estudiante.setNombreUsuario(parte1);
				estudiante.setGenero((String) comboGenero.getSelectedItem());

				estudiante.setLocalidad(txtIngreseLocalidad.getText());
				estudiante.setMail(txtEmail.getText());
				estudiante.setMailInstitucional(mailInsti);
				estudiante.setFechaNac(dateFec_Nac.getDate());
				// Falta controlar FecNac

				estudiante.setContrasenia(pwdIngresarContrasea.getText());
				estudiante.setItr(itrs);
				estudiante.setEstadoUsuario(EstadoUsuario.SinValidar);
				estudiante.setTipoUsuario(TipoUsuario.Estudiante);
				estudiante.setEstadoEstudiante(EstadoEstudiante.Activo);
				estudiante.setAñoIngreso(String.valueOf(yearChooser.getYear()));

				try {
					estudianteBean.crearEstudiante(estudiante);

					JOptionPane.showMessageDialog(null,
							"El Usuario se ha creado exitosamente, el usuario estara pendiente de verificacion");

				} catch (ServiciosException f) {
					// TODO Auto-generated catch block
					System.out.println(f.getMessage());
				}
				dispose();

				Login frame = new Login();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

			} else {
				JOptionPane.showMessageDialog(null, "La cedula Ingresada no es correcta, intentelo nuevamente");
			}}
		}

	

	protected void registrarAnalista() throws ServiciosException {

		if (txtNombres.getText().equals("Ingrese Nombres")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Nombre'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (txtApellidos.getText().equals("Ingrese Apellidos")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Apellido'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (txtDocumento.getText().equals("Ingrese Documento")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Documento / C.I'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (dateFec_Nac.getDate()==null) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Fecha' ", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}	

		else if (comboGenero.getSelectedItem().equals("Seleccionar")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Género'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (txtEmail.getText().equals("Ingrese Email")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Email personal'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (txtTelefono.getText().equals("Ingrese Teléfono")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Teléfono'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (comboDep.getSelectedItem().equals("Seleccionar")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Departamento'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (txtIngreseLocalidad.getText().equals("Ingrese Localidad")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Localidad'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (txtEmail_Institucional.getText().equals("Email Institucional")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Email institucional'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (!txtEmail_Institucional.getText().contains("@utec.edu.uy")) {
			JOptionPane.showMessageDialog(null, "El correo debe contener el dominio de @utec.edu.uy",
					"Datos incompletos!", JOptionPane.WARNING_MESSAGE);
		}

		else if (pwdIngresarContrasea.getText().equals("Contraseña")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Contraseña'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (comboITR.getSelectedItem().equals("Seleccionar")) {
			JOptionPane.showMessageDialog(null, "Seleccione un ITR para registrar el usuario", "ITR no seleccionado",
					JOptionPane.WARNING_MESSAGE);
		}

		// Control de datos vacios

		//
		// Control caracteres mínimos y máximos
		//
		else if (txtNombres.getText().length() > 30 || txtNombres.getText().length() < 4) {
			JOptionPane.showMessageDialog(null,
					" Largo del campo Nombre debe estar comprendido entre 4 y 30 caracteres.",
					"Nombre no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);
		}

		else if (txtDocumento.getText().length() > 8 || txtDocumento.getText().length() < 7) {
			JOptionPane.showMessageDialog(null, " Documento / C.I debe contener 7 u 8 números  =(   ",
					"Documento no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);

		}

		else if (txtTelefono.getText().length() > 20 || txtTelefono.getText().length() < 8) {
			JOptionPane.showMessageDialog(null, " 'Teléfono' debe contener entre 8 - 20 números ",
					"Teléfono no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);

		}

		else if (txtIngreseLocalidad.getText().length() > 30 || txtIngreseLocalidad.getText().length() < 3) {
			JOptionPane.showMessageDialog(null, " 'Localidad' debe contener entre 3 - 30 caracteres ",
					"Localidad no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);

		}

		else if (txtEmail.getText().length() > 500 || txtEmail.getText().length() < 6) {
			JOptionPane.showMessageDialog(null, " 'Email personal' debe contener entre 5 - 500 caracteres ",
					"Email personal no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);

		}

		else if (txtEmail_Institucional.getText().length() > 500 || txtEmail_Institucional.getText().length() < 6) {
			JOptionPane.showMessageDialog(null, " 'Email institucional' debe contener entre 5 - 500 caracteres ",
					"Email institucional no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);

		}

		else if (pwdIngresarContrasea.getText().length() > 100 || pwdIngresarContrasea.getText().length() < 7) {
			JOptionPane.showMessageDialog(null, " 'Contraseña' debe contener entre 6 - 100 caracteres ",
					"Contraseña no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);

		}

		//
		// Control caracteres mínimos y máximos
		//
		else {

			String CI = txtDocumento.getText(); // "12345672"

			if (CI.length() == 7) {
				CI = "0" + CI;
			}

			int d = CI.charAt(CI.length() - 1);
			int digitoVerificar = Character.getNumericValue(d);

			String codigoMultiplicador = "2987634";
			int acumulador = 0; // 2 -> 20

			for (int i = 0; i < CI.length() - 1; i++) {//
				acumulador += Character.getNumericValue(CI.charAt(i))
						* Character.getNumericValue(codigoMultiplicador.charAt(i));

			}
			//comentario
			int digitoVerificador = (10 - (acumulador % 10)) % 10;

			if (digitoVerificar == digitoVerificador) {
				ITR itrs = itrBean.obtenerTodosITRPorNombre((String) comboITR.getSelectedItem());
				String mailInsti = txtEmail_Institucional.getText() + lblDominio.getText();

				String[] parte = txtEmail_Institucional.getText().split("@");
				String parte1 = parte[0];

				AnalistaDTO analista = new AnalistaDTO();

				analista.setNombre(txtNombres.getText());
				analista.setApellido(txtApellidos.getText());
				analista.setDocumento(Integer.parseInt(txtDocumento.getText()));
				analista.setDepartamento((String) comboDep.getSelectedItem());
				analista.setTelefono(txtTelefono.getText());
				analista.setNombreUsuario(parte1);
				analista.setGenero((String) comboGenero.getSelectedItem());
				analista.setLocalidad(txtIngreseLocalidad.getText());
				analista.setMail(txtEmail.getText());
				analista.setMailInstitucional(mailInsti);
				analista.setFechaNac(dateFec_Nac.getDate());
				analista.setContrasenia(pwdIngresarContrasea.getText());
				analista.setItr(itrs);
				analista.setEstadoUsuario(EstadoUsuario.SinValidar);
				analista.setTipoUsuario(TipoUsuario.Analista);

				try {
					analistaBean.crearAnalista(analista);

					JOptionPane.showMessageDialog(null,
							"El Usuario se ha creado exitosamente, el usuario estara pendiente de verificacion");

				} catch (ServiciosException f) {
					System.out.println(f.getMessage());
				}
				dispose();

				Login frame = new Login();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

			} else {
				JOptionPane.showMessageDialog(null, "La cedula Ingresada no es correcta, intentelo nuevamente");
			}

		}
	}

	protected void registrarTutor() throws ServiciosException {

		if (txtNombres.getText().equals("Ingrese Nombres")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Nombre'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (txtApellidos.getText().equals("Ingrese Apellidos")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Apellido'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (txtDocumento.getText().equals("Ingrese Documento")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Documento /C.I'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (dateFec_Nac.getDate()==null) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Fecha' ", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}	
		

		else if (comboGenero.getSelectedItem().equals("Seleccionar")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Género'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (txtEmail.getText().equals("Ingrese Email")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Email personal'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (txtTelefono.getText().equals("Ingrese Teléfono")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Teléfono'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (comboDep.getSelectedItem().equals("Seleccionar")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Departamento'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (txtIngreseLocalidad.getText().equals("Ingrese Localidad")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Localidad'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (txtEmail_Institucional.getText().equals("Email Institucional")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Email institucional'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (!txtEmail_Institucional.getText().contains("@utec.edu.uy")) {
			JOptionPane.showMessageDialog(null, "El correo debe contener el dominio de @utec.edu.uy",
					"Datos incompletos!", JOptionPane.WARNING_MESSAGE);
		}

		else if (pwdIngresarContrasea.getText().equals("Contraseña")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Contraseña'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (comboITR.getSelectedItem().equals("Seleccionar")) {
			JOptionPane.showMessageDialog(null, "Seleccione un ITR para registrar el usuario", "ITR no seleccionado",
					JOptionPane.WARNING_MESSAGE);
		}

		// Específico de Usuario Tutor
		else if (!rdbtnEncargado.isSelected() && !rdbtnTutor.isSelected()) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un rol", "Rol no seleccionado!",
					JOptionPane.WARNING_MESSAGE);
		}
		// Control de datos vacios

		//
		// Control caracteres mínimos y máximos
		//

		else if (txtNombres.getText().length() > 30 || txtNombres.getText().length() < 4) {
			JOptionPane.showMessageDialog(null,
					" Largo del campo Nombre debe estar comprendido entre 4 y 30 caracteres.",
					"Nombre no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);
		}
		
		else if (txtApellidos.getText().length() > 30 || txtApellidos.getText().length() < 4) {
			JOptionPane.showMessageDialog(null,
					" Largo del campo Apellido debe estar comprendido entre 4 y 30 caracteres.",
					"Apellido no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);
		}

		else if (txtDocumento.getText().length() > 8 || txtDocumento.getText().length() < 7) {
			JOptionPane.showMessageDialog(null, " Documento / C.I debe contener 7 u 8 números  =(   ",
					"Documento no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);

		}

		else if (txtTelefono.getText().length() > 20 || txtTelefono.getText().length() < 8) {
			JOptionPane.showMessageDialog(null, " 'Teléfono' debe contener entre 8 - 20 números ",
					"Teléfono no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);

		}

		else if (txtIngreseLocalidad.getText().length() > 30 || txtIngreseLocalidad.getText().length() < 3) {
			JOptionPane.showMessageDialog(null, " 'Localidad' debe contener entre 3 - 30 caracteres ",
					"Localidad no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);

		}

		else if (txtEmail.getText().length() > 500 || txtEmail.getText().length() < 6) {
			JOptionPane.showMessageDialog(null, " 'Email personal' debe contener entre 5 - 500 caracteres ",
					"Email personal no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);

		}

		else if (txtEmail_Institucional.getText().length() > 500 || txtEmail_Institucional.getText().length() < 6) {
			JOptionPane.showMessageDialog(null, " 'Email institucional' debe contener entre 5 - 500 caracteres ",
					"Email institucional no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);

		}

		else if (pwdIngresarContrasea.getText().length() > 100 || pwdIngresarContrasea.getText().length() < 7) {
			JOptionPane.showMessageDialog(null, " 'Contraseña' debe contener entre 6 - 100 caracteres ",
					"Contraseña no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);

		}

		// Específico de Usuario Tutor
		else if (txtIngreseArea.getText().length() > 20 || txtIngreseArea.getText().length() < 1) {
			JOptionPane.showMessageDialog(null, " 'Área' debe contener entre 1 - 20 caracteres ",
					"Área no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);
		}

		//
		// Control caracteres mínimos y máximos
		//

		else {
			String CI = txtDocumento.getText(); // "12345672"

			if (CI.length() == 7) {
				CI = "0" + CI;
			}

			int d = CI.charAt(CI.length() - 1);
			int digitoVerificar = Character.getNumericValue(d);

			String codigoMultiplicador = "2987634";
			int acumulador = 0; // 2 -> 20

			for (int i = 0; i < CI.length() - 1; i++) {//
				acumulador += Character.getNumericValue(CI.charAt(i))
						* Character.getNumericValue(codigoMultiplicador.charAt(i));

			}

			int digitoVerificador = (10 - (acumulador % 10)) % 10;

			if (digitoVerificar == digitoVerificador) {
				ITR itrs = itrBean.obtenerTodosITRPorNombre((String) comboITR.getSelectedItem());
				String mailInsti = txtEmail_Institucional.getText() + lblDominio.getText();

				if (mailInsti.contains("utec.edu.uy")) {

				} else {
					JOptionPane.showMessageDialog(null,
							"El correo debe contener el dominio correspondiente al tipo de usuario");

				}
				String[] parte = txtEmail_Institucional.getText().split("@");
				String parte1 = parte[0];

				TutorDTO tutor = new TutorDTO();

				tutor.setNombre(txtNombres.getText());
				tutor.setApellido(txtApellidos.getText());
				tutor.setDocumento(Integer.parseInt(txtDocumento.getText()));
				tutor.setDepartamento((String) comboDep.getSelectedItem());
				tutor.setTelefono(txtTelefono.getText());
				tutor.setNombreUsuario(parte1);
				tutor.setGenero((String) comboGenero.getSelectedItem());
				tutor.setLocalidad(txtIngreseLocalidad.getText());
				tutor.setMail(txtEmail.getText());
				tutor.setMailInstitucional(mailInsti);
				tutor.setFechaNac(dateFec_Nac.getDate());
				tutor.setContrasenia(pwdIngresarContrasea.getText());
				tutor.setItr(itrs);
				tutor.setEstadoUsuario(EstadoUsuario.SinValidar);
				tutor.setTipoUsuario(TipoUsuario.Tutor);
				tutor.setTipoRol(tipoRol);

				tutor.setArea(txtIngreseArea.getText());
				try {
					tutorBean.crearTutor(tutor);

					JOptionPane.showMessageDialog(null,
							"El Usuario se ha creado exitosamente, el usuario estara pendiente de verificacion");

				} catch (ServiciosException f) {
					System.out.println(f.getMessage());
				}
			} else {
				JOptionPane.showMessageDialog(null, "La cedula Ingresada no es correcta, intentelo nuevamente");
			}
		}

	}

	private List<String> RellenarITR() {
		List<String> nombreITR = new ArrayList<>();
		try {
			nombreITR = itrBean.obtenerTodosITR().stream().map(e -> e.getNombre()).collect(Collectors.toList());
		} catch (ServiciosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombreITR;
	}
	void UsuarioUniqueAnalista() throws ServiciosException {
		List<Usuario> uSUA = usuarioBean.obtenerTodosUsuarios();

		for (Usuario usu : uSUA) {
			int asd = Integer.parseInt(txtDocumento.getText());

			if (usu.getDocumento() == asd) {
				JOptionPane.showMessageDialog(null, "Cedula de identidad ya registrada", "Intetente nuevamente",
						JOptionPane.WARNING_MESSAGE);
			} else {
				registrarAnalista();

			}
		}
	}
	void UsuarioUniqueEstudiante() throws ServiciosException {
		List<Usuario> uSUA = usuarioBean.obtenerTodosUsuarios();

		for (Usuario usu : uSUA) {
			int asd = Integer.parseInt(txtDocumento.getText());

			if (usu.getDocumento() == asd) {
				JOptionPane.showMessageDialog(null, "Cedula de identidad ya registrada", "Intetente nuevamente",
						JOptionPane.WARNING_MESSAGE);
			} else {
				registrarEstudiante();

			}
		}
	}
	void UsuarioUniqueTutor() throws ServiciosException {
		List<Usuario> uSUA = usuarioBean.obtenerTodosUsuarios();

		for (Usuario usu : uSUA) {
			int asd = Integer.parseInt(txtDocumento.getText());

			if (usu.getDocumento() == asd) {
				JOptionPane.showMessageDialog(null, "Cedula de identidad ya registrada", "Intetente nuevamente",
						JOptionPane.WARNING_MESSAGE);
			} else {
				registrarTutor();

			}
		}
	}
}