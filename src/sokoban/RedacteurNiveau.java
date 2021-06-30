package sokoban;
import java.io.PrintStream;

public class RedacteurNiveau {
	PrintStream ps;
	RedacteurNiveau (PrintStream p){
		ps = p;
	}
	public void ecrisNiveau(Niveau n){
		for(int i=0; i<n.lignes(); i++) {
			int dernier = n.colonnes() - 1;
			while (dernier >=0) {
				if (n.estVide(i, dernier)) {
					dernier--;
				}else {
					break;
				}
			}
			for (int j=0; j<=dernier ; j++) {
				if (n.aMur(i, j)) {
					ps.print('#');
				}
				if (n.estVide(i, j)) {
					ps.print(' ');
				}
				if (n.aBut(i, j)) {
					if (n.aCaisse(i, j)) {
						ps.print('*');
					}else if(n.aPousseur(i, j)){
						ps.print('+');
					}else {
						ps.print('.');
					}
				}
				if (n.aCaisse(i, j)) {
					if (n.aBut(i, j)) {
						ps.print('*');
					}else {
						ps.print('$');
					}
				}
				if (n.aPousseur(i, j)) {
					if (n.aBut(i, j)) {
						ps.print('+');
					}else {
						ps.print('@');
					}
				}
			}
			ps.println();
		}
		ps.println(";" + n.nom());
	}
}
