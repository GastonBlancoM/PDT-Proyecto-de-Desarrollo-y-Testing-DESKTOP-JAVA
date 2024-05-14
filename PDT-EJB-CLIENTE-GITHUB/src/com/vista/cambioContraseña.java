package com.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Cursor;

public class cambioContraseña extends JFrame {

	private JPanel contentPane;
	static String contramodi;
	private ITRBeanCliente itrBean = new ITRBeanImp();
	private AnalistaBeanCliente analistaBean = new AnalistaBeanImp();
	private TutorBeanCliente tutorBean = new TutorBeanImp();
	private UsuarioBeanCliente usuarioBean = new UsuarioBeanImp();
	private EstudianteBeanCliente estudianteBean = new EstudianteBeanImp();
	private JPasswordField txtContraA;
	private JPasswordField txtContraN;
	private JPasswordField txtContraCN;
	private JRadioButton rbtnVerContra1 = new JRadioButton("");
	private JRadioButton rbtnVerContra2 = new JRadioButton("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cambioContraseña frame = new cambioContraseña();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//PEPITO
	/**
	 * Create the frame.
	 */
	public cambioContraseña() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 336, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Contraseña antigua");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setBounds(109, 31, 102, 13);
		contentPane.add(lblNewLabel);

		JLabel lblContraseaNueva = new JLabel("Contraseña nueva");
		lblContraseaNueva.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblContraseaNueva.setBounds(109, 105, 102, 13);
		contentPane.add(lblContraseaNueva);

		JLabel lblConfirmeContrasea = new JLabel("Confirme contraseña");
		lblConfirmeContrasea.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblConfirmeContrasea.setBounds(96, 165, 115, 13);
		contentPane.add(lblConfirmeContrasea);

		JButton btnNewButton = new JButton("Modificar contraseña");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					modificarContra();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(10, 232, 144, 21);
		contentPane.add(btnNewButton);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(163, 232, 149, 21);
		contentPane.add(btnCancelar);

		txtContraA = new JPasswordField();
		txtContraA.setBounds(70, 54, 179, 21);
		contentPane.add(txtContraA);

		txtContraN = new JPasswordField();
		txtContraN.setBounds(70, 134, 179, 21);
		contentPane.add(txtContraN);

		txtContraCN = new JPasswordField();
		txtContraCN.setBounds(70, 188, 179, 21);
		contentPane.add(txtContraCN);
		rbtnVerContra1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		rbtnVerContra1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verContrasenia1();
			}
		});
		rbtnVerContra1.setIcon(new ImageIcon(cambioContraseña.class.getResource("/com/iconos/ojo.png")));
		rbtnVerContra1.setOpaque(false);
		rbtnVerContra1.setToolTipText("Mostrar contraseña");
		rbtnVerContra1.setBackground(Color.WHITE);
		rbtnVerContra1.setBounds(255, 54, 33, 20);
		contentPane.add(rbtnVerContra1);
		rbtnVerContra2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		
		rbtnVerContra2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verContrasenia2();
			}
		});
		rbtnVerContra2.setIcon(new ImageIcon(cambioContraseña.class.getResource("/com/iconos/ojo.png")));
		rbtnVerContra2.setOpaque(false);
		rbtnVerContra2.setToolTipText("Mostrar contraseña");
		rbtnVerContra2.setBackground(Color.WHITE);
		rbtnVerContra2.setBounds(255, 134, 33, 20);
		contentPane.add(rbtnVerContra2);
	}

	void modificarContra() throws ServiciosException {
		Usuario est;
		est = usuarioBean.obtenerPorIdUsuario(Login.getIdLoginUsuario());
		//awdawd
		if (est.getContrasenia().equals(txtContraA.getText())) {

			if (txtContraN.getText().equals(txtContraCN.getText())) {

				EstudianteDTO estudiante = new EstudianteDTO();
				estudiante.setIdUsuario(est.getIdUsuario());
				estudiante.setNombre(est.getNombre());
				estudiante.setApellido(est.getApellido());
				estudiante.setDocumento(est.getDocumento());
				estudiante.setDepartamento(est.getDepartamento());
				estudiante.setTelefono(est.getTelefono());
				estudiante.setNombreUsuario(est.getNombreUsuario());
				String a = String.valueOf(PDU_Actualizar.fechaGlobal);
				estudiante.setAñoIngreso(a);
				estudiante.setGenero(est.getGenero());
				estudiante.setLocalidad(est.getLocalidad());
				estudiante.setMail((est.getMail()));
				estudiante.setMailInstitucional(est.getMailInstitucional());
				estudiante.setFechaNac(est.getFechaNac());
				estudiante.setContrasenia(txtContraN.getText());
				estudiante.setTipoUsuario(TipoUsuario.Estudiante);
				estudiante.setEstadoUsuario(EstadoUsuario.Validado);
				estudiante.setEstadoEstudiante(EstadoEstudiante.Activo);
				estudiante.setItr(est.getItr());

				try {
					estudianteBean.modificarEstudiante(estudiante);
					JOptionPane.showMessageDialog(null, "Datos actualizados Correctamente");
				} catch (ServiciosException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		}

		else {
			JOptionPane.showMessageDialog(null, "La contraseña antigua no es correcta", "Contraseña invalida",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	protected void verContrasenia1() {
		if (rbtnVerContra1.isSelected()) {
			txtContraA.setEchoChar((char) 0);
			rbtnVerContra1.setIcon(new ImageIcon(PDU_Actualizar.class.getResource("/com/iconos/ojos-cruzados.png")));
			rbtnVerContra1.setToolTipText("Ocultar contraseña");
		} else {
			txtContraA.setEchoChar('*');
			rbtnVerContra1.setIcon(new ImageIcon(PDU_Actualizar.class.getResource("/com/iconos/ojo.png")));
			rbtnVerContra1.setToolTipText("Mostrar contraseña");
		}

	}

	protected void verContrasenia2() {

		if (rbtnVerContra2.isSelected()) {
			txtContraN.setEchoChar((char) 0);
			txtContraCN.setEchoChar((char) 0);
			rbtnVerContra2.setIcon(new ImageIcon(PDU_Actualizar.class.getResource("/com/iconos/ojos-cruzados.png")));
			rbtnVerContra2.setToolTipText("Ocultar contraseña");
		} else {
			txtContraN.setEchoChar('*');
			txtContraCN.setEchoChar('*');
			rbtnVerContra2.setIcon(new ImageIcon(PDU_Actualizar.class.getResource("/com/iconos/ojo.png")));
			rbtnVerContra2.setToolTipText("Mostrar contraseña");
		}

	}

}
