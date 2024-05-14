package com.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.dto.EventoDTO;
import com.dto.ITRDTO;
import com.entities.Evento;
import com.entities.ITR;
import com.entities.TipoEvento;
import com.entities.Tutor;
import com.entities.Usuario;
import com.enums.EstadoEvento;
import com.enums.EstadoITR;
import com.enums.Modalidad;
import com.exception.ServiciosException;
import com.itextpdf.text.log.SysoCounter;
import com.servicios.EventoBeanCliente;
import com.servicios.EventoBeanImp;
import com.servicios.ITRBeanCliente;
import com.servicios.ITRBeanImp;
import com.servicios.ITRBeanRemote;
import com.servicios.TipoEventoBeanCliente;
import com.servicios.TipoEventoBeanImp;
import com.servicios.TutorBeanCliente;
import com.servicios.TutorBeanImp;
import com.servicios.UsuarioBeanCliente;
import com.servicios.UsuarioBeanImp;
import com.toedter.calendar.JDateChooser;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.ComponentOrientation;
import javax.swing.JMenuItem;
import com.toedter.components.JLocaleChooser;
import java.awt.SystemColor;

public class PDE_Alta_de_Eventos extends JPanel {

	private JPanel panel_1;
	private JLabel lblNewLabel;

	private JTextField txt_Titulo_Evento;

	private JLabel lbl_Titulo;
	private JLabel lbl_Tipo;
	private JLabel lbl_Inicio;
	private JLabel lbl_Localizacion;
	private JTextField txt_Localizacion;
	private JLabel lblTipoDeUsuario;
	private JComboBox comboBox_Modalidad;

	private JLabel lblNewLabel_3;
	private JSeparator separator_1;
	private JSeparator separator_6;
	private Long idItr;
	private Long idEstudiante;
	private JComboBox comboITR = new JComboBox();
	private JComboBox comboBox_Tipo_Evento;
	private JTextField textField;
	// Enums
	
	private EstadoEvento estadoEvento;
	private Modalidad modalidad;
	// Beans
	private EventoBeanCliente eventoBean = new EventoBeanImp();
	private ITRBeanCliente itrBean = new ITRBeanImp();
	private TutorBeanCliente tutorBean = new TutorBeanImp();
	private UsuarioBeanCliente usuarioBean = new UsuarioBeanImp();

	// Fecha inicio y fin
	private JDateChooser dateFecha_Fin = new JDateChooser();
	private JDateChooser dateFecha_Inicio = new JDateChooser();
	private JTable table_tutores;
	private JTable table_event_tutor;

	private String[] colums_tutores = { "ID", "Nombres", "Apellidos", "C.I", "Email" };
	private DefaultTableModel model_tutores = new DefaultTableModel(colums_tutores, 0);

	private String[] colums_event_tutor = { "Evento", "Localización", "ITR", "Tutores" };
	private DefaultTableModel model_event_tutor = new DefaultTableModel(colums_event_tutor, 0);

	private String[] colums_tutores2 = { "ID", "Nombres", "Apellidos", "C.I", "Email" };
	private DefaultTableModel model_tutores2 = new DefaultTableModel(colums_tutores2, 0);

	List<Tutor> tutAsig;
	private JSpinner spinnerMinuto_Ini = new JSpinner();
	private JSpinner spinnerHora_Fin = new JSpinner();
	private JSpinner spinnerMinuto_Fin = new JSpinner();
	private JSpinner spinnerHora_Ini = new JSpinner();
	private long idTut;
	private List<Tutor> tutores = new ArrayList<>();
	private List<Tutor> tutor = new ArrayList<>();
	private TipoEventoBeanCliente tipoEvento = new TipoEventoBeanImp();

	PDE_Convocatoria_Eventos convocatoriaE = new PDE_Convocatoria_Eventos();

