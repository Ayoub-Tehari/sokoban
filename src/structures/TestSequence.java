package structures;

import java.util.Random;

public class TestSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// main for SequenceListe
			Sequence s = new SequenceListe();

			/*
			s.insereTete(42);
			s.insereQueue(54);
			s.insereTete(43);
			s.insereTete(5435);
			s.extraitTete();
			s.extraitTete();
			s.extraitTete();
			s.extraitTete();
			s.extraitTete();
			 */

			Random r = new Random();
			System.out.println("sequence vide :" + s.estVide());
//				System.out.println("suppression de :" + s.extraitTete());


			for  (int i = 0 ; i<100 ; i++) {
				try {
					System.out.println("sequence vide :" + s.estVide());
					
					if (r.nextBoolean()) {
						if (r.nextBoolean()) {
							int a = r.nextInt(100);
							System.out.println("insertion en queue de :" + a);
							s.insereQueue(a);
						}else {
							int a = r.nextInt(100);
							System.out.println("insertion en tete de :" + a);
							s.insereTete(a);
						}
					} else {
						System.out.println("supprisstion de :" + s.extraitTete());	
					
					}
					
					
				}catch (Exception e) {
					System.out.println(e);
				}
				System.out.println("[" + s + "]");
			}

	}

}
