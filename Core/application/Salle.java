package application;

import interfaces.AbstractAction;
import interfaces.AbstractCharacter;
import interfaces.AbstractMonster;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import latourextensible.platform.PluginAlreadyInstantiateException;
import latourextensible.platform.PluginManager;
import latourextensible.platform.PluginProperty;
import latourextensible.platform.event.Event;
import latourextensible.platform.event.EventManager;
import latourextensible.platform.event.IEventListener;


public class Salle extends JFrame implements ActionListener , IEventListener{

	private JLabel background;
	private JLabel image_character;
	private JLabel image_monster;

	private JComboBox<String> actionList;
	private JButton actionButton;
	
	private ArrayList<AbstractAction> mesActions;
	private AbstractCharacter character;
	private AbstractMonster monster;
	private JFrame creationPersonnage;
	
	PluginProperty difficultee;
	
	PluginProperty pluginAction;
	PluginProperty pluginMonstre;
	
	PluginManager pluginMgr;
	
	JProgressBar vieCharacter;
	JProgressBar vieMonster;

	public Salle(JFrame parent, AbstractCharacter character, PluginProperty pluginMonsterChoix, PluginProperty pluginActionChoix, PluginProperty diff){
		
		this.pluginAction = pluginActionChoix;
		this.pluginMonstre = pluginMonsterChoix;
		this.difficultee = diff;
		
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



		Event envoieEventAction = new Event(AbstractAction.sendFromCore);
		Event envoieEventMonstre = new Event(AbstractMonster.sendFromCore);
		envoieEventMonstre.addExtra("IA", difficultee);

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
		Random r = new Random();
		int rand = Math.abs(r.nextInt()%19);
		ImageIcon image = new ImageIcon(this.getClass().getResource("/images/fond"+rand+".png"));
		float t  = (float) (700.0/image.getIconWidth());

		Image image2 = image.getImage().getScaledInstance(Math.round(image.getIconWidth()*t), 400, Image.SCALE_DEFAULT);
		image.setImage(image2);
		background = new JLabel();
		background.setIcon(image);
		background.setBounds(0, 0, image.getIconWidth(), 400);
		/*
		 * Image du character
		 */
		
		image = new ImageIcon(monster.getClass().getResource(monster.getChemin_sprite()));
		t  = (float) (200.0/image.getIconHeight());
		image2 = image.getImage().getScaledInstance(Math.round(image.getIconWidth()*t), Math.round(image.getIconHeight()*t), Image.SCALE_DEFAULT);
		image.setImage(image2);
		
	    image_monster = new JLabel();
	    image_monster.setIcon(image);
		this.add(image_monster);
		image_monster.setBounds(background.getWidth()-image.getIconWidth()-10, background.getHeight()-image.getIconHeight(), image.getIconWidth(), image.getIconHeight());
		
		
		image = new ImageIcon(character.getClass().getResource(character.getChemin_sprite()));
		t  = (float) (200.0/image.getIconHeight());
		image2 = image.getImage().getScaledInstance(Math.round(image.getIconWidth()*t), Math.round(image.getIconHeight()*t), Image.SCALE_DEFAULT);
		image.setImage(image2);
		
	    image_character = new JLabel();
		image_character.setIcon(image);
		this.add(image_character);
		image_character.setBounds(10, background.getHeight()-image.getIconHeight(), image.getIconWidth(), image.getIconHeight());
				
		
		this.add(background);

		
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
		
		vieMonster = new JProgressBar();
		vieMonster.setMaximum(monster.getLife());
		vieMonster.setValue(monster.getLife());
		vieMonster.setBounds(background.getWidth()-210, background.getHeight()+10, 200, 20);
		
		vieCharacter = new JProgressBar();
		vieCharacter.setMaximum(character.getLife() + character.getRace().getLife() + character.getJob().getLife());
		vieCharacter.setValue(character.getLife() + character.getRace().getLife() + character.getJob().getLife());
		vieCharacter.setBounds(10, background.getHeight()+10, 200, 20);
		
		this.add(vieMonster);
		this.add(vieCharacter);
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
		action.doAction(this.character, this.monster);
		vieMonster.setValue(monster.getLife());
		if(this.monster.getLife()<0){
			changerSalle();
		}
		if(this.character.getLife() + character.getRace().getLife() + character.getJob().getLife()<=0){
			partieFinie();			
		}
		
		vieCharacter.setValue(character.getLife() + character.getRace().getLife() + character.getJob().getLife());
		
	}
	
	public void changerSalle(){
		//TODO: demander a la plateforme un monstre
		Random r = new Random();
		int rand = Math.abs(r.nextInt()%19);
		ImageIcon image = new ImageIcon(this.getClass().getResource("/images/fond"+rand+".png"));
		float t  = (float) (700.0/image.getIconWidth());

		Image image2 = image.getImage().getScaledInstance(Math.round(image.getIconWidth()*t), 400, Image.SCALE_DEFAULT);
		image.setImage(image2);
		background.setIcon(image);
		
		

		this.invalidate();
		this.monster = null;
		Event envoieEventMonstre = new Event(AbstractMonster.sendFromCore);
		envoieEventMonstre.addExtra("IA", difficultee);

		EventManager.getDefaultInstance().broadcast(envoieEventMonstre);
		waitEvents();
		
		image = new ImageIcon(monster.getClass().getResource(monster.getChemin_sprite()));
		t  = (float) (200.0/image.getIconHeight());
		image2 = image.getImage().getScaledInstance(Math.round(image.getIconWidth()*t), Math.round(image.getIconHeight()*t), Image.SCALE_DEFAULT);
		image.setImage(image2);
		image_monster.setIcon(image);
		image_monster.setSize(image.getIconWidth(), image.getIconHeight());		
		
		image_monster.setAlignmentY(background.getWidth()-image_monster.getWidth());
		image_monster.setBounds(background.getWidth()-image.getIconWidth()-10, background.getHeight()-image.getIconHeight(), image.getIconWidth(), image.getIconHeight());
		
		vieMonster.setMaximum(monster.getLife());
		vieMonster.setValue(monster.getLife());
		image_monster.invalidate();
				
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