	public PDE_Alta_de_Eventos() {

		setLayout(new BorderLayout(0, 0));

		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(Color.WHITE);
		add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panelCentro.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel(" Alta de eventos ");
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

		separator_6 = new JSeparator();
		separator_6.setForeground(Color.GRAY);
		separator_6.setBackground(Color.GRAY);
		separator_6.setBounds(10, 381, 160, 2);
		panel_2.add(separator_6);

		separator_1 = new JSeparator();
		separator_1.setBackground(new Color(128, 128, 128));
		separator_1.setForeground(new Color(128, 128, 128));
		separator_1.setBounds(10, 99, 118, 2);
		panel_2.add(separator_1);

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
		txt_Titulo_Evento.setBorder(null);

		txt_Titulo_Evento.setForeground(new Color(102, 102, 102));
		txt_Titulo_Evento.setDisabledTextColor(Color.LIGHT_GRAY);
		txt_Titulo_Evento.setFont(new Font("Arial", Font.PLAIN, 11));
		txt_Titulo_Evento.setText("Ingrese Título");
		txt_Titulo_Evento.setBounds(10, 74, 118, 20);
		panel_2.add(txt_Titulo_Evento);
		txt_Titulo_Evento.setColumns(10);

		lbl_Titulo = new JLabel("Titulo del evento");
		lbl_Titulo.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Titulo.setForeground(new Color(30, 144, 255));
		lbl_Titulo.setBounds(10, 55, 118, 14);
		panel_2.add(lbl_Titulo);

		lbl_Tipo = new JLabel("Tipo");
		lbl_Tipo.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Tipo.setForeground(new Color(30, 144, 255));
		lbl_Tipo.setBounds(138, 55, 118, 14);
		panel_2.add(lbl_Tipo);

		lbl_Inicio = new JLabel("Inicio");
		lbl_Inicio.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Inicio.setForeground(new Color(30, 144, 255));
		lbl_Inicio.setBounds(10, 112, 41, 14);
		panel_2.add(lbl_Inicio);

		lbl_Localizacion = new JLabel("Localización");
		lbl_Localizacion.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Localizacion.setForeground(new Color(30, 144, 255));
		lbl_Localizacion.setBounds(10, 337, 118, 14);
		panel_2.add(lbl_Localizacion);

		JLabel lbl_Fin = new JLabel("Fin");
		lbl_Fin.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Fin.setForeground(new Color(30, 144, 255));
		lbl_Fin.setBounds(10, 193, 118, 14);
		panel_2.add(lbl_Fin);

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
		txt_Localizacion.setBorder(null);
		txt_Localizacion.setText("Ingrese Localización");
		txt_Localizacion.setForeground(new Color(102, 102, 102));
		txt_Localizacion.setFont(new Font("Arial", Font.PLAIN, 11));
		txt_Localizacion.setDisabledTextColor(Color.LIGHT_GRAY);
		txt_Localizacion.setColumns(10);
		txt_Localizacion.setBounds(10, 355, 160, 20);
		panel_2.add(txt_Localizacion);

//		ITRBeanRemote itrBean = null;
//		try {
//			itrBean = (ITRBeanRemote) InitialContext
//					.doLookup("ejb:/PDT-EJB-GITHUB/ITRBean!com.servicios.ITRBeanRemote");
//		} catch (NamingException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		
//		ITR itrs1 = new ITR();
//
//		itrs1.setDepartamento("Ortivaaaa");
//		itrs1.setEstadoITR(EstadoITR.ACTIVO);
//		itrs1.setLocalidad("ORTIVAA");
//		itrs1.setNombre("UZURO");
//
//		try {
//			itrBean.crearITR(itrs1);
//			System.out.println("Se crea exitosamente el departamento");
//		} catch (ServiciosException f) {
//			// TODO Auto-generated catch block
//			System.out.println(f.getMessage());
//		}
//
//		comboITR.addItem("Seleccionar");
//
//		ArrayList<String> nombreITR = new ArrayList<>();
//		List<ITR> itrs = itrBean.obtenerTodos();
//		for (ITR itr : itrs) {
//			nombreITR.add(itr.getNombre());
//		}
//
//		for (String nombre : nombreITR) {
//			comboITR.addItem(nombre);
//		}
		comboITR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboITR.setBorder(null);
		comboITR.setBounds(138, 304, 183, 22);
		panel_2.add(comboITR);

		comboITR.addItem("Seleccionar");

		for (String itr : RellenarITR()) {
			comboITR.addItem(itr);

		}
		JLabel itr = new JLabel("\t\tITR");
		itr.setFont(new Font("Arial", Font.BOLD, 13));
		itr.setForeground(new Color(30, 144, 255));
		itr.setBounds(138, 278, 76, 14);
		panel_2.add(itr);

		lblTipoDeUsuario = new JLabel("Modalidad");
		lblTipoDeUsuario.setFont(new Font("Arial", Font.BOLD, 13));
		lblTipoDeUsuario.setForeground(new Color(30, 144, 255));
		lblTipoDeUsuario.setBounds(10, 279, 118, 14);
		panel_2.add(lblTipoDeUsuario);

		comboBox_Modalidad = new JComboBox();
		comboBox_Modalidad.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_Modalidad.setModel(
				new DefaultComboBoxModel(new String[] { "Seleccionar", "Virtual", "Presencial ", "Semipresencial" }));
		comboBox_Modalidad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox_Modalidad.setBorder(null);
		comboBox_Modalidad.setBounds(10, 302, 118, 24);
		panel_2.add(comboBox_Modalidad);

		lblNewLabel_3 = new JLabel("Datos del evento");
		lblNewLabel_3.setForeground(new Color(128, 128, 128));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 11, 160, 22);
		panel_2.add(lblNewLabel_3);

