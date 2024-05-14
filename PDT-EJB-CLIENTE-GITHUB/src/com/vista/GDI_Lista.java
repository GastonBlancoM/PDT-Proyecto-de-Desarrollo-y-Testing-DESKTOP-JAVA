package com.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.dto.ITRDTO;
import com.dto.TutorDTO;
import com.entities.Estudiante;
import com.entities.ITR;
import com.entities.Usuario;
import com.enums.EstadoITR;
import com.enums.EstadoUsuario;
import com.enums.TipoUsuario;
import com.exception.ServiciosException;
import com.servicios.EstudianteBeanRemote;
import com.servicios.ITRBeanCliente;
import com.servicios.ITRBeanImp;
import com.servicios.ITRBeanRemote;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Cursor;

public class GDI_Lista extends JPanel {

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
	private JTable tablaITRs;
	private JPanel panel_4;
	private long idITR;
	private String[] colums = { "ID", "Nombre", "Localidad", "Departamento", "Estado ITR" };
	private DefaultTableModel models = new DefaultTableModel(colums, 0);
	private ITRBeanCliente itrBean = new ITRBeanImp();
	private JTable table;
	private JPanel panel_5;
	private JPanel panel_6;
	private JTextField txt_Nombre_ITR;
	private JTextField txt_Localidad_ITR;
	private JComboBox comboBox_Departamento_ITR = new JComboBox();
	private JComboBox comboBox_Estado_ITR = new JComboBox();
	private long idItr;
	private EstadoITR estadoITR;

	public GDI_Lista() {
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
					filtrarItrPorEstado();
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

		comboBox_Generacion = new JComboBox();
		comboBox_Generacion.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar generación" }));

		comboBox_Tipo_de_Filtro = new JComboBox();
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
		comboBox_Tipo_de_Filtro.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccionar", "Estado: ACTIVO", "Estado: DESACTIVADO", "Estado: ELIMINADO" }));
		panel_2.add(comboBox_Tipo_de_Filtro, BorderLayout.CENTER);

		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel(" Lista de ITRs ");
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

		panel_5 = new JPanel();
		panelCentro.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		panel_5.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idITR = (Long) models.getValueAt(table.getSelectedRow(), 0);
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

		JLabel lblNewLabel_3_1 = new JLabel("Datos a modificar");
		lblNewLabel_3_1.setForeground(Color.GRAY);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(10, 11, 160, 22);
		panel_6.add(lblNewLabel_3_1);

		JLabel lbl_Titulo = new JLabel("Nombre");
		lbl_Titulo.setForeground(new Color(30, 144, 255));
		lbl_Titulo.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Titulo.setBounds(10, 55, 86, 14);
		panel_6.add(lbl_Titulo);

		txt_Nombre_ITR = new JTextField();
		txt_Nombre_ITR.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txt_Nombre_ITR.getText().equals("Ingrese Nombre")) {
					txt_Nombre_ITR.setText("");
					txt_Nombre_ITR.setForeground(Color.BLACK);
				}

