package structures;

public class SequenceTableau<E> implements Sequence<E> {
	Object	[] elements;
	int nbrElements;
	int debut;
	int nbrMax;
	
	public SequenceTableau () {
		nbrMax = 1;
		elements = new Object [nbrMax];
	}
	
	@Override
	public void insereTete(E element) {
		// TODO Auto-generated method stub
		if (this.estVide()) {
			elements[debut] = element;
		}else if (nbrElements == nbrMax){
			//throw new RuntimeException("limite de nombre max d\'elements atteinte");
			Object [] newElements = new Object [nbrMax*2];
			for (int i=0 ; i<nbrElements ; i++) {
				newElements [i+1] = elements[(debut + i)%nbrMax];
			}
			newElements[0] = element;
			nbrMax *= 2;
			elements = newElements;
			debut = 0;
		}else {
			debut = (debut-1);
			if (debut < 0) {
				debut += nbrMax;
			}
			elements[debut] = element;
		}
		nbrElements ++;
	}

	@Override
	public void insereQueue(E element) {
		// TODO Auto-generated method stub
		if (this.estVide()) {
			this.insereTete(element);
		} else if (this.nbrElements == nbrMax) {
			//throw new RuntimeException("insertion impossible : nombre d\'elements atteint");
			Object [] newElements = new Object [nbrMax*2];
			for (int i=0 ; i<nbrElements ; i++) {
				newElements [i] = elements[(debut + i)%nbrMax];
			}
			newElements[nbrMax] = element;
			nbrMax *= 2;
			elements = newElements;
			debut = 0;
			nbrElements ++;
		} else {
			this.elements[(nbrElements + debut)%nbrMax] = element;
			nbrElements ++;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public E extraitTete() {
		// TODO Auto-generated method stub
		if (this.estVide()) {
			throw new RuntimeException ("extraction impossible : Sequence vide");
		} else {
			E e = (E) elements[debut];
			debut = (debut + 1) % nbrMax;
			nbrElements --;
			return e;
		}
	}

	@Override
	public boolean estVide() {
		// TODO Auto-generated method stub
		return this.nbrElements == 0;
	}
	
	@Override
	public String toString () {
		String mot = "";
		for (int i = debut ; i - debut < nbrElements ; i++) {
			mot = mot + " " + elements[i % nbrMax];
		}
		return mot;
	}

	@Override
	public Iterateur<E> iterateur() {
		// TODO Auto-generated method stub
		return new IterateurSequenceTableau<E>(this);
	}

}
