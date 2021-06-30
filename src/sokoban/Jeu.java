package sokoban;
import java.io.InputStream;

import Global.Configuration;


public class Jeu {
	private LecteurNiveau lecteur;
	private Niveau n;
	
	public Jeu (InputStream in) {
		lecteur = new LecteurNiveau(in);
	}
	
    Niveau niveau() {
    	return n;
    }
    
    public boolean prochainNiveau() {
    	n = lecteur.lisProchainNiveau();
    	return (n != null);
    }
    
    public boolean deplace (int x, int y) {
    	if (!n.deplace(x, y)) {
    		Configuration.instance().logger().info("deplacement impossible !");
    	}
    	
    	if (n.fini()) {
    		return this.prochainNiveau(); 
    	}
    	return true;
    }
    
    public int pousseurL() {
    	return n.pousseurL;
    }
   
    public int pousseurC() {
    	return n.pousseurC;
    }
}
