package contacts2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AllContacts extends JDialog {
    protected JTable jt;
    ContactTableModel ctm;
    
 
    public void refresh(){
        ctm = new ContactTableModel();
        jt.setModel(ctm);
    }
    
    protected AllContacts(){//(ArrayList<Person> person){
        setSize(300,400);
        setLocationRelativeTo(this);
        setVisible(true);
        /*JTextArea allContacts = new JTextArea();
        for(Person p:person){
            allContacts.append(p.getName() +"\t"+p.getAdd()+"\t"+p.getPhone()+"\t"+p.getEmailAdd()+System.lineSeparator() );
        }*/
        JButton refresh = new JButton("Refresh");
        refresh.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
               refresh();
                
            }
        });
        add(refresh,BorderLayout.NORTH);
        ctm = new ContactTableModel();
        jt = new JTable(ctm);
        
        add(jt,BorderLayout.CENTER);
        JScrollPane jsb = new JScrollPane(jt);
        add(jsb,BorderLayout.EAST);
        
    }
    
}
