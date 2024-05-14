package com.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import com.exception.ServiciosException;

public class Panel_Perfil_Usuario extends JInternalFrame {

	Color colorBackgroudMenu = new Color(0, 123, 255);
	Color colorBackgroudControl = new Color(24, 24, 24);
	
	PDU_Principal PDU_Principal = new PDU_Principal();
	PDU_Actualizar PDU_Actualizar = new PDU_Actualizar();
	
	
	
	Panel panelGeneral;
	JPanel panel_Menu;
	JPanel panel_menuEncabezado;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	JLabel lblNewLabel_2;
	JLabel lblNewLabel_3;
	JLabel lblNewLabel_4;
	JLabel lblNewLabel_5;
	JLabel lblNewLabel_6;
	JLabel lblNewLabel_7;
	JLabel lblNewLabel_8;
	JLabel lblNewLabel_9;

	JPanel panel_Control;
	JPanel panel_menuBotones;
	JPanel panel_controlEncabezado;
	JPanel panel_controlCentro;
	JPanel panel_menuPie;

	JButton btn_PdeU_Principal;
	JButton btn_PerDeU_Modificar_Perfil;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel_Perfil_Usuario frame = new Panel_Perfil_Usuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Panel_Perfil_Usuario() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, PDU_Principal);
				try {
					PDU_Principal.rellenarDatosPropios();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, PDU_Principal);
			}
		});
		
		setFrameIcon(null);
		//setMaximizable(true);
		setIconifiable(true);
		setPreferredSize(new Dimension(50, 50));
		setClosable(true);
		setTitle("Mi perfil");
		setBounds(100, 100, 1300, 705);//749, 587
		getContentPane().setLayout(new BorderLayout(0, 0));

		panelGeneral = new Panel();
		getContentPane().setBackground(new Color(24, 24, 24));
		getContentPane().add(panelGeneral, BorderLayout.CENTER);
		panelGeneral.setLayout(new BorderLayout(0, 0));

		panel_Menu = new JPanel();
		panel_Menu.setBackground(colorBackgroudMenu);
		panelGeneral.add(panel_Menu, BorderLayout.WEST);
		panel_Menu.setLayout(new BorderLayout(0, 0));

		panel_menuEncabezado = new JPanel();
		panel_menuEncabezado.setBackground(colorBackgroudMenu);
		panel_Menu.add(panel_menuEncabezado, BorderLayout.NORTH);
		panel_menuEncabezado.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel("Perfil del usuario ");
		lblNewLabel.setForeground(new Color(255, 255, 224));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		panel_menuEncabezado.add(lblNewLabel);

		lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel_menuEncabezado.add(lblNewLabel_1, BorderLayout.NORTH);

		lblNewLabel_2 = new JLabel("         ");
		panel_menuEncabezado.add(lblNewLabel_2, BorderLayout.WEST);

		lblNewLabel_3 = new JLabel("         ");
		panel_menuEncabezado.add(lblNewLabel_3, BorderLayout.EAST);

		lblNewLabel_4 = new JLabel(" ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		panel_menuEncabezado.add(lblNewLabel_4, BorderLayout.SOUTH);

		panel_menuBotones = new JPanel();
		panel_menuBotones.setBackground(new Color(0, 142, 255));
		panel_Menu.add(panel_menuBotones, BorderLayout.CENTER);
		panel_menuBotones.setLayout(null);

		panel_menuPie = new JPanel();
		panel_menuPie.setBackground(colorBackgroudMenu);
		panel_Menu.add(panel_menuPie, BorderLayout.SOUTH);

		lblNewLabel_9 = new JLabel(" ");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_menuPie.add(lblNewLabel_9);

		panel_Control = new JPanel();
		panel_Control.setBackground(colorBackgroudControl);
		panelGeneral.add(panel_Control, BorderLayout.CENTER);
		panel_Control.setLayout(new BorderLayout(0, 0));

		panel_controlEncabezado = new JPanel();
		panel_controlEncabezado.setBackground(new Color(0, 142, 255));
		panel_Control.add(panel_controlEncabezado, BorderLayout.NORTH);
		panel_controlEncabezado.setLayout(new BorderLayout(0, 0));

		lblNewLabel_5 = new JLabel("  ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_controlEncabezado.add(lblNewLabel_5, BorderLayout.NORTH);

		lblNewLabel_6 = new JLabel("Datos del usuario/Actualización");
		lblNewLabel_6.setForeground(new Color(255, 255, 224));
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 13));
		panel_controlEncabezado.add(lblNewLabel_6, BorderLayout.CENTER);

		lblNewLabel_7 = new JLabel("                     ");
		panel_controlEncabezado.add(lblNewLabel_7, BorderLayout.WEST);

		lblNewLabel_8 = new JLabel("                ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_controlEncabezado.add(lblNewLabel_8, BorderLayout.SOUTH);

		panel_controlCentro = new JPanel();

		panel_controlCentro.setBackground(Color.WHITE);
		panel_Control.add(panel_controlCentro, BorderLayout.CENTER);
		panel_controlCentro.setLayout(new BorderLayout(0, 0));

		Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, PDU_Principal);
		
		btn_PdeU_Principal = new JButton("Principal");
		btn_PdeU_Principal.setIcon(new ImageIcon(Panel_De_Usuarios.class.getResource("/com/iconos/principal_ICON.png")));
		btn_PdeU_Principal.setFocusable(false);
		btn_PdeU_Principal.setBackground(new Color(0, 142, 255));
		btn_PdeU_Principal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, PDU_Principal);
				
			
				try {
					PDU_Principal.rellenarDatosPropios();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btn_PdeU_Principal.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent evt) {
				btn_PerDeU_PrincipalMouseEntered(evt);
			}

			public void mouseExited(MouseEvent evt) {
				btn_PerDeU_PrincipalMouseExited(evt);
			}

			public void mousePressed(MouseEvent evt) {
				btn_PerDeU_PrincipalMousePressed(evt);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		
		btn_PdeU_Principal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_PdeU_Principal.setHorizontalAlignment(SwingConstants.LEFT);
		btn_PdeU_Principal.setForeground(Color.WHITE);
		btn_PdeU_Principal.setFont(new Font("Arial", Font.BOLD, 14));
		btn_PdeU_Principal.setBorder(null);
		btn_PdeU_Principal.setBounds(10, 11, 203, 48);
		panel_menuBotones.add(btn_PdeU_Principal);

		btn_PerDeU_Modificar_Perfil = new JButton("Modificar perfil");
		btn_PerDeU_Modificar_Perfil.setIcon(new ImageIcon(Panel_Perfil_Usuario.class.getResource("/com/iconos/editar_usuario_ICON.png")));
		btn_PerDeU_Modificar_Perfil.setFocusable(false);
		btn_PerDeU_Modificar_Perfil.setBackground(new Color(0, 142, 255));
		btn_PerDeU_Modificar_Perfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, PDU_Actualizar);
				try {
					PDU_Actualizar.cargarDatosPropios();
					
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btn_PerDeU_Modificar_Perfil.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent evt) {
				btn_PerDeU_Actualizar_PerfilMouseEntered(evt);
			}

			public void mouseExited(MouseEvent evt) {
				btn_PerDeU_Actualizar_PerfilMouseExited(evt);
			}

			public void mousePressed(MouseEvent evt) {
				btn_PerDeU_Actualizar_PerfilMousePressed(evt);
			}
		});
		btn_PerDeU_Modificar_Perfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_PerDeU_Modificar_Perfil.setHorizontalAlignment(SwingConstants.LEFT);
		btn_PerDeU_Modificar_Perfil.setForeground(Color.WHITE);
		btn_PerDeU_Modificar_Perfil.setFont(new Font("Arial", Font.BOLD, 14));
		btn_PerDeU_Modificar_Perfil.setBorder(null);
		btn_PerDeU_Modificar_Perfil.setBounds(10, 60, 203, 48);
		panel_menuBotones.add(btn_PerDeU_Modificar_Perfil);

	}

	private void btn_PerDeU_PrincipalMousePressed(MouseEvent evt) {
		setColor(btn_PdeU_Principal);
		
		resetColor(btn_PerDeU_Modificar_Perfil);
		

	}

	private void btn_PerDeU_Actualizar_PerfilMousePressed(MouseEvent evt) {
		resetColor(btn_PdeU_Principal);

		setColor(btn_PerDeU_Modificar_Perfil);
	

	}

	private void btn_PerDeU_PrincipalMouseEntered(MouseEvent evt) {
		if (btn_PdeU_Principal.getBackground().getRGB() == -16740609)
			setColor(btn_PdeU_Principal);
	}

	private void btn_PerDeU_PrincipalMouseExited(MouseEvent evt) {
		if (btn_PerDeU_Modificar_Perfil.getBackground().getRGB() != -16740609)
			resetColor(btn_PdeU_Principal);
	}

	private void btn_PerDeU_Actualizar_PerfilMouseEntered(MouseEvent evt) {
		if (btn_PerDeU_Modificar_Perfil.getBackground().getRGB() == -16740609)
			setColor(btn_PerDeU_Modificar_Perfil);
	}

	private void btn_PerDeU_Actualizar_PerfilMouseExited(MouseEvent evt) {
		if (btn_PdeU_Principal.getBackground().getRGB() != -16740609)
			resetColor(btn_PerDeU_Modificar_Perfil);
	}

	void setColor(JButton boton) {
		boton.setBackground(new Color(0, 174, 230));
	}

	void resetColor(JButton boton) {
		boton.setBackground(new Color(0, 142, 255));
	}

	

}
