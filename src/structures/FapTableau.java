package structures;

public class FapTableau<E extends Comparable<E>> extends Fap<E> {
	SequenceTableau<E> s;
	FapTableau (){
		s = new SequenceTableau<>();
		super.s = s;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	void insere(E element) {
		// TODO Auto-generated method stub
		s.insereTete(element);
		int index1 = s.debut;
		int index2 = (s.debut + 1) % s.elements.length;
		E element1 = (E) s.elements[index1];
		E element2 = (E) s.elements[index2];
		for (int i=1; i<s.nbrElements && element1.compareTo(element2)>0 ; i++) {
			s.elements[index1] = element2;
			s.elements[index2] = element1;
			index1 = index2;
			index2 = (index2 + 1)%s.elements.length;
			element1 = (E) s.elements[index1];
			element2 = (E) s.elements[index2];
		}
	}

}
