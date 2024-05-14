package com.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.dto.Convocatoria_AsistenciaDTO;
import com.dto.EstudianteDTO;
import com.entities.Convocatoria_Asistencia;
import com.entities.Estudiante;
import com.entities.Evento;
import com.entities.ITR;
import com.entities.Usuario;
import com.enums.EstadoEstudiante;
import com.enums.EstadoUsuario;
import com.enums.TipoRol;
import com.enums.TipoUsuario;
import com.exception.ServiciosException;
import com.servicios.ConvocatoriaBeanCliente;
import com.servicios.ConvocatoriaBeanImp;
import com.servicios.EstudianteBeanCliente;
import com.servicios.EstudianteBeanImp;
import com.servicios.EventoBeanCliente;
import com.servicios.EventoBeanImp;
import com.servicios.ITRBeanCliente;
import com.servicios.ITRBeanImp;
import com.servicios.UsuarioBeanCliente;
import com.servicios.UsuarioBeanImp;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JToggleButton;

public class PDE_Convocatoria_Eventos extends JPanel {

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
	private JButton btnAsignar;

	private JPanel panel_4;
	private long idEst;

	private JTable tabla_Convocados;
	private String[] colums_Convocados = { "ID.Conv", "ID.Estu", "Estudiante", "Cédula", "Usuario", "Email institucional", "ITR", "Convocado a"};
	private DefaultTableModel model_Convocados = new DefaultTableModel(colums_Convocados, 0);
	private EstudianteBeanCliente estudianteBean = new EstudianteBeanImp();
	private ITRBeanCliente itrBean = new ITRBeanImp();
	private JPanel panel_5;
	private JPanel panel_6;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDocumento;
	private JTextField txtDepartamento;
	private UsuarioBeanCliente usuarioBean = new UsuarioBeanImp();
	private ConvocatoriaBeanCliente convocatoriaBean = new ConvocatoriaBeanImp();
	private TipoRol tipoRol;
	private JTextField textField;
	JComboBox combo_Eventos;
	private JLabel lbl_ConvocarA;
	private JLabel lblNewLabel_3_2;

	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	// private MenuPrincipalAnalista MPA = new MenuPrincipalAnalista();
	// private Convocatoria_Lista_De_Estudiantes Convocatoria_Lista_De_Estudiantes;

	private JTable table_est;
	private String[] colums_est = { "ID", "Nombres", "Apellidos", "Cédula", "Departamento" };
	private DefaultTableModel model_est = new DefaultTableModel(colums_est, 0);

	private EventoBeanCliente eventoBean = new EventoBeanImp();
	private JPanel contenedor_Lista_Estudiantes = new JPanel();
	private JPanel panel_7 = new JPanel();
	private JScrollPane scrollPane_1 = new JScrollPane();
	private JPanel panel_8;
	private JLabel lblNewLabel_7;
	private JTextField txt_Filtro_Documento;;
	private TableRowSorter trs;
	private JComboBox combo_Generacion;

	private JLabel lbl_Nombres = new JLabel("Nombres");
	private JLabel lbl_Apellidos = new JLabel("Apellidos");
	private JLabel lbl_Cedula_Identidad = new JLabel("C.I");
	private JLabel lbl_Departamento = new JLabel("Departamento");
	
	private JButton btnLista_de_estudiantes;
	
	private JLabel lbl_Generacion = new JLabel("Generación");

	private JComboBox comboBox_TipoAsignacion;
	private JButton btnLista_de_estudiantes_1;

