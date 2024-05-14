package com.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.entities.Estudiante;
import com.entities.Usuario;
import com.exception.ServiciosException;
import com.servicios.EstudianteBeanRemote;
import com.servicios.EventoBeanRemote;
import com.servicios.UsuarioBeanCliente;
import com.servicios.UsuarioBeanImp;
import java.awt.GridLayout;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;

public class PDE_Lista_Eventos extends JPanel {

	private JPanel panelCentro;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel_1;
	private JButton btnBuscar;
	private JPanel panel_2;
	private JSeparator separator;
	private JLabel lblNewLabel_3;
	private JComboBox comboBox_Tipo_de_Filtro;
	private JComboBox comboBox_Generacion;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_4_1;
	private JPanel panelPie;
	private JPanel panel_controlPie_Botones;
	private JButton btnBorrar;
	private JButton btnModificar;
	private JButton btnRefrescar;
	private JTable tablaEstudiantes;
	private JPanel panel_4;
	private String[] colums = { "ID", "Nombres", "Apellidos", "Cédula", "Fecha nacimiento", "Genero", "Departamento",
			"Localidad", "Email personal", "Teléfono", "Usuario", "Email institucional", "Contraseñia", "ITR", };
	private DefaultTableModel model = new DefaultTableModel(colums, 0);
	private JTable table;
	private UsuarioBeanCliente usuarioBean = new UsuarioBeanImp();
	private JPanel panel_5;
	private JPanel panel_6;
	private JTextField txt_Titulo_Evento;
	private JTextField txt_Localizacion;
	private JTextField textField_2;

