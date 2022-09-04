package com.nbarraille.jjsonrpc;

import org.slf4j.Logger;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This is a basic TCP Client, that creates a JJsonPeer.
 * @author nbarraille
 *
 */
public class TcpClient {
	private final static Logger _log = org.slf4j.LoggerFactory.getLogger(TcpClient.class);
	private final JJsonPeer _peer; // The JJson Peer
	
	/**
	 * Creates a new TCP Socket by connecting to a SocketServer, and creates a JJsonPeer that will use this socket to communicate.
	 * @param serverAddress the address of the SocketServer to connect too.
	 * @param serverListenerPort the port of the SocketServer to connect too.
	 * @param handler the local "API Class" where all the methods that the other Peer can be remotely executed from the other peer are.
	 * @throws UnknownHostException the provided serverAddress or serverPort cannot be found.
	 * @throws IOException if an I/O exception occurs while creating the Socket.
	 */
	public TcpClient(String serverAddress, int serverListenerPort, Object handler) throws IOException {
		_peer = new JJsonPeer(new Socket(serverAddress, serverListenerPort), handler);
		_log.info("TCP Client started");
		_peer.start();
	}
	
	/**
	 * Returns this client's peer.
	 * @return the JJsonPeer of this client.
	 */
	public JJsonPeer getPeer() {
		return _peer;
	}

}
