package ventanasemergentes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;
import java.util.jar.JarInputStream;

import javax.swing.*;

public class AppVentanasEmergentes {
	public static void main(String[] Args) {

		MarcoPrincipal miMarcoPrincipal = new MarcoPrincipal();
		miMarcoPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarcoPrincipal.setVisible(true);

	}

}

class MarcoPrincipal extends JFrame {

	MarcoPrincipal() {
		setTitle("Ventanas emergentes");
		setBounds(200, 200, 600, 400);
		LaminaVentanasEmergentes miLaminaVentanasEmergentes = new LaminaVentanasEmergentes();
		add(miLaminaVentanasEmergentes);
	}

}

class LaminaVentanasEmergentes extends JPanel {

	ButtonGroup grupoOpciones;
	ButtonGroup grupoTipo;
	ButtonGroup grupoMensaje;
	ButtonGroup grupoTipoMensaje;
	ButtonGroup grupoConfirmar;
	ButtonGroup grupoOpcion;
	ButtonGroup grupoEntrada;

	private String cadenaMensaje = "Mensaje";
	private Icon iconoMensaje = new ImageIcon("src/ventanasemergentes/heart.png");
	private Object objetoMensaje = new Date();
	private Component componenteMensaje = new LaminaEjemplo();

	LaminaVentanasEmergentes() {

		setLayout(new BorderLayout());

		JPanel panelVentanasEmergentes = new JPanel(new GridLayout(2, 3));

		String[] opcionesTipo = { "Mensaje", "Confirmar", "Opciones", "Entrada" };
		String[] opcionesTipoMensaje = { "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE",
				"PLAIN_MESSAGE" };
		String[] opcionesMensaje = { "Cadena", "Icono", "Componente", "Otros", "Object" };
		String[] opcionesConfirmar = { "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION" };
		String[] opcionesOpcion = { "String[]", "Icon[]", "Object[]" };
		String[] opcionesEntrada = { "Campo de texto", "Combo" };

		panelVentanasEmergentes.add(crearPanelOpciones("Tipo", opcionesTipo));
		panelVentanasEmergentes.add(crearPanelOpciones("Tipo Mensaje", opcionesTipoMensaje));
		panelVentanasEmergentes.add(crearPanelOpciones("Mensaje", opcionesMensaje));
		panelVentanasEmergentes.add(crearPanelOpciones("Confirmar", opcionesConfirmar));
		panelVentanasEmergentes.add(crearPanelOpciones("Opción", opcionesOpcion));
		panelVentanasEmergentes.add(crearPanelOpciones("Entrada", opcionesEntrada));

		add(panelVentanasEmergentes, BorderLayout.CENTER);

		JButton botonMostrar = new JButton("Mostrar");

		botonMostrar.addActionListener(new AccionMostrar());

		JPanel panelBoton = new JPanel(new FlowLayout());
		panelBoton.add(botonMostrar);
		add(panelBoton, BorderLayout.SOUTH);
	}
	
	

	public Object dameMensaje() {

		String s = grupoMensaje.getSelection().getActionCommand();
		if (s.endsWith("Cadena")) {
			return cadenaMensaje;
		} else if (s.equals("Icono")) {
			return iconoMensaje;
		} else if (s.equals("Componente")) {
			return componenteMensaje;
		} else if (s.equals("Otros")) {
			return objetoMensaje;
		} else if (s.equals("Object")) {
			return new Object[] { cadenaMensaje, iconoMensaje, componenteMensaje, objetoMensaje };
		}
		return "Error";
	}

	public int dameConfirmar() {

		String s = grupoConfirmar.getSelection().getActionCommand();
		if (s.equals("DEFAULT_OPTION")) {
			return -1;
		} else if (s.equals("YES_NO_OPTION")) {
			return 0;
		} else if (s.equals("YES_NO_CANCEL_OPTION")) {
			return 1;
		} else if (s.equals("OK_CANCEL_OPTION")) {
			return 2;
		}
		return -1;
	}

