package com.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.internal.build.AllowSysOut;

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
import com.servicios.UsuarioBeanCliente;
import com.servicios.UsuarioBeanImp;
import com.servicios.AnalistaBeanCliente;
import com.servicios.AnalistaBeanImp;
import com.servicios.EstudianteBeanCliente;
import com.servicios.EstudianteBeanImp;
import com.servicios.EstudianteBeanRemote;
import com.servicios.ITRBeanCliente;
import com.servicios.ITRBeanImp;
import com.servicios.TutorBeanCliente;
import com.servicios.TutorBeanImp;

import java.awt.Component;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JSeparator;
import javax.swing.JTable;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Point;
import javax.swing.JComboBox;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import com.toedter.calendar.JYearChooser;
import java.awt.Cursor;

public class U_Lista extends JPanel {

	private JPanel panelCentro;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel_1;
	private JButton btnBuscar;
	private JPanel panel_2;
	private JSeparator separator;
	private JLabel lblNewLabel_3;
	private JComboBox comboTipoDeUsuarioFiltro;
	private JComboBox comboBox_Generacion;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_4_1;
	private JLabel lbl_estado_Estudiante;
	private JPanel panelPie;
	private JPanel panel_controlPie_Botones;
	private JButton btnBorrar;
	private JButton btnModificar;
	private JButton btnRefrescar;
	private JTable tablaEstudiantes;
	private JPanel panel_4;
	private JTable table;
	private long idEst;
	private JComboBox comboBox_Estado_Usuario = new JComboBox();
	private String[] colums = { "ID" };
	private DefaultTableModel model = new DefaultTableModel(colums, 0);
	private EstudianteBeanCliente estudianteBean = new EstudianteBeanImp();
	private ITRBeanCliente itrBean = new ITRBeanImp();
	private TutorBeanCliente tutorBean = new TutorBeanImp();
	private JPanel panel_5;
	private JPanel panel_6;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDocumento;
	private JTextField txtIngreseLocalidad;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JTextField txtEmail_Institucional;
	private JComboBox comboITR;
	private JComboBox comboGenero = new JComboBox();
	private JLabel itr;
	private JLabel lblRol;
	private JLabel lblAoDeIngreso;
	private boolean condicion;
	private boolean condicion1;
	private JLabel email_personal = new JLabel("Email personal");
	private JYearChooser yearChooserAñoIngreso = new JYearChooser();
	private JDateChooser dateFec_Nac = new JDateChooser();
	private JComboBox comboDepa = new JComboBox();
	private JLabel fecha_nacimiento_1;
	private JTextField txtIngreseArea = new JTextField();;
	private UsuarioBeanCliente usuarioBean = new UsuarioBeanImp();
	private AnalistaBeanCliente analistaBean = new AnalistaBeanImp();
	private TipoRol tipoRol;
	private JComboBox comboBox_Tipo_Usuario = new JComboBox();

	private JLabel lblArea = new JLabel("Área");
	private JSeparator separator_2 = new JSeparator();
	private JTextField textField;
	private JLabel estado_Usuario;;
	private JRadioButton rdbtnEncargado = new JRadioButton("Encargado");
	private JRadioButton rdbtnTutor = new JRadioButton("Tutor");
	private TipoUsuario tipoUsuario;
	private EstadoUsuario estadoUsuario;
	private EstadoEstudiante estadoEstudiante;
	private JComboBox comboBox_Estado_Estudiante = new JComboBox();
	private JPanel panel_7;
	private JComboBox comboEstadoUsuarioFiltro;
	private JComboBox comboITRFIltro;
	private JTextField textField_1;

	public U_Lista() {
		setLayout(new BorderLayout(0, 0));

		panelCentro = new JPanel();
		panelCentro.setBackground(Color.WHITE);
		add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panelCentro.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		lblNewLabel_1 = new JLabel("");
		panel.add(lblNewLabel_1, BorderLayout.WEST);

		lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setFont(lblNewLabel_2.getFont().deriveFont(3f));
		panel.add(lblNewLabel_2, BorderLayout.SOUTH);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1, BorderLayout.EAST);

		btnBuscar = new JButton("Filtrar");
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					obtenerPorFiltros();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnBuscar.setRequestFocusEnabled(false);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 13));
		btnBuscar.setBorderPainted(false);
		btnBuscar.setBackground(new Color(0, 102, 255));
		panel_1.add(btnBuscar);

		panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		separator = new JSeparator();
		separator.setBackground(Color.LIGHT_GRAY);
		separator.setPreferredSize(new Dimension(0, 4));
		panel_2.add(separator, BorderLayout.SOUTH);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setIcon(new ImageIcon(U_Lista.class.getResource("/com/iconos/buscar_ICON.png")));
		panel_2.add(lblNewLabel_3, BorderLayout.WEST);

		panel_7 = new JPanel();
		panel_2.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new GridLayout(1, 0, 0, 0));

		comboBox_Generacion = new JComboBox();
		comboBox_Generacion.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar generación" }));

		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel(" Listado de usuarios ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBackground(Color.WHITE);
		panel_3.add(lblNewLabel, BorderLayout.WEST);

//		comboDep.setFont(new Font("Arial", Font.PLAIN, 11));
//		comboDep.setModel(new DefaultComboBoxModel(new String[] { "Selecccionar", "Artigas", "Canelones", "Cerro Largo",
//				"Colonia", "Durazno", "Flores", "Florida", "Lavalleja", "Maldonado", "Montevideo", "Paysandú",
//				"Río Negro", "Rivera", "Rocha", "Salto", "San José", "Soriano", "Tacuarembó", "Treinta y Tres" }));

		lblNewLabel_4 = new JLabel(" ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 5));
		panel_3.add(lblNewLabel_4, BorderLayout.NORTH);

		lblNewLabel_2_1 = new JLabel("  ");
		lblNewLabel_2_1.setOpaque(true);
		lblNewLabel_2_1.setBackground(new Color(0, 102, 255));
		panel_3.add(lblNewLabel_2_1, BorderLayout.CENTER);

		lblNewLabel_5 = new JLabel("  ");
		panel_3.add(lblNewLabel_5, BorderLayout.EAST);

		lblNewLabel_4_1 = new JLabel(" ");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 5));
		panel_3.add(lblNewLabel_4_1, BorderLayout.SOUTH);

		panel_5 = new JPanel();
		panelCentro.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_5.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					agregarCampos();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		scrollPane.setViewportView(table);

		panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_5.add(panel_6);
		panel_6.setLayout(null);

		comboTipoDeUsuarioFiltro = new JComboBox();
		comboTipoDeUsuarioFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (comboTipoDeUsuarioFiltro.getSelectedIndex() == 0) {
					tipoUsuario = null;
				}
				if (comboTipoDeUsuarioFiltro.getSelectedIndex() == 1) {
					tipoUsuario = TipoUsuario.Analista;
				}

				if (comboTipoDeUsuarioFiltro.getSelectedIndex() == 2) {
					tipoUsuario = TipoUsuario.Estudiante;
				}
				if (comboTipoDeUsuarioFiltro.getSelectedIndex() == 3) {
					tipoUsuario = TipoUsuario.Tutor;
				}

