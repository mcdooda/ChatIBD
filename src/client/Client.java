package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.ConnectException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import remote.*;

public class Client {

	public static void main(String[] args) {
		String host = "localhost";
		if (args.length > 0) {
			host = args[0];
		}
		System.out.println("Serveur : " + host);
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Pseudo : ");
			String pseudo = br.readLine();

			Registry registry = LocateRegistry.getRegistry(host, 18554);
			remote.Serveur serveur = (remote.Serveur) registry.lookup("Serveur");

			ClientImpl clientImpl = new ClientImpl(pseudo);
			remote.Client client = (remote.Client) UnicastRemoteObject.exportObject(clientImpl, 0);
			serveur.enregistrerClient(client);

			System.out.println("Connecté au chat en tant que " + pseudo);
			System.out.println("--------------------------------------");

			while (true) {
				String line = br.readLine();
				serveur.envoyerMessage(client, line);
			}
		} catch (ConnectException ex) {
			System.out.println("Impossible de se connecter au serveur " + host);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
