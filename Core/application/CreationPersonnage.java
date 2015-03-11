package application;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;


public class CreationPersonnage extends JFrame{

	
	public CreationPersonnage(){
		super("Création personnage");
		
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
		JButton b = new JButton("Valider");
		
		ActionListener mlis = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new Salle();
				setVisible(false);
			}
		};
		b.addActionListener(mlis);		
		this.add(b);
		b.setBounds(490, 225, 100, 30);
		
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
		JLabel label_race = new JLabel("Je suis un: ");
		this.add(label_race);
		label_race.setBounds(lab.getWidth()+20, 0, 100, 25);

		String[] mes_races = {"Vampire", "Demi-dieu", "Humain", "Elfe", "Nain"};
		JComboBox<String> liste_race = new JComboBox<String>(mes_races);
		this.add(liste_race);
		liste_race.setBounds(lab.getWidth()+120, 0, 100, 25);
		validate();

		/*
		 * Choix job
		 */
		JLabel label_job = new JLabel("Mon travail ne peut être que: ");
		this.add(label_job);
		label_job.setBounds(lab.getWidth()+20, 100, 220, 25);

		String[] mes_job = {"Chevalier", "Mage noir", "Sentinelle", "Berserker", "Archer"};
		JComboBox<String> liste_job = new JComboBox<String>(mes_job);
		this.add(liste_job);
		liste_job.setBounds(lab.getWidth()+250, 100, 100, 25);
		validate();
	}
	/*private static PluginManager pluginManager = new PluginManager();
	private static FactoryPersonnage charactersFactory = (FactoryPersonnage)pluginManager.getPlugin("Personnage");
	private static FactoryAction actionFactory = (FactoryAction)pluginManager.getPlugin("Action");
	private static ArrayList<Action> actions = new ArrayList<>();
	*/

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		
		JFrame frame = new CreationPersonnage();
		
		/*Personnage joueur;	
		
		System.out.println("Quel personnage voulez vous créer ? vous avez le choix entre " + charactersFactory.getNbPersonnage()+" personnages");
		Scanner sc = new Scanner(System.in);
		int numero_perso = sc.nextInt();
		joueur = charactersFactory.make(numero_perso);
		for(int i=0; i<actionFactory.getNbActions(); i++){
			actions.add((Action) actionFactory.make(i));

		}

		boolean fini = false;
		
		while(!fini){
			System.out.println("quelle action ? "+actionFactory.getNbActions()+" actions possible, entrer un nombre negatif pour finir");
			int numero_action = sc.nextInt();
			if(numero_action<0){
				fini = true;
			}
			else if(numero_action>actions.size()){
				System.out.println("eu non ca n'existe pas ...");
			}
			else{
				actions.get(numero_action).doaction();		
			}
			
			
		}
		

	}*/

}