		comboBox_Tipo_Evento = new JComboBox();

		comboBox_Tipo_Evento.addItem("Seleccionar");
		
		for (String tipoEvento : RellenarTipoEvento()) {
			comboBox_Tipo_Evento.addItem(tipoEvento);
		}
		

		comboBox_Tipo_Evento.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_Tipo_Evento.setBorder(null);
		comboBox_Tipo_Evento.setBounds(138, 80, 183, 21);
		panel_2.add(comboBox_Tipo_Evento);

		dateFecha_Inicio.setBorder(null);
		dateFecha_Inicio.setBounds(49, 160, 144, 22);
		panel_2.add(dateFecha_Inicio);

		JLabel lbl_Fecha_Ini = new JLabel("Fecha");
		lbl_Fecha_Ini.setForeground(Color.BLACK);
		lbl_Fecha_Ini.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Fecha_Ini.setBounds(49, 137, 118, 14);
		panel_2.add(lbl_Fecha_Ini);

		spinnerHora_Ini.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerHora_Ini.setBounds(203, 160, 41, 22);
		panel_2.add(spinnerHora_Ini);

		spinnerMinuto_Ini.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerMinuto_Ini.setBounds(268, 160, 41, 20);
		panel_2.add(spinnerMinuto_Ini);

		JLabel lbl_Hora_Ini = new JLabel("Hora");
		lbl_Hora_Ini.setForeground(Color.BLACK);
		lbl_Hora_Ini.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Hora_Ini.setBounds(203, 137, 41, 14);
		panel_2.add(lbl_Hora_Ini);

		JLabel lbl_Minuto_Ini = new JLabel("Minuto");
		lbl_Minuto_Ini.setForeground(Color.BLACK);
		lbl_Minuto_Ini.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Minuto_Ini.setBounds(268, 134, 53, 20);
		panel_2.add(lbl_Minuto_Ini);

		JLabel lbl_minuto_1 = new JLabel(":");
		lbl_minuto_1.setForeground(Color.BLACK);
		lbl_minuto_1.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_minuto_1.setBounds(254, 160, 4, 20);
		panel_2.add(lbl_minuto_1);

		JLabel lbl_Fecha_Fin = new JLabel("Fecha");
		lbl_Fecha_Fin.setForeground(Color.BLACK);
		lbl_Fecha_Fin.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Fecha_Fin.setBounds(49, 214, 118, 14);
		panel_2.add(lbl_Fecha_Fin);

