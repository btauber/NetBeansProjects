package chatserver;

import java.util.LinkedList;

public class ChatServer {
    private LinkedList<ChatMessage> chats = new LinkedList<ChatMessage>();

    public synchronized void sendChat(ChatMessage message) {
        chats.add(message);
        notifyAll();
    }
    
    public synchronized ChatMessage getChatMessage(int index) {
        while (chats.size() <= index) {
            try {
                wait();
            } catch(InterruptedException e) {
                return null;
            }
        }
        return chats.get(index);
    }
    
    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        
        for(int i = 0; i < 3; i++) {
            new ChatWindow(server, "Chatter #" + i);
        }
    }
}
