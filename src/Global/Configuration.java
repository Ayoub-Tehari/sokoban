package Global;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import structures.Sequence;
import structures.SequenceTableau;


public class Configuration {
	private static Configuration conf;
	private static Properties pConfig;
	
	private Configuration () {
		InputStream inConfig = charge("defaut.cfg");
		pConfig = new Properties();
		try {
			pConfig.load(inConfig);
			pConfig = new Properties(pConfig);
			InputStream nConfig = new FileInputStream (System.getProperty("user.home") + "\\.sokoban");
			pConfig.load(nConfig);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("erreur lors de la lecture du fichier de configuration :" + e);
		}
	}
	
	
	public static Configuration instance () {
		if (conf == null)
			conf = new Configuration();
		return conf;
	}
	public static InputStream charge(String nom) {
		return ClassLoader.getSystemClassLoader().getResourceAsStream(nom);
	}
	
	public String lis(String cle) {
		String resultat = pConfig.getProperty(cle);
		if (resultat.isEmpty())
			throw new NoSuchElementException("impossible de lire la propriete"+cle);
		return resultat;
	}
	
	public <E> Sequence<E> nouvelleSequence (){
		String type = lis("Sequence");
		switch(type) {
		case "Tableau" : return new SequenceTableau<E>();
		case "Liste" : return new SequenceTableau<E>();
		default : throw new RuntimeException("type inconnue" + type);
		}
	}
	
	public Logger logger () {
		Logger log = Logger.getLogger("sokoban.logger");
		log.setLevel(Level.parse(lis("LogLevel")));
		return log;
	}
}
