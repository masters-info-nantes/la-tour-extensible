package application;

import interfaces.AbstractCharacter;
import interfaces.AbstractJob;
import interfaces.AbstractRace;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

import latourextensible.platform.PluginAlreadyInstantiateException;
import latourextensible.platform.PluginManager;
import latourextensible.platform.PluginProperty;
import latourextensible.platform.event.*;

public class CreationPersonnage extends JFrame implements ActionListener, IEventListener, ItemListener{

	private JFrame choixPlugin;
	
	private PluginManager pluginMgr;
	
	private PluginProperty race;
	private PluginProperty job;
	private PluginProperty character;	
	
	private PluginProperty pluginMonster;
	private PluginProperty pluginAction;
	
	private List<PluginProperty> mesDifficultees;
	
	private ArrayList<AbstractCharacter> mesCharacter;
	private ArrayList<AbstractJob> mesJob;
	private ArrayList<AbstractRace> mesRaces;
	
	private JComboBox<String> liste_race;
	private JComboBox<String> liste_job;
	private JComboBox<String> listePersonnage;
	private JComboBox<String> listeDifficultees;
	
	private JLabel image_character;
	private JLabel force_character;
	private JLabel vie_character;
	private JLabel defense_character;
	private JLabel difficultees;
	
	public CreationPersonnage(JFrame parent, PluginProperty pluginRaceChoix, PluginProperty pluginJobChoix, PluginProperty pluginCharacterChoix, PluginProperty pluginMonsterChoix, PluginProperty pluginActionChoix){
		
		super("Création personnage");
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
		this.setSize(600,310);
		this.setVisible(true);
		this.setLayout(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    
	    this.choixPlugin = parent;
	    
		pluginMgr = PluginManager.getDefaultInstance();
		
		boolean raceRun = false;
		boolean jobRun = false;
		boolean characterRun = false;
		
		race = pluginRaceChoix;
		job = pluginJobChoix;
		character = pluginCharacterChoix;
		
		try {
			raceRun = pluginMgr.runPlugin(pluginRaceChoix);
			jobRun = pluginMgr.runPlugin(pluginJobChoix);
			characterRun = pluginMgr.runPlugin(pluginCharacterChoix);
		} catch (ClassNotFoundException | IllegalAccessException
				| InstantiationException | PluginAlreadyInstantiateException e1) {
			e1.printStackTrace();
		}
		

	  	//Pour dire quel genre d'event je veux recevoir
	  	
		EventManager.getDefaultInstance().register(AbstractCharacter.waitFromCore, this);
		EventManager.getDefaultInstance().register(AbstractJob.waitFromCore, this);
		EventManager.getDefaultInstance().register(AbstractRace.waitFromCore, this);
		
		//Je cree des events
		Event envoieEventCharacter = new Event(AbstractCharacter.sendFromCore);
		Event envoieEventJob = new Event(AbstractJob.sendFromCore);
		Event envoieEventRace = new Event(AbstractRace.sendFromCore);
		
		//j'envoie des events
		EventManager.getDefaultInstance().broadcast(envoieEventCharacter);
		EventManager.getDefaultInstance().broadcast(envoieEventJob);
		EventManager.getDefaultInstance().broadcast(envoieEventRace);
		
		
		this.pluginMonster = pluginMonsterChoix;
		this.pluginAction = pluginActionChoix;
		
		WindowListener lis = new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		addWindowListener(lis);

		waitEvent();
		

		/*
		 * Bouton pour appeller la fenetre de jeux
		 */
		JButton jouer = new JButton("Valider");
		jouer.addActionListener(this);		
		this.add(jouer);
		jouer.setBounds(490, 225, 100, 30);
		jouer.setVisible(true);
		
		/*
		 * Bouton pour revenir au choix des plugins
		 */
		JButton retour = new JButton("Retour");
		retour.addActionListener(this);		
		this.add(retour);
		retour.setBounds(10, 225, 100, 30);
		retour.setVisible(true);
		
		
		/*
		 * Image du personnage
		 */
		ImageIcon image = new ImageIcon(this.mesCharacter.get(0).getClass().getResource(this.mesCharacter.get(0).getChemin_sprite()));
		float ratio  = (float) (150.0/image.getIconWidth());
		Image image2 = image.getImage().getScaledInstance(Math.round(image.getIconWidth()*ratio), Math.round(image.getIconHeight()*ratio), Image.SCALE_DEFAULT);
		image.setImage(image2);
		image_character = new JLabel();

		image_character.setIcon(image);
		this.add(image_character);
		image_character.setBounds(0, 0, image.getIconWidth(), image.getIconWidth());
		
		
		/*
		 * Choix race
		 */
		//TODO: parcourir notre liste de Race pour ajouter leur nom dans la liste
		JLabel label_race = new JLabel("Je suis un: ");
		this.add(label_race);
		label_race.setBounds(image_character.getWidth()+20, 0, 100, 25);

		liste_race = new JComboBox<String>();

		for(AbstractRace race: mesRaces){
			liste_race.addItem(race.getRace());
		}
		
		this.add(liste_race);
		liste_race.setBounds(image_character.getWidth()+120, 0, 100, 25);
		validate();

		/*
		 * Choix job
		 */
		//TODO: parcourir notre liste de Job pour ajouter leur nom dans la liste
		JLabel label_job = new JLabel("Mon travail ne peut être que: ");
		this.add(label_job);
		label_job.setBounds(image_character.getWidth() + 20, 30, 220, 25);

		liste_job = new JComboBox<String>();

		for(AbstractJob job: mesJob){
			liste_job.addItem(job.getJob());
		}
		
		this.add(liste_job);
		liste_job.setBounds(image_character.getWidth() + 250, 30, 100, 25);
		validate();
		
		/*
		 * Choix Personnage
		 */
		//TODO: parcourir notre liste de Job pour ajouter leur nom dans la liste
		JLabel label_personnage = new JLabel("Je suis: ");
		this.add(label_personnage);
		label_personnage.setBounds(image_character.getWidth() + 20, 60, 100, 25);

		listePersonnage = new JComboBox<String>();

		for(AbstractCharacter character: mesCharacter){
			listePersonnage.addItem(character.getName());
		}
		
		this.liste_race.addItemListener(this);
		this.liste_job.addItemListener(this);
		this.listePersonnage.addItemListener(this);

		
		this.add(listePersonnage);
		listePersonnage.setBounds(image_character.getWidth()+100, 60, 100, 25);
		
		force_character = new JLabel();
		force_character.setText("Force : " + (this.mesCharacter.get(0).getForce() + this.mesRaces.get(0).getForce() + this.mesJob.get(0).getForce()));
		this.add(force_character);
		force_character.setBounds(0, image_character.getY()+image_character.getHeight(), 100, 25);
		
		defense_character = new JLabel();
		defense_character.setText("Defense : " + (this.mesCharacter.get(0).getDefence() + this.mesRaces.get(0).getDefence() + this.mesJob.get(0).getDefence()));
		this.add(defense_character);
		defense_character.setBounds(0, force_character.getY()+force_character.getHeight(), 100, 25);
		
		vie_character = new JLabel();
		vie_character.setText("Vie : " + (this.mesCharacter.get(0).getLife() + this.mesRaces.get(0).getLife() + this.mesJob.get(0).getLife()));
		this.add(vie_character);
		vie_character.setBounds(0, defense_character.getY()+defense_character.getHeight(), 100, 25);
		
		/*
		 * Choix difficultée
		 */
		mesDifficultees = pluginMgr.getLoadablePlugins("IA");
		
		difficultees = new JLabel("Choix difficultée : ");
		difficultees.setBounds(image_character.getWidth() + 20, 90, 130, 25);
		
		listeDifficultees = new JComboBox<String>();
		listeDifficultees.setBounds(image_character.getWidth()+150, 90, 100, 25);

		for(PluginProperty prop:mesDifficultees){
			listeDifficultees.addItem(prop.getName());
		} 
		
		this.add(difficultees);
		this.add(listeDifficultees);
		validate();
	}

	private void waitEvent() {
		// TODO Auto-generated method stub
		int nb_secondes = 0;
		while(mesJob == null && mesCharacter == null && mesRaces == null && nb_secondes<5){
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
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Valider")){
			AbstractCharacter monCharacter = mesCharacter.get(listePersonnage.getSelectedIndex());
			monCharacter.setRace(mesRaces.get(liste_race.getSelectedIndex()));
			monCharacter.setJob(mesJob.get(liste_job.getSelectedIndex()));
			new Salle(this, monCharacter, pluginMonster, pluginAction, mesDifficultees.get(listeDifficultees.getSelectedIndex()));
			setVisible(false);
		}
		else if(e.getActionCommand().equals("Retour")){
			pluginMgr.stopPlugin(race);
			pluginMgr.stopPlugin(job);
			pluginMgr.stopPlugin(character);
			EventManager.getDefaultInstance().unregister(AbstractCharacter.waitFromCore, this);
			EventManager.getDefaultInstance().unregister(AbstractJob.waitFromCore, this);
			EventManager.getDefaultInstance().unregister(AbstractRace.waitFromCore, this);
			
			this.dispose();
			choixPlugin.setVisible(true);
		}
	}

	@Override
	public void onEvent(Event arg0) {
		// TODO Auto-generated method stub
		String nomEvent = arg0.getAction();//nom evenement (actions, monstre ...)
		if(nomEvent.equals(AbstractJob.waitFromCore)){
			AbstractJob[] temp = (AbstractJob[]) arg0.getExtra("Job");
			this.mesJob = new ArrayList<AbstractJob>(Arrays.asList(temp));
		}
		else if(nomEvent.equals(AbstractRace.waitFromCore)){
			AbstractRace[] temp = (AbstractRace[]) arg0.getExtra("Race");
			this.mesRaces = new ArrayList<AbstractRace>(Arrays.asList(temp));
		}
		else if(nomEvent.equals(AbstractCharacter.waitFromCore)){
			AbstractCharacter[] temp = (AbstractCharacter[]) arg0.getExtra("Character");
			this.mesCharacter = new ArrayList<AbstractCharacter>(Arrays.asList(temp));
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		 
		if(source == listePersonnage){
			
			ImageIcon image = new ImageIcon(this.mesCharacter.get(this.listePersonnage.getSelectedIndex()).getClass().getResource(this.mesCharacter.get(this.listePersonnage.getSelectedIndex()).getChemin_sprite()));
			float t  = (float) (150.0/image.getIconWidth());
			Image image2 = image.getImage().getScaledInstance(Math.round(image.getIconWidth()*t), Math.round(image.getIconHeight()*t), Image.SCALE_DEFAULT);
			image.setImage(image2);
			

			image_character.setIcon(image);
			image_character.invalidate();
		}
		
		if(e.getStateChange() == ItemEvent.SELECTED){
			force_character.setText("Force : " + (this.mesCharacter.get(this.listePersonnage.getSelectedIndex()).getForce() + this.mesRaces.get(this.liste_race.getSelectedIndex()).getForce() + this.mesJob.get(this.liste_job.getSelectedIndex()).getForce()));	
			defense_character.setText("Defense : " + (this.mesCharacter.get(this.listePersonnage.getSelectedIndex()).getDefence() + this.mesRaces.get(this.liste_race.getSelectedIndex()).getDefence() + this.mesJob.get(this.liste_job.getSelectedIndex()).getDefence()));	
			vie_character.setText("Vie : " + (this.mesCharacter.get(this.listePersonnage.getSelectedIndex()).getLife() + this.mesRaces.get(this.liste_race.getSelectedIndex()).getLife() + this.mesJob.get(this.liste_job.getSelectedIndex()).getLife()));
	
			force_character.invalidate();
			defense_character.invalidate();
			vie_character.invalidate();
		}
	}

	/**
	 * @param args
	 */

}