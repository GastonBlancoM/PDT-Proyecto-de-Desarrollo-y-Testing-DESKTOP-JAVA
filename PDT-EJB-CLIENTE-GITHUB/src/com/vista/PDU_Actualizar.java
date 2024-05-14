package com.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import com.dto.EstudianteDTO;
import com.entities.ITR;
import com.entities.Usuario;
import com.enums.EstadoEstudiante;
import com.enums.EstadoUsuario;
import com.enums.TipoUsuario;
import com.exception.ServiciosException;
import com.servicios.AnalistaBeanCliente;
import com.servicios.AnalistaBeanImp;
import com.servicios.EstudianteBeanCliente;
import com.servicios.EstudianteBeanImp;
import com.servicios.ITRBeanCliente;
import com.servicios.ITRBeanImp;
import com.servicios.TutorBeanCliente;
import com.servicios.TutorBeanImp;
import com.servicios.UsuarioBeanCliente;
import com.servicios.UsuarioBeanImp;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTree;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JSeparator;

public class PDU_Actualizar extends JPanel {
	private JTextField txtDocumento;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtIngreseLocalidad;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JTextField txtEmail_Institucional;
	private JTextField textField;
	static String contraCambiante = "pepito";
	static Date fechaGlobal;
	static int documentoGlobal;
	private ITRBeanCliente itrBean = new ITRBeanImp();
	private AnalistaBeanCliente analistaBean = new AnalistaBeanImp();
	private TutorBeanCliente tutorBean = new TutorBeanImp();
	private UsuarioBeanCliente usuarioBean = new UsuarioBeanImp();
	private EstudianteBeanCliente estudianteBean = new EstudianteBeanImp();
	private JDateChooser dateFec_Nac = new JDateChooser();
	private JComboBox comboDepa = new JComboBox();
	private JComboBox comboITR = new JComboBox();
	private JPasswordField passwordField;
	private JComboBox comboGenero = new JComboBox();
	private JRadioButton rbtnVerContra = new JRadioButton("");
	// private JLabel lblClickParaVer = new JLabel("Ver contraseña");
	private JLabel lblContrasenia = new JLabel("Contraseña: ");

