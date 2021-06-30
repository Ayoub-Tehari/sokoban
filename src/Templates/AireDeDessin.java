package Templates;
/*
 * Sokoban - Encore une nouvelle version (� but p�dagogique) du c�l�bre jeu
 * Copyright (C) 2018 Guillaume Huard
 *
 * Ce programme est libre, vous pouvez le redistribuer et/ou le
 * modifier selon les termes de la Licence Publique G�n�rale GNU publi�e par la
 * Free Software Foundation (version 2 ou bien toute autre version ult�rieure
 * choisie par vous).
 *
 * Ce programme est distribu� car potentiellement utile, mais SANS
 * AUCUNE GARANTIE, ni explicite ni implicite, y compris les garanties de
 * commercialisation ou d'adaptation dans un but sp�cifique. Reportez-vous � la
 * Licence Publique G�n�rale GNU pour plus de d�tails.
 *
 * Vous devez avoir re�u une copie de la Licence Publique G�n�rale
 * GNU en m�me temps que ce programme ; si ce n'est pas le cas, �crivez � la Free
 * Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307,
 * �tats-Unis.
 *
 * Contact:
 *          Guillaume.Huard@imag.fr
 *          Laboratoire LIG
 *          700 avenue centrale
 *          Domaine universitaire
 *          38401 Saint Martin d'H�res
 */

import Global.Configuration;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

class AireDeDessin extends JComponent {
	int counter;
	Image img;

	public AireDeDessin() {
		// Chargement de l'image de la m�me mani�re que le fichier de niveaux
		InputStream in = Configuration.charge("Images\\Pousseur.png");
		try {
			// Chargement d'une image utilisable dans Swing
			img = ImageIO.read(in);
		} catch (Exception e) {
			Configuration.instance().logger().severe("Impossible de charger l'image");
			System.exit(1);
		}
		counter = 1;
	}

	@Override
	public void paintComponent(Graphics g) {
		System.out.println("Entree dans paintComponent : " + counter++);

		// Graphics 2D est le vrai type de l'objet pass� en param�tre
		// Le cast permet d'avoir acces a un peu plus de primitives de dessin
		Graphics2D drawable = (Graphics2D) g;

		// On reccupere quelques infos provenant de la partie JComponent
		int width = getSize().width;
		int height = getSize().height;

		// On calcule le centre de la zone et un rayon
		Point center = new Point(width/2, height/2);

		// On efface tout
		drawable.clearRect(0, 0, width, height);

		// On affiche une petite image au milieu
		drawable.drawImage(img, center.x-20, center.y-20, 40, 40, null);
	}
}