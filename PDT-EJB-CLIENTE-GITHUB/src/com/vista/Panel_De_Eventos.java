package com.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import com.exception.ServiciosException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel_De_Eventos extends JInternalFrame {
	
	PDE_Principal PDE_Principal = new PDE_Principal();
	PDE_Alta_de_Eventos PDE_Alta_de_Eventos = new PDE_Alta_de_Eventos();
	PDE_Lista_Eventos PDE_Lista_Eventos = new PDE_Lista_Eventos();
	PDE_Convocatoria_Eventos PDE_Convocatoria_Eventos = new PDE_Convocatoria_Eventos();
	PDE_Mant_Tipo_Evento PDE_Mant_Tipo_Evento = new PDE_Mant_Tipo_Evento();
	
	Color colorBackgroudMenu = new Color(0,123,255);//31743
	Color colorBackgroudControl = new Color(24,24,24);
	
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

	JButton btn_PDE_Principal;
	JButton btn_PDE_ListaDeEventos;
	JButton btn_PDE_AltaDeEventos;
	JButton btn_PDE_Convocatoria_Eventos;
	JButton btn_PDE_Mantenimiento;
	
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

	/**
	 * Create the frame.
	 */
	public Panel_De_Eventos() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, PDE_Principal);
				
			}
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, PDE_Principal);
			}
		});
		setFrameIcon(null);
		setResizable(true);
		
		
		//setMaximizable(true);
		setIconifiable(true);
		setPreferredSize(new Dimension(50, 50));
		setClosable(true);
		setTitle("Usuarios");
		setBounds(100, 100, 1300, 705);//749, 587
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		panelGeneral = new Panel();
		getContentPane().setBackground(new Color(24,24,24));
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
		
		lblNewLabel = new JLabel("Panel de eventos");
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
		panel_menuBotones.setBackground(new Color(0,142,255));
		panel_Menu.add(panel_menuBotones, BorderLayout.CENTER);
		panel_menuBotones.setLayout(null);
		
		btn_PDE_ListaDeEventos = new JButton(" Lista de eventos");
		btn_PDE_ListaDeEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, PDE_Lista_Eventos);
			}
		});
		btn_PDE_ListaDeEventos.setRequestFocusEnabled(false);
		btn_PDE_ListaDeEventos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		btn_PDE_ListaDeEventos.setIcon(new ImageIcon(Panel_De_Eventos.class.getResource("/com/iconos/Lista_ICON.png")));
		btn_PDE_ListaDeEventos.setHorizontalAlignment(SwingConstants.LEFT);
		btn_PDE_ListaDeEventos.setBackground(new Color(0,142,255));
		btn_PDE_ListaDeEventos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_PDE_ListaDeEventosMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_PDE_ListaDeEventosMouseExited(e);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_PDE_ListaDeEventosMousePressed(e);
			}
		});
		btn_PDE_ListaDeEventos.setForeground(new Color(255, 255, 255));
		btn_PDE_ListaDeEventos.setBorder(null);
		btn_PDE_ListaDeEventos.setFont(new Font("Arial", Font.BOLD, 14));
		btn_PDE_ListaDeEventos.setBounds(10, 60, 196, 48);
		panel_menuBotones.add(btn_PDE_ListaDeEventos);
		
		btn_PDE_Principal = new JButton(" Principal");
		btn_PDE_Principal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, PDE_Principal);
			}
		});
		btn_PDE_Principal.setHorizontalAlignment(SwingConstants.LEFT);
		btn_PDE_Principal.setAlignmentY(6.0f);
		btn_PDE_Principal.setAlignmentX(6.0f);
		btn_PDE_Principal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_PDE_Principal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_PDE_PrincipalMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_PDE_PrincipalMouseExited(e);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_PDE_PrincipalPressed(e);
			}
		});