				if (txt_Localidad_ITR.getText().isEmpty()) {
					txt_Localidad_ITR.setText("Ingrese Localidad");
					txt_Localidad_ITR.setForeground(Color.GRAY);
				}

			}
		});
		txt_Nombre_ITR.setText("Ingrese Nombre");
		txt_Nombre_ITR.setForeground(new Color(102, 102, 102));
		txt_Nombre_ITR.setFont(new Font("Arial", Font.PLAIN, 11));
		txt_Nombre_ITR.setDisabledTextColor(Color.LIGHT_GRAY);
		txt_Nombre_ITR.setColumns(10);
		txt_Nombre_ITR.setBorder(null);
		txt_Nombre_ITR.setBounds(10, 74, 118, 20);
		panel_6.add(txt_Nombre_ITR);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		separator_1.setBackground(Color.GRAY);
		separator_1.setBounds(10, 99, 118, 2);
		panel_6.add(separator_1);

		comboBox_Departamento_ITR.setModel(
				new DefaultComboBoxModel(new String[] { "Seleccionar", "Artigas", "Canelones", "Cerro Largo", "Colonia",
						"Durazno", "Flores", "Florida", "Lavalleja", "Maldonado", "Montevideo", "Paysandú", "Río Negro",
						"Rivera", "Rocha", "Salto", "San José", "Soriano", "Tacuarembó", "Treinta y Tres" }));
		comboBox_Departamento_ITR.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_Departamento_ITR.setBorder(null);
		comboBox_Departamento_ITR.setBounds(138, 80, 118, 21);
		panel_6.add(comboBox_Departamento_ITR);

		JLabel lbl_Tipo = new JLabel("Departamento");
		lbl_Tipo.setForeground(new Color(30, 144, 255));
		lbl_Tipo.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Tipo.setBounds(138, 55, 118, 14);
		panel_6.add(lbl_Tipo);

		JSeparator separator_6 = new JSeparator();
		separator_6.setForeground(Color.GRAY);
		separator_6.setBackground(Color.GRAY);
		separator_6.setBounds(266, 99, 118, 2);
		panel_6.add(separator_6);

		txt_Localidad_ITR = new JTextField();
		txt_Localidad_ITR.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txt_Localidad_ITR.getText().equals("Ingrese Localidad")) {
					txt_Localidad_ITR.setText("");
					txt_Localidad_ITR.setForeground(Color.BLACK);
				}
				if (txt_Nombre_ITR.getText().isEmpty()) {
					txt_Nombre_ITR.setText("Ingrese Nombre");
					txt_Nombre_ITR.setForeground(Color.GRAY);
				}

			}
		});
		txt_Localidad_ITR.setText("Ingrese Localidad");
		txt_Localidad_ITR.setForeground(new Color(102, 102, 102));
		txt_Localidad_ITR.setFont(new Font("Arial", Font.PLAIN, 11));
		txt_Localidad_ITR.setDisabledTextColor(Color.LIGHT_GRAY);
		txt_Localidad_ITR.setColumns(10);
		txt_Localidad_ITR.setBorder(null);
		txt_Localidad_ITR.setBounds(266, 74, 118, 20);
		panel_6.add(txt_Localidad_ITR);

		JLabel lbl_Localizacion = new JLabel("Localidad");
		lbl_Localizacion.setForeground(new Color(30, 144, 255));
		lbl_Localizacion.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Localizacion.setBounds(266, 55, 118, 14);
		panel_6.add(lbl_Localizacion);

		JLabel lblTipoDeUsuario = new JLabel("Estado del ITR");
		lblTipoDeUsuario.setForeground(new Color(30, 144, 255));
		lblTipoDeUsuario.setFont(new Font("Arial", Font.BOLD, 13));
		lblTipoDeUsuario.setBounds(394, 55, 118, 14);
		panel_6.add(lblTipoDeUsuario);

		comboBox_Estado_ITR.setModel(
				new DefaultComboBoxModel(new String[] { "Seleccionar", "Activo", "Desactivado", "Eliminado" }));
		comboBox_Estado_ITR.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_Estado_ITR.setBorder(null);
		comboBox_Estado_ITR.setBounds(394, 77, 118, 24);
		panel_6.add(comboBox_Estado_ITR);

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
				borrarITR();
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
				try {
					modificarITR();
					listarITRs();

				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnModificar.setRequestFocusEnabled(false);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.setFont(new Font("Arial", Font.BOLD, 13));
		btnModificar.setBorderPainted(false);
		btnModificar.setBackground(new Color(0, 102, 255));
		panel_controlPie_Botones.add(btnModificar);

		btnRefrescar = new JButton("Refrescar");
		btnRefrescar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listarITRs();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnRefrescar.setRequestFocusEnabled(false);
		btnRefrescar.setForeground(Color.WHITE);
		btnRefrescar.setFont(new Font("Arial", Font.BOLD, 13));
		btnRefrescar.setBorderPainted(false);
		btnRefrescar.setBackground(new Color(0, 102, 255));
		panel_controlPie_Botones.add(btnRefrescar);
	}

	void listarITRs() throws ServiciosException {
		table.setModel(models);
		List<ITR> itrsRegistro = new ArrayList();
		List<ITR> itr = itrBean.obtenerTodosITR();
		for (ITR itrss : itr) {
			if (itrss.getEstadoITR() != EstadoITR.ELIMINADO) {
				itrsRegistro.add(itrss);
			}

		}
		Object[] fila = new Object[5];

		models.setRowCount(0);

		for (int i = 0; i < itrsRegistro.size(); i++) {
			fila[0] = itrsRegistro.get(i).getIdITR();
			fila[1] = itrsRegistro.get(i).getNombre();
			fila[2] = itrsRegistro.get(i).getLocalidad();
			fila[3] = itrsRegistro.get(i).getDepartamento();
			fila[4] = itrsRegistro.get(i).getEstadoITR();

			models.addRow(fila);
		}

	}

	void modificarITR() throws ServiciosException {

		ITR itrLista;

		itrLista = (ITR) itrBean.obtenerPorIdITR(idITR);

		if (comboBox_Estado_ITR.getSelectedItem().equals("Activo")) {
			estadoITR = EstadoITR.ACTIVO;

		} else if (comboBox_Estado_ITR.getSelectedItem().equals("Desactivado")) {
			estadoITR = EstadoITR.DESACTIVADO;

		} else if (comboBox_Estado_ITR.getSelectedItem().equals("Eliminado")) {
			estadoITR = EstadoITR.ELIMINADO;

		}

		ITRDTO itr = new ITRDTO();
		itr.setIdITR(itrLista.getIdITR());
		itr.setNombre(txt_Nombre_ITR.getText());
		itr.setDepartamento((String) comboBox_Departamento_ITR.getSelectedItem());
		itr.setLocalidad(txt_Localidad_ITR.getText());
		itr.setEstadoITR(estadoITR);

		try {
			itrBean.modificarITR(itr);
			JOptionPane.showMessageDialog(null, "Se actualizo exitosamente el ITR: " + itr.getNombre());
		} catch (ServiciosException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}

	}

	private void filtrarItrPorEstado() throws ServiciosException {
		table.setModel(models);

		if (comboBox_Tipo_de_Filtro.getSelectedItem().equals("Seleccionar")) {
			JOptionPane.showMessageDialog(null, "Debe de seleccionar un filtro primero", "Atención",
					JOptionPane.INFORMATION_MESSAGE);

		}

		if (comboBox_Tipo_de_Filtro.getSelectedItem().equals("Estado: ACTIVO")) {
			estadoITR = EstadoITR.ACTIVO;
		} else if (comboBox_Tipo_de_Filtro.getSelectedItem().equals("Estado: DESACTIVADO")) {
			estadoITR = EstadoITR.DESACTIVADO;
		}

		else if (comboBox_Tipo_de_Filtro.getSelectedItem().equals("Estado: ELIMINADO")) {
			estadoITR = EstadoITR.ELIMINADO;
		}

		else {
			listarITRs();
		}

		List<ITR> itrs = itrBean.buscarPorEstadoITR(estadoITR);

		Object[] fila = new Object[5];

		models.setRowCount(0);

		for (int i = 0; i < itrs.size(); i++) {
			fila[0] = itrs.get(i).getIdITR();
			fila[1] = itrs.get(i).getNombre();
			fila[2] = itrs.get(i).getDepartamento();
			fila[3] = itrs.get(i).getLocalidad();
			fila[4] = itrs.get(i).getEstadoITR();
			models.addRow(fila);
		}

	}

	void borrarITR() {
		try {
			int salida = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el usuario?");
			System.out.println(salida);
			if (salida == 0) {
				ITR itrLista;

				itrLista = (ITR) itrBean.obtenerPorIdITR(idITR);

				ITRDTO itr = new ITRDTO();
				itr.setIdITR(itrLista.getIdITR());
				itr.setNombre(txt_Nombre_ITR.getText());
				itr.setDepartamento((String) comboBox_Departamento_ITR.getSelectedItem());
				itr.setLocalidad(txt_Localidad_ITR.getText());
				itr.setEstadoITR(estadoITR.ELIMINADO);

				try {
					itrBean.modificarITR(itr);

				} catch (ServiciosException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				listarITRs();

				JOptionPane.showMessageDialog(null, "Se elimino correctamente el ITR");
			} else {
				JOptionPane.showMessageDialog(null, "La eliminacion se canselo");
			}

		} catch (ServiciosException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	private int recorrerComboBoxDepartamentoITR(String nombre, JComboBox combo) {
		int indice = 0;

		for (int i = 0; i < comboBox_Departamento_ITR.getItemCount(); i++) {

			if (comboBox_Departamento_ITR.getItemAt(i).toString().equals(nombre)) {

				indice = i;

			}

		}
		return indice;
	}

	private int recorrerComboBoxEstadoITR(String nombre, JComboBox combo) {
		int indice = 0;

		for (int i = 0; i < comboBox_Estado_ITR.getItemCount(); i++) {

			if (comboBox_Estado_ITR.getItemAt(i).toString().equals(nombre)) {

				indice = i;

			}

		}
		return indice;
	}

	void agregarCampos() throws ServiciosException {
		idItr = (Long) models.getValueAt(table.getSelectedRow(), 0);

		txt_Nombre_ITR.setText((String) models.getValueAt(table.getSelectedRow(), 1));

		txt_Localidad_ITR.setText((String) models.getValueAt(table.getSelectedRow(), 2));

		comboBox_Departamento_ITR.setSelectedItem((String) models.getValueAt(table.getSelectedRow(), 3));

		EstadoITR estado = (EstadoITR) models.getValueAt(table.getSelectedRow(), 4);
		int indice = recorrerComboBoxEstadoITR(estado.getNombre(), comboBox_Estado_ITR);
		comboBox_Estado_ITR.setSelectedIndex(indice);
	}

	void eliminarITR() throws ServiciosException {

		

	}

}
