package com.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.exception.ServiciosException;

public class MenuPrincipalEstudiante extends JFrame {

	private JPanel contentPane;
	private JDesktopPane menuEstudiante;
	private Panel_De_Usuarios Panel_De_Usuarios;
	private Panel_Perfil_Usuario Panel_Perfil_Usuario;
	private Color colorBarraTareas = new Color(24, 24, 24);
	private PDU_Principal PDU_Principal = new PDU_Principal();

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
					MenuPrincipalEstudiante frame = new MenuPrincipalEstudiante();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipalEstudiante() {
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

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					PDU_Principal.rellenarDatosPropios();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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

		JButton btnEventos = new JButton("Eventos");
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
		btnEventos.setBounds(10, 71, 46, 49);
		panel_3.add(btnEventos);

		menuEstudiante = new JDesktopPane();
		menuEstudiante.setBackground(new Color(44, 153, 171));
		menuEstudiante.setBorder(null);
		getContentPane().add(menuEstudiante, BorderLayout.CENTER);
		menuEstudiante.setLayout(null);
	}

	public void CentrarVentanaInterna(JInternalFrame internalFrame) {
		int x = (menuEstudiante.getWidth() / 2) - internalFrame.getWidth() / 2;
		int y = (menuEstudiante.getHeight() / 2) - internalFrame.getHeight() / 2;

		if (internalFrame.isShowing()) {
			internalFrame.setLocation(x, y);

		} else {
			menuEstudiante.add(internalFrame);
			internalFrame.setLocation(x, y);
			internalFrame.setVisible(true);
			;
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
