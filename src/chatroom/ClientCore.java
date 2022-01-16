//IN THE NAME OF GOD
// ALIREZA binesh

package chatroom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class ClientCore {

    private final JButton jButton1;
    private final JTextArea jTextAreaInput;
    private final JTextArea jTextAreaOutput;

    ClientCore(JButton jButton1, JTextArea jTextAreaInput, JTextArea jTextAreaOutput) {
	this.jButton1 = jButton1;
	this.jTextAreaInput = jTextAreaInput;
	this.jTextAreaOutput = jTextAreaOutput;
    }

    public void start(int port) throws IOException{
	try {
	    System.out.println("hello client");
	    Socket socket = new Socket("127.0.0.1", port);
	    ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
	    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
	    
	    jButton1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		    try {
			System.out.println("action correct");
			out.writeObject(new Message.Builder().message(jTextAreaInput.getText()).senderName("Mamad").build());
		    } catch (IOException ex) {
			Logger.getLogger(ClientCore.class.getName()).log(Level.SEVERE, null, ex);
		    }
		}
	    });
	} catch (IOException ex) {
	}
	
    }
}
