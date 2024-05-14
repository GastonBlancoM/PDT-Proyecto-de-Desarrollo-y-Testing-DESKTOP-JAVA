package com.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.entities.ITR;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowEvent;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class MenuPrincipalAnalista extends JFrame {

	public static JDesktopPane menuAnalista;
	private JPanel contentPane;
	private Panel_De_Usuarios Panel_De_Usuarios;
	private Panel_De_Eventos Panel_De_Eventos;
	private Panel_Perfil_Usuario Panel_Perfil_Usuario;
	private Panel_ITRs Panel_ITRs;
	

	private Color colorBarraTareas = new Color(24, 24, 24);

	int xRaton;
	int yRaton;

	int ancho = Toolkit.getDefaultToolkit().getScreenSize().width;
	int alto = Toolkit.getDefaultToolkit().getScreenSize().height;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipalAnalista frame = new MenuPrincipalAnalista();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//comentario
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuPrincipalAnalista() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 497);

		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(colorBarraTareas);
		getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(colorBarraTareas);
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuPrincipalAnalista.class.getResource("/com/imagenes/SimboloUtecPNG.png")));
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("  ");
		panel_1.add(lblNewLabel_1, BorderLayout.EAST);

		JLabel lblNewLabel_2 = new JLabel("  ");
		panel_1.add(lblNewLabel_2, BorderLayout.WEST);

		JLabel lblNewLabel_3 = new JLabel(" ");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 5));
		panel_1.add(lblNewLabel_3, BorderLayout.NORTH);

		JLabel lblNewLabel_4 = new JLabel(" ");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 5));
		panel_1.add(lblNewLabel_4, BorderLayout.SOUTH);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(colorBarraTareas);
		panel.add(panel_2, BorderLayout.SOUTH);

		JButton btnCerrar_Sesion = new JButton("Salir");
		btnCerrar_Sesion.setFocusable(false);
		btnCerrar_Sesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrar_Sesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCerrar_Sesion.setIcon(
						new ImageIcon(MenuPrincipalAnalista.class.getResource("/com/iconos/Cerrar_Sesion_ICON_2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCerrar_Sesion.setIcon(
						new ImageIcon(MenuPrincipalAnalista.class.getResource("/com/iconos/Cerrar_Sesion_ICON.png")));
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				windowClosing(null);

			}

		});
		panel_2.setLayout(new BorderLayout(0, 0));
		btnCerrar_Sesion
				.setIcon(new ImageIcon(MenuPrincipalAnalista.class.getResource("/com/iconos/Cerrar_Sesion_ICON.png")));
		btnCerrar_Sesion.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCerrar_Sesion.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCerrar_Sesion.setToolTipText("Cerrar sesion");
		btnCerrar_Sesion.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCerrar_Sesion.setForeground(Color.WHITE);
		btnCerrar_Sesion.setFont(new Font("Arial", Font.BOLD, 10));
		btnCerrar_Sesion.setContentAreaFilled(false);
		btnCerrar_Sesion.setBorder(null);
		panel_2.add(btnCerrar_Sesion, BorderLayout.CENTER);

		JLabel lblNewLabel_5 = new JLabel(" ");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 5));
		lblNewLabel_5.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_5.setForeground(Color.LIGHT_GRAY);
		panel_2.add(lblNewLabel_5, BorderLayout.NORTH);

		JLabel lblNewLabel_6 = new JLabel(" ");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 5));
		panel_2.add(lblNewLabel_6, BorderLayout.SOUTH);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(colorBarraTareas);
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(null);

		JButton btnMiPerfil = new JButton("Mi perfil");
		btnMiPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!(Panel_Perfil_Usuario instanceof Panel_Perfil_Usuario)) {
					Panel_Perfil_Usuario = new Panel_Perfil_Usuario();

				}
				CentrarVentanaInterna(Panel_Perfil_Usuario);

			}
		});
		btnMiPerfil.setFocusable(false);
		btnMiPerfil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnMiPerfil.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				btnMiPerfil.setIcon(
						new ImageIcon(MenuPrincipalAnalista.class.getResource("/com/iconos/Perfil_ICON_2.png")));

			}

			public void mouseExited(MouseEvent e) {
				btnMiPerfil.setIcon(
						new ImageIcon(MenuPrincipalAnalista.class.getResource("/com/iconos/Perfil_ICON_1.png")));
			}

		});
		btnMiPerfil.setIcon(new ImageIcon(MenuPrincipalAnalista.class.getResource("/com/iconos/Perfil_ICON_1.png")));
		btnMiPerfil.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMiPerfil.setVerticalAlignment(SwingConstants.BOTTOM);
		btnMiPerfil.setToolTipText("Modificación de datos propios del Usuario");
		btnMiPerfil.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMiPerfil.setForeground(Color.WHITE);
		btnMiPerfil.setFont(new Font("Arial", Font.BOLD, 10));
		btnMiPerfil.setContentAreaFilled(false);
		btnMiPerfil.setBorder(null);
		btnMiPerfil.setBounds(10, 11, 46, 49);
		panel_3.add(btnMiPerfil);

		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setFocusable(false);

		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!(Panel_De_Usuarios instanceof Panel_De_Usuarios)) {
					Panel_De_Usuarios = new Panel_De_Usuarios();

				}
				CentrarVentanaInterna(Panel_De_Usuarios);

			}
		});

		btnUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnUsuarios.setIcon(
						new ImageIcon(MenuPrincipalAnalista.class.getResource("/com/iconos/listaUsuarios_ICON_2.png")));

			}

			public void mouseExited(MouseEvent e) {
				btnUsuarios.setIcon(
						new ImageIcon(MenuPrincipalAnalista.class.getResource("/com/iconos/listaUsuarios_ICON_1.png")));
			}
		});
		btnUsuarios.setIcon(
				new ImageIcon(MenuPrincipalAnalista.class.getResource("/com/iconos/listaUsuarios_ICON_1.png")));
		btnUsuarios.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnUsuarios.setVerticalAlignment(SwingConstants.BOTTOM);
		btnUsuarios.setToolTipText("Lista y modificaciones");
		btnUsuarios.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUsuarios.setForeground(Color.WHITE);
		btnUsuarios.setFont(new Font("Arial", Font.BOLD, 10));
		btnUsuarios.setContentAreaFilled(false);
		btnUsuarios.setBorder(null);
		btnUsuarios.setBounds(10, 71, 46, 49);
		panel_3.add(btnUsuarios);

		JButton btnMantenimiento = new JButton("ITRs");
		btnMantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(Panel_ITRs instanceof Panel_ITRs)) {
					Panel_ITRs = new Panel_ITRs();

				}
				CentrarVentanaInterna(Panel_ITRs);
			}
		});
		btnMantenimiento.setFocusable(false);
		btnMantenimiento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMantenimiento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMantenimiento.setIcon(
						new ImageIcon(MenuPrincipalAnalista.class.getResource("/com/iconos/Mantenimiento_ICON_2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMantenimiento.setIcon(
						new ImageIcon(MenuPrincipalAnalista.class.getResource("/com/iconos/Mantenimiento_ICON.png")));
			}

		});
		btnMantenimiento
				.setIcon(new ImageIcon(MenuPrincipalAnalista.class.getResource("/com/iconos/Mantenimiento_ICON.png")));
		btnMantenimiento.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMantenimiento.setVerticalAlignment(SwingConstants.BOTTOM);
		btnMantenimiento.setToolTipText("Mantenimiento de lista auxiliar de ITRs");
		btnMantenimiento.setHorizontalTextPosition(SwingConstants.CENTER);
		btnMantenimiento.setForeground(Color.WHITE);
		btnMantenimiento.setFont(new Font("Arial", Font.BOLD, 10));
		btnMantenimiento.setContentAreaFilled(false);
		btnMantenimiento.setBorder(null);
		btnMantenimiento.setBounds(10, 131, 46, 49);
		panel_3.add(btnMantenimiento);

		JButton btnEventos = new JButton("Eventos");
		btnEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(Panel_De_Eventos instanceof Panel_De_Eventos)) {
					Panel_De_Eventos = new Panel_De_Eventos();

				}
				CentrarVentanaInterna(Panel_De_Eventos);
			}
		});
		btnEventos.setFocusable(false);
		btnEventos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEventos.setIcon(new ImageIcon(MenuPrincipalAnalista.class.getResource("/com/iconos/Eventos_ICON.png")));
		btnEventos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEventos.setIcon(
						new ImageIcon(MenuPrincipalAnalista.class.getResource("/com/iconos/Eventos_ICON_2.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnEventos.setIcon(
						new ImageIcon(MenuPrincipalAnalista.class.getResource("/com/iconos/Eventos_ICON.png")));
			}
		});

		btnEventos.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEventos.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEventos.setToolTipText("Gestion y administracion de eventos");
		btnEventos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEventos.setForeground(Color.WHITE);
		btnEventos.setFont(new Font("Arial", Font.BOLD, 10));
		btnEventos.setContentAreaFilled(false);
		btnEventos.setBorder(null);
		btnEventos.setBounds(10, 190, 46, 49);
		panel_3.add(btnEventos);

		menuAnalista = new JDesktopPane();
		menuAnalista.setBackground(new Color(44, 153, 171));
		menuAnalista.setBorder(null);
		getContentPane().add(menuAnalista, BorderLayout.CENTER);
		menuAnalista.setLayout(null);

	}



	public void CentrarVentanaInterna(JInternalFrame internalFrame) {
		int x = (menuAnalista.getWidth() / 2) - internalFrame.getWidth() / 2;
		int y = (menuAnalista.getHeight() / 2) - internalFrame.getHeight() / 2;

		if (internalFrame.isShowing()) {
			internalFrame.setLocation(x, y);

		} else {
			menuAnalista.add(internalFrame);
			internalFrame.setLocation(x, y);
			internalFrame.setVisible(true);

		}
	}

	public void windowClosing(WindowEvent e) {

		int option = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres cerrar la sessión?",
				"Confirmación de cierre", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		if (option == JOptionPane.YES_OPTION) {
			dispose();
			Login frame = new Login();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
		}

	}
}
