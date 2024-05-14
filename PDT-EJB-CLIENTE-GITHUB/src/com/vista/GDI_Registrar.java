package com.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.dto.ITRDTO;
import com.dto.TutorDTO;
import com.entities.ITR;
import com.entities.Usuario;
import com.enums.EstadoITR;
import com.exception.ServiciosException;
import com.servicios.ITRBean;
import com.servicios.ITRBeanCliente;
import com.servicios.ITRBeanImp;
import com.servicios.ITRBeanRemote;
import com.toedter.calendar.JDateChooser;

public class GDI_Registrar extends JPanel {

	private JPanel panel_1;
	private JLabel lblNewLabel;

	private JTextField txt_Nombre_ITR;

	private JLabel lbl_Titulo;
	private JLabel lbl_Tipo;
	private JLabel lbl_Localizacion;
	private JTextField txt_Localidad_ITR;
	private JLabel lblTipoDeUsuario;
	private JComboBox comboBox_Estado_ITR;

	private JLabel lblNewLabel_3;
	private JSeparator separator_1;
	private JSeparator separator_6;
	private Long idItr;
	private Long idEstudiante;
	private JComboBox comboBox_Departamento_ITR;
	private ITRBeanCliente itrBean = new ITRBeanImp();
	private JTextField textField;
	private EstadoITR estadoITR;

	public GDI_Registrar() {
		setLayout(new BorderLayout(0, 0));

		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(Color.WHITE);
		add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panelCentro.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel(" Registro de ITRs ");
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
		separator_6.setBounds(138, 178, 118, 2);
		panel_2.add(separator_6);

		separator_1 = new JSeparator();
		separator_1.setBackground(new Color(128, 128, 128));
		separator_1.setForeground(new Color(128, 128, 128));
		separator_1.setBounds(10, 99, 118, 2);
		panel_2.add(separator_1);

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
		txt_Nombre_ITR.setBorder(null);

		txt_Nombre_ITR.setForeground(new Color(102, 102, 102));
		txt_Nombre_ITR.setDisabledTextColor(Color.LIGHT_GRAY);
		txt_Nombre_ITR.setFont(new Font("Arial", Font.PLAIN, 11));
		txt_Nombre_ITR.setText("Ingrese Nombre");
		txt_Nombre_ITR.setBounds(10, 74, 118, 20);
		panel_2.add(txt_Nombre_ITR);
		txt_Nombre_ITR.setColumns(10);

		lbl_Titulo = new JLabel("Nombre");
		lbl_Titulo.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Titulo.setForeground(new Color(30, 144, 255));
		lbl_Titulo.setBounds(10, 55, 86, 14);
		panel_2.add(lbl_Titulo);

		lbl_Tipo = new JLabel("Departamento");
		lbl_Tipo.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Tipo.setForeground(new Color(30, 144, 255));
		lbl_Tipo.setBounds(10, 135, 118, 14);
		panel_2.add(lbl_Tipo);

		lbl_Localizacion = new JLabel("Localidad");
		lbl_Localizacion.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_Localizacion.setForeground(new Color(30, 144, 255));
		lbl_Localizacion.setBounds(138, 134, 118, 14);
		panel_2.add(lbl_Localizacion);

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
		txt_Localidad_ITR.setBorder(null);
		txt_Localidad_ITR.setText("Ingrese Localidad");
		txt_Localidad_ITR.setForeground(new Color(102, 102, 102));
		txt_Localidad_ITR.setFont(new Font("Arial", Font.PLAIN, 11));
		txt_Localidad_ITR.setDisabledTextColor(Color.LIGHT_GRAY);
		txt_Localidad_ITR.setColumns(10);
		txt_Localidad_ITR.setBounds(138, 152, 118, 20);
		panel_2.add(txt_Localidad_ITR);

		lblTipoDeUsuario = new JLabel("Estado del ITR");
		lblTipoDeUsuario.setFont(new Font("Arial", Font.BOLD, 13));
		lblTipoDeUsuario.setForeground(new Color(30, 144, 255));
		lblTipoDeUsuario.setBounds(10, 210, 118, 14);
		panel_2.add(lblTipoDeUsuario);

		comboBox_Estado_ITR = new JComboBox();
		comboBox_Estado_ITR.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_Estado_ITR.setModel(
				new DefaultComboBoxModel(new String[] { "Seleccionar", "Activo", "Desactivado", "Eliminado" }));
		comboBox_Estado_ITR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox_Estado_ITR.setBorder(null);
		comboBox_Estado_ITR.setBounds(10, 233, 118, 24);
		panel_2.add(comboBox_Estado_ITR);

		lblNewLabel_3 = new JLabel("Datos del ITR");
		lblNewLabel_3.setForeground(new Color(128, 128, 128));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 11, 160, 22);
		panel_2.add(lblNewLabel_3);

