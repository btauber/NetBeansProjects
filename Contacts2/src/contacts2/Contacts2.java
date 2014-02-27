package contacts2;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class Contacts2 extends JFrame {
    ArrayList<Person> person = new ArrayList<>();
    JTextField nameField;
    JTextField addField;
    JTextField phoneField;
    JTextField emailField;
    AllContacts ac;
   
   
    private void addContact(){
        String personName = nameField.getText();
        String personAdd = addField.getText();
        String personPhone = phoneField.getText();
        String personEmail = emailField.getText();
        
        Person p = new Person(personName,personAdd,personPhone,personEmail);
        
        //person.add(p);
        /*try {
            PersonIO.add(p, "contacts.txt");
        } catch (IOException ex) {
            return;
            }*/
        DatabaseManager.addContact(p);
        //JDialog jd = new AllContacts(person);
    }

    protected Contacts2(){
        addWindowListener(new WindowAdapter() {

            

            @Override
            public void windowClosing(WindowEvent e) {
                PersonIO.writeObj(person);
                
                }

            @Override
            public void windowClosed(WindowEvent e) {
                }
            @Override
            public void windowOpened(WindowEvent e) {
                if(PersonIO.readObj()==null){
                    return;
                }
                    person = PersonIO.readObj();
                }

        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,400);
        setLocationRelativeTo(null);
        setTitle("My Contact");
        
        JPanel panel = new JPanel(new GridLayout(5,2,2,2));
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        JLabel nameLabel = new JLabel("Name:");
        JLabel addLabel = new JLabel("Address:");
        JLabel phoneLabel = new JLabel("Phone:");
        JLabel emailLabel = new JLabel("Email:");
        
        nameField = new JTextField();
        addField = new JTextField();
        phoneField = new JTextField();
        emailField = new JTextField();
        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addContact();
                
                nameField.setText("");
                addField.setText("");
                phoneField.setText("");
                emailField.setText("");
                ac.refresh();
                
                
                }
        });
        panel.add(nameLabel);
        panel.add(nameField);
        
        panel.add(addLabel);
        panel.add(addField);
        
        panel.add(phoneLabel);
        panel.add(phoneField);
        
        panel.add(emailLabel);
        panel.add(emailField);
        
        panel.add(submit);
        
        add(panel,BorderLayout.SOUTH); 
        JButton show = new JButton("View all Contacts");
        show.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               ac = new AllContacts();
                
                }
        });
        add(show,BorderLayout.NORTH);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Contacts2();
            }
        });
    }
    
}
