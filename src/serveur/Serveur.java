package serveur;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;
import remote.*;

public class Serveur {

	public static void main(String[] args) {
		int port = 18554;
		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
		}
		try {
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
			}
			Registry registry = LocateRegistry.createRegistry(port);
			ServeurImpl serveurImpl = new ServeurImpl();
			remote.Serveur serveur = (remote.Serveur) UnicastRemoteObject.exportObject(serveurImpl, 0);
			System.out.println("En attente de clients...");
			System.out.println("--------------------------------------");
			registry.bind("Serveur", serveur);
		} catch (ExportException ex) {
			System.out.println("Impossible de lancer le serveur :");
			System.out.println("Le port " + port + " est déjà utilisé.");
			System.out.println("Il est possible de préciser le port à utiliser en premier argument du programme.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
