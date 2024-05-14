package com.vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.Cursor;
import java.awt.SystemColor;

public class U_Principal extends JPanel {

	/**
	 * Create the panel.
	 */
	public U_Principal() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_General = new JPanel();
		panel_General.setBackground(Color.WHITE);
		add(panel_General);
		panel_General.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Pie = new JPanel();
		panel_General.add(panel_Pie, BorderLayout.SOUTH);
		panel_Pie.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		panel_Pie.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_Encabezado = new JPanel();
		panel_Encabezado.setBackground(Color.WHITE);
		panel_General.add(panel_Encabezado, BorderLayout.NORTH);
		panel_Encabezado.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPrincipal = new JLabel(" Principal ");
		lblPrincipal.setFont(new Font("Arial", Font.BOLD, 20));
		lblPrincipal.setBackground(Color.WHITE);
		panel_Encabezado.add(lblPrincipal, BorderLayout.WEST);
		
		JLabel lblNewLabel_4 = new JLabel(" ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 5));
		panel_Encabezado.add(lblNewLabel_4, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_2_1 = new JLabel("  ");
		lblNewLabel_2_1.setOpaque(true);
		lblNewLabel_2_1.setBackground(new Color(0, 102, 255));
		panel_Encabezado.add(lblNewLabel_2_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_5 = new JLabel("  ");
		panel_Encabezado.add(lblNewLabel_5, BorderLayout.EAST);
		
		JLabel lblNewLabel_4_1 = new JLabel(" ");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 5));
		panel_Encabezado.add(lblNewLabel_4_1, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel_General.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTextPane txtpnEnElPanel = new JTextPane();
		txtpnEnElPanel.setFont(new Font("Arial", Font.BOLD, 12));
		txtpnEnElPanel.setText("\r\n\r\n\r\n  En el panel de usuario visualizaremos:");
		txtpnEnElPanel.setBackground(new Color(51, 0, 51));
		txtpnEnElPanel.setSelectionColor(Color.GRAY);
		txtpnEnElPanel.setDisabledTextColor(Color.WHITE);
		txtpnEnElPanel.setEnabled(false);
		txtpnEnElPanel.setEditable(false);
		txtpnEnElPanel.setBounds(21, 33, 235, 99);
		panel.add(txtpnEnElPanel);
		
		JTextPane txtpnListarUsuariosDentro = new JTextPane();
		txtpnListarUsuariosDentro.setFont(new Font("Arial", Font.BOLD, 12));
		txtpnListarUsuariosDentro.setDisabledTextColor(Color.WHITE);
		txtpnListarUsuariosDentro.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnListarUsuariosDentro.setContentType("");
		txtpnListarUsuariosDentro.setForeground(Color.WHITE);
		txtpnListarUsuariosDentro.setText("\r\n\r\n\r\n\r\n\r\n\r\n1. Listar usuarios: dentro podrás encontrar el listado de usuarios donde contaremos con la posibilidad de gestionar a los mismos a través de funciones como modificar datos, dar de baja, filtrar, actualizar lista, etc.");
		txtpnListarUsuariosDentro.setBackground(new Color(0, 102, 153));
		txtpnListarUsuariosDentro.setEnabled(false);
		txtpnListarUsuariosDentro.setEditable(false);
		txtpnListarUsuariosDentro.setBounds(147, 86, 468, 213);
		panel.add(txtpnListarUsuariosDentro);
		
		JTextPane txtpnRegistrarUsuario = new JTextPane();
		txtpnRegistrarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnRegistrarUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		txtpnRegistrarUsuario.setDisabledTextColor(Color.WHITE);
		txtpnRegistrarUsuario.setText("\r\n\r\n\r\n\r\n\r\n\r\n2. Registrar usuario: donde podrás registrar a los usuarios con los datos personales e institucionales requeridos.");
		txtpnRegistrarUsuario.setEnabled(false);
		txtpnRegistrarUsuario.setEditable(false);
		txtpnRegistrarUsuario.setBackground(new Color(0, 102, 153));
		txtpnRegistrarUsuario.setBounds(501, 254, 438, 204);
		panel.add(txtpnRegistrarUsuario);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(GDI_Principal.class.getResource("/com/imagenes/Logo_SIMBOLICO_del_EQUIPO.png")));
		lblNewLabel_1.setBounds(876, 11, 183, 187);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(GDI_Principal.class.getResource("/com/imagenes/Logo_DESCRIPTIVO_del_EQUIPO_.png")));
		lblNewLabel_2.setBounds(10, 458, 218, 67);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Powered by");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 438, 76, 14);
		panel.add(lblNewLabel_3);
	}
}
