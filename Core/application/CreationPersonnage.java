package application;

import interfaces.AbstractCharacter;
import interfaces.AbstractJob;
import interfaces.AbstractRace;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

import latourextensible.platform.PluginManager;
import latourextensible.platform.PluginProperty;
import latourextensible.platform.event.*;

public class CreationPersonnage extends JFrame implements ActionListener, IEventListener{

	private String pluginMonster;
	private String pluginAction;
	
	ArrayList<AbstractCharacter> mesCharacter;
	ArrayList<AbstractJob> mesJob;
	ArrayList<AbstractRace> mesRaces;
	
	JComboBox<String> liste_race;
	JComboBox<String> liste_job;
	JComboBox<String> listePersonnage;
	
	public CreationPersonnage(String pluginRaceChoix, String pluginJobChoix, String pluginCharacterChoix, String pluginMonsterChoix, String pluginActionChoix){
		
		super("Création personnage");
		
	  	/*List<PluginProperty> l = PluginManager.getDefaultInstance().getLoadablePlugins("Action");
	  	//l.getname etc ..............
	  	boolean t = PluginManager.getDefaultInstance().runPlugin(l.get(index));
	  	//la je peux envoyer des event*/
	  	
		EventManager.getDefaultInstance().register(AbstractCharacter.waitFromCore, this);
		EventManager.getDefaultInstance().register(AbstractJob.waitFromCore, this);
		EventManager.getDefaultInstance().register(AbstractRace.waitFromCore, this);
		
		this.pluginMonster = pluginMonsterChoix;
		this.pluginAction = pluginActionChoix;
		
		WindowListener lis = new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		
		addWindowListener(lis);
		setSize(600,310);
		setVisible(true);
		this.setLayout(null);

		/*
		 * Bouton pour appeller la fenetre de jeux
		 */
		JButton jouer = new JButton("Valider");
		jouer.addActionListener(this);		
		this.add(jouer);
		jouer.setBounds(490, 225, 100, 30);
		jouer.setVisible(true);
		/*
		 * Image du personnage
		 */
		ImageIcon image = new ImageIcon("../Core/Ike_(FE9_Artwork).png");
		Image image2 = image.getImage().getScaledInstance(image.getIconWidth()/3, image.getIconHeight()/3, Image.SCALE_DEFAULT);
		image.setImage(image2);
		JLabel lab = new JLabel();
		lab.setIcon(image);
		this.add(lab);
		lab.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		
		/*
		 * Choix race
		 */
		//TODO: parcourir notre liste de Race pour ajouter leur nom dans la liste
		JLabel label_race = new JLabel("Je suis un: ");
		this.add(label_race);
		label_race.setBounds(lab.getWidth()+20, 0, 100, 25);

		liste_race = new JComboBox<String>();

		for(AbstractRace race: mesRaces){
			liste_race.addItem(race.getRace());
		}
		
		this.add(liste_race);
		liste_race.setBounds(lab.getWidth()+120, 0, 100, 25);
		validate();

		/*
		 * Choix job
		 */
		//TODO: parcourir notre liste de Job pour ajouter leur nom dans la liste
		JLabel label_job = new JLabel("Mon travail ne peut être que: ");
		this.add(label_job);
		label_job.setBounds(lab.getWidth() + 20, 100, 220, 25);

		liste_job = new JComboBox<String>();

		for(AbstractJob job: mesJob){
			liste_job.addItem(job.getJob());
		}
		
		this.add(liste_job);
		liste_job.setBounds(lab.getWidth() + 250, 100, 100, 25);
		validate();
		
		/*
		 * Choix Personnage
		 */
		//TODO: parcourir notre liste de Job pour ajouter leur nom dans la liste
		JLabel label_personnage = new JLabel("Je suis: ");
		this.add(label_personnage);
		label_personnage.setBounds(lab.getWidth() + 20, 200, 100, 25);

		listePersonnage = new JComboBox<String>();

		for(AbstractCharacter character: mesCharacter){
			listePersonnage.addItem(character.getName());
		}
		
		this.add(listePersonnage);
		listePersonnage.setBounds(lab.getWidth()+100, 200, 100, 25);
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
		// TODO Auto-generated method stub
		AbstractCharacter monCharacter = mesCharacter.get(listePersonnage.getSelectedIndex());
		monCharacter.setRace(mesRaces.get(liste_race.getSelectedIndex()));
		monCharacter.setJob(mesJob.get(liste_job.getSelectedIndex()));
		
		JFrame frame = new Salle(this, monCharacter, pluginMonster, pluginAction);
		setVisible(false);
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
		//arg0.getatbleau
	}

	/**
	 * @param args
	 */

}