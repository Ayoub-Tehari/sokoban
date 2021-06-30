package structures;

public interface Sequence<Tiri> {

    void insereTete(Tiri element) ;
    //insère l'élément element en début de séquence (en première position)
    void insereQueue(Tiri element) ;
    //insère l'élément element en fin de séquence (en dernière position)
    Tiri extraitTete() ;
    //extrait et renvoie la valeur de l'élément situé en début de séquence (en première position)
    boolean estVide() ;
    //renvoie vrai si et seulement si la séquence est vide
    String toString () ;
    //revoie la sequence sous forme textuel
    Iterateur<Tiri> iterateur();
}
