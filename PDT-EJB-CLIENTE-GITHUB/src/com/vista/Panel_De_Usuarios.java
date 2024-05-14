package com.vista;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;

import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Point;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.event.AncestorListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.AncestorEvent;

public class Panel_De_Usuarios extends JInternalFrame {

	Color colorBackgroudMenu = new Color(0, 123, 255);
	Color colorBackgroudControl = new Color(24, 24, 24);
	
	U_Principal U_Principal = new U_Principal();
	U_Lista U_Lista = new U_Lista();
	U_Registrar U_Registrar = new U_Registrar();
	
	
	
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
	JButton btn_PdeU_ListaDeUsuarios;
	JButton btn_PdeU_Nuevo_Usuario;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel_De_Usuarios frame = new Panel_De_Usuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Panel_De_Usuarios() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, U_Principal);
				
			}
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, U_Principal);
			}
		});
		
		setFrameIcon(null);
		//setMaximizable(true);
		setIconifiable(true);
		setPreferredSize(new Dimension(50, 50));
		setClosable(true);
		setTitle("Usuarios");
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

		lblNewLabel = new JLabel("       Usuarios       ");
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

		lblNewLabel_6 = new JLabel("Administracion/Control de usuarios");
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

		Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, U_Principal);
		
		btn_PdeU_Principal = new JButton("Principal");
		btn_PdeU_Principal.setIcon(new ImageIcon(Panel_De_Usuarios.class.getResource("/com/iconos/principal_ICON.png")));
		btn_PdeU_Principal.setFocusable(false);
		btn_PdeU_Principal.setBackground(new Color(0, 142, 255));
		btn_PdeU_Principal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, U_Principal);

			}
		});
		btn_PdeU_Principal.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent evt) {
				btn_PdeU_PrincipalMouseEntered(evt);
			}

			public void mouseExited(MouseEvent evt) {
				btn_PdeU_PrincipalMouseExited(evt);
			}

			public void mousePressed(MouseEvent evt) {
				btn_PdeU_PrincipalMousePressed(evt);
			}
		});
		
		btn_PdeU_Principal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_PdeU_Principal.setHorizontalAlignment(SwingConstants.LEFT);
		btn_PdeU_Principal.setForeground(Color.WHITE);
		btn_PdeU_Principal.setFont(new Font("Arial", Font.BOLD, 14));
		btn_PdeU_Principal.setBorder(null);
		btn_PdeU_Principal.setBounds(10, 11, 203, 48);
		panel_menuBotones.add(btn_PdeU_Principal);
		
		btn_PdeU_ListaDeUsuarios = new JButton(" Lista de usuarios");
		btn_PdeU_ListaDeUsuarios.setIcon(new ImageIcon(Panel_De_Usuarios.class.getResource("/com/iconos/lista_usuarios_ICON.png")));
		btn_PdeU_ListaDeUsuarios.setFocusable(false);
		btn_PdeU_ListaDeUsuarios.setBackground(new Color(0, 142, 255));
		btn_PdeU_ListaDeUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, U_Lista);

			}
		});
		btn_PdeU_ListaDeUsuarios.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent evt) {
				btn_PdeU_ListaDeUsuariosMouseEntered(evt);
			}

			public void mouseExited(MouseEvent evt) {
				btn_PdeU_ListaDeUsuariosMouseExited(evt);
			}

			public void mousePressed(MouseEvent evt) {
				btn_PdeU_ListaDeUsuariosMousePressed(evt);
			}
		});
		btn_PdeU_ListaDeUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_PdeU_ListaDeUsuarios.setHorizontalAlignment(SwingConstants.LEFT);
		btn_PdeU_ListaDeUsuarios.setForeground(Color.WHITE);
		btn_PdeU_ListaDeUsuarios.setBorder(null);
		btn_PdeU_ListaDeUsuarios.setFont(new Font("Arial", Font.BOLD, 14));
		btn_PdeU_ListaDeUsuarios.setBounds(10, 60, 203, 48);
		panel_menuBotones.add(btn_PdeU_ListaDeUsuarios);

		btn_PdeU_Nuevo_Usuario = new JButton("Registrar usuario");
		btn_PdeU_Nuevo_Usuario.setIcon(new ImageIcon(Panel_De_Usuarios.class.getResource("/com/iconos/registrar_usuario_ICON.png")));
		btn_PdeU_Nuevo_Usuario.setFocusable(false);
		btn_PdeU_Nuevo_Usuario.setBackground(new Color(0, 142, 255));
		btn_PdeU_Nuevo_Usuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, U_Registrar);

			}
		});
		btn_PdeU_Nuevo_Usuario.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent evt) {
				btn_PdeU_Nuevo_UsuarioMouseEntered(evt);
			}

			public void mouseExited(MouseEvent evt) {
				btn_PdeU_Nuevo_UsuarioMouseExited(evt);
			}

			public void mousePressed(MouseEvent evt) {
				btn_PdeU_Nuevo_UsuarioMousePressed(evt);
			}
		});
		btn_PdeU_Nuevo_Usuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_PdeU_Nuevo_Usuario.setHorizontalAlignment(SwingConstants.LEFT);
		btn_PdeU_Nuevo_Usuario.setForeground(Color.WHITE);
		btn_PdeU_Nuevo_Usuario.setFont(new Font("Arial", Font.BOLD, 14));
		btn_PdeU_Nuevo_Usuario.setBorder(null);
		btn_PdeU_Nuevo_Usuario.setBounds(10, 109, 203, 48);
		panel_menuBotones.add(btn_PdeU_Nuevo_Usuario);

	}

	private void btn_PdeU_PrincipalMousePressed(MouseEvent evt) {
		setColor(btn_PdeU_Principal);
		resetColor(btn_PdeU_ListaDeUsuarios);
		resetColor(btn_PdeU_Nuevo_Usuario);
		

	}

	private void btn_PdeU_ListaDeUsuariosMousePressed(MouseEvent evt) {
		resetColor(btn_PdeU_Principal);
		setColor(btn_PdeU_ListaDeUsuarios);
		resetColor(btn_PdeU_Nuevo_Usuario);
		

	}

	private void btn_PdeU_Nuevo_UsuarioMousePressed(MouseEvent evt) {
		resetColor(btn_PdeU_Principal);
		resetColor(btn_PdeU_ListaDeUsuarios);
		setColor(btn_PdeU_Nuevo_Usuario);
		

	}

	private void btn_PdeU_PrincipalMouseEntered(MouseEvent evt) {
		if (btn_PdeU_Principal.getBackground().getRGB() == -16740609)
			setColor(btn_PdeU_Principal);
	}

	private void btn_PdeU_PrincipalMouseExited(MouseEvent evt) {
		if (btn_PdeU_ListaDeUsuarios.getBackground().getRGB() != -16740609
				|| btn_PdeU_Nuevo_Usuario.getBackground().getRGB() != -16740609)
			resetColor(btn_PdeU_Principal);
	}

	private void btn_PdeU_ListaDeUsuariosMouseEntered(MouseEvent evt) {
		if (btn_PdeU_ListaDeUsuarios.getBackground().getRGB() == -16740609)
			setColor(btn_PdeU_ListaDeUsuarios);
	}

	private void btn_PdeU_ListaDeUsuariosMouseExited(MouseEvent evt) {
		if (btn_PdeU_Principal.getBackground().getRGB() != -16740609
				|| btn_PdeU_Nuevo_Usuario.getBackground().getRGB() != -16740609)
			resetColor(btn_PdeU_ListaDeUsuarios);
	}

	private void btn_PdeU_Nuevo_UsuarioMouseEntered(MouseEvent evt) {
		if (btn_PdeU_Nuevo_Usuario.getBackground().getRGB() == -16740609)
			setColor(btn_PdeU_Nuevo_Usuario);
	}

	private void btn_PdeU_Nuevo_UsuarioMouseExited(MouseEvent evt) {
		if (btn_PdeU_Principal.getBackground().getRGB() != -16740609
				|| btn_PdeU_ListaDeUsuarios.getBackground().getRGB() != -16740609)
			resetColor(btn_PdeU_Nuevo_Usuario);
	}

	void setColor(JButton boton) {
		boton.setBackground(new Color(0, 174, 230));
	}

	void resetColor(JButton boton) {
		boton.setBackground(new Color(0, 142, 255));
	}
}
