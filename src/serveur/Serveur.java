package serveur;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import remote.*;

public class Serveur {

	public static void main(String[] args) {
		try {
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
			}
			Registry registry = LocateRegistry.createRegistry(18554);
			ServeurImpl serveurImpl = new ServeurImpl();
			remote.Serveur serveur = (remote.Serveur) UnicastRemoteObject.exportObject(serveurImpl, 0);
			System.out.println("En attente de clients...");
			System.out.println("--------------------------------------");
			registry.bind("Serveur", serveur);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
