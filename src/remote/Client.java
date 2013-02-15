package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote {

	public void connecter(Serveur serveur) throws RemoteException;
	public void deconnecter() throws RemoteException;
	
	public String getPseudo() throws RemoteException;
	public void envoyerMessage(String message) throws RemoteException;
	public void afficherMessage(String pseudo, String message) throws RemoteException;
}