	public PDE_Lista_Eventos() {
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
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int fila = table.get
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

		comboBox_Tipo_de_Filtro = new JComboBox();
		comboBox_Tipo_de_Filtro.setBackground(Color.WHITE);
		comboBox_Tipo_de_Filtro.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar tipo de filtro",
				"Tipo de evento", "Fecha de inicio", "Modalidad: Virtual", "Modalidad: Presencial",
				"Modalidad: Semipresencial", "ITR", "Estado: Finalizado", "Estado: Corriente", "Estado: Futuro" }));
		panel_2.add(comboBox_Tipo_de_Filtro, BorderLayout.CENTER);

		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel(" Listado de eventos ");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBackground(Color.WHITE);
		panel_3.add(lblNewLabel, BorderLayout.WEST);

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

		panel_4 = new JPanel();

		panelPie = new JPanel();
		add(panelPie, BorderLayout.SOUTH);
		panelPie.setLayout(new BorderLayout(0, 0));

		panel_controlPie_Botones = new JPanel();
		panel_controlPie_Botones.setBackground(new Color(240, 240, 240));
		panelPie.add(panel_controlPie_Botones, BorderLayout.EAST);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFocusable(false);
		btnBorrar.setRequestFocusEnabled(false);
		btnBorrar.setForeground(Color.WHITE);
		btnBorrar.setFont(new Font("Arial", Font.BOLD, 13));
		btnBorrar.setBorderPainted(false);
		btnBorrar.setBackground(new Color(0, 102, 255));
		panel_controlPie_Botones.add(btnBorrar);

		btnModificar = new JButton("Modificar");
		btnModificar.setRequestFocusEnabled(false);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Arial", Font.BOLD, 13));
		btnModificar.setBorderPainted(false);
		btnModificar.setBackground(new Color(0, 102, 255));
		panel_controlPie_Botones.add(btnModificar);

		btnRefrescar = new JButton("Refrescar");
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				listarUsuarios();

			}
		});
		btnRefrescar.setRequestFocusEnabled(false);
		btnRefrescar.setForeground(Color.WHITE);
		btnRefrescar.setFont(new Font("Arial", Font.BOLD, 13));
		btnRefrescar.setBorderPainted(false);
		btnRefrescar.setBackground(new Color(0, 102, 255));
		panel_controlPie_Botones.add(btnRefrescar);

		panelCentro.add(panel_4.add(new JScrollPane(tablaEstudiantes)), BorderLayout.CENTER);
		
		panel_5 = new JPanel();
		panelCentro.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_5.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("Datos a modificar");
		lblNewLabel_3_1.setForeground(Color.GRAY);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(10, 11, 160, 22);
		panel_6.add(lblNewLabel_3_1);
		
		JLabel lbl_Titulo = new JLabel("Titulo");
		lbl_Titulo.setForeground(new Color(30, 144, 255));
		lbl_Titulo.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Titulo.setBounds(10, 55, 86, 14);
		panel_6.add(lbl_Titulo);
		
		txt_Titulo_Evento = new JTextField();
		txt_Titulo_Evento.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txt_Titulo_Evento.getText().equals("Ingrese Titulo")) {
					txt_Titulo_Evento.setText("");
					txt_Titulo_Evento.setForeground(Color.BLACK);
				}
				
				
				if (txt_Localizacion.getText().isEmpty()) {
					txt_Localizacion.setText("Ingrese Localización del evento");
					txt_Localizacion.setForeground(Color.GRAY);
				}
				
		
			}
		});
		txt_Titulo_Evento.setText("Ingrese Titulo");
		txt_Titulo_Evento.setForeground(new Color(102, 102, 102));
		txt_Titulo_Evento.setFont(new Font("Arial", Font.PLAIN, 11));
		txt_Titulo_Evento.setDisabledTextColor(Color.LIGHT_GRAY);
		txt_Titulo_Evento.setColumns(10);
		txt_Titulo_Evento.setBorder(null);
		txt_Titulo_Evento.setBounds(10, 74, 118, 20);
		panel_6.add(txt_Titulo_Evento);
		
		JComboBox comboBox_Tipo_Evento = new JComboBox();
		comboBox_Tipo_Evento.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Examen", "Jornada_presencial", "Prueba_final", "Defensa_de_proyecto", "Evento_vme", "Actividad_optativa", "Actividad_ape"}));
		comboBox_Tipo_Evento.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_Tipo_Evento.setBorder(null);
		comboBox_Tipo_Evento.setBounds(138, 80, 118, 21);
		panel_6.add(comboBox_Tipo_Evento);
		
		JLabel lbl_Tipo = new JLabel("Tipo");
		lbl_Tipo.setForeground(new Color(30, 144, 255));
		lbl_Tipo.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Tipo.setBounds(138, 56, 118, 14);
		panel_6.add(lbl_Tipo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		separator_1.setBackground(Color.GRAY);
		separator_1.setBounds(10, 99, 118, 2);
		panel_6.add(separator_1);
		
		JLabel lbl_Inicio = new JLabel("Inicio");
		lbl_Inicio.setForeground(new Color(30, 144, 255));
		lbl_Inicio.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Inicio.setBounds(266, 31, 41, 14);
		panel_6.add(lbl_Inicio);
		
		JLabel lbl_Fecha_Ini = new JLabel("Fecha");
		lbl_Fecha_Ini.setForeground(Color.BLACK);
		lbl_Fecha_Ini.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Fecha_Ini.setBounds(266, 56, 118, 14);
		panel_6.add(lbl_Fecha_Ini);
		
		JDateChooser dateFeccha_Inicio = new JDateChooser();
		dateFeccha_Inicio.setBorder(null);
		dateFeccha_Inicio.setBounds(266, 79, 118, 22);
		panel_6.add(dateFeccha_Inicio);
		
		JSpinner spinnerHora_Ini = new JSpinner();
		spinnerHora_Ini.setBounds(394, 79, 41, 22);
		panel_6.add(spinnerHora_Ini);
		
		JLabel lbl_Hora_Ini = new JLabel("Hora");
		lbl_Hora_Ini.setForeground(Color.BLACK);
		lbl_Hora_Ini.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Hora_Ini.setBounds(394, 56, 41, 14);
		panel_6.add(lbl_Hora_Ini);
		
		JLabel lbl_minuto_1 = new JLabel(":");
		lbl_minuto_1.setForeground(Color.BLACK);
		lbl_minuto_1.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_minuto_1.setBounds(445, 79, 4, 20);
		panel_6.add(lbl_minuto_1);
		
		JSpinner spinnerMinuto_Ini = new JSpinner();
		spinnerMinuto_Ini.setBounds(459, 79, 41, 22);
		panel_6.add(spinnerMinuto_Ini);
		
		JLabel lbl_Minuto_Ini = new JLabel("Minuto");
		lbl_Minuto_Ini.setForeground(Color.BLACK);
		lbl_Minuto_Ini.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Minuto_Ini.setBounds(459, 53, 53, 20);
		panel_6.add(lbl_Minuto_Ini);
		
		JLabel lbl_Fin = new JLabel("Fin");
		lbl_Fin.setForeground(new Color(30, 144, 255));
		lbl_Fin.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Fin.setBounds(522, 35, 118, 14);
		panel_6.add(lbl_Fin);
		
		JLabel lbl_Fecha_Fin = new JLabel("Fecha");
		lbl_Fecha_Fin.setForeground(Color.BLACK);
		lbl_Fecha_Fin.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Fecha_Fin.setBounds(522, 56, 118, 14);
		panel_6.add(lbl_Fecha_Fin);
		
		JDateChooser dateFecha_Fin = new JDateChooser();
		dateFecha_Fin.setBorder(null);
		dateFecha_Fin.setBounds(522, 79, 118, 22);
		panel_6.add(dateFecha_Fin);
		
		JSpinner spinnerHora_Fin = new JSpinner();
		spinnerHora_Fin.setBounds(650, 79, 41, 22);
		panel_6.add(spinnerHora_Fin);
		
		JLabel lbl_Hora_Fin = new JLabel("Hora");
		lbl_Hora_Fin.setForeground(Color.BLACK);
		lbl_Hora_Fin.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Hora_Fin.setBounds(650, 56, 41, 14);
		panel_6.add(lbl_Hora_Fin);
		
		JLabel lbl_minuto_1_1 = new JLabel(":");
		lbl_minuto_1_1.setForeground(Color.BLACK);
		lbl_minuto_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_minuto_1_1.setBounds(701, 79, 4, 20);
		panel_6.add(lbl_minuto_1_1);
		
		JLabel lbl_Minuto_Fin = new JLabel("Minuto");
		lbl_Minuto_Fin.setForeground(Color.BLACK);
		lbl_Minuto_Fin.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Minuto_Fin.setBounds(715, 53, 53, 20);
		panel_6.add(lbl_Minuto_Fin);
		
		JSpinner spinnerMinuto_Fin = new JSpinner();
		spinnerMinuto_Fin.setBounds(715, 79, 41, 22);
		panel_6.add(spinnerMinuto_Fin);
		
		JLabel itr = new JLabel("ITR");
		itr.setForeground(new Color(30, 144, 255));
		itr.setFont(new Font("Arial", Font.BOLD, 13));
		itr.setBounds(138, 112, 118, 14);
		panel_6.add(itr);
		
		JComboBox comboITR = new JComboBox();
		comboITR.setBorder(null);
		comboITR.setBounds(138, 137, 183, 22);
		panel_6.add(comboITR);
		
		JComboBox comboBox_Modalidad = new JComboBox();
		comboBox_Modalidad.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Virtual", "Presencial", "Semipresencial"}));
		comboBox_Modalidad.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_Modalidad.setBorder(null);
		comboBox_Modalidad.setBounds(10, 135, 118, 24);
		panel_6.add(comboBox_Modalidad);
		
		JLabel lblTipoDeUsuario = new JLabel("Modalidad");
		lblTipoDeUsuario.setForeground(new Color(30, 144, 255));
		lblTipoDeUsuario.setFont(new Font("Arial", Font.BOLD, 13));
		lblTipoDeUsuario.setBounds(10, 112, 118, 14);
		panel_6.add(lblTipoDeUsuario);
		
		JLabel lbl_Localizacion = new JLabel("Localización");
		lbl_Localizacion.setForeground(new Color(30, 144, 255));
		lbl_Localizacion.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Localizacion.setBounds(331, 113, 118, 14);
		panel_6.add(lbl_Localizacion);
		
		txt_Localizacion = new JTextField();
		txt_Localizacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txt_Localizacion.getText().equals("Ingrese Localización del evento")) {
					txt_Localizacion.setText("");
					txt_Localizacion.setForeground(Color.BLACK);
				}
				if (txt_Titulo_Evento.getText().isEmpty()) {
					txt_Titulo_Evento.setText("Ingrese Titulo");
					txt_Titulo_Evento.setForeground(Color.GRAY);
				}
				
			}
		});
		txt_Localizacion.setText("Ingrese Localización del evento");
		txt_Localizacion.setForeground(new Color(102, 102, 102));
		txt_Localizacion.setFont(new Font("Arial", Font.PLAIN, 11));
		txt_Localizacion.setDisabledTextColor(Color.LIGHT_GRAY);
		txt_Localizacion.setColumns(10);
		txt_Localizacion.setBorder(null);
		txt_Localizacion.setBounds(331, 131, 169, 20);
		panel_6.add(txt_Localizacion);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(Color.GRAY);
		separator_6.setBackground(Color.GRAY);
		separator_6.setBounds(331, 157, 169, 2);
		panel_6.add(separator_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 0, -5, -13);
		panel_6.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEstadoDelEvento = new JLabel("Estado del evento");
		lblEstadoDelEvento.setForeground(new Color(30, 144, 255));
		lblEstadoDelEvento.setFont(new Font("Arial", Font.BOLD, 13));
		lblEstadoDelEvento.setBounds(522, 112, 169, 14);
		panel_6.add(lblEstadoDelEvento);
		
		JComboBox comboITR_1 = new JComboBox();
		comboITR_1.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Finalizado", "Corriente", "Futuro"}));
		comboITR_1.setBorder(null);
		comboITR_1.setBounds(522, 137, 118, 22);
		panel_6.add(comboITR_1);
		
		
	}

	void listarUsuarios() {
		table.setModel(model);

		List<Usuario> est;

		try {
			est = usuarioBean.obtenerTodosUsuarios();
			Object[] fila = new Object[15];

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
				fila[12] = est.get(i).getContrasenia();
				fila[13] = est.get(i).getItr();

				model.addRow(fila);
			}

		} catch (ServiciosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
