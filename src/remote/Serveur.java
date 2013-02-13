package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Serveur extends Remote {

	void enregistrerClient(Client client) throws RemoteException;
	void envoyerMessage(Client client, String message) throws RemoteException;
}
