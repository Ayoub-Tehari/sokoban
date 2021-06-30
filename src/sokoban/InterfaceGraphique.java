package sokoban;

import javax.swing.*;

public class InterfaceGraphique implements Runnable {
	Jeu jeu;
	public InterfaceGraphique(Jeu j) {
		jeu = j;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		JFrame maFenetre = new JFrame("jeu SOKOBAN");
		NiveauGraphique ng = new NiveauGraphique(jeu);
		maFenetre.add(ng);
		ng.addMouseListener(new EcouteurDeSouris(ng));
		maFenetre.addKeyListener(new EcouteurClavier(ng));
		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		maFenetre.setSize(500, 300);
		maFenetre.setVisible(true);
	}

	
}
