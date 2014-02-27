package contacts2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseManager {
    public static Connection connection;
    public static PreparedStatement insertStatement;
    
    public static void init() {
        String url = "jdbc:mysql://localhost:8889/";
        String database = "contact";
        String userName = "contact";
        String password = "contact";
        
        try {
            connection = DriverManager.getConnection(url + database, userName, password);
            insertStatement = connection.prepareStatement("INSERT INTO contact SET name = ?, address = ?, phone = ? , email = ?");
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public  static ArrayList<Person> getContacts() {
        init();
        ArrayList<Person> contacts = new ArrayList<Person>();
        try {
            Statement selectContacts = connection.createStatement();
            ResultSet results = selectContacts.executeQuery("SELECT * FROM contact");
            while(results.next()) {
                String name = results.getString(2);
                String address = results.getString(3);
                String phone = results.getString(4);
                String email = results.getString(5);
                
                Person person = new Person(name,address, phone,email);
                contacts.add(person);
            }
        } catch(SQLException e) {
        
        }
        return contacts;
    }
    
    public static void addContact(Person person) {
        init();
        /*String url = "jdbc:mysql://localhost:8889/";
        String database = "contact";
        String userName = "contact";
        String password = "contact";*/
        
        try {
            //Connection connection = DriverManager.getConnection(url + database, userName, password);
            //PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO contact SET name = ?, address = ?, phone = ? , email = ?");
            insertStatement.setString(1, person.getName());
            insertStatement.setString(2, person.getAdd());
            insertStatement.setString(3, person.getPhone());
            insertStatement.setString(4, person.getEmailAdd());
            insertStatement.executeUpdate();
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    
        
        
        
        
    }
}
