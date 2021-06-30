package structures;

public class Couple<E, F extends Comparable<F>> implements Comparable<Couple<E,F>>  {
	E element;
	F priorite;
	Couple (E e, F p){
		element = e;
		priorite = p;
	}
	

	@Override
	public int compareTo(Couple<E,F> c1) {
		// TODO Auto-generated method stub
		return this.priorite.compareTo(c1.priorite);
	}
	
	public String toString() {
		return "(" + element + ", " + priorite + ")";
	}
}
