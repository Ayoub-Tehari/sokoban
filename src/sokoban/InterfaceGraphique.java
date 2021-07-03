package sokoban;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class InterfaceGraphique implements Runnable, ActionListener {
	Jeu jeu;
	NiveauGraphique ng;
	
	public InterfaceGraphique(Jeu j) {
		jeu = j;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		JFrame maFenetre = new JFrame("jeu SOKOBAN");
		ng = new NiveauGraphique(jeu);
		maFenetre.add(ng, BorderLayout.CENTER);
		Box topBox = Box.createHorizontalBox();
		topBox.add(Box.createGlue());
		JLabel titre = new JLabel("Sokoban");
		titre.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		topBox.add(titre);
		topBox.add(Box.createGlue());
		
		JButton button = new JButton("Annuler");
		button.addActionListener(this);
		button.setFocusable(false);
		topBox.add(button);
		topBox.add(Box.createGlue());
		
		maFenetre.add(topBox, BorderLayout.PAGE_START);
		
		Box endBox = Box.createVerticalBox();
		
		JLabel cr = new JLabel("By T.Ayoub");
		cr.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		endBox.add(Box.createGlue());
		endBox.add(cr);
		
		maFenetre.add(endBox, BorderLayout.LINE_END);
		
		ng.addMouseListener(new EcouteurDeSouris(ng));
		maFenetre.addKeyListener(new EcouteurClavier(ng));
		maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		maFenetre.setSize(500, 300);
		maFenetre.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ng.undo();
	}

	
}
