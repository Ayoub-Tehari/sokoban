package sokoban;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Global.Configuration;



public class EcouteurClavier implements KeyListener {
	
	NiveauGraphique ng;
	
	EcouteurClavier(NiveauGraphique n){
		ng = n;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP :
			ng.tapAuClavier(0, -1);
			break;
		case KeyEvent.VK_DOWN :
			ng.tapAuClavier(0, 1);
			break;
		case KeyEvent.VK_RIGHT :
			ng.tapAuClavier(1, 0);
			break;
		case KeyEvent.VK_LEFT :
			ng.tapAuClavier(-1, 0);
			break;
		case KeyEvent.VK_ESCAPE :
			System.exit(0);
			break;
		default :
			Configuration.instance().logger().info("la touche clavier n'est pas implementée !");
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