	public PDE_Convocatoria_Eventos() {
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

		comboBox_Generacion = new JComboBox();
		comboBox_Generacion.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar generación" }));

		comboBox_Tipo_de_Filtro = new JComboBox();
		comboBox_Tipo_de_Filtro.setFocusable(false);
		comboBox_Tipo_de_Filtro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox_Tipo_de_Filtro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String item = (String) comboBox_Tipo_de_Filtro.getSelectedItem();

				if (item.equals("Estudiante")) {
					panel_2.add(comboBox_Generacion, BorderLayout.EAST);
				} else {
					panel_2.remove(comboBox_Generacion);
				}
			}
		});
		comboBox_Tipo_de_Filtro.setBackground(Color.WHITE);
		comboBox_Tipo_de_Filtro.setModel(
				new DefaultComboBoxModel(new String[] { "Seleccionar tipo de filtro", "Usuario", "Tutor", "Estudiante",
						"ITR", "Generación", "Estado: sin validar", "Estado: activo", "Estado: eliminado" }));
		panel_2.add(comboBox_Tipo_de_Filtro, BorderLayout.CENTER);

		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel(" Convocatoria a eventos ");
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

		tabla_Convocados = new JTable();
//		table.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				idEst = (Long) model.getValueAt(table.getSelectedRow(), 0);
//				txtNombres.setText((String) model.getValueAt(table.getSelectedRow(), 1));
//				txtApellidos.setText((String) model.getValueAt(table.getSelectedRow(), 2));
//				int doc = ((int) model.getValueAt(table.getSelectedRow(), 3));
//				comboGenero.setActionCommand((String) model.getValueAt(table.getSelectedRow(), 5));
//				txtIngreseLocalidad.setText((String) model.getValueAt(table.getSelectedRow(), 7));
//				txtDocumento.setText((doc + ""));
//				txtEmail.setText(((String) model.getValueAt(table.getSelectedRow(), 11)));
//				txtEmail_Institucional.setText(((String) model.getValueAt(table.getSelectedRow(), 15)));
//				int tel = ((int) model.getValueAt(table.getSelectedRow(), 12));
//				txtTelefono.setText(tel + "");
//
//			}
//		});
		scrollPane.setViewportView(tabla_Convocados);

		panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_5.add(panel_6);
		panel_6.setLayout(null);

		lbl_Nombres.setForeground(new Color(30, 144, 255));
		lbl_Nombres.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Nombres.setBounds(10, 62, 86, 14);
		panel_6.add(lbl_Nombres);

		txtNombres = new JTextField();
		txtNombres.setEditable(false);
		txtNombres.setBackground(Color.LIGHT_GRAY);

		txtNombres.setForeground(Color.BLACK);
		txtNombres.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNombres.setDisabledTextColor(Color.LIGHT_GRAY);
		txtNombres.setColumns(10);
		txtNombres.setBorder(null);
		txtNombres.setBounds(10, 81, 118, 20);
		panel_6.add(txtNombres);

		lbl_Apellidos.setForeground(new Color(30, 144, 255));
		lbl_Apellidos.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Apellidos.setBounds(138, 63, 118, 14);
		panel_6.add(lbl_Apellidos);

		txtApellidos = new JTextField();
		txtApellidos.setEditable(false);
		txtApellidos.setBackground(Color.LIGHT_GRAY);

		txtApellidos.setForeground(Color.BLACK);
		txtApellidos.setFont(new Font("Arial", Font.PLAIN, 11));
		txtApellidos.setDisabledTextColor(Color.LIGHT_GRAY);
		txtApellidos.setColumns(10);
		txtApellidos.setBorder(null);
		txtApellidos.setBounds(138, 80, 118, 20);
		panel_6.add(txtApellidos);

		separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		separator_1.setBackground(Color.GRAY);
		separator_1.setBounds(10, 106, 118, 2);
		panel_6.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setForeground(Color.GRAY);
		separator_2.setBackground(Color.GRAY);
		separator_2.setBounds(138, 105, 118, 3);
		panel_6.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setForeground(Color.GRAY);
		separator_3.setBackground(Color.GRAY);
		separator_3.setBounds(266, 106, 118, 2);
		panel_6.add(separator_3);
		
		separator_4 = new JSeparator();
		separator_4.setForeground(Color.GRAY);
		separator_4.setBackground(Color.GRAY);
		separator_4.setBounds(394, 106, 118, 2);
		panel_6.add(separator_4);

		lbl_Cedula_Identidad.setForeground(new Color(30, 144, 255));
		lbl_Cedula_Identidad.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Cedula_Identidad.setBounds(266, 61, 118, 14);
		panel_6.add(lbl_Cedula_Identidad);

		txtDocumento = new JTextField();
		txtDocumento.setEditable(false);
		txtDocumento.setBackground(Color.LIGHT_GRAY);

		txtDocumento.setForeground(Color.BLACK);
		txtDocumento.setFont(new Font("Arial", Font.PLAIN, 11));
		txtDocumento.setDisabledTextColor(Color.LIGHT_GRAY);
		txtDocumento.setColumns(10);
		txtDocumento.setBorder(null);
		txtDocumento.setBounds(266, 81, 118, 20);
		panel_6.add(txtDocumento);

		

		// JLabel departamento = new JLabel("Departamento");

		lbl_Departamento.setForeground(new Color(30, 144, 255));
		lbl_Departamento.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Departamento.setBounds(394, 61, 118, 14);
		panel_6.add(lbl_Departamento);

		textField = new JTextField();
		textField.setBounds(10, 0, -4, -6);
		panel_6.add(textField);
		textField.setColumns(10);

		combo_Eventos = new JComboBox();
		
		combo_Eventos.addItem("Seleccionar");
		
		for (String comEvent : RellenarEVENTO()) {
			combo_Eventos.addItem(comEvent);
		}
		

		combo_Eventos.setFocusable(false);
		combo_Eventos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		combo_Eventos.setFont(new Font("Arial", Font.PLAIN, 11));
		combo_Eventos.setBorder(null);
		combo_Eventos.setBounds(10, 142, 160, 20);
		panel_6.add(combo_Eventos);

		lbl_ConvocarA = new JLabel("Convocar a");
		lbl_ConvocarA.setForeground(new Color(30, 144, 255));
		lbl_ConvocarA.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_ConvocarA.setBounds(10, 119, 118, 14);
		panel_6.add(lbl_ConvocarA);

		lblNewLabel_3_2 = new JLabel("Asignación a eventos");
		lblNewLabel_3_2.setForeground(Color.GRAY);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(10, 12, 152, 21);
		panel_6.add(lblNewLabel_3_2);

		txtDepartamento = new JTextField();
		txtDepartamento.setEditable(false);
		txtDepartamento.setBackground(Color.LIGHT_GRAY);
		txtDepartamento.setForeground(Color.BLACK);
		txtDepartamento.setFont(new Font("Arial", Font.PLAIN, 11));
		txtDepartamento.setDisabledTextColor(Color.LIGHT_GRAY);
		txtDepartamento.setColumns(10);
		txtDepartamento.setBorder(null);
		txtDepartamento.setBounds(394, 80, 118, 20);
		panel_6.add(txtDepartamento);

		btnLista_de_estudiantes = new JButton("...");
		btnLista_de_estudiantes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLista_de_estudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnLista_de_estudiantes.setVisible(false);
				contenedor_Lista_Estudiantes.setVisible(true);
				listarUsuarios();

			}
		});
		btnLista_de_estudiantes.setRequestFocusEnabled(false);
		btnLista_de_estudiantes.setForeground(Color.WHITE);
		btnLista_de_estudiantes.setFont(new Font("Arial", Font.BOLD, 13));
		btnLista_de_estudiantes.setFocusable(false);
		btnLista_de_estudiantes.setBorderPainted(false);
		btnLista_de_estudiantes.setBackground(new Color(0, 102, 255));
		btnLista_de_estudiantes.setBounds(522, 78, 25, 25);
		panel_6.add(btnLista_de_estudiantes);

		contenedor_Lista_Estudiantes.setVisible(false);
		contenedor_Lista_Estudiantes.setBounds(522, 11, 547, 222);
		panel_6.add(contenedor_Lista_Estudiantes);
		contenedor_Lista_Estudiantes.setLayout(new BorderLayout(0, 0));

		contenedor_Lista_Estudiantes.add(panel_7, BorderLayout.NORTH);

		panel_7.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_6 = new JLabel("LISTA DE ESTUDIANTES");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBackground(SystemColor.textHighlight);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setOpaque(true);
		panel_7.add(lblNewLabel_6);

		JButton btn_Cerrar_List_Estu = new JButton("X");
		btn_Cerrar_List_Estu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Cerrar_List_Estu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_Cerrar_List_Estu.setForeground(Color.WHITE);
				btn_Cerrar_List_Estu.setBackground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn_Cerrar_List_Estu.setForeground(Color.BLACK);
				btn_Cerrar_List_Estu.setBackground(Color.WHITE);
			}
		});
		btn_Cerrar_List_Estu.setForeground(Color.BLACK);
		btn_Cerrar_List_Estu.setBackground(Color.WHITE);
		btn_Cerrar_List_Estu.setBorderPainted(false);
		btn_Cerrar_List_Estu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contenedor_Lista_Estudiantes.setVisible(false);
				btnLista_de_estudiantes.setVisible(true);
			}
		});
		panel_7.add(btn_Cerrar_List_Estu, BorderLayout.WEST);

		contenedor_Lista_Estudiantes.add(scrollPane_1, BorderLayout.CENTER);

		table_est = new JTable();
		table_est.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txtNombres.setText((String) model_est.getValueAt(table_est.getSelectedRow(), 1));
				txtApellidos.setText((String) model_est.getValueAt(table_est.getSelectedRow(), 2));
				int doc = ((int) model_est.getValueAt(table_est.getSelectedRow(), 3));
				txtDocumento.setText(doc + "");
				txtDepartamento.setText((String) model_est.getValueAt(table_est.getSelectedRow(), 4));
				;
				// System.out.println(Nombres);

			}
		});
		// panel_7.setLayout(new BorderLayout(0, 0));
		scrollPane_1.setViewportView(table_est);

		panel_8 = new JPanel();
		contenedor_Lista_Estudiantes.add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 1));

		lblNewLabel_7 = new JLabel("  Filtrar: ");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		panel_8.add(lblNewLabel_7);

		txt_Filtro_Documento = new JTextField();
		txt_Filtro_Documento.setToolTipText("Ingresar documento del estudiante");
		txt_Filtro_Documento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				trs.setRowFilter(RowFilter.regexFilter(txt_Filtro_Documento.getText(), 3));
			}
		});
		trs = new TableRowSorter(model_est);
		table_est.setRowSorter(trs);
		panel_8.add(txt_Filtro_Documento);
		txt_Filtro_Documento.setColumns(10);

		comboBox_TipoAsignacion = new JComboBox();
		comboBox_TipoAsignacion.setOpaque(false);
		comboBox_TipoAsignacion.setFocusable(false);
		comboBox_TipoAsignacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox_TipoAsignacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_TipoAsignacion.getSelectedItem().equals("Por estudiante")) {
					lbl_Nombres.setVisible(true);
					lbl_Apellidos.setVisible(true);
					lbl_Cedula_Identidad.setVisible(true);
					lbl_Departamento.setVisible(true);
					txtNombres.setVisible(true);
					txtApellidos.setVisible(true);
					txtDocumento.setVisible(true);
					txtDepartamento.setVisible(true);
					separator_1.setVisible(true);
					separator_2.setVisible(true);
					separator_3.setVisible(true);
					separator_4.setVisible(true);
					btnLista_de_estudiantes.setVisible(true);
					
					lbl_Generacion.setVisible(false);
					combo_Generacion.setVisible(false);
				} 
				if(comboBox_TipoAsignacion.getSelectedItem().equals("Por generación")){
					lbl_Generacion.setVisible(true);
					combo_Generacion.setVisible(true);
					
					lbl_Nombres.setVisible(false);
					lbl_Apellidos.setVisible(false);
					lbl_Cedula_Identidad.setVisible(false);
					lbl_Departamento.setVisible(false);
					txtNombres.setVisible(false);
					txtApellidos.setVisible(false);
					txtDocumento.setVisible(false);
					txtDepartamento.setVisible(false);
					separator_1.setVisible(false);
					separator_2.setVisible(false);
					separator_3.setVisible(false);
					separator_4.setVisible(false);
					btnLista_de_estudiantes.setVisible(false);
				}
			}
		});
		comboBox_TipoAsignacion.setFont(new Font("Arial", Font.PLAIN, 10));
		comboBox_TipoAsignacion.setModel(new DefaultComboBoxModel(new String[] { "Por estudiante", "Por generación" }));

		comboBox_TipoAsignacion.setBounds(172, 12, 108, 19);
		panel_6.add(comboBox_TipoAsignacion);

		combo_Generacion = new JComboBox();
		combo_Generacion.setFont(new Font("Arial", Font.PLAIN, 11));
		combo_Generacion.setBorder(null);
		combo_Generacion.setBounds(10, 81, 118, 20);
		panel_6.add(combo_Generacion);

		lbl_Generacion.setForeground(new Color(30, 144, 255));
		lbl_Generacion.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Generacion.setBounds(10, 62, 86, 14);
		panel_6.add(lbl_Generacion);
		
		btnLista_de_estudiantes_1 = new JButton("...");
		btnLista_de_estudiantes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					regisConvocatoriaPorEstudiante();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLista_de_estudiantes_1.setRequestFocusEnabled(false);
		btnLista_de_estudiantes_1.setForeground(Color.WHITE);
		btnLista_de_estudiantes_1.setFont(new Font("Arial", Font.BOLD, 13));
		btnLista_de_estudiantes_1.setFocusable(false);
		btnLista_de_estudiantes_1.setBorderPainted(false);
		btnLista_de_estudiantes_1.setBackground(new Color(0, 102, 255));
		btnLista_de_estudiantes_1.setBounds(469, 201, 25, 25);
		panel_6.add(btnLista_de_estudiantes_1);
		// scrollPane_1.add(table_est);

		panel_4 = new JPanel();

		panelPie = new JPanel();
		add(panelPie, BorderLayout.SOUTH);
		panelPie.setLayout(new BorderLayout(0, 0));

		panel_controlPie_Botones = new JPanel();
		panel_controlPie_Botones.setBackground(new Color(240, 240, 240));
		panelPie.add(panel_controlPie_Botones, BorderLayout.EAST);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		btnBorrar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					int salida = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el usuario?");
