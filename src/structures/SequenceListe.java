package structures;

public class SequenceListe<Rot> implements Sequence<Rot> {
	Maillon<Rot> tete;
	
	@Override
	public void insereTete(Rot element) {
		// TODO Auto-generated method stub
		Maillon<Rot> m = new Maillon<Rot> (element);
		m.suivant = tete;
		tete = m;
	}

	@Override
	public void insereQueue(Rot element) {
		// TODO Auto-generated method stub
		
		if (this.estVide()) {
			this.insereTete(element);
		}else {
			Maillon<Rot> m1 = tete;
			Maillon<Rot> m2 = tete.suivant;
			while (m2 != null) {
				m1 = m2;
				m2 = m2.suivant;
			}
			m2 = new Maillon<> (element);
			m1.suivant = m2;
		}
		
	}

	@Override
	public Rot extraitTete() {
		// TODO Auto-generated method stub
		if (this.estVide()) {
			throw new RuntimeException("Sequence vide");
		}else {
			Maillon<Rot> m = tete;
			tete = tete.suivant;
			return m.element;
		}
	}

	@Override
	public boolean estVide() {
		// TODO Auto-generated method stub
		return tete == null;
	}
	
	@Override
	public String toString() {
		String mot = "";
		Maillon<Rot> m = tete;
		while (m != null) {
			mot = mot + " " + m.element ;
			m = m.suivant;
		}
		return mot;
	}
	
	public Iterateur<Rot> iterateur() {
		return new IterateurSequenceListe<Rot>(this);
	}
}
