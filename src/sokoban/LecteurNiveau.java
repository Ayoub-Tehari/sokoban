package sokoban;
import java.io.InputStream;
import java.util.Scanner;


public class LecteurNiveau {
	Scanner sc;
	
	LecteurNiveau(InputStream i) {
			sc = new Scanner(i);
		
	}
	
	public Niveau lisProchainNiveau () {
		String ligne;
		int c = 0, l=0;
		Niveau n = new Niveau();
		boolean bool = true;
		try {
		do {
			//System.out.println(sc.nextLine());
			ligne = sc.nextLine();
			if(bool) {
				System.out.println(ligne);
			}
			if (ligne.isEmpty()) {
				break;
			}
			if (ligne.charAt(0) == ';') {
				n.fixeNom(ligne.substring(1));
				continue;
			}
			
			c = Integer.max(c, ligne.length());
			for (int i=0; i<ligne.length(); i++) {
				switch(ligne.charAt(i)) {
				case '#' : n.ajouteMur(l, i); break;
				case '.' : n.ajouteBut(l, i); break;
				case '@' : n.ajoutePousseur(l, i); break;
				case '$' : n.ajouteCaisse(l, i); break;
				case '+' : n.ajoutePousseur(l, i); n.ajouteBut(l, i); break;
				case '*' : n.ajouteBut(l, i); n.ajouteCaisse(l, i); break;
				case ' ' : break;
				default : System.err.println("caractere inconnue lors de la lecture d'un niveau :[" + ligne.charAt(i) + "]");
					System.exit(0); 
				}
			}
			l++;
		}while (sc.hasNextLine());
		} catch (Exception e) {
			//System.out.println("Exception");
			//e.printStackTrace(System.err);
			return null;
		}
		if ( l == 0) {
			System.out.println("l est null");
			return null;
		}else {
			n.lignes= l;
			n.colonnes= c;
			return n;
		}
	}
}
