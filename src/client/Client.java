package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import remote.*;

public class Client {

	public static void main(String[] args) {
		String host = "localhost";
		if (args.length > 0) {
			host = args[0];
		}
		System.out.println("host: " + host);
		try {
			Registry registry = LocateRegistry.getRegistry(host, 18554);
			Message message = (Message) registry.lookup("Message");
			System.out.println(message.getPseudo() + " : " + message.getTexte());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
