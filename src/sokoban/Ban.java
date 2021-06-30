package sokoban;
import java.io.InputStream;
import Global.Configuration;


import javax.swing.SwingUtilities;

public class Ban {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 //main for Sokoban
  		try {

  			System.out.println("Tapez un niveau :");
  			int numero=1;
  			//System.out.println(numero);
			InputStream in =Configuration.charge ("Original.txt");
			Jeu jeu = new Jeu(in);
			RedacteurNiveau rn = new RedacteurNiveau(System.out);
			int i=0;
			Niveau n=null;
			while (i<numero && jeu.prochainNiveau()) {
				n = jeu.niveau();
				
				i++;
			}
			//rn.ecrisNiveau(n);
			InterfaceGraphique ig = new InterfaceGraphique(jeu);
			SwingUtilities.invokeLater(ig);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
