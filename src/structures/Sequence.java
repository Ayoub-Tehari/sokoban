package structures;

public interface Sequence<Tiri> {

    void insereTete(Tiri element) ;
    //ins�re l'�l�ment element en d�but de s�quence (en premi�re position)
    void insereQueue(Tiri element) ;
    //ins�re l'�l�ment element en fin de s�quence (en derni�re position)
    Tiri extraitTete() ;
    //extrait et renvoie la valeur de l'�l�ment situ� en d�but de s�quence (en premi�re position)
    boolean estVide() ;
    //renvoie vrai si et seulement si la s�quence est vide
    String toString () ;
    //revoie la sequence sous forme textuel
    Iterateur<Tiri> iterateur();
}
