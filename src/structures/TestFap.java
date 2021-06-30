package structures;

import java.util.Random;

public class TestFap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fap<Couple<Double, Integer>> sT = new FapTableau<>();
		Fap<Couple<Double, Integer>> sL = new FapListe<>();
		
		Random r = new Random();
		for  (int i=0 ; i<100 ; i++) {
			try {
				System.out.println("sequenceL vide :" + sL.estVide());
				System.out.println("sequenceT vide :" + sT.estVide());
				assert(sL.estVide() == sT.estVide());
				
				if (r.nextBoolean()) {
					Couple<Double, Integer> a = new Couple<Double, Integer>(r.nextDouble(), r.nextInt(10));
						System.out.println("insertion de :" + a);
						sL.insere(a);
						sT.insere(a);
					
				} else if (!sL.estVide()){
					Couple<Double, Integer> k1 = sL.extraire();
					Couple<Double, Integer> k2 = sT.extraire();
					assert(k1.equals(k2));
					System.out.println("suppression de :" + k1);
					System.out.println("suppression de :" + k2);	
				
				}
			}catch (Exception e) {
				System.out.println(e);
			}
			
		}
	}

}
