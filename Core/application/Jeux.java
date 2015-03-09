package application;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Jeux extends JFrame {

	public Jeux(){
		super("Interieur de la tour");
		
		WindowListener lis = new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		};
		
		addWindowListener(lis);
		setSize(600,600);
		setVisible(true);
		this.setLayout(null);
		
		/*
		 * Image du personnage
		 */
		ImageIcon image = new ImageIcon("../Core/Ike_(FE9_Artwork).png");

		JLabel lab = new JLabel();
		lab.setIcon(image);
		this.add(lab);
		lab.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		

	}
	/*private static PluginManager pluginManager = new PluginManager();
	private static FactoryPersonnage charactersFactory = (FactoryPersonnage)pluginManager.getPlugin("Personnage");
	private static FactoryAction actionFactory = (FactoryAction)pluginManager.getPlugin("Action");
	private static ArrayList<Action> actions = new ArrayList<>();
	*/


}
