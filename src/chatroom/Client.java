//IN THE NAME OF GOD
// ALIREZA binesh

package chatroom;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;

    public void setSocket(Socket socket) {
	this.socket = socket;
    }

    public void setIn(ObjectInputStream in) {
	this.in = in;
    }

    public void setOut(ObjectOutputStream out) {
	this.out = out;
    }

    public ObjectInputStream getIn() {
	return in;
    }

    public ObjectOutputStream getOut() {
	return out;
    }

    public Socket getSocket() {
	return socket;
    }
}
