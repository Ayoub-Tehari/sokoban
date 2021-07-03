package sokoban;

import structures.Sequence;
import Global.Configuration;

public class Coup {
	Sequence<Deplacement> deplacements;
	
	Coup (){
		deplacements = Configuration.instance().nouvelleSequence();
	}
	
	public Sequence<Deplacement> getCoup(){
		return deplacements;
	}
	
	public void ajoutDep(int a, int b, int c, int d) {
		deplacements.insereTete(new Deplacement(a, b, c, d));
	}

}