		comboBox_Departamento_ITR = new JComboBox();
		comboBox_Departamento_ITR.setModel(
				new DefaultComboBoxModel(new String[] { "Seleccionar", "Artigas", "Canelones", "Cerro Largo", "Colonia",
						"Durazno", "Flores", "Florida", "Lavalleja", "Maldonado", "Montevideo", "Paysandú", "Río Negro",
						"Rivera", "Rocha", "Salto", "San José", "Soriano", "Tacuarembó", "Treinta y Tres" }));
		comboBox_Departamento_ITR.addItem("Seleccionar");
		comboBox_Departamento_ITR.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox_Departamento_ITR.setBorder(null);
		comboBox_Departamento_ITR.setBounds(10, 159, 118, 21);
		panel_2.add(comboBox_Departamento_ITR);

		textField = new JTextField();
		textField.setBounds(10, 0, -2, -6);
		panel_2.add(textField);
		textField.setColumns(10);

		JPanel panelPie = new JPanel();
		add(panelPie, BorderLayout.SOUTH);
		panelPie.setLayout(new BorderLayout(0, 0));

		JPanel panel_controlPie_Botones = new JPanel();
		panel_controlPie_Botones.setBackground(new Color(240, 240, 240));
		panelPie.add(panel_controlPie_Botones, BorderLayout.EAST);

		JButton btnNewButton_4 = new JButton("Registrar");
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {

					if (txt_Nombre_ITR.getText().equals("Ingrese Nombre")) {
						JOptionPane.showMessageDialog(null, "Falta completar campo 'Nombre ITR'", "Datos incompletos!",
								JOptionPane.WARNING_MESSAGE);

					}

					else if (txt_Localidad_ITR.getText().equals("Ingrese Localidad")) {
						JOptionPane.showMessageDialog(null, "Falta completar campo 'Localidad'", "Datos incompletos!",
								JOptionPane.WARNING_MESSAGE);

					} else if (comboBox_Departamento_ITR.getSelectedItem().equals("Seleccionar")) {
						JOptionPane.showMessageDialog(null, "Falta completar campo 'Departamento'",
								"Datos incompletos!", JOptionPane.WARNING_MESSAGE);

					} else if (comboBox_Estado_ITR.getSelectedItem().equals("Seleccionar")) {
						JOptionPane.showMessageDialog(null, "Falta completar campo 'Estado'", "Datos incompletos!",
								JOptionPane.WARNING_MESSAGE);

					}

					else if (txt_Nombre_ITR.getText().length() > 30 || txt_Nombre_ITR.getText().length() < 3) {
						JOptionPane.showMessageDialog(null,
								" Largo del campo Nombre debe estar comprendido entre 3 y 30 caracteres.",
								"Nombre no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);
					}

					else if (txt_Localidad_ITR.getText().length() > 30 || txt_Localidad_ITR.getText().length() < 3) {
						JOptionPane.showMessageDialog(null,
								" Largo del campo Localidad debe estar comprendido entre 3 y 30 caracteres.",
								"Localidad no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);
					}

					else {

						if (txt_Nombre_ITR.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "El nombre  ''", "Datos incompletos!",
									JOptionPane.WARNING_MESSAGE);

						}

						itrUnique();

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

	protected void registrarITR() throws ServiciosException {

		String estado = (String) comboBox_Estado_ITR.getSelectedItem();

		if (estado.equals("Activo")) {
			estadoITR = EstadoITR.ACTIVO;
		} else if (estado.equals("Desactivado")) {
			estadoITR = EstadoITR.DESACTIVADO;
		} else if (estado.equals("Eliminado")) {
			estadoITR = EstadoITR.ELIMINADO;
		}

		ITRDTO itr = new ITRDTO().builder()

				.nombre(txt_Nombre_ITR.getText()).departamento((String) comboBox_Departamento_ITR.getSelectedItem())
				.localidad(txt_Localidad_ITR.getText()).estadoITR(estadoITR).build();

		try {
			itrBean.crearITR(itr);
			JOptionPane.showMessageDialog(null, "El ITR se ha creado exitosamente");

		} catch (ServiciosException f) {
			System.out.println(f.getMessage());
		}

	}

	void itrUnique() throws ServiciosException {
		List<ITR> itr = itrBean.obtenerTodosITR();
		for (ITR itr2 : itr) {
			if (itr2.getNombre().equals(txt_Nombre_ITR.getText())) {
				JOptionPane.showMessageDialog(null, "Nombre del ITR ya registrado", "Intetente nuevamente",
						JOptionPane.WARNING_MESSAGE);
			} else {
				registrarITR();

			}
		}
	}
}
