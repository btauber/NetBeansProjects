package chatserver;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChatWindow extends JFrame {
    private JTextArea chat;
    private JTextField chatMessage;
    private ChatServer server;
    private String name;
    
    public ChatWindow(final ChatServer server, final String name) {
        this.server = server;
        this.name = name;
        
        chat = new JTextArea();
        chat.setEditable(false);
        chatMessage = new JTextField();
        JButton send = new JButton("send");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.sendChat(new ChatMessage(name, chatMessage.getText()));
                chatMessage.setText("");
            }
        });
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(chatMessage);
        panel.add(send, BorderLayout.EAST);
        add(chat);
        add(panel, BorderLayout.SOUTH);
        setSize(300, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                int index = 0;
                while(true) {
                    ChatMessage message = server.getChatMessage(index++);
                    chat.append(message.getSender() + ": ");
                    chat.append(message.getMessage());
                    chat.append(System.lineSeparator());
                }
            }
        }).start();
    }
}
