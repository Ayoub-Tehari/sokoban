package structures;

public class IterateurSequenceListe<Type> extends Iterateur<Type> {
	Maillon<Type> courant, precedent;
	SequenceListe<Type> seq;
	IterateurSequenceListe (SequenceListe<Type> seqL){
		courant = seqL.tete;
		seq = seqL;
	}
	
	@Override
	boolean aProchain() {
		// TODO Auto-generated method stub
		return courant != null;
	}

	@Override
	Type prochain() {
		// TODO Auto-generated method stub
		super.prochain();
		precedent = courant;
		courant = courant.suivant;
		return precedent.element;
	}

	@Override
	void supprime() {
		// TODO Auto-generated method stub
		super.supprime();
		if (precedent == null) {
			seq.tete = courant.suivant;
			courant = seq.tete;
		} else {
			precedent.suivant = courant.suivant;
			courant = precedent.suivant;
		}
	}

}
