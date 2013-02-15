package remote;

import client.FenetreMessages;
import java.rmi.RemoteException;

public class ClientImpl implements Client {

	private String pseudo;
	private FenetreMessages fenetreMessages;
	private remote.Serveur serveur;

	public ClientImpl(String pseudo, FenetreMessages fenetreMessages) {
		this.pseudo = pseudo;
		this.fenetreMessages = fenetreMessages;
	}

	@Override
	public void connecter(remote.Serveur serveur) throws RemoteException {
		this.serveur = serveur;
		serveur.connecterClient(this);
	}

	@Override
	public void deconnecter() throws RemoteException {
		serveur.deconnecterClient(this);
	}

	@Override
	public String getPseudo() throws RemoteException {
		return pseudo;
	}

	@Override
	public void envoyerMessage(String message) throws RemoteException {
		serveur.envoyerMessage(this, message);
	}

	@Override
	public void afficherMessage(String pseudo, String message) {
		fenetreMessages.afficherMessage(pseudo, message);
	}
}
