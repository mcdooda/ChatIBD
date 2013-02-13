package remote;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class ServeurImpl implements Serveur {

	private ArrayList<Client> clients;

	public ServeurImpl() {
		clients = new ArrayList<Client>();
	}

	@Override
	public void enregistrerClient(Client client) throws RemoteException {
		clients.add(client);
		System.out.println("connexion de " + client.getPseudo());
	}

	@Override
	public void envoyerMessage(Client client, String message) throws RemoteException {
		for (Client c : clients) {
			if (!c.equals(client)) {
				c.afficherMessage(client.getPseudo(), message);
			}
		}
	}
}
