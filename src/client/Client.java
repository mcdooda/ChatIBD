package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import remote.*;

public class Client {

	private static remote.Client client;

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new FenetreConnexion().setVisible(true);
			}
		});
	}

	public static void connexion(String pseudo, String hote, int port) throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry(hote, port);
		remote.Serveur serveur = (remote.Serveur) registry.lookup("Serveur");
		
		FenetreMessages fenetreMessages = new FenetreMessages();
		fenetreMessages.setVisible(true);
		ClientImpl clientImpl = new ClientImpl(pseudo, fenetreMessages);
		client = (remote.Client) UnicastRemoteObject.exportObject(clientImpl, 0);
		client.connecter(serveur);
	}
	
	public static void deconnexion() throws RemoteException {
		client.deconnecter();
	}
	
	public static void envoyerMessage(String message) throws RemoteException {
		client.envoyerMessage(message);
	}

}
