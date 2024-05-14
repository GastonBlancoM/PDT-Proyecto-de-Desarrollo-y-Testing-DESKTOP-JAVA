package com.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.entities.Estudiante;
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

import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class PDU_Principal extends JPanel {

	private ITRBeanCliente itrBean = new ITRBeanImp();
	private AnalistaBeanCliente analistaBean = new AnalistaBeanImp();
	private TutorBeanCliente tutorBean = new TutorBeanImp();
	private UsuarioBeanCliente usuarioBean = new UsuarioBeanImp();
	private EstudianteBeanCliente estudianteBean = new EstudianteBeanImp();
	private JLabel lblNombres = new JLabel("Nombres: ");
	private JLabel lblApellidos = new JLabel("Apellidos: ");
	private JLabel lblCedula = new JLabel("Documento de identidad: ");
	private JLabel lblEmail_Institucional = new JLabel("Email institucional: ");
	private JLabel lblFechaNacimiento = new JLabel("Fecha de nacimiento: ");
	private JLabel lblEmail_Personal = new JLabel("Email personal: ");
	private JLabel lblDepartamento = new JLabel("Departamento: ");
	private JLabel lblITR = new JLabel("ITR: ");
	private JLabel lblTipo_De_Usuario = new JLabel("Tipo de usuario: ");
	private JLabel lblLocalidad = new JLabel("Localidad: ");
	private JLabel lblTelefono = new JLabel("Teléfono: ");
	private JLabel lblGenero = new JLabel("Genero: ");

	private JLabel lblNombres_1 = new JLabel("");
	private JLabel lblApellidos_1 = new JLabel("");
	private JLabel lblCedula_1 = new JLabel("");
	private JLabel lblEmail_Institucional_1 = new JLabel("");
	private JLabel lblNombreUsuario_1 = new JLabel("");

	private JLabel lblTipo_De_Usuario_1 = new JLabel("");
	private JLabel lblITR_1 = new JLabel("");
	private JLabel lblLocalidad_1 = new JLabel("");
	private JLabel lblTelefono_1 = new JLabel("");
	private JLabel lblFechaNacimiento_1 = new JLabel("");

	private JLabel lblEmail_Personal_1 = new JLabel("");
	private JLabel lblGenero_1 = new JLabel("");
	private JLabel lblDepartamento_1 = new JLabel("");
	private final JLabel lblNewLabel_3 = new JLabel("Personales");
	private final JSeparator separator = new JSeparator();
	private final JLabel lblInstitucionales = new JLabel("Institucionales");
	private final JSeparator separator_1 = new JSeparator();

	public PDU_Principal() {

		setLayout(new BorderLayout(0, 0));

		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(Color.WHITE);
		add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panelCentro.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		lblNombres.setForeground(new Color(0, 102, 255));
		lblApellidos.setForeground(new Color(0, 102, 255));
		lblCedula.setForeground(new Color(0, 102, 255));
		lblDepartamento.setForeground(new Color(0, 102, 255));
		lblTelefono.setForeground(new Color(0, 102, 255));
		lblGenero.setForeground(new Color(0, 102, 255));
		lblLocalidad.setForeground(new Color(0, 102, 255));
		lblEmail_Personal.setForeground(new Color(0, 102, 255));
		lblEmail_Institucional.setForeground(new Color(0, 102, 255));
		lblFechaNacimiento.setForeground(new Color(0, 102, 255));
		lblITR.setForeground(new Color(0, 102, 255));
		lblTipo_De_Usuario.setForeground(new Color(0, 102, 255));

		JLabel lblNewLabel_1 = new JLabel(" NA  ");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 48));
		panel.add(lblNewLabel_1, BorderLayout.WEST);
				lblNombreUsuario_1.setOpaque(true);
				panel.add(lblNombreUsuario_1, BorderLayout.CENTER);
		
				lblNombreUsuario_1.setFont(new Font("Arial", Font.BOLD, 20));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panelCentro.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		lblFechaNacimiento.setFont(new Font("Arial", Font.BOLD, 13));
		lblFechaNacimiento.setBounds(10, 154, 147, 25);
		panel_1.add(lblFechaNacimiento);

		lblEmail_Personal.setFont(new Font("Arial", Font.BOLD, 13));
		lblEmail_Personal.setBounds(10, 299, 105, 25);
		panel_1.add(lblEmail_Personal);

		lblTelefono.setFont(new Font("Arial", Font.BOLD, 13));
		lblTelefono.setBounds(10, 335, 64, 25);
		panel_1.add(lblTelefono);

		lblDepartamento.setFont(new Font("Arial", Font.BOLD, 13));
		lblDepartamento.setBounds(10, 227, 99, 25);
		panel_1.add(lblDepartamento);

		lblLocalidad.setFont(new Font("Arial", Font.BOLD, 13));
		lblLocalidad.setBounds(10, 263, 76, 25);
		panel_1.add(lblLocalidad);

		lblEmail_Institucional.setFont(new Font("Arial", Font.BOLD, 13));
		lblEmail_Institucional.setBounds(513, 46, 126, 25);
		panel_1.add(lblEmail_Institucional);

		lblITR.setFont(new Font("Arial", Font.BOLD, 13));
		lblITR.setBounds(513, 82, 29, 25);
		panel_1.add(lblITR);

		lblTipo_De_Usuario.setFont(new Font("Arial", Font.BOLD, 13));
		lblTipo_De_Usuario.setBounds(513, 118, 110, 25);
		panel_1.add(lblTipo_De_Usuario);

		lblCedula.setBounds(10, 118, 164, 25);
		panel_1.add(lblCedula);
		lblCedula.setFont(new Font("Arial", Font.BOLD, 13));

		lblNombres.setFont(new Font("Arial", Font.BOLD, 13));
		lblNombres.setBounds(10, 46, 64, 25);
		panel_1.add(lblNombres);

		lblApellidos.setFont(new Font("Arial", Font.BOLD, 13));
		lblApellidos.setBounds(10, 82, 70, 25);
		panel_1.add(lblApellidos);

		lblGenero.setFont(new Font("Arial", Font.BOLD, 13));
		lblGenero.setBounds(10, 191, 55, 25);
		panel_1.add(lblGenero);

		lblNombres_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNombres_1.setBounds(84, 46, 315, 25);
		panel_1.add(lblNombres_1);

		lblApellidos_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblApellidos_1.setBounds(90, 82, 308, 25);
		panel_1.add(lblApellidos_1);

		lblCedula_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblCedula_1.setBounds(184, 118, 215, 25);
		panel_1.add(lblCedula_1);

		lblFechaNacimiento_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblFechaNacimiento_1.setBounds(166, 154, 232, 25);
		panel_1.add(lblFechaNacimiento_1);

		lblEmail_Personal_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblEmail_Personal_1.setBounds(125, 301, 274, 25);
		panel_1.add(lblEmail_Personal_1);

		lblTelefono_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblTelefono_1.setBounds(84, 335, 315, 25);
		panel_1.add(lblTelefono_1);

		lblGenero_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblGenero_1.setBounds(75, 190, 324, 25);
		panel_1.add(lblGenero_1);

		lblDepartamento_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblDepartamento_1.setBounds(119, 227, 280, 25);
		panel_1.add(lblDepartamento_1);

		lblLocalidad_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblLocalidad_1.setBounds(96, 263, 303, 25);
		panel_1.add(lblLocalidad_1);

		lblEmail_Institucional_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblEmail_Institucional_1.setBounds(649, 46, 254, 25);
		panel_1.add(lblEmail_Institucional_1);

		lblITR_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblITR_1.setBounds(552, 82, 351, 25);
		panel_1.add(lblITR_1);

		lblTipo_De_Usuario_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblTipo_De_Usuario_1.setBounds(633, 118, 270, 25);
		panel_1.add(lblTipo_De_Usuario_1);
		lblNewLabel_3.setForeground(Color.GRAY);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 11, 92, 14);
		
		panel_1.add(lblNewLabel_3);
		separator.setBounds(10, 33, 390, 2);
		
		panel_1.add(separator);
		lblInstitucionales.setForeground(Color.GRAY);
		lblInstitucionales.setFont(new Font("Arial", Font.BOLD, 15));
		lblInstitucionales.setBounds(513, 11, 146, 14);
		
		panel_1.add(lblInstitucionales);
		separator_1.setBounds(513, 32, 390, 2);
		
		panel_1.add(separator_1);

		JPanel panel_2 = new JPanel();
		panelCentro.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

		JLabel lblNewLabel_8 = new JLabel("                                     ");
		panel_2.add(lblNewLabel_8);

		JPanel panelPie = new JPanel();
		add(panelPie, BorderLayout.SOUTH);
		panelPie.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		panelPie.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panelEncabezado = new JPanel();
		panelEncabezado.setBackground(Color.WHITE);
		add(panelEncabezado, BorderLayout.NORTH);
		panelEncabezado.setLayout(new BorderLayout(0, 0));

		JLabel lblDatosDelUsuario = new JLabel(" Datos del usuario ");
		lblDatosDelUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblDatosDelUsuario.setForeground(Color.DARK_GRAY);
		lblDatosDelUsuario.setFont(new Font("Arial", Font.BOLD, 20));
		lblDatosDelUsuario.setBackground(Color.DARK_GRAY);
		panelEncabezado.add(lblDatosDelUsuario, BorderLayout.WEST);

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

	}

	public void rellenarDatosPropios() throws ServiciosException {
		Usuario usu = usuarioBean.obtenerPorIdUsuario(Login.getIdLoginUsuario());

		lblNombres_1.setText(usu.getNombre());
		lblApellidos_1.setText(usu.getApellido());
		lblCedula_1.setText(""+usu.getDocumento());
		lblDepartamento_1.setText(usu.getDepartamento());
		lblTelefono_1.setText(usu.getTelefono());
		lblNombreUsuario_1.setText("  "+usu.getNombreUsuario());
		lblGenero_1.setText(usu.getGenero());
		lblLocalidad_1.setText(usu.getLocalidad());
		lblEmail_Personal_1.setText(usu.getMail());
		lblEmail_Institucional_1.setText(usu.getMailInstitucional());
		lblFechaNacimiento_1.setText(""+usu.getFechaNac());
		lblITR_1.setText(""+usu.getItr().getNombre());
		lblTipo_De_Usuario_1.setText("" + usu.getTipoUsuario());

	}
}
