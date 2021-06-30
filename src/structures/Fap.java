package structures;

public abstract class Fap<E> {
	Sequence<E> s;
	abstract void insere(E element);
	E extraire () {
		return s.extraitTete();
	}
	boolean estVide() {
		return s.estVide();
	}
}
