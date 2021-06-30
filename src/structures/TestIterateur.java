package structures;
import java.util.Random;

public class TestIterateur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			Sequence<Integer> s = new SequenceTableau<>();
			for (int i=0; i<100 ; i++) {
				s.insereQueue(i);
			}
			System.out.println("[" + s + "]");
			Random r = new Random();
			Iterateur<Integer> it = s.iterateur();
			if (it == null)
				System.out.println("return null");
			while (it.aProchain()) {
				try {
					if (r.nextInt(3)<2) {
						System.out.println(" " + it.prochain());
					} else {
						it.supprime();
						System.out.println("suppression");	
					}
				}catch (Exception e) {
					System.out.println(e);
				}
			}
			System.out.println("[" + s + "]");
	}
}