package com.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class GDI_Principal extends JPanel {

	/**
	 * Create the panel.
	 */
	public GDI_Principal() {
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
		txtpnEnElPanel.setText("\r\n\r\n\r\n  En este panel de gestión de ITRs visualizaremos:");
		txtpnEnElPanel.setBackground(new Color(51, 0, 51));
		txtpnEnElPanel.setSelectionColor(Color.GRAY);
		txtpnEnElPanel.setDisabledTextColor(Color.WHITE);
		txtpnEnElPanel.setEnabled(false);
		txtpnEnElPanel.setEditable(false);
		txtpnEnElPanel.setBounds(21, 33, 288, 99);
		panel.add(txtpnEnElPanel);
		
		JTextPane txtpnListarUsuariosDentro = new JTextPane();
		txtpnListarUsuariosDentro.setFont(new Font("Arial", Font.BOLD, 12));
		txtpnListarUsuariosDentro.setDisabledTextColor(Color.WHITE);
		txtpnListarUsuariosDentro.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnListarUsuariosDentro.setContentType("");
		txtpnListarUsuariosDentro.setForeground(Color.WHITE);
		txtpnListarUsuariosDentro.setText("\r\n\r\n1. Registrar ITRs: dentro se va a encontrar la lista de ITRs donde están las opciones de seleccionar el tipo de filtro, Borrar ITR, Modificar ITR y Refrescar el registro de los mismos.\r\n\r\n\r\n\r\n\r\n");
		txtpnListarUsuariosDentro.setBackground(new Color(0, 102, 153));
		txtpnListarUsuariosDentro.setEnabled(false);
		txtpnListarUsuariosDentro.setEditable(false);
		txtpnListarUsuariosDentro.setBounds(224, 108, 531, 99);
		panel.add(txtpnListarUsuariosDentro);
		
		JTextPane txtpnRegistrarUsuario = new JTextPane();
		txtpnRegistrarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnRegistrarUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		txtpnRegistrarUsuario.setDisabledTextColor(Color.WHITE);
		txtpnRegistrarUsuario.setText("\r\n\r\n\r\n\r\n\r\n\r\n");
		txtpnRegistrarUsuario.setEnabled(false);
		txtpnRegistrarUsuario.setEditable(false);
		txtpnRegistrarUsuario.setBackground(new Color(0, 102, 153));
		txtpnRegistrarUsuario.setBounds(473, 187, 438, 99);
		panel.add(txtpnRegistrarUsuario);
		
		JTextPane txtpnConvocatoriaA = new JTextPane();
		txtpnConvocatoriaA.setText("\r\n\r\n2. Registrar un ITR: dentro se visualizarán los campos requeridos para ingresar los datos del nuevo ITR  que deseemos registrar.\r\n\r\n\r\n\r\n\r\n");
		txtpnConvocatoriaA.setFont(new Font("Arial", Font.BOLD, 12));
		txtpnConvocatoriaA.setEnabled(false);
		txtpnConvocatoriaA.setEditable(false);
		txtpnConvocatoriaA.setDisabledTextColor(Color.WHITE);
		txtpnConvocatoriaA.setBackground(new Color(0, 102, 153));
		txtpnConvocatoriaA.setBounds(132, 271, 438, 99);
		panel.add(txtpnConvocatoriaA);
		
		JTextPane txtpnMantenimientoDe = new JTextPane();
		txtpnMantenimientoDe.setText("\r\n\r\n\r\n\r\n\r\n\r\n");
		txtpnMantenimientoDe.setFont(new Font("Arial", Font.BOLD, 12));
		txtpnMantenimientoDe.setEnabled(false);
		txtpnMantenimientoDe.setEditable(false);
		txtpnMantenimientoDe.setDisabledTextColor(Color.WHITE);
		txtpnMantenimientoDe.setBackground(new Color(0, 102, 153));
		txtpnMantenimientoDe.setBounds(473, 353, 438, 99);
		panel.add(txtpnMantenimientoDe);
		
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
