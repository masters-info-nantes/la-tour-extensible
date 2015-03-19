package application;

import interfaces.AbstractAction;
import interfaces.AbstractCharacter;
import interfaces.AbstractMonster;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import latourextensible.platform.PluginAlreadyInstantiateException;
import latourextensible.platform.PluginManager;
import latourextensible.platform.PluginProperty;
import latourextensible.platform.event.Event;
import latourextensible.platform.event.EventManager;
import latourextensible.platform.event.IEventListener;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


public class Salle extends JFrame implements ActionListener , IEventListener{

	private ImageIcon image;
	private Image image2;
	private JLabel lab;
	private JComboBox<String> actionList;
	private JButton actionButton;
	
	private ArrayList<AbstractAction> mesActions;
	private AbstractCharacter character;
	private AbstractMonster monster;
	private JFrame creationPersonnage;
	
	PluginProperty pluginAction;
	PluginProperty pluginMonstre;
	
	PluginManager pluginMgr;

	public Salle(JFrame parent, AbstractCharacter character, PluginProperty pluginMonsterChoix, PluginProperty pluginActionChoix){
		
		this.pluginAction = pluginActionChoix;
		this.pluginMonstre = pluginMonsterChoix;
		
		pluginMgr = PluginManager.getDefaultInstance();
		
		try {
			boolean actionRun = pluginMgr.runPlugin(pluginActionChoix);
			boolean monstreRun = pluginMgr.runPlugin(pluginMonsterChoix);
		} catch (ClassNotFoundException | IllegalAccessException
				| InstantiationException | PluginAlreadyInstantiateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//je veux recevoir
		EventManager.getDefaultInstance().register(AbstractMonster.waitFromCore, this);
		EventManager.getDefaultInstance().register(AbstractAction.waitFromCore, this);
		
		//je demande (j'envoie un event a la plateforme)
		Event envoieEventMonstre = new Event(AbstractMonster.sendFromCore);
		Event envoieEventAction = new Event(AbstractAction.sendFromCore);
		
		//e.addExtra(key, value); : pour les parametre
		EventManager.getDefaultInstance().broadcast(envoieEventAction);
		EventManager.getDefaultInstance().broadcast(envoieEventMonstre);
		
		
		
		creationPersonnage = parent;
		this.character = character;
		
		this.setTitle("Salle #");
	    this.setSize(700, 650);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
	    this.setLayout(null);
	    
		waitEvents();

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

	private void waitEvents(){
		// TODO Auto-generated method stub
		int nb_secondes = 0;
		while(mesActions == null && monster == null && nb_secondes<5){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//je verifie toutes les secondes
			nb_secondes++;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		AbstractAction action = mesActions.get(actionList.getSelectedIndex());
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa             "+this.monster + "               "+this.character);
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
		this.monster = null;
		Event envoieEventMonstre = new Event(AbstractMonster.sendFromCore);
		EventManager.getDefaultInstance().broadcast(envoieEventMonstre);
		waitEvents();
	}
	
	public void partieFinie(){
		
		pluginMgr.stopPlugin(pluginAction);
		pluginMgr.stopPlugin(pluginMonstre);
		EventManager.getDefaultInstance().unregister(AbstractMonster.waitFromCore, this);
		EventManager.getDefaultInstance().unregister(AbstractAction.waitFromCore, this);
		this.creationPersonnage.setVisible(true);
		this.dispose();
	}

	@Override
	public void onEvent(Event arg0) {
		// TODO Auto-generated method stub
		String nomEvent = arg0.getAction();//nom evenement (actions, monstre ...)
		if(nomEvent.equals(AbstractAction.waitFromCore)){
			AbstractAction[] temp = (AbstractAction[]) arg0.getExtra("Action");
			this.mesActions = new ArrayList<AbstractAction>(Arrays.asList(temp));
		}
		else if(nomEvent.equals(AbstractMonster.waitFromCore)){
			this.monster = (AbstractMonster) arg0.getExtra("Monster");
		}		
	}

}