package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Serveur extends Remote {

	void connecterClient(Client client) throws RemoteException;
	void deconnecterClient(Client client) throws RemoteException;
	void envoyerMessage(Client client, String message) throws RemoteException;
}
