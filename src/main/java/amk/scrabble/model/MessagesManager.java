package amk.scrabble.model;

import java.util.ArrayList;
import java.util.List;

public class MessagesManager {
    List<String> messages;


    public MessagesManager() {
        messages = new ArrayList<>();
        messages.add("Game started. Have fun!");

    }


    public void addMessage(String message) {
        messages.add(0, message);
    }

    public List<String> getMessages() {
        return messages;
    }
}
