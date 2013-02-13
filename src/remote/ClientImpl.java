package remote;

import java.rmi.RemoteException;

public class ClientImpl implements Client {

	private String pseudo;

	public ClientImpl(String pseudo) {
		this.pseudo = pseudo;
	}

	@Override
	public String getPseudo() throws RemoteException {
		return pseudo;
	}

	@Override
	public void afficherMessage(String pseudo, String message) {
		System.out.println(pseudo + " : " + message);
	}
}