	/**
	 * Create the panel.
	 */
	public PDU_Actualizar() {
		setLayout(new BorderLayout(0, 0));

		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(Color.WHITE);
		add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));
		// lblClickParaVer.setVisible(false);
		JPanel panelEncabezado = new JPanel();
		panelEncabezado.setBackground(Color.WHITE);
		panelCentro.add(panelEncabezado, BorderLayout.NORTH);
		panelEncabezado.setLayout(new BorderLayout(0, 0));

		JLabel lblModificarDatos = new JLabel(" Modificar datos ");
		lblModificarDatos.setHorizontalAlignment(SwingConstants.LEFT);
		lblModificarDatos.setForeground(Color.DARK_GRAY);
		lblModificarDatos.setFont(new Font("Arial", Font.BOLD, 20));
		lblModificarDatos.setBackground(Color.DARK_GRAY);
		panelEncabezado.add(lblModificarDatos, BorderLayout.WEST);

		JLabel lblNewLabel_1_1 = new JLabel(" ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 5));
		panelEncabezado.add(lblNewLabel_1_1, BorderLayout.SOUTH);

		JLabel lblNewLabel_2 = new JLabel("  ");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(0, 102, 255));
		panelEncabezado.add(lblNewLabel_2, BorderLayout.CENTER);

		JLabel lblNewLabel_4 = new JLabel(" ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 5));
		panelEncabezado.add(lblNewLabel_4, BorderLayout.NORTH);

		JLabel lblNewLabel_5 = new JLabel("  ");
		panelEncabezado.add(lblNewLabel_5, BorderLayout.EAST);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panelCentro.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		rbtnVerContra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		rbtnVerContra.setToolTipText("Mostrar contraseña");
		rbtnVerContra.setBackground(Color.WHITE);
		rbtnVerContra.setIcon(new ImageIcon(PDU_Actualizar.class.getResource("/com/iconos/ojo.png")));
		rbtnVerContra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					verContrasenia();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

		rbtnVerContra.setBounds(748, 172, 33, 20);
		panel.add(rbtnVerContra);

		JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento: ");
		lblFechaNacimiento.setFont(new Font("Arial", Font.BOLD, 13));
		lblFechaNacimiento.setBounds(210, 145, 146, 14);
		panel.add(lblFechaNacimiento);

		JLabel lblEmail_Personal = new JLabel("Email personal: ");
		lblEmail_Personal.setFont(new Font("Arial", Font.BOLD, 13));
		lblEmail_Personal.setBounds(10, 375, 146, 14);
		panel.add(lblEmail_Personal);

		JLabel lblTelefono = new JLabel("Teléfono: ");
		lblTelefono.setFont(new Font("Arial", Font.BOLD, 13));
		lblTelefono.setBounds(10, 305, 146, 14);
		panel.add(lblTelefono);

		JLabel lblDepartamento = new JLabel("Departamento: ");
		lblDepartamento.setFont(new Font("Arial", Font.BOLD, 13));
		lblDepartamento.setBounds(10, 225, 146, 14);
		panel.add(lblDepartamento);

		JLabel lblLocalidad = new JLabel("Localidad: ");
		lblLocalidad.setFont(new Font("Arial", Font.BOLD, 13));
		lblLocalidad.setBounds(210, 225, 146, 14);
		panel.add(lblLocalidad);

		JLabel lblEmail_Institucional = new JLabel("Email institucional: ");
		lblEmail_Institucional.setFont(new Font("Arial", Font.BOLD, 13));
		lblEmail_Institucional.setBounds(513, 72, 146, 14);
		panel.add(lblEmail_Institucional);

		JLabel lblITR = new JLabel("ITR: ");
		lblITR.setFont(new Font("Arial", Font.BOLD, 13));
		lblITR.setBounds(513, 225, 146, 14);
		panel.add(lblITR);

		JLabel lblCedula = new JLabel("Cedula: ");
		lblCedula.setFont(new Font("Arial", Font.BOLD, 13));
		lblCedula.setBounds(10, 145, 53, 16);
		panel.add(lblCedula);

		JLabel lblNombres = new JLabel("Nombres: ");
		lblNombres.setFont(new Font("Arial", Font.BOLD, 13));
		lblNombres.setBounds(10, 71, 109, 16);
		panel.add(lblNombres);

		JLabel lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setFont(new Font("Arial", Font.BOLD, 13));
		lblApellidos.setBounds(210, 71, 109, 16);
		panel.add(lblApellidos);

		txtDocumento = new JTextField();
		txtDocumento.setToolTipText("Este campo no puede modificarse");
		txtDocumento.setEditable(false);
		txtDocumento.setBounds(10, 172, 190, 20);
		panel.add(txtDocumento);
		txtDocumento.setColumns(10);

		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(10, 98, 190, 20);
		panel.add(txtNombres);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(210, 98, 190, 20);
		panel.add(txtApellidos);

		txtIngreseLocalidad = new JTextField();
		txtIngreseLocalidad.setColumns(10);
		txtIngreseLocalidad.setBounds(210, 250, 190, 20);
		panel.add(txtIngreseLocalidad);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(10, 400, 265, 20);
		panel.add(txtEmail);

		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(10, 330, 190, 20);
		panel.add(txtTelefono);

		txtEmail_Institucional = new JTextField();
		txtEmail_Institucional.setColumns(10);
		txtEmail_Institucional.setBounds(513, 97, 268, 20);
		panel.add(txtEmail_Institucional);

		dateFec_Nac.setBounds(210, 170, 190, 20);
		panel.add(dateFec_Nac);
		comboDepa.setModel(new DefaultComboBoxModel(
				new String[] { "Selecccionar", "Artigas", "Canelones", "Cerro Largo", "Colonia", "Durazno", "Flores",
						"Florida", "Lavalleja", "Maldonado", "Montevideo", "Paysandú", "Río Negro", "Rivera", "Rocha",
						"Salto", "San José", "Soriano", "Tacuarembó", "Treinta y Tres" }));

		comboDepa.setBackground(Color.WHITE);
		comboDepa.setBounds(10, 249, 190, 20);
		panel.add(comboDepa);

		lblContrasenia.setFont(new Font("Arial", Font.BOLD, 13));
		lblContrasenia.setBounds(513, 145, 146, 14);
		panel.add(lblContrasenia);

		comboITR.setBackground(Color.WHITE);
		comboITR.setBounds(513, 250, 268, 20);
		panel.add(comboITR);
		comboITR.addItem("Seleccionar");

		for (String itr : RellenarITR()) {
			comboITR.addItem(itr);
		}
		textField = new JTextField();
		textField.setBounds(10, 0, -3, -3);
		panel.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setEditable(false);
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//			if)()

			}
		});
		passwordField.setBounds(513, 172, 229, 20);
		panel.add(passwordField);

		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setFont(new Font("Arial", Font.BOLD, 13));
		lblGenero.setBounds(210, 305, 146, 14);
		panel.add(lblGenero);
		comboGenero.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar", "Masculino", "Femenino", "Otro" }));

		comboGenero.setBackground(Color.WHITE);
		comboGenero.setBounds(210, 329, 190, 20);
		panel.add(comboGenero);

		JLabel lblCambioContra = new JLabel("Cambiar contraseña");
		lblCambioContra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCambioContra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCambioContra.setForeground(new Color(218, 165, 32));
		lblCambioContra.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				cambioContraseña frame = new cambioContraseña();
				frame.setVisible(true);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCambioContra.setForeground(new Color(255, 215, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblCambioContra.setForeground(new Color(218, 165, 32));
			}
		});
		
		
		
		lblCambioContra.setFont(new Font("Arial", Font.BOLD, 10));
		lblCambioContra.setBounds(513, 192, 229, 14);
		panel.add(lblCambioContra);
		
		JLabel lblNewLabel = new JLabel("Personales");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 92, 14);
		panel.add(lblNewLabel);
		
		JLabel lblInstitucionales = new JLabel("Institucionales");
		lblInstitucionales.setForeground(Color.GRAY);
		lblInstitucionales.setFont(new Font("Arial", Font.BOLD, 15));
		lblInstitucionales.setBounds(513, 12, 146, 14);
		panel.add(lblInstitucionales);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 33, 390, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(513, 33, 390, 2);
		panel.add(separator_1);