		dateFecha_Fin.setBorder(null);
		dateFecha_Fin.setBounds(49, 237, 144, 22);
		panel_2.add(dateFecha_Fin);

		spinnerHora_Fin.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerHora_Fin.setBounds(203, 237, 41, 22);
		panel_2.add(spinnerHora_Fin);

		JLabel lbl_Hora_Fin = new JLabel("Hora");
		lbl_Hora_Fin.setForeground(Color.BLACK);
		lbl_Hora_Fin.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Hora_Fin.setBounds(203, 214, 41, 14);
		panel_2.add(lbl_Hora_Fin);

		JLabel lbl_Minuto_Fin = new JLabel("Minuto");
		lbl_Minuto_Fin.setForeground(Color.BLACK);
		lbl_Minuto_Fin.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Minuto_Fin.setBounds(268, 211, 53, 20);
		panel_2.add(lbl_Minuto_Fin);

		spinnerMinuto_Fin.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerMinuto_Fin.setBounds(268, 237, 41, 20);
		panel_2.add(spinnerMinuto_Fin);

		JLabel lbl_minuto_1_1 = new JLabel(":");
		lbl_minuto_1_1.setForeground(Color.BLACK);
		lbl_minuto_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_minuto_1_1.setBounds(254, 237, 4, 20);
		panel_2.add(lbl_minuto_1_1);

		textField = new JTextField();
		textField.setBounds(10, 0, -2, -4);
		panel_2.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(371, 50, 695, 206);
		panel_2.add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(371, 304, 695, 206);
		panel_2.add(scrollPane_1);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(scrollPane, popupMenu);

		JPopupMenu popupMenu_1 = new JPopupMenu();
		addPopup(scrollPane_1, popupMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Asignar tutor");
		mntmNewMenuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				idTut = (Long) model_tutores.getValueAt(table_tutores.getSelectedRow(), 0);
				Tutor tut = new Tutor();

				try {
					tut = tutorBean.oBuscaOBusca(idTut);
					if (tut != null) {

						System.out.println(tut);

						boolean existeTutor = tutor.contains(tut);
						if (!existeTutor) {
							tutor.add(tut);
							crearListadoITRPRO(tut);

						}

						System.out.println(tutor);
					} else {
						System.out.println("ERROR AL ASIGNAR TUTOR A EVENTO");
					}

				} catch (ServiciosException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				System.out.println(tutores);

			}

		});
		popupMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Quitar tutor");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				idTut = (Long) model_tutores2.getValueAt(table_event_tutor.getSelectedRow(), 0);
				Tutor tut = new Tutor();

				try {
					tut = tutorBean.oBuscaOBusca(idTut);
					if (tut != null) {

						System.out.println(tut);

						boolean existeTutor = tutor.contains(tut);
						if (existeTutor) {
							tutor.remove(tut);
							model_tutores2.removeRow(table_event_tutor.getSelectedRow());

						}

						System.out.println(tutor);
					} else {
						System.out.println("ERROR AL ASIGNAR TUTOR A EVENTO");
					}

				} catch (ServiciosException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				System.out.println(tutores);

			}

		});
		popupMenu_1.add(mntmNewMenuItem_1);
