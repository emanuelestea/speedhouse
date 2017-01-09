package it.speedhouse.main.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JLabel;

public class Index extends Finestra implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BarraMenu barraMenu;
	private JLabel databaseNonSelezionato;
	
	private boolean databaseSelezionato; //l'utente deve selezionare un db. all'inizio questa variabile � false.
	
	public Index()
	{
		super();
		
		barraMenu = new BarraMenu(this);
		this.setJMenuBar(barraMenu);
		
		databaseNonSelezionato = new JLabel("Non hai ancora selezionato un database...");
		this.add(databaseNonSelezionato, BorderLayout.CENTER);
		
		databaseSelezionato = false;
		try {
			barraMenu.getMenuFunzioni().forzaSelezioneDB();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //finch� non seleziona un db le altre funzioni sono disabilitate
		
		this.setVisible(true);
	}

	/**
	 * action listener delle funzioni della barra dei men�
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		switch (e.getActionCommand()) {
		case "importaCsv":
			dispose();
			break;
		case "creaDatabase":
			dispose();
			break;
		case "selezionaDatabase":
			dispose();
			break;
		case "produciGrafici":
			dispose();
			break;
		default:
			break;
		}
	}
}