//					System.out.println(salida);
//					if (salida == 0) {
//						estudianteBean.borrarEstudiante(idEst);
//						listarConvocados();
//
//						JOptionPane.showMessageDialog(null, "Se elimino correctamente el usuario");
//					} else {
//						JOptionPane.showMessageDialog(null, "La eliminacion fue cancelada");
//					}
//
//				} catch (ServiciosException e1) {
//					// TODO Auto-generated catch block
//					JOptionPane.showMessageDialog(null, e1.getMessage());
//				}
//			}
//
//		});
		btnBorrar.setFocusable(false);
		btnBorrar.setRequestFocusEnabled(false);
		btnBorrar.setForeground(Color.WHITE);
		btnBorrar.setFont(new Font("Arial", Font.BOLD, 13));
		btnBorrar.setBorderPainted(false);
		btnBorrar.setBackground(new Color(0, 102, 255));
		panel_controlPie_Botones.add(btnBorrar);

		btnModificar = new JButton("Modificar");
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		// btnModificar.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent e) {
//				try {
//					//ModificarEstudiantes();
//					//listarConvocados();
//				} catch (ServiciosException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
		// });
		btnModificar.setRequestFocusEnabled(false);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Arial", Font.BOLD, 13));
		btnModificar.setBorderPainted(false);
		btnModificar.setBackground(new Color(0, 102, 255));
		panel_controlPie_Botones.add(btnModificar);

		btnAsignar = new JButton("Asignar");
		btnAsignar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_TipoAsignacion.getSelectedIndex()==0) {
					try {
						regisConvocatoriaPorEstudiante();
					} catch (ServiciosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(comboBox_TipoAsignacion.getSelectedIndex()==1) {
					
				}
				listarConvocados();
			}
		});
		btnAsignar.setRequestFocusEnabled(false);
		btnAsignar.setForeground(Color.WHITE);
		btnAsignar.setFont(new Font("Arial", Font.BOLD, 13));
		btnAsignar.setBorderPainted(false);
		btnAsignar.setBackground(new Color(0, 102, 255));
		panel_controlPie_Botones.add(btnAsignar);

		
		
	}

	List<String> RellenarEVENTO() {

		List<String> nombreEVENTO = new ArrayList<>();
		try {
			nombreEVENTO = eventoBean.obtenerTodosEventos().stream().map(e -> e.getTitulo())
					.collect(Collectors.toList());
			
		} catch (ServiciosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombreEVENTO;

	}

	protected void listarConvocados() {
		tabla_Convocados.setModel(model_Convocados);

		List<Convocatoria_Asistencia> con;

		try {
			con = convocatoriaBean.obtenerTodosConvocatoria_Asistencia();
			///estu = usuarioBean.obtenerPorIdUsuario(0);
			Object[] fila = new Object[8];

			model_est.setRowCount(0);

		//	"ID.Conv", "ID.Estu", "Estudiante", "Cédula", "Usuario", "Email institucional", "ITR", "Convocado a"
			
			for (int i = 0; i < con.size(); i++) {
				fila[0] = con.get(i).getIdConvocatoria_Ast();
				fila[1] = con.get(i).getEstudiante().getIdUsuario();
				fila[2] = con.get(i).getEstudiante().getNombre() +" "+con.get(i).getEstudiante().getApellido();
				fila[3] = con.get(i).getEstudiante().getDocumento();
				fila[4] = con.get(i).getEstudiante().getNombreUsuario();
				fila[5] = con.get(i).getEstudiante().getMailInstitucional();
				fila[6] = con.get(i).getEstudiante().getItr();
				fila[7] = con.get(i).getEvento().getTitulo();

				model_est.addRow(fila);
			}

		} catch (ServiciosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	void listarUsuarios() {
		table_est.setModel(model_est);

		List<Usuario> est;

		try {
			est = usuarioBean.obtenerTodosUsuarios();
			Object[] fila = new Object[5];

			model_est.setRowCount(0);

			for (int i = 0; i < est.size(); i++) {
				fila[0] = est.get(i).getIdUsuario();
				fila[1] = est.get(i).getNombre();
				fila[2] = est.get(i).getApellido();
				fila[3] = est.get(i).getDocumento();
				fila[4] = est.get(i).getDepartamento();

				model_est.addRow(fila);
			}

		} catch (ServiciosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	protected void regisConvocatoriaPorEstudiante() throws ServiciosException {
		System.out.println("pepito");
		List<Evento> eV;
			eV = eventoBean.obtenerTodosEventos();
			
			System.out.println(eV);
			
//			Convocatoria_AsistenciaDTO convocado = new Convocatoria_AsistenciaDTO();
		
			
		
			
			
//			Usuario usuSelec = usuarioBean.obtenerPorIdUsuario((Long)model_est.getValueAt(table_est.getSelectedRow(), 0));
			
//			Estudiante estuSelec = (Estudiante) usuSelec; //new Estudiante();
			
			
			
//			convocado.setEvento(eV);
//			System.out.println(estuSelec);
			
//			convocado.setEstudiante(estuSelec);
//			convocado.setTipoAsistencia(null);
//			convocado.setCalificacion(0);
			

//			try {
//				convocatoriaBean.crearConvocatoria_Asistencia(convocado);
//
//				JOptionPane.showMessageDialog(null,
//						"El Usuario se ha creado exitosamente, el usuario estara pendiente de verificacion");
//
//			} catch (ServiciosException f) {
//				// TODO Auto-generated catch block
//				System.out.println(f.getMessage());
//			}


	}
}