//		btn_PDE_Principal.setIcon(new ImageIcon(Panel_De_Eventos.class.getResource("/com/iconos/principal_ICON.png")));
		btn_PDE_Principal.setRequestFocusEnabled(false);
		btn_PDE_Principal.setForeground(Color.WHITE);
		btn_PDE_Principal.setFont(new Font("Arial", Font.BOLD, 14));
		btn_PDE_Principal.setBorder(null);
		btn_PDE_Principal.setBackground(new Color(0, 142, 255));
		btn_PDE_Principal.setBounds(10, 11, 196, 48);
		panel_menuBotones.add(btn_PDE_Principal);
		
		btn_PDE_Convocatoria_Eventos = new JButton(" Convocatorias");
		btn_PDE_Convocatoria_Eventos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_PDE_Convocatoria_Eventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, PDE_Convocatoria_Eventos);
				//PDE_Convocatoria_Eventos.listarConvocados();
				
			}
		});
		btn_PDE_Convocatoria_Eventos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_PDE_Convocatoria_EventosMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_PDE_Convocatoria_EventosMouseExited(e);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_PDE_Convocatoria_EventosMousePressed(e);
			}
		});
		btn_PDE_Convocatoria_Eventos.setRequestFocusEnabled(false);
		btn_PDE_Convocatoria_Eventos.setHorizontalAlignment(SwingConstants.LEFT);
		btn_PDE_Convocatoria_Eventos.setForeground(Color.WHITE);
		btn_PDE_Convocatoria_Eventos.setFont(new Font("Arial", Font.BOLD, 14));
		btn_PDE_Convocatoria_Eventos.setBorder(null);
		btn_PDE_Convocatoria_Eventos.setBackground(new Color(0, 142, 255));
		btn_PDE_Convocatoria_Eventos.setBounds(10, 158, 196, 48);
		panel_menuBotones.add(btn_PDE_Convocatoria_Eventos);
		
		
		
		btn_PDE_AltaDeEventos = new JButton(" Alta de eventos");
		btn_PDE_AltaDeEventos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_PDE_AltaDeEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, PDE_Alta_de_Eventos);
				PDE_Alta_de_Eventos.listarTutores();
			}
		});
		btn_PDE_AltaDeEventos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_PDE_AltaDeEventosMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_PDE_AltaDeEventosMouseExited(e);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_PDE_AltaDeEventosMousePressed(e);
			}
		});
		btn_PDE_AltaDeEventos.setRequestFocusEnabled(false);
		btn_PDE_AltaDeEventos.setHorizontalAlignment(SwingConstants.LEFT);
		btn_PDE_AltaDeEventos.setForeground(Color.WHITE);
		btn_PDE_AltaDeEventos.setFont(new Font("Arial", Font.BOLD, 14));
		btn_PDE_AltaDeEventos.setBorder(null);
		btn_PDE_AltaDeEventos.setBackground(new Color(0, 142, 255));
		btn_PDE_AltaDeEventos.setBounds(10, 109, 196, 48);
		panel_menuBotones.add(btn_PDE_AltaDeEventos);
		
		btn_PDE_Mantenimiento = new JButton(" Mant. Tipo de evento");
		btn_PDE_Mantenimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cambia_Paneles Cambia_Panel = new Cambia_Paneles(panel_controlCentro, PDE_Mant_Tipo_Evento);
				try {
					PDE_Mant_Tipo_Evento.listarTipoEvento();
				} catch (ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_PDE_Mantenimiento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_PDE_MantenimientoMouseEntered(e);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btn_PDE_MantenimientoMouseExited(e);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				btn_PDE_MantenimientoMousePressed(e);
			}
		});
		btn_PDE_Mantenimiento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_PDE_Mantenimiento.setToolTipText("Mantenimiento de listas auxiliares\r\nde ESTADOS y MODALIDADES de los eventos");
		btn_PDE_Mantenimiento.setRequestFocusEnabled(false);
		btn_PDE_Mantenimiento.setHorizontalAlignment(SwingConstants.LEFT);
		btn_PDE_Mantenimiento.setForeground(Color.WHITE);
		btn_PDE_Mantenimiento.setFont(new Font("Arial", Font.BOLD, 14));
		btn_PDE_Mantenimiento.setBorder(null);
		btn_PDE_Mantenimiento.setBackground(new Color(0, 142, 255));
		btn_PDE_Mantenimiento.setBounds(10, 207, 196, 48);
		panel_menuBotones.add(btn_PDE_Mantenimiento);
		
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
		panel_controlEncabezado.setBackground(new Color(0,142,255));
		panel_Control.add(panel_controlEncabezado, BorderLayout.NORTH);
		panel_controlEncabezado.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_5 = new JLabel("  ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_controlEncabezado.add(lblNewLabel_5, BorderLayout.NORTH);
		
		lblNewLabel_6 = new JLabel("Administracion/Gestion de eventos");
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

	}
	
