package structures;

public abstract class Iterateur<E> {
	int j;
	
	abstract boolean aProchain();
	
	E prochain() {
		j=0;
		return null;
	}
	
	void supprime() {
		j++;
		if(j != 1) {
			throw new IllegalStateException("un seul appel autorise");
		}
	}
}
