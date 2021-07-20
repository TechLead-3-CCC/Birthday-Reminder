package principal.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import principal.model.*;
import principal.vue.*;

public class Control {
	Traitement traitement;
	Fenetre view= new Fenetre();
	
	
	
	public Control (Traitement traitement, Fenetre view) {
		super();
		this.traitement=traitement;
		this.view=view;
	}
	
	public void init() {
		view.setVisible(true);
		traitement.ConnectionToDB();
		traitement.ShowElements ( view.getModel());
		
		view.getBouton3().addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {		
				traitement.insertDonnees(view.getJtf(),view.getDateEditor());
				view.getJtf().setText(" ");
				view.getDateEditor().setText(" ");
			}
		});
		
		 view.getBouton1().addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e) {
					view.getJtf().setText(" ");
					view.getDateEditor().setText(" ");
				}
			});
		 
		 view.getBouton5().addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e) {
					traitement.Clearmodel(view.getModel());
					traitement.ShowElements ( view.getModel());
					
				}
			});
		 
		 view.getBouton2().addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e) {
					 
					    JFrame f=new JFrame();   
					    String name=JOptionPane.showInputDialog(f,"Enter the correspondant ID");
				
					traitement.DeleteElements(name);
					
				}
			});
		 view.getBouton6().addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e) {
					traitement.AddElements(view.getDateEditor());
					
				}
			});
		 
		 view.getBouton7().addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e) {
					traitement.Clearmodel(view.getModel1());
					 traitement.ajoutDate(view.getModel1());
					
				}
			});
		 
	}
}
