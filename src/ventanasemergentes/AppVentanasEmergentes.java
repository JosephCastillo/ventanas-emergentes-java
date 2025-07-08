package ventanasemergentes;

import java.awt.*;

import javax.swing.*;

public class AppVentanasEmergentes {
	public static void main(String[] Args) {
		
		MarcoPrincipal miMarcoPrincipal = new MarcoPrincipal();
		miMarcoPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarcoPrincipal.setVisible(true);
		
		
	}

}

class MarcoPrincipal extends JFrame{
	
	MarcoPrincipal(){
		setTitle("Ventanas emergentes");
		setBounds(200,200,600,400);
		LaminaVentanasEmergentes miLaminaVentanasEmergentes = new LaminaVentanasEmergentes();
		add(miLaminaVentanasEmergentes);
	}
	
}

class LaminaVentanasEmergentes extends JPanel {
	
	LaminaVentanasEmergentes(){
		
		setLayout(new BorderLayout());
		
		JPanel panelVentanasEmergentes = new JPanel(new GridLayout(2,3));
		
		String[] opcionesTipo = {"Mensaje", "Confirmar","Opciones", "Entrada"};
		String[] opcionesTipoMensaje = {"ERROR_MESSAGE","INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE"};
		String[] opcionesMensaje = {"Cadena", "Icono", "Componente", "Otros", "Object"};
		String[] opcionesConfirmar = {"DEFAULT_OPTION","YES_NO_OPTION","YES_NO_CANCEL_OPTION","OK_CANCEL_OPTION"};
		String[] opcionesOpcion = {"String[]", "Icon[]","Object[]"};
		String[] opcionesEntrada = {"Campo de texto", "Combo"};
		
		panelVentanasEmergentes.add(crearPanelOpciones("Tipo", opcionesTipo));
		panelVentanasEmergentes.add(crearPanelOpciones("Tipo Mensaje", opcionesTipoMensaje));
		panelVentanasEmergentes.add(crearPanelOpciones("Mensaje", opcionesMensaje));
		panelVentanasEmergentes.add(crearPanelOpciones("Confirmar", opcionesConfirmar));
		panelVentanasEmergentes.add(crearPanelOpciones("Opción", opcionesOpcion));
		panelVentanasEmergentes.add(crearPanelOpciones("Entrada", opcionesEntrada));
		
		
		
		add(panelVentanasEmergentes, BorderLayout.CENTER);
		
		JButton botonMostrar = new JButton("Mostrar");
		JPanel panelBoton = new JPanel(new FlowLayout());
		panelBoton.add(botonMostrar);
		add(panelBoton, BorderLayout.SOUTH);
	}
	
	private JPanel crearPanelOpciones(String titulo, String[] textoBotones ) {
		
		JPanel panelOpciones = new JPanel();
		panelOpciones.setLayout(new BoxLayout(panelOpciones, BoxLayout.Y_AXIS));
		panelOpciones.setBorder(BorderFactory.createTitledBorder(titulo));
		
		
		ButtonGroup grupoOpciones = new ButtonGroup();
		for(String texto : textoBotones) {
			JRadioButton boton = new JRadioButton(texto);
			grupoOpciones.add(boton);
			panelOpciones.add(boton);
		}
		
		return panelOpciones;
	}
	
}
