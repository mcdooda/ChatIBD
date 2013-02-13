/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author gervaila
 */
public interface Message extends Remote {
	
	public String getPseudo() throws RemoteException;
	public String getTexte() throws RemoteException;
	
}
