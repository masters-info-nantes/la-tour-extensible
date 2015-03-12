package application;

import interfaces.AbstractAction;
import interfaces.AbstractCharacter;
import interfaces.AbstractMonster;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


public class Salle extends JFrame implements ActionListener {

	private ImageIcon image;
	private Image image2;
	private JLabel lab;
	private JComboBox<String> actionList;
	private JButton actionButton;
	
	private ArrayList<AbstractAction> mesActions;
	private AbstractCharacter character;
	private AbstractMonster monster;
	private JFrame creationPersonnage;
	
	public Salle(JFrame parent, AbstractCharacter character, String pluginMonsterChoix, String pluginActionChoix){
		
		creationPersonnage = parent;
		this.character = character;
		//TODO: demander a la plateforme un monstre
		//TODO: demander a la plateforme les actions
		
		this.setTitle("Salle #");
	    this.setSize(700, 650);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
	    this.setLayout(null);
	    

		/*
		* Image de fond
		*/
		image = new ImageIcon("/comptes/E120404Z/workspace/testLogExten/rendu_decorjeu1.jpg");
		Image image2 = image.getImage().getScaledInstance(image.getIconWidth(), image.getIconHeight(), Image.SCALE_DEFAULT);
		image.setImage(image2);
		lab = new JLabel();
		lab.setIcon(image);
		this.add(lab);
		lab.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
	    
		actionList = new JComboBox<String>();
		actionList.setBounds(30, 530, 200, 30);
		
		for(AbstractAction action: mesActions){
			actionList.addItem(action.getName());
		}
		
		actionButton = new JButton("Exec");
		actionButton.setBounds(450, 530, 200, 30);
		actionButton.addActionListener(this);		

		
		this.add(actionList);
		this.add(actionButton);
	    this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		AbstractAction action = mesActions.get(actionList.getSelectedIndex());
		action.doAction(this.character, this.monster);
		
		if(this.monster.getLife()<0){
			changerSalle();
		}
		if(this.character.getLife()<0){
			partieFinie();			
		}
	}
	
	public void changerSalle(){
		//TODO: demander a la plateforme un monstre
	}
	
	public void partieFinie(){
		this.creationPersonnage.setVisible(true);
		this.dispose();
	}

}