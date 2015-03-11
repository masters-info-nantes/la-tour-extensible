package application;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Salle extends JFrame implements ActionListener {

	private ImageIcon image;
	private Image image2;
	private JLabel lab;
	private JComboBox<String> actionList;
	private JButton actionButton;
	
	public Salle(){
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
		actionList.addItem("Test1");
		actionList.addItem("Test2");
		actionList.addItem("Test3");
		
		actionButton = new JButton("Exec");
		actionButton.setBounds(450, 530, 200, 30);
		
		this.add(actionList);
		this.add(actionButton);
	    this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}