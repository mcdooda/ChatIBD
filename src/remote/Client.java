package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote {

	public String getPseudo() throws RemoteException;
	public void afficherMessage(String pseudo, String message) throws RemoteException;
}