//		JPopupMenu popupMenu_1 = new JPopupMenu();
//		addPopup(scrollPane, popupMenu_1);
//		
//		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Asignar");
//		popupMenu_1.add(mntmNewMenuItem_1);

		table_tutores = new JTable();
		table_tutores.setComponentPopupMenu(popupMenu);
		scrollPane.setViewportView(table_tutores);

		table_event_tutor = new JTable();
		table_event_tutor.setComponentPopupMenu(popupMenu_1);
		scrollPane_1.setViewportView(table_event_tutor);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(371, 11, 695, 39);
		panel_2.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_7 = new JLabel("LISTA DE TUTORES");
		lblNewLabel_7.setForeground(SystemColor.textHighlightText);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel_7, BorderLayout.CENTER);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.textHighlight);
		panel_3.setBounds(371, 265, 695, 39);
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_6 = new JLabel("TUTORES ASIGNADOS AL EVENTO");
		lblNewLabel_6.setForeground(SystemColor.textHighlightText);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_6, BorderLayout.CENTER);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 124, 311, 2);
		panel_2.add(separator);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 205, 311, 2);
		panel_2.add(separator_2);

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

					if (txt_Titulo_Evento.getText().equals("Ingrese Título")) {

						JOptionPane.showMessageDialog(null, "Falta completar campo 'Título Evento'",
								"Datos incompletos!", JOptionPane.WARNING_MESSAGE);
					}

					else if (comboBox_Tipo_Evento.getSelectedItem().equals("Seleccionar")) {

						JOptionPane.showMessageDialog(null, "Falta completar campo 'Tipo Evento'", "Datos incompletos!",
								JOptionPane.WARNING_MESSAGE);
					}
					
					else if (dateFecha_Inicio.getDate()==null) {

						JOptionPane.showMessageDialog(null, "Falta completar campo 'Fecha Inicio' ", "Datos incompletos!",
								JOptionPane.WARNING_MESSAGE);
					}	
					
					else if (dateFecha_Fin.getDate()==null) {

						JOptionPane.showMessageDialog(null, "Falta completar campo 'Fecha Fin' ", "Datos incompletos!",
								JOptionPane.WARNING_MESSAGE);
					}	
					
					else if (dateFecha_Inicio.getDate().after(dateFecha_Fin.getDate())) {

						JOptionPane.showMessageDialog(null, "La 'Fecho Inicio' seleccionada es posterior a 'Fecha Fin' ", "Fecha de Evento no validas!",
								JOptionPane.WARNING_MESSAGE);
					}
					

					else if (comboBox_Modalidad.getSelectedItem().equals("Seleccionar")) {

						JOptionPane.showMessageDialog(null, "Falta completar campo 'Modalidad'", "Datos incompletos!",
								JOptionPane.WARNING_MESSAGE);
					}

					else if (comboITR.getSelectedItem().equals("Seleccionar")) {

						JOptionPane.showMessageDialog(null, "Falta completar campo 'ITR'", "Datos incompletos!",
								JOptionPane.WARNING_MESSAGE);
					}

					else if (txt_Localizacion.getText().equals("Ingrese Localización")) {

						JOptionPane.showMessageDialog(null, "Falta completar campo 'Localización'",
								"Datos incompletos!", JOptionPane.WARNING_MESSAGE);
					}

					// Control de datos vacios

					//
					// Control caracteres mínimos y máximos
					//

					else if (txt_Titulo_Evento.getText().length() > 30 || txt_Titulo_Evento.getText().length() < 4) {
						JOptionPane.showMessageDialog(null,
								" Largo del campo Título debe estar comprendido entre 4 y 30 caracteres.",
								"Título no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);
					}

					else if (txt_Localizacion.getText().length() > 30 || txt_Titulo_Evento.getText().length() < 4) {
						JOptionPane.showMessageDialog(null,
								" Largo del campo Localización debe estar comprendido entre 4 y 30 caracteres.",
								"Localización no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);
					}

					else if (txt_Titulo_Evento.getText().length() > 30 || txt_Titulo_Evento.getText().length() < 4) {
						JOptionPane.showMessageDialog(null,
								" Largo del campo Localización debe estar comprendido entre 4 y 30 caracteres.",
								"Localización no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);
					}

					else {
					
						crearEvento();
						for (String even : convocatoriaE.RellenarEVENTO()) {
							convocatoriaE.combo_Eventos.addItem(even);

						}
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

	private void crearTabla_event_tutor() {
		table_event_tutor.setModel(model_event_tutor);

		Object[] fila = new Object[3];

		model_event_tutor.setRowCount(0);

		fila[0] = txt_Titulo_Evento.getText();
		fila[1] = comboITR.getSelectedItem();
		for (int i = 0; i < tutor.size(); i++) {

			fila[2] = tutores.get(i).getNombre();

			model_event_tutor.addRow(fila);
		}

	}

	void crearEvento() throws ServiciosException {
		TipoEvento tipoEventoE = tipoEvento.obtenerPorNombreTipoEvento((String) comboBox_Tipo_Evento.getSelectedItem());
		estadoEvento = EstadoEvento.Futuro;
		modalidad = Modalidad.Presencial;

		int horaInicioSpinner = (int) spinnerHora_Ini.getValue();
		int minutoInicioSpinner = (int) spinnerMinuto_Ini.getValue();
		int HoraFinalSpinner = (int) spinnerHora_Fin.getValue();
		int minutoFinalSpinner = (int) spinnerMinuto_Fin.getValue();

		String horaInicio = String.valueOf(horaInicioSpinner) + ":" + String.valueOf(minutoInicioSpinner);
		String horaFinal = String.valueOf(HoraFinalSpinner + ":" + String.valueOf(minutoFinalSpinner));

		ITR itrs = itrBean.obtenerTodosITRPorNombre((String) comboITR.getSelectedItem());

//		Tutor tutt = tutorBean.obtenerPorNombreTutor((String) comboBox_Tutor_Encargado.getSelectedItem());

//		List<Tutor> tut = tutorBean.obtenerTodosTutores();

		EventoDTO evento = new EventoDTO().builder().Titulo(txt_Titulo_Evento.getText())
				.fechaInicio(dateFecha_Inicio.getDate()).fechaFinal(dateFecha_Fin.getDate()).horaInicio(horaInicio)
				.horaFinal(horaFinal)
				.tipoEvento(tipoEventoE)// Esto esta seteado
				.modalidad(modalidad)// Esto esta seteado
				.localizacion(txt_Localizacion.getText()).estadoEvento(EstadoEvento.Futuro)// Esto esta seteado
				.tutores(tutor).itr(itrs).build();

		try {
			eventoBean.crearEvento(evento);
			JOptionPane.showMessageDialog(null, "El Evento se ha creado exitosamente");

		} catch (ServiciosException f) {
			System.out.println(f.getMessage());
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

	private List<String> RellenarTutores() {
		List<String> nombreTutor = new ArrayList<>();

		try {
			nombreTutor = tutorBean.obtenerTodosTutores().stream().map(e -> e.getNombre()).collect(Collectors.toList());
		} catch (ServiciosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombreTutor;

	}

	void listarTutores() {
		table_tutores.setModel(model_tutores);

		List<Tutor> tu;

		try {
			tu = tutorBean.obtenerTodosTutores();
			Object[] fila = new Object[5];

			model_tutores.setRowCount(0);

			for (int i = 0; i < tu.size(); i++) {
				fila[0] = tu.get(i).getIdUsuario();
				fila[1] = tu.get(i).getNombre();
				fila[2] = tu.get(i).getApellido();
				fila[3] = tu.get(i).getDocumento();
				fila[4] = tu.get(i).getMailInstitucional();

				model_tutores.addRow(fila);
			}

		} catch (ServiciosException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	void crearListadoITRPRO(Tutor tutor) {

		Object[] fila = new Object[5];

		fila[0] = tutor.getIdUsuario();
		fila[1] = tutor.getNombre();
		fila[2] = tutor.getApellido();
		fila[3] = tutor.getDocumento();
		fila[4] = tutor.getMail();

		model_tutores2.addRow(fila);

		table_event_tutor.setModel(model_tutores2);
	}
	private List<String> RellenarTipoEvento() {
		List<String> nombreEvento = new ArrayList<>();
		try {
			nombreEvento = tipoEvento.obtenerTodosTipoEventos().stream().map(e -> e.getNombre()).collect(Collectors.toList());
		} catch (ServiciosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombreEvento;
	}
}

