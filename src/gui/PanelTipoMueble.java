package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import model.controllers.TipoMuebleControlador;
import model.entities.Tipomueble;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelTipoMueble extends JPanel {
	
	Tipomueble actual = new Tipomueble();  
	
	private JTextField jtfId;
	private JTextField jtfDescripcion;
	JButton btnPrimero;
	JButton btnUltimo;
	JButton btnSiguiente;
	JButton btnAnterior;
	private JButton btnGuardar;
	private JButton btnNuevo;
	

	/**
	 * Create the panel.
	 */
	public PanelTipoMueble() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descripción:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 1;
		add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnPrimero = new JButton("Primero");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = TipoMuebleControlador.getInstancia().findPrimero();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnPrimero);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = TipoMuebleControlador.getInstancia().findAnterior(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = TipoMuebleControlador.getInstancia().findSiguiente(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnSiguiente);
		
		btnUltimo = new JButton("Último");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = TipoMuebleControlador.getInstancia().findUltimo();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnUltimo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		panel.add(btnNuevo);

		
		// Cargo el primer registro
		actual = TipoMuebleControlador.getInstancia().findPrimero();
		cargarActualEnPantalla();

	}

	
	/**
	 * 
	 */
	private void cargarActualEnPantalla () {
		this.jtfId.setText("" + this.actual.getId());
		this.jtfDescripcion.setText(this.actual.getDescripcion());
		
		// Ahora determino el botón "Anterior" habilitados o deshabilitados
		if (TipoMuebleControlador.getInstancia().findAnterior(this.actual.getId()) == null) {
			this.btnAnterior.setEnabled(false);
			this.btnPrimero.setEnabled(false);
		}
		else {
			this.btnAnterior.setEnabled(true);
			this.btnPrimero.setEnabled(true);
		}
		
		// Ahora determino el botón "Siguiente" habilitados o deshabilitados
		if (TipoMuebleControlador.getInstancia().findSiguiente(this.actual.getId()) == null) {
			this.btnSiguiente.setEnabled(false);
			this.btnUltimo.setEnabled(false);
		}
		else {
			this.btnSiguiente.setEnabled(true);
			this.btnUltimo.setEnabled(true);
		}
		

	}
	
	
	
	private void actualizarActualDesdePantalla() {
		this.actual.setDescripcion(this.jtfDescripcion.getText());
	}
	
	
	/**
	 * 
	 */
	private void guardar() {
		actualizarActualDesdePantalla();
		boolean resultado = TipoMuebleControlador.getInstancia().guardar(this.actual);
		if (resultado == true) {
			JOptionPane.showMessageDialog(null, "Guardado correctamente");
		}
		else {
			JOptionPane.showMessageDialog(null, "Imposible guardar. Error");
		}
		cargarActualEnPantalla();
	}
	
	/**
	 * 
	 */
	private void nuevo() {
		this.actual = new Tipomueble();
		this.jtfId.setText("" + 0);
		this.jtfDescripcion.setText("");
	}
}
