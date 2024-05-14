package com.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.xnio.conduits.SynchronizedStreamSourceConduit;

import com.dto.EstudianteDTO;
import com.dto.ITRDTO;
import com.dto.TipoEventoDTO;
import com.dto.TutorDTO;
import com.entities.ITR;
import com.entities.TipoEvento;
import com.entities.Usuario;
import com.enums.EstadoITR;
import com.enums.EstadoTipoEvento;
import com.enums.EstadoUsuario;
import com.enums.TipoUsuario;
import com.exception.ServiciosException;
import com.itextpdf.text.log.SysoCounter;
import com.servicios.TipoEventoBean;
import com.servicios.TipoEventoBeanCliente;
import com.servicios.TipoEventoBeanImp;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;

public class PDE_Mant_Tipo_Evento extends JPanel {
	private JTextField txtNombre;
	private TipoEventoBeanCliente tipoEvento = new TipoEventoBeanImp();
	private JTable table;
	private String[] colums = { "ID" };
	private DefaultTableModel model = new DefaultTableModel(colums, 0);
	private long idTE;
	private JComboBox boxEstadoTipoEvento = new JComboBox();
	private EstadoTipoEvento estadoTipoEvento;
	private JComboBox boxestadoTipoEvento = new JComboBox();

	/**
	 * Create the panel.
	 */
	public PDE_Mant_Tipo_Evento() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel_General = new JPanel();
		add(panel_General, BorderLayout.CENTER);
		panel_General.setLayout(new BorderLayout(0, 0));

		JPanel panel_Encabezado = new JPanel();
		panel_Encabezado.setBackground(Color.WHITE);
		panel_General.add(panel_Encabezado, BorderLayout.NORTH);
		panel_Encabezado.setLayout(new BorderLayout(0, 0));

