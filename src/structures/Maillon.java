package structures;

public class Maillon<Toto> {
	Toto element;
	Maillon<Toto> suivant;
	Maillon (Toto e) {
		element = e;
		suivant = null;
	}
}
