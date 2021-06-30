package structures;

public class FapListe<E extends Comparable<E>> extends Fap<E> {
	SequenceListe<E> s;
	
	FapListe() {
		s = new SequenceListe<>();
		super.s = s;
	}
	
	@Override
	void insere(E element) {
		// TODO Auto-generated method stub
		Maillon<E> m1 = null;
		Maillon<E> m2 = s.tete;
		while (m2 != null && (element.compareTo(m2.element) >0)) {
			m1 = m2;
			m2 = m2.suivant;
		}
		if (m1 == null) {
			s.insereTete(element);
		}else {
			Maillon<E> m = new Maillon<E>(element);
			m.suivant = m2;
			m1.suivant = m;
		}
		
	}

}
