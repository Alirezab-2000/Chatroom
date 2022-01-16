//IN THE NAME OF GOD
// ALIREZA binesh
package chatroom;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerCore {

    private ArrayList<Client> clients = new ArrayList<>();

    public void start(int port) throws IOException {
	System.out.println("hello server");
	ServerSocket serverSocket = new ServerSocket(port);

	while (true) {
	    Socket socket = serverSocket.accept();
	    Client client = new Client();
	    client.setIn(new ObjectInputStream(socket.getInputStream()));
	    client.setOut(new ObjectOutputStream(socket.getOutputStream()));
	    client.setSocket(socket);

	    clients.add(client);

	    new Thread(new Runnable() {
		@Override
		public void run() {
		    Message message;
		    while (true) {
			try {
			    if ((message = (Message) client.getIn().readObject()) == null) {
				break;
			    }

			    for (Client c : clients) {
				c.getOut().writeObject(message);
			    }
			} catch (ClassNotFoundException | IOException ex) {
			    Logger.getLogger(ServerCore.class.getName()).log(Level.SEVERE, null, ex);
			}
		    }
		}
	    }).start();
	}
    }
}
