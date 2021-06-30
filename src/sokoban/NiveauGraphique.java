package sokoban;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import Global.Configuration;

public class NiveauGraphique extends JComponent {
	Jeu jeu;
	Image pousseur, mur, but, caisse, caisse_sur_but, sol;

	int pas;
	
	private Image chargerImage (String nom) {
		InputStream in = Configuration.charge(nom);
		Image res = null;
		try {
			res = ImageIO.read(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Configuration.instance().logger().severe("impossible de charger l'image"+e);
			System.exit(1);
		}
		return res;
	}
	
	public NiveauGraphique(Jeu j) {
		jeu = j;	
		pousseur = chargerImage("Images" + File.separator + "Pousseur.png");
		mur = chargerImage("Images" + File.separator + "mur.png");
		but = chargerImage("Images" + File.separator + "but.png");
		caisse = chargerImage("Images" + File.separator + "caisse.png");
		caisse_sur_but = chargerImage("Images" + File.separator + "caisse_sur_but.png");
		sol = chargerImage("Images" + File.separator + "sol.png");
	}
	
	public int getPas() {
		return pas;
	}
	
	public void clickSouris(int c, int l) {
		int dC = jeu.pousseurC()-c;
		int dL = jeu.pousseurL()-l;
		int somme = dC + dL;
		somme *= somme;
		int produit = dC * dL;
		
		if (somme == 1 && produit == 0) {
			if (!jeu.deplace(c, l)) {
				System.exit(0);
			}else {
				this.repaint();
			}
		} else {
			Configuration.instance().logger().info("mouvement impossible !");
		}
	}
	
	public void tapAuClavier (int c, int l) {
		if (!jeu.deplace(c+jeu.pousseurC(), l+jeu.pousseurL())) {
			System.exit(0);
		}else {
			this.repaint();
		}
	}
	
	public void paintComponent (Graphics g) {
		Graphics2D drawable = (Graphics2D) g;
		int x = 0, y = 0;
		int width = getSize().width;
		int height = getSize().height;
		int pasI = height / jeu.niveau().lignes();
		int pasJ = width / jeu.niveau().colonnes();
		pas = Math.min(pasI, pasJ);
		drawable.clearRect(0, 0, width, height);
		for(int i=0 ; i<jeu.niveau().lignes() ; i++) {
			for(int j=0 ; j<jeu.niveau().colonnes() ; j++) {
				x = j*pas;
				y = i*pas;
				drawable.drawImage(sol, x, y, pas, pas, null);
				if (jeu.niveau().aMur(i, j)) {
					drawable.drawImage(mur, x, y, pas, pas, null);
				}
			
				if (jeu.niveau().aBut(i, j)) {
					if (jeu.niveau().aCaisse(i, j)) {
						drawable.drawImage(caisse_sur_but, x, y, pas, pas, null);
					}else {
						drawable.drawImage(but, x, y, pas, pas, null);
					}
				} else if (jeu.niveau().aCaisse(i, j)) {
					drawable.drawImage(caisse, x, y, pas, pas, null);
				}
			}
		}
		drawable.drawImage(pousseur, jeu.pousseurC()*pas, jeu.pousseurL()*pas, pas, pas, null);
	}
}
