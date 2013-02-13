/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import java.rmi.RemoteException;

/**
 *
 * @author gervaila
 */
public class MessageImpl implements Message {
	
	private String pseudo;
	private String texte;
	
	public MessageImpl(String pseudo, String texte) {
		this.pseudo = pseudo;
		this.texte = texte;
	}
	
	@Override
	public String getPseudo() throws RemoteException {
		return pseudo;
	}

	@Override
	public String getTexte() throws RemoteException {
		return texte;
	}
	
}
