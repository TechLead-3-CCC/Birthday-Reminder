package principal.vue;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JTextFieldDateEditor;

public class Fenetre extends JFrame{
	
	
	
	private JPanel panel = new JPanel();
	String date ="";
    private JCalendar dateChooser = new JCalendar();
    private String [] title = {"Name "," Birth Date"};
    private JTable table;
    private JScrollPane Scroll;
    private  JScrollPane Scroll1;
    private JTextField jtf = new JTextField();
	private JTextFieldDateEditor dateEditor =new  JTextFieldDateEditor();
	

	public JTextField getJtf() {
		return jtf;
	}
	public void setJtf(JTextField jtf) {
		this.jtf = jtf;
	}
	public JTextFieldDateEditor getDateEditor() {
		return dateEditor;
	}
	public void setDateEditor(JTextFieldDateEditor dateEditor) {
		this.dateEditor = dateEditor;
	}

	DefaultListModel model = new DefaultListModel();

	 public void setModel(DefaultListModel model) {
		this.model = model;
	}
	public DefaultListModel getModel() {
			return model;
		}
		
	DefaultListModel model1 = new DefaultListModel();

	 public void setModel1(DefaultListModel model) {
		this.model1 = model;
	}
	public DefaultListModel getModel1() {
			return model1;
		}
		
    JList listNom = new JList(model);
    JList listNais = new JList(model1);
    JButton bouton3, bouton1, bouton2, bouton4, bouton5, bouton6,bouton7;
    
      public JButton getBouton7() {
		return bouton7;
	}
	public void setBouton7(JButton bouton7) {
		this.bouton7 = bouton7;
	}
	public JButton getBouton6() {
		return bouton6;
	}
	public JButton getBouton1() {
		return bouton1;
	}
	public JButton getBouton2() {
		return bouton2;
	}
	public JButton getBouton4() {
		return bouton4;
	}
	public JButton getBouton5() {
		return bouton5;
	}
	public JButton getBouton3() {
		return bouton3;
	}
	public Fenetre(){
    	
         super("BIRTHDAY REMINDER APP");
         this.initFrame();
         this.ajoutImage();
         this.ajoutLabel();
         this.ajoutChampText();
         this.ajoutBouton();
         
      
         this.positionComposant();
         
 		listNom.setValueIsAdjusting(true);
 		listNom.setBorder(null);
 		listNom.setVisibleRowCount(10);
 		
 		
 		listNais.setValueIsAdjusting(true);
 		listNais.setBorder(null);
 		listNais.setVisibleRowCount(10);
        
	}
	
	private  void initFrame() {
		
		
		setLocation(300,30);
		setSize(900,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		panel.setBackground(Color.getHSBColor(45, 174, 204));
		
		
		Scroll= new JScrollPane(listNom);
		Scroll1= new JScrollPane(listNais);
 
		
		panel.add(Scroll1);
		Scroll1.setBounds(120, 615, 200, 30);
		
		panel.add(Scroll);
		Scroll.setBounds(520, 200, 300, 300);
		
		getContentPane().add(dateChooser);
		setContentPane(panel);
		
		
		
	}

	public void positionComposant(){
		 panel.setLayout(null);
		
	}
	
	
	public void ajoutBouton() {
		
		bouton1 = new JButton("Clear");
		bouton1.setBackground(Color.LIGHT_GRAY);
	    bouton1.setBounds(170, 435, 70, 20);
	   
		panel.add(bouton1);
		
		bouton2 = new JButton("Delete");
		bouton2.setBackground(Color.LIGHT_GRAY);
		bouton2.setBounds(90, 460, 70, 20);
		panel.add(bouton2);
		
		bouton3 = new JButton("Add");
		bouton3.setBackground(Color.LIGHT_GRAY);
		bouton3.setBounds(250, 460, 70, 20);
		panel.add(bouton3);
		
		
		bouton5 = new JButton("Refresh");
		bouton5.setBackground(Color.LIGHT_GRAY);
		bouton5.setBounds(700, 610, 80, 30);
		
		panel.add(bouton5);
		
		bouton7 = new JButton("show");
		bouton7.setBackground(Color.LIGHT_GRAY);
		bouton7.setBounds(330, 615, 80, 30);
		
		panel.add(bouton7);
	} 
	
	public void ajoutImage() {
		
		String imageUrl = "images (1).jpeg";
		ImageIcon icone = new ImageIcon(imageUrl);
		JLabel label4 = new JLabel("        Birthday Reminder",icone,JLabel.NORTH_EAST);
		label4.setBounds(10,-105,560,450);
		panel.add(label4);
		 Font police = new Font("Arial", Font.BOLD, 30);
		 label4.setForeground(Color.orange);
		 label4.setFont(police);
	}
	public void ajoutLabel() {
		
		JLabel label1 = new JLabel("Name :");
		label1.setBounds(110, 300, 60, 30);
		panel.add(label1);
		JLabel label2 = new JLabel("Birth Date :");
		label2.setBounds(110, 340, 70, 30);
		panel.add(label2);
		JLabel label3 = new JLabel("Today is birthday of :");
		label3.setBounds(120, 590, 120, 30);
		panel.add(label3);
		
	}
	public void ajoutChampText() {
		
	
	jtf.setPreferredSize(new Dimension(200,30));
	jtf.setBounds(180, 300, 200, 30);
	panel.add(jtf);
	
		dateEditor.setBounds(180, 340, 200, 30);
		panel.add(dateEditor);
		
		  bouton6 = new JButton("PUSH");
		  bouton6.setBounds(380, 340, 70, 30);
		  panel.add(bouton6);
         
		 

	}
	
	
}
