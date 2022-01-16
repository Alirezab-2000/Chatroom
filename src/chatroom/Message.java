//IN THE NAME OF GOD
// ALIREZA binesh
package chatroom;

public class Message {

    String text;
    String sender_name;

    private Message(String text, String sender_name) {
	this.text = text;
	this.sender_name = sender_name;
    }

    static class Builder {

	String text;
	String sender_name;

	Builder message(String message) {
	    text = message;
	    return this;
	}

	Builder senderName(String senderName) {
	    sender_name = senderName;
	    return this;
	}

	Message build() {
	    return new Message(text, sender_name);
	}
    }

    public String getSenderName() {
	return sender_name;
    }

    public String getText() {
	return text;
    }
}
