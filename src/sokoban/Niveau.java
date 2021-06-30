package sokoban;

public class Niveau {
	
	private String nom;
	int lignes;
	int colonnes;
	private int[][] tab;
	final int VIDE = 0;
	final int MUR = 1;
	final int POUSSEUR = 2;
	final int CAISSE = 4;
	final int BUT = 8;
	int pousseurC, pousseurL;
	int lesCaissesSurBut, lesButs;
	
	
	public Niveau() {
		tab = new int [1][1];
		lignes = colonnes = 0;
	}
	
	private int ajuste (int c, int i) {
		while (c <= i) {
			c *= 2;
		}
		return c;
	}
	
	private void redimentionne (int i, int j) {
		int oldI = tab.length;
		int oldJ = tab[0].length;
		if (oldI<=i || oldJ<=j) {
			int newI = ajuste (oldI, i);
			int newJ = ajuste (oldJ, j);
			int [][] newTab = new int [newI][newJ];
			//System.out.println("redimentionnement : " + newI + "*" + newJ);
			for (int a=0; a<oldI ;a++) {
				for (int b=0; b<oldJ ; b++) {
					newTab[a][b] = tab[a][b];
				}
			}
			tab = newTab;
		}
	}
	
	public void fixeNom (String n) {
		this.nom = n;
	}
	
	public int lignes() {
		return lignes;
	}
	
	public int colonnes() {
		return colonnes;
	}
	
	public String nom () {
		return nom;
	}
	
	public boolean fini () {
		return lesCaissesSurBut == lesButs;
	}
	
	private void ajoute (int element, int i , int j) {
		redimentionne(i, j);
		tab[i][j] |= element;
		if (lignes <= i) {
			lignes = i+1;
		}
		if (colonnes <= j) {
			colonnes = j+1;
		}
	}
	
	private void supprime (int element, int i , int j) {
		tab[i][j] &= ~element;
		if (this.aBut(i, j)) {
			if (element == CAISSE) {
				lesCaissesSurBut--;
			}
		}
	}
	
	public boolean deplace (int j, int i) {
		if (this.aMur(i, j)) {
			return false;
		}else if (this.aCaisse(i, j)) {
			int dx = j - pousseurC;
			int dy = i - pousseurL;
			int ax = j + dx;
			int ay = i + dy;
			if (this.estLibre(ay, ax)) {
				this.supprime(CAISSE, i, j);
				this.ajouteCaisse(ay, ax);
				this.supprime(POUSSEUR, pousseurL, pousseurC);
				this.ajoutePousseur(i, j);
			} else {
				return false;
			}
		}else {
			this.supprime(POUSSEUR, pousseurL, pousseurC);
			this.ajoutePousseur(i, j);
		}
		return true;
	}
	
	public void videCase(int i, int j) {
		tab [i][j] = VIDE;
	}
	
	public void ajouteMur(int i, int j) {
		ajoute(MUR, i, j);
	}
	
	public void ajoutePousseur(int i, int j) {
		ajoute(POUSSEUR, i, j);
		pousseurC=j;
		pousseurL=i;
	}
	
	public void ajouteCaisse(int i, int j) {
		ajoute(CAISSE, i, j);
		if (this.aBut(i, j)) {
			lesCaissesSurBut ++;
		}
	}
	
	public void ajouteBut(int i, int j) {
		ajoute(BUT, i, j);
		lesButs ++;
	}

	public boolean estVide (int i, int j) {
		return (tab [i][j]  == 0);
	}
	
	public boolean aMur(int i, int j) {
		return ((tab [i][j] & MUR) != 0);
	}
	
	public boolean aPousseur (int i, int j) {
		return ((tab [i][j] & POUSSEUR) != 0);
	}
	
	public boolean aBut (int i, int j) {
		return ((tab [i][j] & BUT) != 0);
	}
	
	public boolean aCaisse (int i, int j) {
		return ((tab [i][j] & CAISSE) != 0);
	}
	
	public boolean estLibre(int i, int j) {
		return !this.aCaisse(i, j) && !this.aMur(i, j);
	}
}
