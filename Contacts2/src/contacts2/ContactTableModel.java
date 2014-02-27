package contacts2;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ContactTableModel extends AbstractTableModel {
    ArrayList<Person> contacts = new ArrayList<>();
    String[] column ={"name","address","phone","email"};
    
    public ContactTableModel(){
        contacts = DatabaseManager.getContacts();
        
    }
    
    @Override
    public int getRowCount() {
        return contacts.size();
        
    }

    @Override
    public int getColumnCount() {
        return column.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Person person = contacts.get(rowIndex);
        switch(columnIndex){
            case 0:
                return person.getName();
            case 1:
                return person.getAdd();
            case 2:
                return person.getPhone();
            case 3:
                return person.getEmailAdd();
        }
        return null;
    }
    
    public String getColumnName(int col) {
        return column[col];
    }
    
}
