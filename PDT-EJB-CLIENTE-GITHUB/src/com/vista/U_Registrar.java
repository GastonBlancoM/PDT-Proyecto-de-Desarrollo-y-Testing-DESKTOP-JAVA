package com.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
import com.servicios.UsuarioBean;
import com.servicios.UsuarioBeanCliente;
import com.servicios.UsuarioBeanImp;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import javax.swing.JScrollPane;

public class U_Registrar extends JPanel {

	private JPanel contentPane;
	private JPanel panel;
	private JButton exitBtn;
	private JButton btnRegistrarse;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private JTextField textField_6;

	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDocumento;
	private JTextField txtEmail_Institucional;

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
	private JPasswordField pwdIngresarContrasea;
	private JLabel lblLocalidad;
	private JTextField txtIngreseLocalidad;
	private JRadioButton rdbtnEncargado;
	private JRadioButton rdbtnTutor;
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
	private UsuarioBeanCliente usuarioBean = new UsuarioBeanImp();
	private JLabel lblArea = new JLabel("Área");
	private JTextField txtIngreseArea = new JTextField();
	private JSeparator separator_7_1 = new JSeparator();
	private TipoRol tipoRol;
	private JTextField textField_7;
	JRadioButton rbtnVerContra = new JRadioButton("");
	private static String PASSWORD_REGEX = "^(?:(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|"
			+ "(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|" + "(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|"
			+ "(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))(?!.*(.)\\1{2,})"
			+ "[A-Za-z0-9!~<>,;:_=?*+#.\"&§%°()\\|\\[\\]\\-\\$\\^\\@\\/]" + "{6,100}$";
	private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

	// comentario
	public U_Registrar() {
		setLayout(new BorderLayout(0, 0));

		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(Color.WHITE);
		add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panelCentro.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel(" Registro de usuario ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBackground(Color.DARK_GRAY);
		panel_1.add(lblNewLabel, BorderLayout.WEST);

		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 5));
		panel_1.add(lblNewLabel_1, BorderLayout.NORTH);

		JLabel lblNewLabel_2 = new JLabel("  ");
		lblNewLabel_2.setBackground(new Color(0, 102, 255));
		lblNewLabel_2.setOpaque(true);
		panel_1.add(lblNewLabel_2, BorderLayout.CENTER);

