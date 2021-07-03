package sokoban;
import java.io.InputStream;

import Global.Configuration;
import structures.Sequence;



public class Jeu {
	private LecteurNiveau lecteur;
	private Niveau n;
	Sequence<Coup> historique;
	
	public Jeu (InputStream in) {
		lecteur = new LecteurNiveau(in);
		
	}
	
    Niveau niveau() {
    	return n;
    }
    
    public boolean prochainNiveau() {
    	n = lecteur.lisProchainNiveau();
    	historique = Configuration.instance().nouvelleSequence();
    	return (n != null);
    }
    
    public boolean deplace (int x, int y) {
    	Coup res = n.deplace(x, y);
    	
    	if (res == null) {
    		Configuration.instance().logger().info("deplacement impossible !");
    	} else {
    		historique.insereTete(res);
    		if (n.fini()) {
    			return this.prochainNiveau(); 
    		}
    	}
    	return true;
    }
    
    public void undo() {
    	if (!historique.estVide()) {
    		Coup coup = historique.extraitTete();
    		Sequence<Deplacement> seq = coup.getCoup();
    		Deplacement d;
    		while (!seq.estVide()) {
    			d = seq.extraitTete();
    			n.undo(d);
    		}
    	}else {
    		Configuration.instance().logger().info("l'historique des deplacement est vide");
    	}
    }
    
    public int pousseurL() {
    	return n.pousseurL;
    }
   
    public int pousseurC() {
    	return n.pousseurC;
    }
}
