package serveur;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import remote.Message;
import remote.MessageImpl;

public class Serveur {

	public static void main(String[] args) {
		try {
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
			}
			Registry registry = LocateRegistry.createRegistry(18554);
			MessageImpl messageImpl = new MessageImpl("pseudo", "texte");
			Message message = (Message) UnicastRemoteObject.exportObject(messageImpl, 0);
                        System.out.println("En attente de clients...");
			registry.bind("Message", message);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