		JLabel lblMantTipoDe = new JLabel(" Mant. Tipo de evento ");
		lblMantTipoDe.setHorizontalAlignment(SwingConstants.LEFT);
		lblMantTipoDe.setForeground(Color.DARK_GRAY);
		lblMantTipoDe.setFont(new Font("Arial", Font.BOLD, 20));
		lblMantTipoDe.setBackground(Color.DARK_GRAY);
		panel_Encabezado.add(lblMantTipoDe, BorderLayout.WEST);

		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 5));
		panel_Encabezado.add(lblNewLabel_1, BorderLayout.SOUTH);

		JLabel lblNewLabel_2 = new JLabel("  ");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(0, 102, 255));
		panel_Encabezado.add(lblNewLabel_2, BorderLayout.CENTER);

		JLabel lblNewLabel_4 = new JLabel(" ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 5));
		panel_Encabezado.add(lblNewLabel_4, BorderLayout.NORTH);

		JLabel lblNewLabel_5 = new JLabel("  ");
		panel_Encabezado.add(lblNewLabel_5, BorderLayout.EAST);

		JPanel panel_Centro = new JPanel();
		panel_Centro.setBackground(Color.WHITE);
		panel_General.add(panel_Centro, BorderLayout.CENTER);
		panel_Centro.setLayout(null);

		txtNombre = new JTextField();
		txtNombre.setText("awdawd");
		txtNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (txtNombre.getText().equals("Ingrese nombre")) {
					txtNombre.setText("");
					txtNombre.setForeground(Color.BLACK);
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {

		});
		scrollPane.setBounds(174, 69, 439, 174);
		panel_Centro.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					agregarCamposTipoEvento();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		separator_1.setBackground(Color.GRAY);
		separator_1.setBounds(8, 95, 124, 2);
		panel_Centro.add(separator_1);
		txtNombre.setForeground(new Color(102, 102, 102));
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNombre.setDisabledTextColor(Color.LIGHT_GRAY);
		txtNombre.setColumns(10);
		txtNombre.setBorder(null);
		txtNombre.setBounds(10, 75, 124, 20);
		panel_Centro.add(txtNombre);

		JLabel primer_Nombre = new JLabel("Nombre");

		primer_Nombre.setForeground(new Color(30, 144, 255));
		primer_Nombre.setFont(new Font("Arial", Font.BOLD, 13));
		primer_Nombre.setBounds(10, 51, 143, 14);
		panel_Centro.add(primer_Nombre);

		JSeparator separator = new JSeparator();
		separator.setFont(new Font("Dialog", Font.BOLD, 13));
		separator.setBounds(-23, 6, 2000, 2);
		panel_Centro.add(separator);

		JLabel lblNewLabel_3 = new JLabel("Nuevo tipo de evento");
		lblNewLabel_3.setForeground(Color.GRAY);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 11, 160, 22);
		panel_Centro.add(lblNewLabel_3);

		boxEstadoTipoEvento
				.setModel(new DefaultComboBoxModel(new String[] { "Seleccione un filtro", "Activo", "Eliminado" }));
		boxEstadoTipoEvento.setBackground(Color.WHITE);
		boxEstadoTipoEvento.setBounds(174, 253, 347, 27);
		panel_Centro.add(boxEstadoTipoEvento);

		JButton btnBuscar = new JButton("Filtrar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					filtrarEstadoTipoEvento();
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
		btnBuscar.setBounds(531, 253, 82, 25);
		panel_Centro.add(btnBuscar);

		JLabel lblNewLabel = new JLabel("TIPOS DE EVENTOS CREADOS");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(SystemColor.textHighlight);
		lblNewLabel.setBounds(174, 41, 439, 27);
		panel_Centro.add(lblNewLabel);

		boxestadoTipoEvento.setModel(new DefaultComboBoxModel(new String[] { "Activo", "Eliminado" }));
		boxestadoTipoEvento.setFont(new Font("Arial", Font.PLAIN, 11));
		boxestadoTipoEvento.setBorder(null);
		boxestadoTipoEvento.setBounds(10, 151, 118, 21);
		panel_Centro.add(boxestadoTipoEvento);

		JLabel lblEstadoTipoEvento = new JLabel("Estado Tipo Evento");
		lblEstadoTipoEvento.setForeground(new Color(30, 144, 255));
		lblEstadoTipoEvento.setFont(new Font("Arial", Font.BOLD, 13));
		lblEstadoTipoEvento.setBounds(10, 125, 143, 14);
		panel_Centro.add(lblEstadoTipoEvento);

		JPanel panel_Pie = new JPanel();
		add(panel_Pie, BorderLayout.SOUTH);
		panel_Pie.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel_Pie.add(panel, BorderLayout.EAST);

		JButton btnNewButton_4 = new JButton("Borrar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int salida = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el tipoEvento?");
					System.out.println(salida);
					if (salida == 0) {
						tipoEvento.borrarTipoEvento(idTE);
						listarTipoEvento();

						JOptionPane.showMessageDialog(null, "Se elimino correctamente el tipo evento");
					} else {
						JOptionPane.showMessageDialog(null, "La eliminacion fue cancelada");
					}

				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}

		});
		btnNewButton_4.setRequestFocusEnabled(false);
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBackground(new Color(0, 102, 255));
		panel.add(btnNewButton_4);

		JButton btnNewButton_4_1 = new JButton("Modificar");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					modificarTipoEvento();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		btnNewButton_4_1.setRequestFocusEnabled(false);
		btnNewButton_4_1.setForeground(Color.WHITE);
		btnNewButton_4_1.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton_4_1.setBorderPainted(false);
		btnNewButton_4_1.setBackground(new Color(0, 102, 255));
		panel.add(btnNewButton_4_1);

		JButton btnNewButton_4_2 = new JButton("Crear");
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtNombre.getText().equals("Ingrese tipo")) {

					JOptionPane.showMessageDialog(null, "Falta completar campo 'Tipo del Evento'", "Datos incompletos!",
							JOptionPane.WARNING_MESSAGE);

				}

				else if (txtNombre.getText().length() > 30 || txtNombre.getText().length() < 4) {
					JOptionPane.showMessageDialog(null,
							" Largo del campo 'Tipo' debe estar comprendido entre 4 y 30 caracteres.",
							"Tipo del Evento no cumple con la condicion de caracteres", JOptionPane.WARNING_MESSAGE);
				}

				else {
					crearTipoEvento();
				}

			}

		});
		btnNewButton_4_2.setRequestFocusEnabled(false);
		btnNewButton_4_2.setForeground(Color.WHITE);
		btnNewButton_4_2.setFont(new Font("Arial", Font.BOLD, 13));
		btnNewButton_4_2.setBorderPainted(false);
		btnNewButton_4_2.setBackground(new Color(0, 102, 255));
		panel.add(btnNewButton_4_2);

	}

	void crearTipoEvento() {

		if (boxestadoTipoEvento.getSelectedIndex() == 0) {
			estadoTipoEvento = EstadoTipoEvento.ACTIVO;
		}

		if (boxestadoTipoEvento.getSelectedIndex() == 1) {
			estadoTipoEvento = EstadoTipoEvento.ELIMINADO;
		}

		TipoEventoDTO tE = new TipoEventoDTO().builder()

				.nombre(txtNombre.getText()).estadoTipoEvento(estadoTipoEvento).build();

		try {
			tipoEvento.crearTipoEvento(tE);
			JOptionPane.showMessageDialog(null, "El Tipo Evento se ha creado correctamente");

		} catch (ServiciosException f) {
			System.out.println(f.getMessage());
		}

	}

	void listarTipoEvento() throws ServiciosException {

		String[] colums = { "", "Nombres" };
		model = new DefaultTableModel(colums, 0);
		table.setModel(model);

		List<TipoEvento> eve = tipoEvento.obtenerTodosTipoEventos();

		for (TipoEvento eve1 : eve) {

			Object[] fila = new Object[3];

			model.setRowCount(0);

			for (int i = 0; i < eve.size(); i++) {
				fila[0] = eve.get(i).getIdTipoEvento();
				fila[1] = eve.get(i).getNombre();
				fila[2] = eve.get(i).getEstadoTipoEvento();

				model.addRow(fila);
			}
		}
	}

	void modificarTipoEvento() throws ServiciosException {
		if (boxestadoTipoEvento.getSelectedIndex() == 0) {
			estadoTipoEvento = EstadoTipoEvento.ACTIVO;
		}

		else if (boxestadoTipoEvento.getSelectedIndex() == 1) {
			estadoTipoEvento = EstadoTipoEvento.ELIMINADO;
		}
		TipoEvento tE = tipoEvento.obtenerPorIdTipoEvento(idTE);

		TipoEventoDTO tipoe = new TipoEventoDTO();

		tipoe.setIdTipoEvento(tE.getIdTipoEvento());
		tipoe.setNombre(txtNombre.getText());
		tipoe.setEstadoTipoEvento(estadoTipoEvento);

		try {
			tipoEvento.modificarTipoEvento(tipoe);
			JOptionPane.showMessageDialog(null, "Se actualizo exitosamente el EstadoEvento");
		} catch (ServiciosException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());

		}
		listarTipoEvento();
	}

	void agregarCamposTipoEvento() throws ServiciosException {

		idTE = (Long) model.getValueAt(table.getSelectedRow(), 0);

		txtNombre.setText((String) model.getValueAt(table.getSelectedRow(), 1));

	}

	private void filtrarEstadoTipoEvento() throws ServiciosException {
		table.setModel(model);
		if (boxEstadoTipoEvento.getSelectedIndex() == 0) {
			listarTipoEvento();

		} else if (boxEstadoTipoEvento.getSelectedIndex() == 1) {
			estadoTipoEvento = EstadoTipoEvento.ACTIVO;

		} else if (boxEstadoTipoEvento.getSelectedIndex() == 2) {
			estadoTipoEvento = EstadoTipoEvento.ELIMINADO;
		}

		else {
			listarTipoEvento();
		}

		List<TipoEvento> itrs = tipoEvento.obtenerPorEstadoTipoEvento(estadoTipoEvento);

		Object[] fila = new Object[2];

		model.setRowCount(0);

		for (int i = 0; i < itrs.size(); i++) {
			fila[0] = itrs.get(i).getIdTipoEvento();
			fila[1] = itrs.get(i).getNombre();

			model.addRow(fila);
		}

	}
}