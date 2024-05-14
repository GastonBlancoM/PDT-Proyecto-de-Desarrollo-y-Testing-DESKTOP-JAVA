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

public class Panel_ITRs extends JInternalFrame {

	
	
		Color colorBackgroudMenu = new Color(0, 123, 255);
		Color colorBackgroudControl = new Color(24, 24, 24);
		
		GDI_Principal GDI_Principal = new GDI_Principal();
		GDI_Lista GDI_Lista = new GDI_Lista();
		GDI_Registrar GDI_Registrar = new GDI_Registrar();
		
		
		
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

		JButton btn_GDI_Principal;
		JButton btn_GDI_Lista_ITRs;
		JButton btn_GDI_Registrar_ITRs;
		
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
		public Panel_ITRs() {
			addInternalFrameListener(new InternalFrameAdapter() {
				@Override
				public void internalFrameOpened(InternalFrameEvent e) {
					Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, GDI_Principal);
				}
				@Override
				public void internalFrameClosed(InternalFrameEvent e) {
					Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, GDI_Principal);
				}
			});
			setFrameIcon(null);
			//setMaximizable(true);
			setIconifiable(true);
			setPreferredSize(new Dimension(50, 50));
			setClosable(true);
			setTitle("Gestión de ITRs");
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

			lblNewLabel = new JLabel("Gestión de ITRs   ");
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

			
			
			btn_GDI_Principal = new JButton(" Principal");
			btn_GDI_Principal.setIcon(new ImageIcon(Panel_De_Usuarios.class.getResource("/com/iconos/principal_ICON.png")));
			btn_GDI_Principal.setFocusable(false);
			btn_GDI_Principal.setBackground(new Color(0, 142, 255));
			btn_GDI_Principal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, GDI_Principal);

				}
			});
			btn_GDI_Principal.addMouseListener(new MouseAdapter() {
				
				public void mouseEntered(MouseEvent evt) {
					btn_GDI_PrincipalMouseEntered(evt);
				}

				public void mouseExited(MouseEvent evt) {
					btn_GDI_PrincipalMouseExited(evt);
				}

				public void mousePressed(MouseEvent evt) {
					btn_GDI_PrincipalMousePressed(evt);
				}
			});
			
			btn_GDI_Principal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btn_GDI_Principal.setHorizontalAlignment(SwingConstants.LEFT);
			btn_GDI_Principal.setForeground(Color.WHITE);
			btn_GDI_Principal.setFont(new Font("Arial", Font.BOLD, 14));
			btn_GDI_Principal.setBorder(null);
			btn_GDI_Principal.setBounds(10, 11, 203, 48);
			panel_menuBotones.add(btn_GDI_Principal);

			btn_GDI_Lista_ITRs = new JButton(" Lista de ITRs");
			btn_GDI_Lista_ITRs.setIcon(new ImageIcon(Panel_Perfil_Usuario.class.getResource("/com/iconos/editar_usuario_ICON.png")));
			btn_GDI_Lista_ITRs.setFocusable(false);
			btn_GDI_Lista_ITRs.setBackground(new Color(0, 142, 255));
			btn_GDI_Lista_ITRs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, GDI_Lista);

				}
			});
			btn_GDI_Lista_ITRs.addMouseListener(new MouseAdapter() {
				
				public void mouseEntered(MouseEvent evt) {
					btn_GDI_Lista_ITRsMouseEntered(evt);
				}

				public void mouseExited(MouseEvent evt) {
					btn_GDI_Lista_ITRsMouseExited(evt);
				}

				public void mousePressed(MouseEvent evt) {
					btn_GDI_Lista_ITRsMousePressed(evt);
				}
			});
			btn_GDI_Lista_ITRs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btn_GDI_Lista_ITRs.setHorizontalAlignment(SwingConstants.LEFT);
			btn_GDI_Lista_ITRs.setForeground(Color.WHITE);
			btn_GDI_Lista_ITRs.setFont(new Font("Arial", Font.BOLD, 14));
			btn_GDI_Lista_ITRs.setBorder(null);
			btn_GDI_Lista_ITRs.setBounds(10, 60, 203, 48);
			panel_menuBotones.add(btn_GDI_Lista_ITRs);
			
			btn_GDI_Registrar_ITRs = new JButton(" Registrar un ITR");
			btn_GDI_Registrar_ITRs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btn_GDI_Registrar_ITRs.setBackground(new Color(0, 142, 255));
			btn_GDI_Registrar_ITRs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, GDI_Registrar);
				}
			});
			btn_GDI_Registrar_ITRs.addMouseListener(new MouseAdapter() {
				
				public void mouseEntered(MouseEvent evt) {
					btn_GDI_Registrar_ITRsMouseEntered(evt);
				}

				public void mouseExited(MouseEvent evt) {
					btn_GDI_Registrar_ITRsMouseExited(evt);
				}

				public void mousePressed(MouseEvent evt) {
					btn_GDI_Registrar_ITRsMousePressed(evt);
				}
			});
			btn_GDI_Registrar_ITRs.setHorizontalAlignment(SwingConstants.LEFT);
			btn_GDI_Registrar_ITRs.setForeground(Color.WHITE);
			btn_GDI_Registrar_ITRs.setFont(new Font("Arial", Font.BOLD, 14));
			btn_GDI_Registrar_ITRs.setFocusable(false);
			btn_GDI_Registrar_ITRs.setBorder(null);
			
			btn_GDI_Registrar_ITRs.setBounds(10, 109, 203, 48);
			panel_menuBotones.add(btn_GDI_Registrar_ITRs);

		}

		private void btn_GDI_PrincipalMousePressed(MouseEvent evt) {
			setColor(btn_GDI_Principal);
			resetColor(btn_GDI_Lista_ITRs);
			resetColor(btn_GDI_Registrar_ITRs);
			

		}

		private void btn_GDI_Lista_ITRsMousePressed(MouseEvent evt) {
			setColor(btn_GDI_Lista_ITRs);
			resetColor(btn_GDI_Principal);
			resetColor(btn_GDI_Registrar_ITRs);
		}
		
		private void btn_GDI_Registrar_ITRsMousePressed(MouseEvent evt) {
			setColor(btn_GDI_Registrar_ITRs);
			resetColor(btn_GDI_Principal);
			resetColor(btn_GDI_Lista_ITRs);
		

		}

		private void btn_GDI_PrincipalMouseEntered(MouseEvent evt) {
			if (btn_GDI_Principal.getBackground().getRGB() == -16740609)
				setColor(btn_GDI_Principal);
		}
		
		private void btn_GDI_Lista_ITRsMouseEntered(MouseEvent evt) {
			if (btn_GDI_Lista_ITRs.getBackground().getRGB() == -16740609)
				setColor(btn_GDI_Lista_ITRs);
		}
		
		private void btn_GDI_Registrar_ITRsMouseEntered(MouseEvent evt) {
			if (btn_GDI_Registrar_ITRs.getBackground().getRGB() == -16740609)
				setColor(btn_GDI_Registrar_ITRs);
		}
		
		private void btn_GDI_PrincipalMouseExited(MouseEvent evt) {
			if (btn_GDI_Lista_ITRs.getBackground().getRGB() != -16740609
					||btn_GDI_Registrar_ITRs.getBackground().getRGB() != -16740609)
				resetColor(btn_GDI_Principal);
		}

		private void btn_GDI_Lista_ITRsMouseExited(MouseEvent evt) {
			if (btn_GDI_Principal.getBackground().getRGB() != -16740609
					||btn_GDI_Registrar_ITRs.getBackground().getRGB() != -16740609)
				resetColor(btn_GDI_Lista_ITRs);
		}

		private void btn_GDI_Registrar_ITRsMouseExited(MouseEvent evt) {
			if (btn_GDI_Principal.getBackground().getRGB() != -16740609
					||btn_GDI_Lista_ITRs.getBackground().getRGB() != -16740609)
				resetColor(btn_GDI_Registrar_ITRs);
		}

		void setColor(JButton boton) {
			boton.setBackground(new Color(0, 174, 230));
		}

		void resetColor(JButton boton) {
			boton.setBackground(new Color(0, 142, 255));
		}
}
