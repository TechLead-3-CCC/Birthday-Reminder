package principal.model;

import  principal.vue.*;

import java .sql.*;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.event.ListDataListener;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JTextFieldDateEditor;

import principal.vue.*;

public class Traitement  {
	
private static Connection conn = null;
	
	
	public void ConnectionToDB() {
		 String BDD = "birthday_reminder";
         String url = "jdbc:mysql://localhost:3306/" + BDD;
         String user = "root";
         String passwd = "";
         
         try {
             Class.forName("com.mysql.jdbc.Driver");
             conn = (Connection) DriverManager.getConnection(url,user,passwd);
             System.out.println("Connecter");
         } catch (Exception e){
             e.printStackTrace();
             System.out.println("Erreur");
             System.exit(0);
         }
         
	}
	
	//Affichage des noms
		 
	public void ShowElements (DefaultListModel model ) {
		try {
 			String req = "select *from personne order by name";
 	 		Statement statement;
 			statement = conn.createStatement();
 			ResultSet resultat = statement.executeQuery(req);
 			while(resultat.next()) {
 				String id= resultat.getString("idPersonne");
 				String nom = resultat.getString("name");
 				String date_nais = resultat.getString("birth_date");
 				model.addElement("ID:"+id+"  "+nom+"  "+date_nais);
 				
 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		
	}
	
	public void AddElements(JTextFieldDateEditor dateEditor) {
		
             JCalendar c = new JCalendar(); 

             dateEditor.setText("");
             JDialog d = new JDialog(); 

             d.setTitle(" Calendrier");
             d.setModalityType(ModalityType.APPLICATION_MODAL);
             d.add(c);
             d.pack();
             d.setLocationRelativeTo(null);; 

             d.setVisible(true);
             java.util.Date date = c.getCalendar().getTime(); 

             System.out.println(date.toString());
            
             Locale locale = Locale.getDefault();
             DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
             dateEditor.setText(new SimpleDateFormat("MM/dd/yyyy", Locale.US).format(date));


         
	}
	
	public void DeleteElements(String i) {
		try {
			String req = "delete from personne where idPersonne="+i;
			PreparedStatement prepareStatement = conn.prepareStatement(req);
			
			int count = prepareStatement.executeUpdate();
			if(count > 0) {
				System.out.println("Les donnees sont enregistrees avec succes");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void ajoutMusique() {
		

	}
	
	

	
	public void Clearmodel(DefaultListModel model) {
		model.clear();
		
	}
	
	 
	public void insertDonnees(JTextField jtf,JTextFieldDateEditor dateEditor) {
			String name = jtf.getText();
			String dateeditor = dateEditor.getText();
			
			try {
				String req = "insert into personne(name,birth_date) values(?,?)";
				PreparedStatement prepareStatement = conn.prepareStatement(req);
				prepareStatement.setString(1, name);
				prepareStatement.setString(2, dateeditor);
				
				int count = prepareStatement.executeUpdate();
				if(count > 0) {
					System.out.println("Les donnees sont enregistrees avec succes");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	public void ShowElements1 (DefaultListModel model1 , String nom) {
		
 	
 				model1.addElement("  "+nom+"  ");
 		
 		
	}
	
	public void ajoutDate(DefaultListModel model1) {
		String str= "";
		Date now = new Date();
		
		Locale locale = Locale.getDefault();
		DateFormat shortDateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
		str= new SimpleDateFormat("MM/dd/yyyy", Locale.US).format(now);
		
		
		try {
 			String req = "select *from personne";
 	 		Statement statement;
 			statement = conn.createStatement();
 			ResultSet resultat = statement.executeQuery(req);
 			
 			while(resultat.next()) {
 				
 				String nom = resultat.getString("name");
 				String date_nais = resultat.getString("birth_date");
 				String data1=str.substring(0, 5);
 				String data2=date_nais.substring(0, 5);
 				
 				if(data1.compareTo(data2) ==0) {
 					
 					model1.addElement(nom);
 				}
 				
 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		
	}

}