	public int dameTipoMensaje() {

		String s = grupoTipoMensaje.getSelection().getActionCommand();
		if (s.equals("ERROR_MESSAGE")) {
			return 0;
		} else if (s.equals("INFORMATION_MESSAGE")) {
			return 1;
		} else if (s.equals("WARNING_MESSAGE")) {
			return 2;
		} else if (s.equals("QUESTION_MESSAGE")) {
			return 3;
		} else if (s.equals("PLAIN_MESSAGE")) {
			return -1;
		}
		return 0;
	}

	public Object[] dameOpcion() {

		String s = grupoOpcion.getSelection().getActionCommand();

		if (s.equals("String[]")) {
			return new String[] { "Amarillo", "Azul", "Rojo" };
		} else if (s.equals("Icon[]")) {
			return new Object[] { new ImageIcon("src/ventanasemergentes/yellow.png"),
					new ImageIcon("src/ventanasemergentes/red.png"), new ImageIcon("src/ventanasemergentes/blue.png") };
		} else if (s.equals("Object[]")) {

			return new Object[] { cadenaMensaje, 
					iconoMensaje, 
					componenteMensaje, 
					objetoMensaje };

		}
		return null;

	}

	public String dameSeleccion() {

		ButtonModel miBoton = grupoOpciones.getSelection();
		String s = miBoton.getActionCommand();

		return s;
	}

	private JPanel crearPanelOpciones(String titulo, String[] textoBotones) {

		JPanel panelOpciones = new JPanel();
		panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.Y_AXIS));
		panelOpciones.setBorder(BorderFactory.createTitledBorder(titulo));

		grupoOpciones = new ButtonGroup();

		for (String texto : textoBotones) {
			JRadioButton boton = new JRadioButton(texto);

			boton.setActionCommand(texto);

			grupoOpciones.add(boton);
			panelOpciones.add(boton);
			boton.setSelected(true);

		}

		if (titulo.equals("Tipo")) {
			grupoTipo = grupoOpciones;
		}
		if (titulo.equals("Mensaje")) {
			grupoMensaje = grupoOpciones;
		}
		if (titulo.equals("Tipo Mensaje")) {
			grupoTipoMensaje = grupoOpciones;
		}
		if (titulo.equals("Confirmar")) {
			grupoConfirmar = grupoOpciones;
		}
		if (titulo.equals("Opción")) {
			grupoOpcion = grupoOpciones;
		}
		if (titulo.equals("Entrada")) {
			grupoEntrada = grupoOpciones;
		}
		return panelOpciones;

	}

	private class AccionMostrar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// System.out.println(grupoTipo.getSelection().getActionCommand());
			String tipoSeleccion = grupoTipo.getSelection().getActionCommand();

			if (tipoSeleccion.equals("Mensaje")) {
				JOptionPane.showMessageDialog(null, dameMensaje(), "Titulo", dameTipoMensaje());
			} else if (tipoSeleccion.equals("Confirmar")) {
				JOptionPane.showConfirmDialog(null, dameMensaje(), "Titulo", dameConfirmar(), dameTipoMensaje());
			} else if (tipoSeleccion.equals("Opciones")) {
				JOptionPane.showOptionDialog(null, dameMensaje(), "Titulo", 1, dameTipoMensaje(), null, dameOpcion(),
						null);
			} else if (tipoSeleccion.equals("Entrada")) {
				if(grupoEntrada.getSelection().getActionCommand().equals("Campo de texto")) {
					
					JOptionPane.showInputDialog(null, dameMensaje(), "Titulo", dameTipoMensaje());
				}else if(grupoEntrada.getSelection().getActionCommand().equals("Combo")) {
					JOptionPane.showInputDialog(
						    null,                      // Componente padre
						    dameMensaje(),          // Mensaje
						    "Titulo",                  // Título
						    dameTipoMensaje(),         // Tipo de mensaje (int)
						    null,                      // Icono personalizado (puede ser null)
						    new String[]{"Amarillo", "Azul", "Rojo"}, // Opciones
						    "Azul"                     // Selección inicial
						);

				}
			}

		}

	}

}

class LaminaEjemplo extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D rectangulo = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
		g2.setPaint(Color.YELLOW);
		g2.fill(rectangulo);

	}
}
