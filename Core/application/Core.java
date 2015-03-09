package application;
import java.util.ArrayList;
import java.util.Scanner;


public class Core {

	/*private static PluginManager pluginManager = new PluginManager();
	private static FactoryPersonnage charactersFactory = (FactoryPersonnage)pluginManager.getPlugin("Personnage");
	private static FactoryAction actionFactory = (FactoryAction)pluginManager.getPlugin("Action");
	private static ArrayList<Action> actions = new ArrayList<>();
	*/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
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
			
			
		}*/
		

	}

}