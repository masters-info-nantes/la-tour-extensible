package application;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.*;

import latourextensible.platform.*;

public class ChoixPlugin extends JFrame implements ActionListener{
	
		private JLabel titleLabel;
		private JLabel raceLabel;
		private JLabel jobLabel;
		private JLabel personLabel;
		private JLabel actionLabel;
		private JLabel monsterLabel;
		
		private JComboBox<String> raceList;
		private JComboBox<String> jobList;
		private JComboBox<String> personList;
		private JComboBox<String> actionList;
		private JComboBox<String> monsterList;
		
		private JButton raceRandom;
		private JButton jobRandom;
		private JButton personRandom;
		private JButton actionRandom;
		private JButton monsterRandom;
		private JButton valideButton;
		
		
		
		
		  public ChoixPlugin(){
			  
			
			    this.setTitle("Choix des plugins");
			    this.setSize(700, 550);
			    this.setLocationRelativeTo(null);
			    this.setResizable(false);
			    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
	  
			   // this.setLayout(new GridLayout(11,2));
			    this.setLayout(null);
			    
			    titleLabel = new JLabel("Choisissez les plugins à charger :");
			    
			    raceLabel = new JLabel("Plugins de races : ");
			    raceList = new JComboBox<String>();
			    
			    jobLabel = new JLabel("Plugins de jobs : ");
			    jobList = new JComboBox<String>();
			    
			    personLabel = new JLabel("Plugins de personnages : ");
			    personList = new JComboBox<String>();
			    
			    actionLabel = new JLabel("Plugins d'actions : ");
			    actionList = new JComboBox<String>();
			    
			    monsterLabel = new JLabel("Plugins de monstres : ");
			    monsterList = new JComboBox<String>();
			    
			    raceRandom = new JButton("Random");
			    jobRandom = new JButton("Random");
			    personRandom = new JButton("Random");
			    actionRandom = new JButton("Random");
			    monsterRandom = new JButton("Random");
			    
			    valideButton = new JButton("OK");
			    valideButton.setVisible(true);
				
				ActionListener mlis = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO: demander à la plateforme de charger un core si different de celui courant
						JFrame frame = new CreationPersonnage(raceList.getSelectedItem().toString(), jobList.getSelectedItem().toString(), personList.getSelectedItem().toString(), monsterList.getSelectedItem().toString(), actionList.getSelectedItem().toString());
						setVisible(false);
					}
				};
				valideButton.addActionListener(mlis);
			    
			    raceRandom.addActionListener(this);
			    jobRandom.addActionListener(this);
			    personRandom.addActionListener(this);
			    actionRandom.addActionListener(this);
			    monsterRandom.addActionListener(this);
			    valideButton.addActionListener(this);
			    
			    
			    ////////////////////// Labels /////////////////////////
			    
			    
			    /* Label title */
			    Font f = new Font("vinDiesel" , 2 , 20);
			    titleLabel.setFont(f);
			    titleLabel.setBounds(180, 10, 400, 25);
			    
			    /* Label race */
			    Font f2 = new Font("jasonStatham",2 , 15);
			    raceLabel.setFont(f2);
			    raceLabel.setBounds(70, 50, 200, 20);
			    
			    /*Label job */
			    jobLabel.setFont(f2);
			    jobLabel.setBounds(70, 125, 200, 20);
			    
			    /* Label Personnages */
			    personLabel.setFont(f2);
			    personLabel.setBounds(70, 200, 200, 20);
			    
			    /* Label Action */
			    actionLabel.setFont(f2);
			    actionLabel.setBounds(70, 275, 200, 20);
			    
			    /* Label Monstre */
			    monsterLabel.setFont(f2);
			    monsterLabel.setBounds(70, 350, 200, 20);
			    
			    
			    ////////////////////// Listes /////////////////////////	
			    
			    /* liste race */
			    raceList.setBounds(100, 80, 200, 30);
			    
			    /*liste job */
			    jobList.setBounds(100, 155, 200, 30);
			    
			    /* liste Personnages */
			    personList.setBounds(100, 230, 200, 30);
			    
			    /* liste Action */
			    actionList.setBounds(100, 305, 200, 30);
			    
			    /* liste Monstre */
			    monsterList.setBounds(100, 380, 200, 30);
			    
			    
			    
			    
			    //////////////////////Boutons /////////////////////////	
			    
			    /* bouton race */
			    raceRandom.setBounds(400, 80, 200, 30);
			    
			    /*bouton job */
			    jobRandom.setBounds(400, 155, 200, 30);
			    
			    /* bouton Personnages */
			    personRandom.setBounds(400, 230, 200, 30);
			    
			    /* bouton Action */
			    actionRandom.setBounds(400, 305, 200, 30);
			    
			    /* bouton Monstre */
			    monsterRandom.setBounds(400, 380, 200, 30);
			    
			    /* bouton OK */
			    valideButton.setBounds(500, 450, 100, 30);
			    
			    
			    this.getContentPane().add(titleLabel);
			    this.getContentPane().add(raceLabel);
			    this.getContentPane().add(raceRandom);
			    this.getContentPane().add(raceList);
			    this.getContentPane().add(jobLabel);
			    this.getContentPane().add(jobRandom);
			    this.getContentPane().add(jobList);
			    this.getContentPane().add(personLabel);
			    this.getContentPane().add(personRandom);
			    this.getContentPane().add(personList);
			    this.getContentPane().add(actionLabel);
			    this.getContentPane().add(actionRandom);
			    this.getContentPane().add(actionList);
			    this.getContentPane().add(monsterLabel);
			    this.getContentPane().add(monsterRandom);
			    this.getContentPane().add(monsterList);
			    this.getContentPane().add(valideButton);
			    this.setVisible(true);
		  }
		  public void actionPerformed(ActionEvent e) {
				Object source = e.getSource();
		 
				if(source == raceRandom){
					raceList.setSelectedIndex(randList(raceList));
				} else if(source == jobRandom){
					jobList.setSelectedIndex(randList(jobList));
				} else if(source == personRandom){
					personList.setSelectedIndex(randList(personList));
				} else if(source == actionRandom){
					actionList.setSelectedIndex(randList(actionList));
				} else if(source == monsterRandom){
					monsterList.setSelectedIndex(randList(monsterList));
				} else if(source == valideButton){
					
				}
				
			}
		  
		  public int randList(JComboBox<String> list){
			  Random rn = new Random();
			  int nbItem = list.getItemCount();
			  return rn.nextInt(nbItem);
			  
		  }

}