		JLabel lblNewLabel_4 = new JLabel(" ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 5));
		panel_1.add(lblNewLabel_4, BorderLayout.SOUTH);

		JLabel lblNewLabel_5 = new JLabel("  ");
		panel_1.add(lblNewLabel_5, BorderLayout.EAST);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panelCentro.add(panel_2);
		panel_2.setLayout(null);

		separator_10 = new JSeparator();
		separator_10.setForeground(new Color(230, 230, 250));
		separator_10.setBounds(10, 11, 502, 3);
		panel_2.add(separator_10);

		separator_9 = new JSeparator();
		separator_9.setForeground(Color.GRAY);
		separator_9.setBackground(Color.GRAY);
		separator_9.setBounds(331, 323, 118, 3);
		panel_2.add(separator_9);

		separator_8 = new JSeparator();
		separator_8.setForeground(Color.GRAY);
		separator_8.setBackground(Color.GRAY);
		separator_8.setBounds(138, 323, 183, 3);
		panel_2.add(separator_8);

		separator_6 = new JSeparator();
		separator_6.setForeground(Color.GRAY);
		separator_6.setBackground(Color.GRAY);
		separator_6.setBounds(10, 213, 118, 2);
		panel_2.add(separator_6);

		separator_7 = new JSeparator();
		separator_7.setForeground(Color.GRAY);
		separator_7.setBackground(Color.GRAY);
		separator_7.setBounds(138, 213, 118, 2);
		panel_2.add(separator_7);

		separator_5 = new JSeparator();
		separator_5.setForeground(Color.GRAY);
		separator_5.setBackground(Color.GRAY);
		separator_5.setBounds(10, 157, 118, 2);
		panel_2.add(separator_5);

		separator_1 = new JSeparator();
		separator_1.setBackground(new Color(128, 128, 128));
		separator_1.setForeground(new Color(128, 128, 128));
		separator_1.setBounds(10, 99, 118, 2);
		panel_2.add(separator_1);

		separator_3 = new JSeparator();
		separator_3.setBackground(new Color(128, 128, 128));
		separator_3.setForeground(new Color(128, 128, 128));
		separator_3.setBounds(138, 98, 118, 3);
		panel_2.add(separator_3);

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
		txtNombres.setBounds(10, 74, 118, 20);
		panel_2.add(txtNombres);
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
		txtApellidos.setBounds(138, 73, 118, 20);
		panel_2.add(txtApellidos);

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
		txtDocumento.setBounds(10, 132, 118, 20);
		panel_2.add(txtDocumento);

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
		txtEmail_Institucional.setBounds(138, 299, 95, 20);
		panel_2.add(txtEmail_Institucional);

		primer_Nombre = new JLabel("Nombres");
		primer_Nombre.setFont(new Font("Arial", Font.BOLD, 13));
		primer_Nombre.setForeground(new Color(30, 144, 255));
		primer_Nombre.setBounds(10, 55, 86, 14);
		panel_2.add(primer_Nombre);

		primer_Apellido = new JLabel("Apellidos");
		primer_Apellido.setFont(new Font("Arial", Font.BOLD, 13));
		primer_Apellido.setForeground(new Color(30, 144, 255));
		primer_Apellido.setBounds(138, 56, 118, 14);
		panel_2.add(primer_Apellido);

		cedula_identidad = new JLabel("C.I");
		cedula_identidad.setFont(new Font("Arial", Font.BOLD, 13));
		cedula_identidad.setForeground(new Color(30, 144, 255));
		cedula_identidad.setBounds(10, 112, 118, 14);
		panel_2.add(cedula_identidad);

		email_personal = new JLabel("Email personal");
		email_personal.setFont(new Font("Arial", Font.BOLD, 13));
		email_personal.setForeground(new Color(30, 144, 255));
		email_personal.setBounds(10, 170, 118, 14);
		panel_2.add(email_personal);

		JLabel fecha_nacimiento = new JLabel("Fec. Nacimiento");
		fecha_nacimiento.setFont(new Font("Arial", Font.BOLD, 13));
		fecha_nacimiento.setForeground(new Color(30, 144, 255));
		fecha_nacimiento.setBounds(138, 112, 118, 14);
		panel_2.add(fecha_nacimiento);

		dateFec_Nac.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateFec_Nac.setBorder(null);
		dateFec_Nac.setBounds(138, 137, 118, 22);
		panel_2.add(dateFec_Nac);

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
		txtEmail.setBounds(10, 188, 118, 20);
		panel_2.add(txtEmail);

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
		txtTelefono.setBounds(138, 188, 118, 20);
		panel_2.add(txtTelefono);

		telefono_de_contacto = new JLabel("Teléfono");
		telefono_de_contacto.setFont(new Font("Arial", Font.BOLD, 13));
		telefono_de_contacto.setForeground(new Color(30, 144, 255));
		telefono_de_contacto.setBounds(138, 170, 118, 14);
		panel_2.add(telefono_de_contacto);

		departamento = new JLabel("Departamento");
		departamento.setFont(new Font("Arial", Font.BOLD, 13));
		departamento.setForeground(new Color(30, 144, 255));
		departamento.setBounds(266, 168, 118, 14);
		panel_2.add(departamento);

		comboDep.setFont(new Font("Arial", Font.PLAIN, 11));
		comboDep.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar", "Artigas", "Canelones", "Cerro Largo",
				"Colonia", "Durazno", "Flores", "Florida", "Lavalleja", "Maldonado", "Montevideo", "Paysandú",
				"Río Negro", "Rivera", "Rocha", "Salto", "San José", "Soriano", "Tacuarembó", "Treinta y Tres" }));
		comboDep.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboDep.setBorder(null);
		comboDep.setBounds(266, 194, 118, 21);
		panel_2.add(comboDep);

		JLabel email_institucional = new JLabel("Email institucional");
		email_institucional.setFont(new Font("Arial", Font.BOLD, 13));
		email_institucional.setForeground(new Color(30, 144, 255));
		email_institucional.setBounds(138, 279, 118, 14);
		panel_2.add(email_institucional);

		JLabel contrasenia = new JLabel("Contraseña");
		contrasenia.setFont(new Font("Arial", Font.BOLD, 13));
		contrasenia.setForeground(new Color(30, 144, 255));
		contrasenia.setBounds(331, 279, 118, 14);
		panel_2.add(contrasenia);

		comboITR.addItem("Seleccionar");

		for (String itr : RellenarITR()) {
			comboITR.addItem(itr);
		}

		comboITR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboITR.setBorder(null);
		comboITR.setBounds(138, 365, 183, 22);
		panel_2.add(comboITR);

		JLabel itr = new JLabel("ITR");
		itr.setFont(new Font("Arial", Font.BOLD, 13));
		itr.setForeground(new Color(30, 144, 255));
		itr.setBounds(138, 337, 118, 14);
		panel_2.add(itr);

		lblTipoDeUsuario = new JLabel("Tipo de usuario");
		lblTipoDeUsuario.setFont(new Font("Arial", Font.BOLD, 13));
		lblTipoDeUsuario.setForeground(new Color(30, 144, 255));
		lblTipoDeUsuario.setBounds(10, 279, 118, 14);
		panel_2.add(lblTipoDeUsuario);

		JLabel lblAoDeIngreso = new JLabel("Año ingreso");
		lblAoDeIngreso.setFont(new Font("Arial", Font.BOLD, 13));
		lblAoDeIngreso.setForeground(new Color(30, 144, 255));
		lblAoDeIngreso.setBounds(10, 337, 118, 14);
		panel_2.add(lblAoDeIngreso);

		JLabel lblRol = new JLabel("Rol");
		lblRol.setFont(new Font("Arial", Font.BOLD, 13));
		lblRol.setForeground(new Color(30, 144, 255));
		lblRol.setBounds(10, 337, 35, 14);
		panel_2.add(lblRol);

		rdbtnEncargado = new JRadioButton("Encargado");
		rdbtnEncargado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnTutor.setSelected(false);
				tipoRol = TipoRol.Encargado;
			}
		});

		rdbtnEncargado.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnEncargado.setBackground(new Color(255, 255, 255));
		rdbtnEncargado.setBounds(51, 339, 77, 23);
		panel_2.add(rdbtnEncargado);

		rdbtnTutor = new JRadioButton("Tutor");
		rdbtnTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnEncargado.setSelected(false);
				tipoRol = TipoRol.Tutor;
			}
		});
		rdbtnTutor.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnTutor.setBackground(new Color(255, 255, 255));
		rdbtnTutor.setBounds(51, 365, 77, 23);
		panel_2.add(rdbtnTutor);

		yearChooser.setBounds(80, 365, 48, 23);
		panel_2.add(yearChooser);

		lblDominio.setText("@utec.edu.uy");
		lblDominio.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDominio.setToolTipText("");
		lblDominio.setBounds(243, 299, 78, 20);
		panel_2.add(lblDominio);

		comboTipoUsuario = new JComboBox();
		comboTipoUsuario.setFont(new Font("Arial", Font.PLAIN, 11));

		rdbtnEncargado.setVisible(false);
		rdbtnTutor.setVisible(false);
		yearChooser.setVisible(false);
		lblAoDeIngreso.setVisible(false);
		lblRol.setVisible(false);
		lblDominio.setText("@utec.edu.uy");
		lblArea.setVisible(false);
		txtIngreseArea.setVisible(false);
		separator_7_1.setVisible(false);

		comboTipoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = (String) comboTipoUsuario.getSelectedItem();

				rdbtnEncargado.setVisible(false);
				rdbtnTutor.setVisible(false);
				yearChooser.setVisible(false);
				lblAoDeIngreso.setVisible(false);
				lblRol.setVisible(false);
				lblDominio.setText("@utec.edu.uy");
				lblArea.setVisible(false);
				txtIngreseArea.setVisible(false);
				separator_7_1.setVisible(false);

				if (item.equals("Tutor")) {
					lblRol.setVisible(true);
					rdbtnEncargado.setVisible(true);
					rdbtnTutor.setVisible(true);
					lblDominio.setText("@utec.edu.uy");
					lblArea.setVisible(true);
					txtIngreseArea.setVisible(true);
					separator_7_1.setVisible(true);
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
					separator_7_1.setVisible(false);
					lblDominio.setText("@utec.edu.uy");
				} else if (item.equals("Analista")) {
					lblDominio.setText("@utec.edu.uy");
				}
			}
		});
		comboTipoUsuario
				.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar", "Analista", "Tutor", "Estudiante" }));
		comboTipoUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboTipoUsuario.setBorder(null);
		comboTipoUsuario.setBounds(10, 302, 118, 24);
		panel_2.add(comboTipoUsuario);

		lblNewLabel_3 = new JLabel("Datos personales");
		lblNewLabel_3.setForeground(new Color(128, 128, 128));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 22, 160, 22);
		panel_2.add(lblNewLabel_3);

		lblNewLabel_2 = new JLabel("Datos institucionales");
		lblNewLabel_2.setForeground(new Color(128, 128, 128));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 238, 160, 14);
		panel_2.add(lblNewLabel_2);

		comboGenero.setFont(new Font("Arial", Font.PLAIN, 11));
		comboGenero.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar", "Masculino", "Femenino", "Otro" }));
		comboGenero.setBorder(null);
		comboGenero.setBounds(266, 138, 118, 21);
		panel_2.add(comboGenero);

		separator = new JSeparator();
		separator.setForeground(new Color(230, 230, 250));
		separator.setBounds(10, 224, 502, 3);
		panel_2.add(separator);

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
		pwdIngresarContrasea.setBounds(331, 299, 118, 20);
		panel_2.add(pwdIngresarContrasea);

		lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setForeground(new Color(30, 144, 255));
		lblLocalidad.setFont(new Font("Arial", Font.BOLD, 13));
		lblLocalidad.setBounds(394, 168, 118, 14);
		panel_2.add(lblLocalidad);

		JLabel lblGnero = new JLabel("Género");
		lblGnero.setForeground(new Color(30, 144, 255));
		lblGnero.setFont(new Font("Arial", Font.BOLD, 13));
		lblGnero.setBounds(266, 112, 118, 14);
		panel_2.add(lblGnero);

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
		txtIngreseLocalidad.setBounds(394, 188, 118, 20);
		panel_2.add(txtIngreseLocalidad);

		JSeparator separator_9_1 = new JSeparator();
		separator_9_1.setForeground(Color.GRAY);
		separator_9_1.setBackground(Color.GRAY);
		separator_9_1.setBounds(394, 212, 118, 3);
		panel_2.add(separator_9_1);

		lblArea.setForeground(new Color(30, 144, 255));
		lblArea.setFont(new Font("Arial", Font.BOLD, 13));
		lblArea.setBounds(10, 395, 118, 14);
		panel_2.add(lblArea);

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
		txtIngreseArea.setBounds(10, 415, 118, 20);
		panel_2.add(txtIngreseArea);

		separator_7_1.setForeground(Color.GRAY);
		separator_7_1.setBackground(Color.GRAY);
		separator_7_1.setBounds(10, 440, 118, 2);
		panel_2.add(separator_7_1);

		textField_7 = new JTextField();
		textField_7.setBounds(10, 0, -29, -25);
		panel_2.add(textField_7);
		textField_7.setColumns(10);
		rbtnVerContra.setBackground(Color.WHITE);

		rbtnVerContra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rbtnVerContra.setToolTipText("Mostrar contraseña");
		rbtnVerContra.setIcon(new ImageIcon(PDU_Actualizar.class.getResource("/com/iconos/ojo.png")));
		rbtnVerContra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				verContrasenia();
			}

		});
		rbtnVerContra.setBounds(455, 299, 33, 23);
		panel_2.add(rbtnVerContra);

		JPanel panelPie = new JPanel();
		add(panelPie, BorderLayout.SOUTH);
		panelPie.setLayout(new BorderLayout(0, 0));

		JPanel panel_controlPie_Botones = new JPanel();
		panel_controlPie_Botones.setBackground(new Color(240, 240, 240));
		panelPie.add(panel_controlPie_Botones, BorderLayout.EAST);

		JButton btnNewButton_4 = new JButton("Registrar");
		btnNewButton_4.addActionListener(new ActionListener() {

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
						UsuarioUniqueAnalista();
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
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_4.setBackground(new Color(0, 191, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_4.setBackground(new Color(30, 144, 255));
			}
		});
		btnNewButton_4.setRequestFocusEnabled(false);
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBackground(new Color(0, 102, 255));
		panel_controlPie_Botones.add(btnNewButton_4);

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

		else if (txtApellidos.getText().equals("Ingrese Apellidos")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Apellido'", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (txtDocumento.getText().equals("Ingrese Documento")) {

			JOptionPane.showMessageDialog(null, "Falta completar campo 'Documento C.I' ", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);
		}

		else if (dateFec_Nac.getDate() == null) {

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

		else if (txtApellidos.getText().length() > 30 || txtApellidos.getText().length() < 4) {
			JOptionPane.showMessageDialog(null,
					" Largo del campo Apellido debe estar comprendido entre 4 y 30 caracteres.",
					"Apellido no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);
		}

		else if (txtDocumento.getText().length() > 8 || txtDocumento.getText().length() < 7) {
			JOptionPane.showMessageDialog(null, " Documento / C.I debe contener 7 u 8 números  =(   ",
					"Documento no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);

		}

		// Fec Nac

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
			//
			if (digitoVerificar == digitoVerificador) {

				ITR itrs = itrBean.obtenerTodosITRPorNombre((String) comboITR.getSelectedItem());
				String mailInsti = txtEmail_Institucional.getText();

				if (mailInsti.contains("utec.edu.uy")) {

				} else {
					JOptionPane.showMessageDialog(null,
							"El correo debe contener el dominio correspondiente al tipo de usuario");

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

			} else {
				JOptionPane.showMessageDialog(null, "La cedula Ingresada no es correcta, intentelo nuevamente");
			}
		}

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

		else if (dateFec_Nac.getDate() == null) {

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
			//
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

		else if (dateFec_Nac.getDate() == null) {

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
			String password = pwdIngresarContrasea.getText();

			if (PASSWORD_PATTERN.matcher((CharSequence) password).matches()) {
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

			} else {
				JOptionPane.showMessageDialog(null, " 'Contraseña' debe contener números y letras ",
						"Contraseña no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);

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

	void verificarContra() {

		String password = pwdIngresarContrasea.getText();

		if (PASSWORD_PATTERN.matcher((CharSequence) password).matches()) {

		}

		else {
			JOptionPane.showMessageDialog(null, " 'Contraseña' debe contener números y letras ",
					"Contraseña no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);
		}
	}
}