//		lblClickParaVer.setFont(new Font("Arial", Font.PLAIN, 13));
//		lblClickParaVer.setBounds(256, 187, 181, 14);
//		panel.add(lblClickParaVer);

		JPanel panelPie = new JPanel();
		add(panelPie, BorderLayout.SOUTH);
		panelPie.setLayout(new BorderLayout(0, 0));

		JPanel panel_controlPie_Botones = new JPanel();
		panel_controlPie_Botones.setBackground(new Color(240, 240, 240));
		panelPie.add(panel_controlPie_Botones, BorderLayout.EAST);

		JButton btnNewButton_4 = new JButton("Modificar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					modificarDatosPropios();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_4.setRequestFocusEnabled(false);
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBackground(new Color(0, 102, 255));
		panel_controlPie_Botones.add(btnNewButton_4);

	}

	void verContrasenia() throws ServiciosException {

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

	void cargarDatosPropios() throws ServiciosException {
		Usuario usu = usuarioBean.obtenerPorIdUsuario(Login.getIdLoginUsuario());

		txtNombres.setText(usu.getNombre());
		txtApellidos.setText(usu.getApellido());
		int a = usu.getDocumento();
		String b = String.valueOf(a);

		txtDocumento.setText(b);
		dateFec_Nac.setDate(usu.getFechaNac());
		comboDepa.setSelectedItem(usu.getDepartamento());
		comboGenero.setSelectedItem(usu.getGenero());

		txtIngreseLocalidad.setText(usu.getLocalidad());
		txtEmail.setText(usu.getMail());
		txtTelefono.setText(usu.getTelefono());

		ITR cambio2 = (ITR) usu.getItr();
		int indice2 = rellenarCampoITR(cambio2.getNombre(), comboITR);
		comboITR.setSelectedIndex(indice2);

		txtEmail_Institucional.setText(usu.getMailInstitucional());
		passwordField.setText(usu.getContrasenia());

	}

	private int rellenarCampoITR(String nombre, JComboBox combo) {
		int indice = 0;

		for (int i = 0; i < comboITR.getItemCount(); i++) {

			if (comboITR.getItemAt(i).toString().equals(nombre)) {

				indice = i;

			}

		}
		return indice;
	}

	private int rellenarCampoGenero(String nombre, JComboBox combo) {
		int indice = 0;

		for (int i = 0; i < comboGenero.getItemCount(); i++) {

			if (comboGenero.getItemAt(i).toString().equals(nombre)) {

				indice = i;

			}

		}
		return indice;
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

	void modificarDatosPropios() throws ServiciosException {
		System.out.println(contraCambiante);
		ITR itrs = itrBean.obtenerTodosITRPorNombre((String) comboITR.getSelectedItem());
		Usuario est;
		est = usuarioBean.obtenerPorIdUsuario(Login.getIdLoginUsuario());

		// estadoITR = EstadoITR.ACTIVO;
		//
//			} else if (comboBox_Estado_ITR.getSelectedItem().equals("Desactivado")) {
//				estadoITR = EstadoITR.DESACTIVADO;
		//
//			}
		//
//			else if (comboBox_Estado_ITR.getSelectedItem().equals("Eliminado")) {
//				estadoITR = EstadoITR.ELIMINADO;
		//
//			}
//			if (mailInsti.contains("utec.edu.uy") || mailInsti.contains("utec.edu.uy")
//					|| mailInsti.contains("estudiante.utec.edu.uy")) {
		//
//			} else {
//				JOptionPane.showMessageDialog(null,
//						"El correo debe contener el dominio correspondiente al tipo de usuario");
		//
//			}

		String[] parte = txtEmail_Institucional.getText().split("@");
		String parte1 = parte[0];

		EstudianteDTO estudiante = new EstudianteDTO();
		estudiante.setIdUsuario(est.getIdUsuario());
		estudiante.setNombre(txtNombres.getText());
		estudiante.setApellido(txtApellidos.getText());
		estudiante.setDocumento(est.getDocumento());
		estudiante.setDepartamento((String) comboDepa.getSelectedItem());
		estudiante.setTelefono(txtTelefono.getText());
		estudiante.setNombreUsuario(parte1);
		fechaGlobal = est.getFechaNac();
		estudiante.setAñoIngreso(dateFec_Nac.getDateFormatString());
		estudiante.setGenero((String) comboGenero.getSelectedItem());
		estudiante.setLocalidad(txtIngreseLocalidad.getText());
		estudiante.setMail((txtEmail.getText()));
		estudiante.setMailInstitucional(txtEmail_Institucional.getText());
		estudiante.setFechaNac(dateFec_Nac.getDate());
		estudiante.setContrasenia(passwordField.getText());
		estudiante.setTipoUsuario(TipoUsuario.Estudiante);
		estudiante.setEstadoUsuario(EstadoUsuario.Validado);
		estudiante.setEstadoEstudiante(estudiante.getEstadoEstudiante());
		estudiante.setItr(itrs);

		try {
			estudianteBean.modificarEstudiante(estudiante);
			JOptionPane.showMessageDialog(null, "Datos actualizados Correctamente");
		} catch (ServiciosException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
}