//				if (comboTipoDeUsuarioFiltro.getSelectedIndex() == 0) {
//					try {
//						//listarTodosUsuarios();
//						obtenerPorFiltros();
//					} catch (ServiciosException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//
//				} else if (comboTipoDeUsuarioFiltro.getSelectedIndex() == 1) {
//					//listarUsuariosAnalista();
//					try {
//						obtenerPorFiltros();
//					} catch (ServiciosException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//
//				else if (comboTipoDeUsuarioFiltro.getSelectedIndex() == 2) {
//					//listarUsuariosEstudiante();
//					try {
//						obtenerPorFiltros();
//					} catch (ServiciosException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//
//				else if (comboTipoDeUsuarioFiltro.getSelectedIndex() == 3) {
//					//listarUsuariosTutor();
//					try {
//						obtenerPorFiltros();
//					} catch (ServiciosException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}

//				else if (comboBox_Tipo_de_Filtro.getSelectedIndex() == 4) {
//					listarUsuariosTutor();
//				}
//
//				else if (comboBox_Tipo_de_Filtro.getSelectedIndex() == 5) {
//					listarUsuariosTutor();
//				}
//
//				else if (comboBox_Tipo_de_Filtro.getSelectedIndex() == 6) {
//					listarUsuariosTutor();
//				} else if (comboBox_Tipo_de_Filtro.getSelectedIndex() == 7) {
//					listarUsuariosTutor();
//				}
//				String item = (String) comboBox_Tipo_de_Filtro.getSelectedItem();
//
//				if (item.equals("Estudiante")) {
//					
//					panel_2.add(comboBox_Generacion, BorderLayout.EAST);
//				} else {
//					panel_2.remove(comboBox_Generacion);
//				}

			}
		});
		comboTipoDeUsuarioFiltro.setBackground(Color.WHITE);
		comboTipoDeUsuarioFiltro.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccionar tipo de usuario", "Analista", "Estudiante", "Tutor" }));
		panel_7.add(comboTipoDeUsuarioFiltro);

		comboEstadoUsuarioFiltro = new JComboBox();
		comboEstadoUsuarioFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboEstadoUsuarioFiltro.getSelectedIndex() == 0) {
					estadoUsuario = null;
				}
				if (comboEstadoUsuarioFiltro.getSelectedIndex() == 1) {
					estadoUsuario = EstadoUsuario.Validado;
				}

				if (comboEstadoUsuarioFiltro.getSelectedIndex() == 2) {
					estadoUsuario = EstadoUsuario.SinValidar;
				}
				if (comboEstadoUsuarioFiltro.getSelectedIndex() == 3) {
					estadoUsuario = EstadoUsuario.Eliminado;
				}
			}
		});
		comboEstadoUsuarioFiltro.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccionar estado usuario", "Validado", "Sin Validar", "Eliminado" }));
		panel_7.add(comboEstadoUsuarioFiltro);

		comboITRFIltro = new JComboBox();
		panel_7.add(comboITRFIltro);

		textField_1 = new JTextField();
		panel_7.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_3_1 = new JLabel("Datos a modificar");
		lblNewLabel_3_1.setForeground(Color.GRAY);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(10, 11, 160, 22);
		panel_6.add(lblNewLabel_3_1);

		JLabel primer_Nombre = new JLabel("Nombres");
		primer_Nombre.setForeground(new Color(30, 144, 255));
		primer_Nombre.setFont(new Font("Arial", Font.BOLD, 13));
		primer_Nombre.setBounds(10, 44, 86, 14);
		panel_6.add(primer_Nombre);

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
		txtNombres.setText("Ingrese Nombres");
		txtNombres.setForeground(new Color(102, 102, 102));
		txtNombres.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNombres.setDisabledTextColor(Color.LIGHT_GRAY);
		txtNombres.setColumns(10);
		txtNombres.setBorder(null);
		txtNombres.setBounds(10, 63, 118, 20);
		panel_6.add(txtNombres);

		JLabel primer_Apellido = new JLabel("Apellidos");
		primer_Apellido.setForeground(new Color(30, 144, 255));
		primer_Apellido.setFont(new Font("Arial", Font.BOLD, 13));
		primer_Apellido.setBounds(138, 45, 118, 14);
		panel_6.add(primer_Apellido);

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
		txtApellidos.setText("Ingrese Apellidos");
		txtApellidos.setForeground(new Color(102, 102, 102));
		txtApellidos.setFont(new Font("Arial", Font.PLAIN, 11));
		txtApellidos.setDisabledTextColor(Color.LIGHT_GRAY);
		txtApellidos.setColumns(10);
		txtApellidos.setBorder(null);
		txtApellidos.setBounds(138, 62, 118, 20);
		panel_6.add(txtApellidos);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.GRAY);
		separator_3.setBackground(Color.GRAY);
		separator_3.setBounds(138, 87, 118, 3);
		panel_6.add(separator_3);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		separator_1.setBackground(Color.GRAY);
		separator_1.setBounds(10, 88, 118, 2);
		panel_6.add(separator_1);

		JLabel cedula_identidad = new JLabel("C.I");
		cedula_identidad.setForeground(new Color(30, 144, 255));
		cedula_identidad.setFont(new Font("Arial", Font.BOLD, 13));
		cedula_identidad.setBounds(266, 43, 118, 14);
		panel_6.add(cedula_identidad);

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
		txtDocumento.setText("Ingrese Documento");
		txtDocumento.setForeground(new Color(102, 102, 102));
		txtDocumento.setFont(new Font("Arial", Font.PLAIN, 11));
		txtDocumento.setDisabledTextColor(Color.LIGHT_GRAY);
		txtDocumento.setColumns(10);
		txtDocumento.setBorder(null);
		txtDocumento.setBounds(266, 63, 118, 20);
		panel_6.add(txtDocumento);

		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(Color.GRAY);
		separator_5.setBackground(Color.GRAY);
		separator_5.setBounds(266, 88, 118, 2);
		panel_6.add(separator_5);

		JLabel fecha_nacimiento = new JLabel("Fec. Nacimiento");
		fecha_nacimiento.setForeground(new Color(30, 144, 255));
		fecha_nacimiento.setFont(new Font("Arial", Font.BOLD, 13));
		fecha_nacimiento.setBounds(394, 43, 118, 14);
		panel_6.add(fecha_nacimiento);

		dateFec_Nac.setBorder(null);
		dateFec_Nac.setBounds(394, 68, 118, 22);
		panel_6.add(dateFec_Nac);

		JLabel lblGnero = new JLabel("Género");
		lblGnero.setForeground(new Color(30, 144, 255));
		lblGnero.setFont(new Font("Arial", Font.BOLD, 13));
		lblGnero.setBounds(522, 43, 118, 14);
		panel_6.add(lblGnero);

		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setForeground(new Color(30, 144, 255));
		lblLocalidad.setFont(new Font("Arial", Font.BOLD, 13));
		lblLocalidad.setBounds(767, 43, 118, 14);
		panel_6.add(lblLocalidad);

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
		txtIngreseLocalidad.setBounds(767, 63, 118, 20);
		panel_6.add(txtIngreseLocalidad);

		JSeparator separator_9_1 = new JSeparator();
		separator_9_1.setForeground(Color.GRAY);
		separator_9_1.setBackground(Color.GRAY);
		separator_9_1.setBounds(767, 87, 118, 3);
		panel_6.add(separator_9_1);

		JLabel telefono_de_contacto = new JLabel("Teléfono");
		telefono_de_contacto.setForeground(new Color(30, 144, 255));
		telefono_de_contacto.setFont(new Font("Arial", Font.BOLD, 13));
		telefono_de_contacto.setBounds(10, 101, 118, 14);
		panel_6.add(telefono_de_contacto);

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
		txtTelefono.setText("Ingrese Teléfono");
		txtTelefono.setForeground(new Color(102, 102, 102));
		txtTelefono.setFont(new Font("Arial", Font.PLAIN, 11));
		txtTelefono.setDisabledTextColor(Color.LIGHT_GRAY);
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(null);
		txtTelefono.setBounds(10, 119, 118, 20);
		panel_6.add(txtTelefono);

		JSeparator separator_7 = new JSeparator();
		separator_7.setForeground(Color.GRAY);
		separator_7.setBackground(Color.GRAY);
		separator_7.setBounds(10, 144, 118, 2);
		panel_6.add(separator_7);

		email_personal.setForeground(new Color(30, 144, 255));
		email_personal.setFont(new Font("Arial", Font.BOLD, 13));
		email_personal.setBounds(906, 45, 118, 14);
		panel_6.add(email_personal);

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
		txtEmail.setText("Ingrese Email");
		txtEmail.setForeground(new Color(102, 102, 102));
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 11));
		txtEmail.setDisabledTextColor(Color.LIGHT_GRAY);
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBounds(906, 63, 118, 20);
		panel_6.add(txtEmail);

		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(Color.GRAY);
		separator_6.setBackground(Color.GRAY);
		separator_6.setBounds(906, 88, 118, 2);
		panel_6.add(separator_6);

		JLabel lblTipoDeUsuario = new JLabel("Tipo de usuario");
		lblTipoDeUsuario.setForeground(new Color(30, 144, 255));
		lblTipoDeUsuario.setFont(new Font("Arial", Font.BOLD, 13));
		lblTipoDeUsuario.setBounds(138, 99, 118, 14);
		panel_6.add(lblTipoDeUsuario);

		rdbtnTutor.setBounds(170, 204, 86, 23);
		rdbtnTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnEncargado.setSelected(false);
				tipoRol = TipoRol.Tutor;

			}
		});
		panel_6.add(rdbtnTutor);

		rdbtnEncargado.setBounds(170, 178, 86, 23);
		rdbtnEncargado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnTutor.setSelected(false);
				tipoRol = TipoRol.Encargado;

			}
		});
		panel_6.add(rdbtnEncargado);

		yearChooserAñoIngreso.setBounds(208, 178, 48, 24);
		panel_6.add(yearChooserAñoIngreso);

		JLabel lblDominio = new JLabel();
		lblDominio.setToolTipText("");
		lblDominio.setText("@utec.edu.uy");
		lblDominio.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDominio.setBounds(394, 118, 118, 20);
		panel_6.add(lblDominio);

		lblRol = new JLabel("Rol");
		lblRol.setForeground(new Color(30, 144, 255));
		lblRol.setFont(new Font("Arial", Font.BOLD, 13));
		lblRol.setBounds(138, 157, 118, 14);
		panel_6.add(lblRol);

		lblAoDeIngreso = new JLabel("Año ingreso");
		lblAoDeIngreso.setForeground(new Color(30, 144, 255));
		lblAoDeIngreso.setFont(new Font("Arial", Font.BOLD, 13));
		lblAoDeIngreso.setBounds(138, 157, 118, 14);
		panel_6.add(lblAoDeIngreso);

		lbl_estado_Estudiante = new JLabel("Estado del Estudiante");
		lbl_estado_Estudiante.setForeground(new Color(30, 144, 255));
		lbl_estado_Estudiante.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_estado_Estudiante.setBounds(268, 156, 145, 14);
		panel_6.add(lbl_estado_Estudiante);

		rdbtnEncargado.setVisible(false);
		rdbtnTutor.setVisible(false);
		yearChooserAñoIngreso.setVisible(false);
		lblAoDeIngreso.setVisible(false);
		lblRol.setVisible(false);
		lblDominio.setText("@utec.edu.uy");
		lblArea.setVisible(false);
		txtIngreseArea.setVisible(false);
		separator_2.setVisible(false);
		comboBox_Estado_Estudiante.setVisible(false);
		lbl_estado_Estudiante.setVisible(false);

		comboBox_Tipo_Usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = (String) comboBox_Tipo_Usuario.getSelectedItem();

				rdbtnEncargado.setVisible(false);
				rdbtnTutor.setVisible(false);
				yearChooserAñoIngreso.setVisible(false);
				lblAoDeIngreso.setVisible(false);
				lblRol.setVisible(false);
				lblDominio.setText("@utec.edu.uy");
				lblArea.setVisible(false);
				txtIngreseArea.setVisible(false);
				separator_2.setVisible(false);
				comboBox_Estado_Estudiante.setVisible(false);
				lbl_estado_Estudiante.setVisible(false);

				if (item.equals("Tutor")) {
					lblRol.setVisible(true);
					rdbtnEncargado.setVisible(true);
					rdbtnTutor.setVisible(true);
					lblDominio.setText("@utec.edu.uy");
					lblArea.setVisible(true);
					txtIngreseArea.setVisible(true);
					separator_2.setVisible(true);
					lblAoDeIngreso.setVisible(false);
					yearChooserAñoIngreso.setVisible(false);
					comboBox_Estado_Estudiante.setVisible(false);
					lbl_estado_Estudiante.setVisible(false);
				} else if (item.equals("Estudiante")) {
					lblAoDeIngreso.setVisible(true);
					yearChooserAñoIngreso.setVisible(true);
					lblRol.setVisible(false);
					rdbtnEncargado.setVisible(false);
					rdbtnTutor.setVisible(false);
					lblArea.setVisible(false);
					txtIngreseArea.setVisible(false);
					separator_2.setVisible(false);
					comboBox_Estado_Estudiante.setVisible(true);
					lbl_estado_Estudiante.setVisible(true);
					lblDominio.setText("@utec.edu.uy");
				} else if (item.equals("Usuario")) {
					lblDominio.setText("@utec.edu.uy");
				}
			}
		});
		comboBox_Tipo_Usuario
				.setModel(new DefaultComboBoxModel(new String[] { "Selecccionar", "Analista", "Tutor", "Estudiante" }));
		comboBox_Tipo_Usuario.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_Tipo_Usuario.setBorder(null);
		comboBox_Tipo_Usuario.setBounds(138, 122, 118, 24);
		panel_6.add(comboBox_Tipo_Usuario);

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
		txtEmail_Institucional.setText("Email Institucional");
		txtEmail_Institucional.setForeground(new Color(102, 102, 102));
		txtEmail_Institucional.setFont(new Font("Dialog", Font.PLAIN, 11));
		txtEmail_Institucional.setDisabledTextColor(Color.LIGHT_GRAY);
		txtEmail_Institucional.setColumns(10);
		txtEmail_Institucional.setBorder(null);
		txtEmail_Institucional.setBounds(266, 119, 118, 20);
		panel_6.add(txtEmail_Institucional);

		JSeparator separator_8 = new JSeparator();
		separator_8.setForeground(Color.GRAY);
		separator_8.setBackground(Color.GRAY);
		separator_8.setBounds(266, 143, 246, 3);
		panel_6.add(separator_8);

		JLabel email_institucional = new JLabel("Email institucional");
		email_institucional.setForeground(new Color(30, 144, 255));
		email_institucional.setFont(new Font("Arial", Font.BOLD, 13));
		email_institucional.setBounds(266, 99, 118, 14);
		panel_6.add(email_institucional);

		comboITR = new JComboBox();
		comboITR.setBorder(null);
		comboITR.setBounds(522, 124, 183, 22);
		panel_6.add(comboITR);

		comboITR.addItem("Seleccionar");

		for (String itr : RellenarITR()) {
			comboITR.addItem(itr);
		}

		comboITRFIltro.addItem("Seleccionar un ITR");
		for (String itr : RellenarITR()) {
			comboITRFIltro.addItem(itr);
		}
		comboDepa.setFont(new Font("Arial", Font.PLAIN, 11));
		comboDepa.setModel(new DefaultComboBoxModel(
				new String[] { "Selecccionar", "Artigas", "Canelones", "Cerro Largo", "Colonia", "Durazno", "Flores",
						"Florida", "Lavalleja", "Maldonado", "Montevideo", "Paysandú", "Río Negro", "Rivera", "Rocha",
						"Salto", "San José", "Soriano", "Tacuarembó", "Treinta y Tres" }));
		comboGenero.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar", "Masculino", "Femenino", "Otro" }));

		comboGenero.setFont(new Font("Arial", Font.PLAIN, 11));
		comboGenero.setBorder(null);
		comboGenero.setBounds(522, 69, 118, 21);
		panel_6.add(comboGenero);

		itr = new JLabel("ITR");
		itr.setForeground(new Color(30, 144, 255));
		itr.setFont(new Font("Arial", Font.BOLD, 13));
		itr.setBounds(522, 101, 118, 14);
		panel_6.add(itr);

		JLabel departamento = new JLabel("Departamento");
		comboDepa.setBounds(650, 69, 107, 21);
		panel_6.add(comboDepa);

		fecha_nacimiento_1 = new JLabel("Departamento");
		fecha_nacimiento_1.setForeground(new Color(30, 144, 255));
		fecha_nacimiento_1.setFont(new Font("Arial", Font.BOLD, 13));
		fecha_nacimiento_1.setBounds(650, 43, 118, 14);
		panel_6.add(fecha_nacimiento_1);

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
		txtIngreseArea.setBounds(10, 175, 118, 20);
		panel_6.add(txtIngreseArea);

		lblArea.setForeground(new Color(30, 144, 255));
		lblArea.setFont(new Font("Arial", Font.BOLD, 13));
		lblArea.setBounds(10, 157, 118, 14);
		panel_6.add(lblArea);

		separator_2.setForeground(Color.GRAY);
		separator_2.setBackground(Color.GRAY);
		separator_2.setBounds(10, 200, 118, 2);
		panel_6.add(separator_2);

		textField = new JTextField();
		textField.setBounds(10, 0, -4, -6);
		panel_6.add(textField);
		textField.setColumns(10);

		estado_Usuario = new JLabel("Estado del usuario");
		estado_Usuario.setForeground(new Color(30, 144, 255));
		estado_Usuario.setFont(new Font("Arial", Font.BOLD, 13));
		estado_Usuario.setBounds(713, 101, 132, 14);
		panel_6.add(estado_Usuario);

		comboBox_Estado_Usuario.setModel(
				new DefaultComboBoxModel(new String[] { "Seleccionar", "Sin validar", "Validado", "Eliminado" }));
		comboBox_Estado_Usuario.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_Estado_Usuario.setBorder(null);
		comboBox_Estado_Usuario.setBounds(713, 122, 118, 24);
		panel_6.add(comboBox_Estado_Usuario);

		comboBox_Estado_Estudiante.setModel(
				new DefaultComboBoxModel(new String[] { "Seleccionar", "Activo", "Congelado", "No_Matriculado" }));
		comboBox_Estado_Estudiante.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_Estado_Estudiante.setBorder(null);
		comboBox_Estado_Estudiante.setBounds(266, 177, 147, 24);
		panel_6.add(comboBox_Estado_Estudiante);

		panel_4 = new JPanel();

		panelPie = new JPanel();
		add(panelPie, BorderLayout.SOUTH);
		panelPie.setLayout(new BorderLayout(0, 0));

		panel_controlPie_Botones = new JPanel();
		panel_controlPie_Botones.setBackground(new Color(240, 240, 240));
		panelPie.add(panel_controlPie_Botones, BorderLayout.EAST);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int salida = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el usuario?");
					System.out.println(salida);
					if (salida == 0) {
						usuarioBean.borrarUsuario(idEst);
						listarTodosUsuarios();

						JOptionPane.showMessageDialog(null, "Se elimino correctamente el usuario");
					} else {
						JOptionPane.showMessageDialog(null, "La eliminacion fue cancelada");
					}

				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}

		});
		btnBorrar.setFocusable(false);
		btnBorrar.setRequestFocusEnabled(false);
		btnBorrar.setForeground(Color.WHITE);
		btnBorrar.setFont(new Font("Arial", Font.BOLD, 13));
		btnBorrar.setBorderPainted(false);
		btnBorrar.setBackground(new Color(0, 102, 255));
		panel_controlPie_Botones.add(btnBorrar);

		btnModificar = new JButton("Modificar");
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipoUsuario = (TipoUsuario) model.getValueAt(table.getSelectedRow(), 10);

				if (tipoUsuario.equals(TipoUsuario.Analista)) {
					try {
						modificarAnalistas();
						listarTodosUsuarios();
					} catch (ServiciosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (tipoUsuario.equals(TipoUsuario.Estudiante)) {
					try {
						modificarEstudiantes();
						listarTodosUsuarios();
					} catch (ServiciosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (tipoUsuario.equals(TipoUsuario.Tutor)) {
					try {
						modificarTutores();
						listarTodosUsuarios();
					} catch (ServiciosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
		btnModificar.setRequestFocusEnabled(false);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Arial", Font.BOLD, 13));
		btnModificar.setBorderPainted(false);
		btnModificar.setBackground(new Color(0, 102, 255));
		panel_controlPie_Botones.add(btnModificar);

		btnRefrescar = new JButton("Listar");
		btnRefrescar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					listarTodosUsuarios();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				comboTipoDeUsuarioFiltro.setSelectedIndex(0);
				comboEstadoUsuarioFiltro.setSelectedIndex(0);
				comboITRFIltro.setSelectedIndex(0);
			}
		});
		btnRefrescar.setRequestFocusEnabled(false);
		btnRefrescar.setForeground(Color.WHITE);
		btnRefrescar.setFont(new Font("Arial", Font.BOLD, 13));
		btnRefrescar.setBorderPainted(false);
		btnRefrescar.setBackground(new Color(0, 102, 255));
		panel_controlPie_Botones.add(btnRefrescar);

	};

	void modificarEstudiantes() throws ServiciosException {
		ITR itrs = itrBean.obtenerTodosITRPorNombre((String) comboITR.getSelectedItem());
		Usuario est;

		String mailInsti = txtEmail_Institucional.getText();

//		if (comboBox_Estado_ITR.getSelectedItem().equals("Activo")) {
//			estadoITR = EstadoITR.ACTIVO;
//
//		} else if (comboBox_Estado_ITR.getSelectedItem().equals("Desactivado")) {
//			estadoITR = EstadoITR.DESACTIVADO;
//
//		}
//
//		else if (comboBox_Estado_ITR.getSelectedItem().equals("Eliminado")) {
//			estadoITR = EstadoITR.ELIMINADO;
//
//		}
//		if (mailInsti.contains("utec.edu.uy") || mailInsti.contains("utec.edu.uy")
//				|| mailInsti.contains("estudiante.utec.edu.uy")) {
//
//		} else {
//			JOptionPane.showMessageDialog(null,
//					"El correo debe contener el dominio correspondiente al tipo de usuario");
//
//		}

		if (comboBox_Estado_Usuario.getSelectedItem().equals("Validado")) {
			estadoUsuario = EstadoUsuario.Validado;
		}

		else if (comboBox_Estado_Usuario.getSelectedItem().equals("SinValidar")) {
			estadoUsuario = EstadoUsuario.SinValidar;
		} else if (comboBox_Estado_Usuario.getSelectedItem().equals("Eliminado")) {
			estadoUsuario = EstadoUsuario.Eliminado;
		}

		if (comboBox_Estado_Estudiante.getSelectedItem() == ("Activo")) {
			estadoEstudiante = EstadoEstudiante.Activo;
		}

		else if (comboBox_Estado_Estudiante.getSelectedItem() == ("Congelado")) {
			estadoEstudiante = EstadoEstudiante.Congelado;
		}

		else if (comboBox_Estado_Estudiante.getSelectedItem() == ("No_Matriculado")) {
			estadoEstudiante = EstadoEstudiante.No_Matriculado;
		}

		String[] parte = txtEmail_Institucional.getText().split("@");
		String parte1 = parte[0];

		est = usuarioBean.obtenerPorIdUsuario(idEst);

		EstudianteDTO estudiante = new EstudianteDTO();
		estudiante.setIdUsuario(est.getIdUsuario());
		estudiante.setNombre(txtNombres.getText());
		estudiante.setApellido(txtApellidos.getText());
		estudiante.setDocumento(Integer.parseInt(txtDocumento.getText()));
		estudiante.setDepartamento((String) comboDepa.getSelectedItem());
		estudiante.setTelefono(txtTelefono.getText());
		estudiante.setNombreUsuario(parte1);
		estudiante.setAñoIngreso(String.valueOf(yearChooserAñoIngreso.getYear()));
		estudiante.setGenero((String) comboGenero.getSelectedItem());
		estudiante.setLocalidad(txtIngreseLocalidad.getText());
		estudiante.setMail((txtEmail.getText()));
		estudiante.setMailInstitucional(mailInsti);
		estudiante.setFechaNac(dateFec_Nac.getDate());
		estudiante.setContrasenia(est.getContrasenia());
		estudiante.setTipoUsuario(TipoUsuario.Estudiante);
		estudiante.setEstadoUsuario(estadoUsuario);
		estudiante.setEstadoEstudiante(estadoEstudiante);
		estudiante.setItr(itrs);

		try {
			estudianteBean.modificarEstudiante(estudiante);
			JOptionPane.showMessageDialog(null, "Se actualizo exitosamente el Estudiante: " + estudiante.getNombre());
		} catch (ServiciosException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	// Modificar analistas
	void modificarAnalistas() throws ServiciosException {
		ITR itrs = itrBean.obtenerTodosITRPorNombre((String) comboITR.getSelectedItem());
		Usuario est;

		String mailInsti = txtEmail_Institucional.getText();

		if (comboBox_Estado_Usuario.getSelectedItem() == ("Validado")) {
			estadoUsuario = EstadoUsuario.Validado;
		}

		else if (comboBox_Estado_Usuario.getSelectedItem() == ("SinValidar")) {
			estadoUsuario = EstadoUsuario.SinValidar;
		}

		else if (comboBox_Estado_Usuario.getSelectedItem() == ("Eliminado")) {
			estadoUsuario = EstadoUsuario.Eliminado;
		}

		String[] parte = txtEmail_Institucional.getText().split("@");
		String parte1 = parte[0];

		est = usuarioBean.obtenerPorIdUsuario(idEst);

		AnalistaDTO analista = new AnalistaDTO();
		analista.setIdUsuario(est.getIdUsuario());
		analista.setNombre(txtNombres.getText());
		analista.setApellido(txtApellidos.getText());
		analista.setDocumento(Integer.parseInt(txtDocumento.getText()));
		analista.setDepartamento((String) comboDepa.getSelectedItem());
		analista.setTelefono(txtTelefono.getText());
		analista.setNombreUsuario(parte1);
		analista.setGenero((String) comboGenero.getSelectedItem());
		analista.setLocalidad(txtIngreseLocalidad.getText());
		analista.setMail(txtEmail.getText());
		analista.setMailInstitucional(mailInsti);
		analista.setFechaNac(dateFec_Nac.getDate());
		analista.setContrasenia(est.getContrasenia());
		analista.setItr(itrs);
		analista.setEstadoUsuario(estadoUsuario);
		analista.setTipoUsuario(TipoUsuario.Analista);

		try {
			analistaBean.modificarAnalista(analista);
			JOptionPane.showMessageDialog(null, "Se actualizo exitosamente el usuario: " + analista.getNombre());
		} catch (ServiciosException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	void modificarTutores() throws ServiciosException {

		if (comboBox_Estado_Usuario.getSelectedItem() == ("Validado")) {
			estadoUsuario = EstadoUsuario.Validado;
		}

		else if (comboBox_Estado_Usuario.getSelectedItem() == ("Sin validar")) {
			estadoUsuario = EstadoUsuario.SinValidar;

		} else if (comboBox_Estado_Usuario.getSelectedItem() == ("Eliminado")) {
			estadoUsuario = EstadoUsuario.Eliminado;
		}

		ITR itrs = itrBean.obtenerTodosITRPorNombre((String) comboITR.getSelectedItem());
		Usuario est;

		String mailInsti = txtEmail_Institucional.getText();

		String[] parte = txtEmail_Institucional.getText().split("@");
		String parte1 = parte[0];

		est = usuarioBean.obtenerPorIdUsuario(idEst);

		TutorDTO tutor = new TutorDTO();
	
		tutor.setIdUsuario(est.getIdUsuario());
		tutor.setNombre(txtNombres.getText());
		tutor.setApellido(txtApellidos.getText());
		tutor.setDocumento(Integer.parseInt(txtDocumento.getText()));
		tutor.setDepartamento((String) comboDepa.getSelectedItem());
		tutor.setTelefono(txtTelefono.getText());
		tutor.setNombreUsuario(parte1);
		tutor.setGenero((String) comboGenero.getSelectedItem());
		tutor.setLocalidad(txtIngreseLocalidad.getText());
		tutor.setMail(txtEmail.getText());
		tutor.setMailInstitucional(mailInsti);
		tutor.setFechaNac(dateFec_Nac.getDate());
		tutor.setContrasenia(est.getContrasenia());
		tutor.setItr(itrs);
		tutor.setEstadoUsuario(estadoUsuario);
		tutor.setTipoUsuario(TipoUsuario.Tutor);
		tutor.setTipoRol(tipoRol);
		tutor.setArea(txtIngreseArea.getText());

		try {
			tutorBean.modificarTutor(tutor);
			JOptionPane.showMessageDialog(null, "Se actualizo exitosamente el Estudiante: " + tutor.getNombre());
		} catch (ServiciosException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
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

	void listarTodosUsuarios() throws ServiciosException {
		String[] colums = { "ID", "Nombres", "Apellidos", "Cédula", "Fecha nacimiento", "Genero", "Departamento",
				"Localidad", "Email personal", "Teléfono", "Usuario", "Email institucional", "ITR", "Estado Usuario", };
		model = new DefaultTableModel(colums, 0);

		table.setModel(model);

		List<Usuario> usu = usuarioBean.obtenerTodosUsuarios();
		List<Usuario> usuarioElim = new ArrayList();
		for (Usuario usurr : usu) {
			if (usurr.getEstadoUsuario() != estadoUsuario.Eliminado) {
				usuarioElim.add(usurr);
			}
			Object[] fila = new Object[14];

			model.setRowCount(0);

			for (int i = 0; i < usuarioElim.size(); i++) {
				fila[0] = usuarioElim.get(i).getIdUsuario();
				fila[1] = usuarioElim.get(i).getNombre();
				fila[2] = usuarioElim.get(i).getApellido();
				fila[3] = usuarioElim.get(i).getDocumento();
				fila[4] = usuarioElim.get(i).getFechaNac();
				fila[5] = usuarioElim.get(i).getGenero();
				fila[6] = usuarioElim.get(i).getDepartamento();
				fila[7] = usuarioElim.get(i).getLocalidad();
				fila[8] = usuarioElim.get(i).getMail();
				fila[9] = usuarioElim.get(i).getTelefono();
				fila[10] = usuarioElim.get(i).getTipoUsuario();
				fila[11] = usuarioElim.get(i).getMailInstitucional();
				fila[12] = usuarioElim.get(i).getItr().getNombre();
				fila[13] = usuarioElim.get(i).getEstadoUsuario().getNombre();

				model.addRow(fila);
			}
		}
	}

	void listarUsuariosEstudiante() {
		String[] colums = { "ID", "Nombres", "Apellidos", "Cédula", "Fecha nacimiento", "Genero", "Departamento",
				"Localidad", "Email personal", "Teléfono", "Usuario", "Email institucional", "ITR", "Estado Usuario",
				"Año Ingreso", "Estado Estudiante" };
		model = new DefaultTableModel(colums, 0);
		table.setModel(model);

		try {
			List<Estudiante> est = estudianteBean.obtenerTodosEstudiantes();

			Object[] fila = new Object[16];

			model.setRowCount(0);

			for (int i = 0; i < est.size(); i++) {
				fila[0] = est.get(i).getIdUsuario();
				fila[1] = est.get(i).getNombre();
				fila[2] = est.get(i).getApellido();
				fila[3] = est.get(i).getDocumento();
				fila[4] = est.get(i).getFechaNac();
				fila[5] = est.get(i).getGenero();
				fila[6] = est.get(i).getDepartamento();
				fila[7] = est.get(i).getLocalidad();
				fila[8] = est.get(i).getMail();
				fila[9] = est.get(i).getTelefono();
				fila[10] = est.get(i).getTipoUsuario();
				fila[11] = est.get(i).getMailInstitucional();
				fila[12] = est.get(i).getItr().getNombre();
				fila[13] = est.get(i).getEstadoUsuario().getNombre();
				fila[14] = est.get(i).getAñoIngreso();
				fila[15] = est.get(i).getEstadoEstudiante().getNombre();

				model.addRow(fila);
			}

		} catch (ServiciosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	void listarUsuariosTutor() {
		String[] colums = { "ID", "Nombres", "Apellidos", "Cédula", "Fecha nacimiento", "Genero", "Departamento",
				"Localidad", "Email personal", "Teléfono", "Usuario", "Email institucional", "ITR", "Estado Usuario",
				"Area", "Rol" };
		model = new DefaultTableModel(colums, 0);
		table.setModel(model);

		try {

			List<Tutor> tut = tutorBean.obtenerTodosTutores();
			Object[] fila = new Object[17];

			model.setRowCount(0);

			for (int i = 0; i < tut.size(); i++) {
				fila[0] = tut.get(i).getIdUsuario();
				fila[1] = tut.get(i).getNombre();
				fila[2] = tut.get(i).getApellido();
				fila[3] = tut.get(i).getDocumento();
				fila[4] = tut.get(i).getFechaNac();
				fila[5] = tut.get(i).getGenero();
				fila[6] = tut.get(i).getDepartamento();
				fila[7] = tut.get(i).getLocalidad();
				fila[8] = tut.get(i).getMail();
				fila[9] = tut.get(i).getTelefono();
				fila[10] = tut.get(i).getTipoUsuario();
				fila[11] = tut.get(i).getMailInstitucional();
				fila[12] = tut.get(i).getItr().getNombre();
				fila[13] = tut.get(i).getEstadoUsuario().getNombre();
				fila[14] = tut.get(i).getArea();
				fila[15] = tut.get(i).getTipoRol();

				model.addRow(fila);
			}

		} catch (ServiciosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	void listarUsuariosAnalista() {
		String[] colums = { "ID", "Nombres", "Apellidos", "Cédula", "Fecha nacimiento", "Genero", "Departamento",
				"Localidad", "Email personal", "Teléfono", "Usuario", "Email institucional", "ITR", "Estado Usuario" };
		model = new DefaultTableModel(colums, 0);
		table.setModel(model);

		try {
			List<Analista> ana = analistaBean.obtenerTodosAnalistas();

			Object[] fila = new Object[14];

			model.setRowCount(0);

			for (int i = 0; i < ana.size(); i++) {
				fila[0] = ana.get(i).getIdUsuario();
				fila[1] = ana.get(i).getNombre();
				fila[2] = ana.get(i).getApellido();
				fila[3] = ana.get(i).getDocumento();
				fila[4] = ana.get(i).getFechaNac();
				fila[5] = ana.get(i).getGenero();
				fila[6] = ana.get(i).getDepartamento();
				fila[7] = ana.get(i).getLocalidad();
				fila[8] = ana.get(i).getMail();
				fila[9] = ana.get(i).getTelefono();
				fila[10] = ana.get(i).getTipoUsuario();
				fila[11] = ana.get(i).getMailInstitucional();
				fila[12] = ana.get(i).getItr().getNombre();
				fila[13] = ana.get(i).getEstadoUsuario().getNombre();
//				fila[14] = ana.get(i).getItr();

				model.addRow(fila);
			}

		} catch (ServiciosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private int recorrerITR(String nombre, JComboBox combo) {
		int indice = 0;

		for (int i = 0; i < comboITR.getItemCount(); i++) {

			if (comboITR.getItemAt(i).toString().equals(nombre)) {

				indice = i;

			}

		}
		return indice;
	}

	private int recorrerTipoUsuario(String nombre, JComboBox combo) {
		int indice = 0;

		for (int i = 0; i < comboBox_Tipo_Usuario.getItemCount(); i++) {

			if (comboBox_Tipo_Usuario.getItemAt(i).toString().equals(nombre)) {

				indice = i;

			}

		}
		return indice;
	}

	private int recorrerEstadoUsuario(String nombre, JComboBox combo) {
		int indice = 0;

		for (int i = 0; i < comboBox_Estado_Usuario.getItemCount(); i++) {

			if (comboBox_Estado_Usuario.getItemAt(i).toString().equals(nombre)) {

				indice = i;

			}

		}
		return indice;
	}

	void agregarCampos() throws ServiciosException {

		idEst = (Long) model.getValueAt(table.getSelectedRow(), 0);

		txtNombres.setText((String) model.getValueAt(table.getSelectedRow(), 1));

		txtApellidos.setText((String) model.getValueAt(table.getSelectedRow(), 2));

		int doc = ((int) model.getValueAt(table.getSelectedRow(), 3));
		txtDocumento.setText((doc + ""));

		dateFec_Nac.setDate((Date) model.getValueAt(table.getSelectedRow(), 4));

		comboGenero.setSelectedItem(model.getValueAt(table.getSelectedRow(), 5));

		comboDepa.setSelectedItem(model.getValueAt(table.getSelectedRow(), 6));

		txtIngreseLocalidad.setText((String) model.getValueAt(table.getSelectedRow(), 7));

		txtEmail.setText(((String) model.getValueAt(table.getSelectedRow(), 8)));

		txtTelefono.setText((String) model.getValueAt(table.getSelectedRow(), 9));

		TipoUsuario cambio = (TipoUsuario) model.getValueAt(table.getSelectedRow(), 10);
		int indice = recorrerTipoUsuario(cambio.getNombre(), comboBox_Tipo_Usuario);
		comboBox_Tipo_Usuario.setSelectedIndex(indice);

		txtEmail_Institucional.setText((String) model.getValueAt(table.getSelectedRow(), 11));

//		ITR cambio2 = (ITR) model.getValueAt(table.getSelectedRow(), 12);
//		int indice2 = recorrerITR(cambio2.getNombre(), comboITR);
//		comboITR.setSelectedIndex(indice2);

		String cambio2 = (String) model.getValueAt(table.getSelectedRow(), 12);
		int indice2 = recorrerITR(cambio2, comboITR);
		comboITR.setSelectedIndex(indice2);

		String cambio1 = (String) model.getValueAt(table.getSelectedRow(), 13);
		int indice1 = recorrerEstadoUsuario(cambio1, comboBox_Estado_Usuario);
		comboBox_Estado_Usuario.setSelectedIndex(indice1);

		if ((TipoUsuario) model.getValueAt(table.getSelectedRow(), 10) == (TipoUsuario.Tutor)) {

			Tutor T = new Tutor();
			List<Tutor> tutores = tutorBean.obtenerTodosTutores();

			for (Tutor tutor : tutores) {
				if (tutor.getIdUsuario() == idEst) {
					T = tutor;

				}

			}

			txtIngreseArea.setText(T.getArea());

			if (T.getTipoRol() == TipoRol.Encargado) {
				condicion = true;
				condicion1 = false;

			}

			if (T.getTipoRol() == TipoRol.Tutor) {
				condicion1 = true;
				condicion = false;

			}
			rdbtnEncargado.setSelected(condicion);
			rdbtnTutor.setSelected(condicion1);

		} else if ((TipoUsuario) model.getValueAt(table.getSelectedRow(), 10) == (TipoUsuario.Estudiante)) {

			Estudiante E = new Estudiante();
			List<Estudiante> estudiantes = estudianteBean.obtenerTodosEstudiantes();

			for (Estudiante estudiante : estudiantes) {
				if (estudiante.getIdUsuario() == idEst) {
					E = estudiante;

				}

			}

			comboBox_Estado_Estudiante.setSelectedItem(E.getEstadoEstudiante().getNombre());

			yearChooserAñoIngreso.setYear(Integer.parseInt(E.getAñoIngreso()));

			comboGenero.setSelectedItem(model.getValueAt(table.getSelectedRow(), 5));
		}

		else if ((TipoUsuario) model.getValueAt(table.getSelectedRow(), 10) == (TipoUsuario.Analista)) {

		}
	}

	void obtenerPorFiltros() throws ServiciosException {
		ITR itrs = itrBean.obtenerTodosITRPorNombre((String) comboITRFIltro.getSelectedItem());

//		if (comboTipoDeUsuarioFiltro.getSelectedIndex() == 0) {
//			tipoUsuario = null;
//		}
//		if (comboTipoDeUsuarioFiltro.getSelectedIndex() == 1) {
//			tipoUsuario = TipoUsuario.Analista;
//		}
//
//		if (comboTipoDeUsuarioFiltro.getSelectedIndex() == 2) {
//			tipoUsuario = TipoUsuario.Estudiante;
//		}
//		if (comboTipoDeUsuarioFiltro.getSelectedIndex() == 3) {
//			tipoUsuario = TipoUsuario.Tutor;
//		}

//		if (comboEstadoUsuarioFiltro.getSelectedIndex() == 0) {
//			estadoUsuario = null;
//		}
//		if (comboEstadoUsuarioFiltro.getSelectedIndex() == 1) {
//			estadoUsuario = EstadoUsuario.Validado;
//		}
//
//		if (comboEstadoUsuarioFiltro.getSelectedIndex() == 2) {
//			estadoUsuario = EstadoUsuario.SinValidar;
//		}
//		if (comboEstadoUsuarioFiltro.getSelectedIndex() == 3) {
//			estadoUsuario = EstadoUsuario.Eliminado;
//		}
		///////

		String[] colums = { "ID", "Nombres", "Apellidos", "Cédula", "Fecha nacimiento", "Genero", "Departamento",
				"Localidad", "Email personal", "Teléfono", "Usuario", "Email institucional", "ITR", "Estado Usuario", };
		model = new DefaultTableModel(colums, 0);
		table.setModel(model);

		List<Usuario> usuarios = usuarioBean.obtenerPorFiltros(tipoUsuario, null, estadoUsuario);

		for (Usuario usuario : usuarios) {

//			List<Usuario> usu = usuarioBean.obtenerTodosUsuarios();
//			List<Usuario> usuarioElim = new ArrayList();
//			
//			for (Usuario usurr : usu) {
//				if (usurr.getEstadoUsuario() != estadoUsuario.Eliminado) {
//					usuarioElim.add(usurr);
//				}
			Object[] fila = new Object[14];

			model.setRowCount(0);

			for (int i = 0; i < usuarios.size(); i++) {
				fila[0] = usuarios.get(i).getIdUsuario();
				fila[1] = usuarios.get(i).getNombre();
				fila[2] = usuarios.get(i).getApellido();
				fila[3] = usuarios.get(i).getDocumento();
				fila[4] = usuarios.get(i).getFechaNac();
				fila[5] = usuarios.get(i).getGenero();
				fila[6] = usuarios.get(i).getDepartamento();
				fila[7] = usuarios.get(i).getLocalidad();
				fila[8] = usuarios.get(i).getMail();
				fila[9] = usuarios.get(i).getTelefono();
				fila[10] = usuarios.get(i).getTipoUsuario();
				fila[11] = usuarios.get(i).getMailInstitucional();
				fila[12] = usuarios.get(i).getItr().getNombre();
				fila[13] = usuarios.get(i).getEstadoUsuario().getNombre();

				model.addRow(fila);
			}
		}
	}
}