//	JButton btn_PDE_Principal;
//	JButton btn_PDE_ListaDeEventos;
//	JButton btn_PDE_AltaDeEventos;
//	JButton btn_PDE_Convocatoria_Eventos;
//	JButton btn_PDE_Control_de_Asistencias;
//	JButton btn_PDE_Mantenimiento;
	
	private void btn_PDE_PrincipalPressed(MouseEvent evt) {
		setColor(btn_PDE_Principal);
		resetColor(btn_PDE_AltaDeEventos);
		resetColor(btn_PDE_ListaDeEventos);
		
		resetColor(btn_PDE_Convocatoria_Eventos);
		resetColor(btn_PDE_Mantenimiento);

	}

	private void btn_PDE_AltaDeEventosMousePressed(MouseEvent evt) {
		resetColor(btn_PDE_Principal);
		setColor(btn_PDE_AltaDeEventos);
		resetColor(btn_PDE_ListaDeEventos);
		
		resetColor(btn_PDE_Convocatoria_Eventos);
		resetColor(btn_PDE_Mantenimiento);
		

	}

	private void btn_PDE_ListaDeEventosMousePressed(MouseEvent evt) {
		resetColor(btn_PDE_Principal);
		resetColor(btn_PDE_AltaDeEventos);
		setColor(btn_PDE_ListaDeEventos);
		
		resetColor(btn_PDE_Convocatoria_Eventos);
		resetColor(btn_PDE_Mantenimiento);
		

	}
	
	private void btn_PDE_Convocatoria_EventosMousePressed(MouseEvent evt) {
		resetColor(btn_PDE_Principal);
		resetColor(btn_PDE_AltaDeEventos);
		resetColor(btn_PDE_ListaDeEventos);
		
		setColor(btn_PDE_Convocatoria_Eventos);
		resetColor(btn_PDE_Mantenimiento);
		

	}
	
	private void btn_PDE_MantenimientoMousePressed(MouseEvent evt) {
		resetColor(btn_PDE_Principal);
		resetColor(btn_PDE_AltaDeEventos);
		resetColor(btn_PDE_ListaDeEventos);
		
		resetColor(btn_PDE_Convocatoria_Eventos);
		setColor(btn_PDE_Mantenimiento);
		

	}
	
	private void btn_PDE_PrincipalMouseEntered(MouseEvent evt) {
		if (btn_PDE_Principal.getBackground().getRGB() == -16740609)
			setColor(btn_PDE_Principal);
	}

	private void btn_PDE_PrincipalMouseExited(MouseEvent evt) {
		if (btn_PDE_AltaDeEventos.getBackground().getRGB() != -16740609
				|| btn_PDE_ListaDeEventos.getBackground().getRGB() != -16740609
				||btn_PDE_Convocatoria_Eventos.getBackground().getRGB() != -16740609
				||btn_PDE_Mantenimiento.getBackground().getRGB() != -16740609)
			resetColor(btn_PDE_Principal);
	}

	private void btn_PDE_AltaDeEventosMouseEntered(MouseEvent evt) {
		if (btn_PDE_AltaDeEventos.getBackground().getRGB() == -16740609)
			setColor(btn_PDE_AltaDeEventos);
	}

	private void btn_PDE_AltaDeEventosMouseExited(MouseEvent evt) {
		if (btn_PDE_Principal.getBackground().getRGB() != -16740609
				|| btn_PDE_ListaDeEventos.getBackground().getRGB() != -16740609
				||btn_PDE_Convocatoria_Eventos.getBackground().getRGB() != -16740609
				||btn_PDE_Mantenimiento.getBackground().getRGB() != -16740609)
			resetColor(btn_PDE_AltaDeEventos);
	}

	private void btn_PDE_ListaDeEventosMouseEntered(MouseEvent evt) {
		if (btn_PDE_ListaDeEventos.getBackground().getRGB() == -16740609)
			setColor(btn_PDE_ListaDeEventos);
	}

	private void btn_PDE_ListaDeEventosMouseExited(MouseEvent evt) {
		if (btn_PDE_Principal.getBackground().getRGB() != -16740609
				|| btn_PDE_AltaDeEventos.getBackground().getRGB() != -16740609
				||btn_PDE_Convocatoria_Eventos.getBackground().getRGB() != -16740609
				||btn_PDE_Mantenimiento.getBackground().getRGB() != -16740609)
			resetColor(btn_PDE_ListaDeEventos);
	}

	private void btn_PDE_Convocatoria_EventosMouseEntered(MouseEvent evt) {
		if (btn_PDE_Convocatoria_Eventos.getBackground().getRGB() == -16740609)
			setColor(btn_PDE_Convocatoria_Eventos);
	}

	private void btn_PDE_Convocatoria_EventosMouseExited(MouseEvent evt) {
		if (btn_PDE_Principal.getBackground().getRGB() != -16740609
				|| btn_PDE_AltaDeEventos.getBackground().getRGB() != -16740609
				||btn_PDE_ListaDeEventos.getBackground().getRGB() != -16740609
				||btn_PDE_Mantenimiento.getBackground().getRGB() != -16740609)
			resetColor(btn_PDE_Convocatoria_Eventos);
	}
	
	private void btn_PDE_MantenimientoMouseEntered(MouseEvent evt) {
		if (btn_PDE_Mantenimiento.getBackground().getRGB() == -16740609)
			setColor(btn_PDE_Mantenimiento);
	}

	private void btn_PDE_MantenimientoMouseExited(MouseEvent evt) {
		if (btn_PDE_Principal.getBackground().getRGB() != -16740609
				|| btn_PDE_AltaDeEventos.getBackground().getRGB() != -16740609
				||btn_PDE_ListaDeEventos.getBackground().getRGB() != -16740609
				||btn_PDE_Convocatoria_Eventos.getBackground().getRGB() != -16740609)
			resetColor(btn_PDE_Mantenimiento);
	}
	
	void setColor(JButton boton) {
		boton.setBackground(new Color(0, 174, 230));
	}

	void resetColor(JButton boton) {
		boton.setBackground(new Color(0, 142, 255));
	}
}
