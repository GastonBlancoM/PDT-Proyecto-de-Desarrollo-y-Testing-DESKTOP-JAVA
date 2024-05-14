package com.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import java.time.LocalDate;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;

import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.PdfWriter;

public class pruebasFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtFecha;
	private JTextField txtCedula;
	private JTextField txtVerficarContra;
	private static  String PASSWORD_REGEX = "^(?:(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|" +
            "(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|" +
            "(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|" +
            "(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))(?!.*(.)\\1{2,})" +
            "[A-Za-z0-9!~<>,;:_=?*+#.\"&§%°()\\|\\[\\]\\-\\$\\^\\@\\/]" +
            "{6,100}$";
	private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pruebasFrame frame = new pruebasFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public pruebasFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNombre = new JTextField();
		txtNombre.setBounds(10, 45, 96, 19);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(129, 45, 96, 19);
		contentPane.add(txtApellido);

		JLabel lblNewLabel = new JLabel("nombre");
		lblNewLabel.setBounds(10, 28, 45, 13);
		contentPane.add(lblNewLabel);

		JLabel lblApellido = new JLabel("apellido");
		lblApellido.setBounds(129, 28, 45, 13);
		contentPane.add(lblApellido);

		JButton btnNewButton = new JButton("Descargar PDF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				veremosDijoUnCiego();

			}
		});
		btnNewButton.setBounds(10, 88, 156, 21);
		contentPane.add(btnNewButton);

		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(235, 45, 96, 19);
		contentPane.add(txtFecha);

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(235, 28, 45, 13);
		contentPane.add(lblFecha);

		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(10, 213, 96, 19);
		contentPane.add(txtCedula);

		JButton btnValidarCi = new JButton("Validar C.I");
		btnValidarCi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnValidarCi.setBounds(10, 242, 87, 21);
		contentPane.add(btnValidarCi);

		txtVerficarContra = new JTextField();
		txtVerficarContra.setColumns(10);
		txtVerficarContra.setBounds(378, 45, 137, 19);
		contentPane.add(txtVerficarContra);

		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(378, 28, 79, 13);
		contentPane.add(lblContrasea);

		JButton btnVerifciarContrasea = new JButton("Verifciar contraseña");
		btnVerifciarContrasea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verificarContra();
			}
		});
		btnVerifciarContrasea.setBounds(378, 88, 137, 21);
		contentPane.add(btnVerifciarContrasea);
	}

	public String getFecha() {

		LocalDate fecha = LocalDate.now();
		int dia = fecha.getDayOfMonth();
		int mes = fecha.getMonthValue();
		int anio = fecha.getYear();

		String fechaCompusta = dia + "/" + mes + "/" + anio;

		return fechaCompusta;

	}

	void veremosDijoUnCiego() {

		JFileChooser sArchivo = new JFileChooser();
		sArchivo.setSelectedFile(new File("reporteautogenerado" + ".pdf"));
		int opcion = sArchivo.showSaveDialog(null);
		if (opcion == sArchivo.APPROVE_OPTION) {
			try {
				OutputStream textoSalida = new FileOutputStream(sArchivo.getSelectedFile());
				Document documento = new Document();
				PdfWriter.getInstance(documento, textoSalida);
				Paragraph titulo = new Paragraph("Mi Reporte");

				documento.open();
				titulo.setAlignment(1);
//
//			Image image = null;
//			String a = "‪UTEC-LOGO.png";
//			try {
//				image = Image.getInstance(a);
//				image.scaleAbsolute(150,100);
//				image.setAbsolutePosition(415, 750);
//				
//			}
//				
//			catch (Exception e) {
//				e.printStackTrace();
//			}
//			documento.add(image);

				documento.add(titulo);

				documento.add(new Paragraph("Nombre: " + txtNombre.getText()));

				documento.add(new Paragraph("Apellidos: " + txtApellido.getText()));

				documento.add(Chunk.NEWLINE);

				Paragraph texto = new Paragraph(
						"PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC,PruebaABC");
				texto.setAlignment(Element.ALIGN_JUSTIFIED);

				documento.add(texto);

				documento.add(Chunk.NEWLINE);

				documento.add(new Paragraph("Fecha: " + getFecha()));

				documento.close();

				JOptionPane.showMessageDialog(null, "El PDF se ha guardado Correctamente", "PDF",
						JOptionPane.INFORMATION_MESSAGE);

			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Eror gil", "Advertencia", JOptionPane.WARNING_MESSAGE);
			} catch (DocumentException e) {
				JOptionPane.showMessageDialog(null, "Eror gil dek do", "Advertencia", JOptionPane.WARNING_MESSAGE);

			}
		}

	}

	void verificarContra() {
		
		 String password = txtVerficarContra.getText();
		 
		 if (PASSWORD_PATTERN.matcher((CharSequence) password).matches()) {
	            System.out.print("The Password " + password+ " is valid");
	        }
	        else {
	            System.out.print("The Password " + password + " isn't valid");
	        }
	    }
	
	}

