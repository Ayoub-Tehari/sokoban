package structures;

public class IterateurSequenceTableau<Type> extends Iterateur<Type> {
	int courant;
	SequenceTableau<Type> seq;
	IterateurSequenceTableau(SequenceTableau<Type> seqT) {
		seq = seqT;
		courant=-1;
	}
	@Override
	boolean aProchain() {
		// TODO Auto-generated method stub
		return courant +1 < seq.nbrElements;
	}

	@SuppressWarnings("unchecked")
	@Override
	Type prochain() {
		// TODO Auto-generated method stub
		super.prochain();
		int index = (courant + seq.debut + 1) % seq.nbrMax;
		Type resultat = (Type) seq.elements[index];
		courant++;
		return resultat;
	}

	@Override
	void supprime() {
		// TODO Auto-generated method stub
		super.supprime();
		if (courant==-1) {
			throw new RuntimeException("suppression interdite");
		}else if (courant == 0) {
			seq.extraitTete();
		}else {
			if (courant >= seq.nbrElements) {
				throw new RuntimeException("suppression interdite");
			}
			for(int i=courant+1 ; i<seq.nbrElements ; i++) {
				int prec = (seq.debut+i) % seq.elements.length;
				int suiv = (prec+1) % seq.elements.length;
				seq.elements[prec] = seq.elements[suiv];
 			}
			seq.nbrElements--; 	
		}
		
		

	}

}
