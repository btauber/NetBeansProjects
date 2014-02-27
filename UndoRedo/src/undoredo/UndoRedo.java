package undoredo;

public class UndoRedo {
    private static UndoRedoManager undoRedo = new UndoRedoManager();
    
    public static void main(String[] args) {
        NameOrAddObj person = new Person();
        System.out.print("person: ");
        System.out.println(person.getName());
        
        executeNameCommand(person, "joe");
        executeAddressCommand(person, "12435 7 st");
        
        NameOrAddObj organization = new Organization();
        executeNameCommand(organization,"PCS");
        executeAddressCommand(organization, "212 2 st.");
        
        executeNameCommand(person, "Bob");
        executeAddressCommand(person, "1243");
   
        /*
        Command command = new SetNameCommand(person, "Bob");
        
        System.out.println("Executing name change person to Bob");
        command.execute();
        undoRedo.addCommand(command);
        System.out.print("person: ");
        System.out.println(person.getName());
        
        Person person2 = new Person();
        System.out.print("person2: ");
        System.out.println(person2.getName());
        
        command = new SetNameCommand(person2, "Joe");
        System.out.println("Executing name change person2 to Joe");
        command.execute();
        undoRedo.addCommand(command);
        System.out.print("person2: ");
        System.out.println(person2.getName());
        
        command = new SetAddressCommand(person2, "123 Any Street Any Town USA");
        System.out.println("Executing address change person2 to 123 Any Street Any Town USA");
        command.execute();
        undoRedo.addCommand(command);
        System.out.print("person2: ");
        System.out.println(person2.getAddress());*/
        
        while(undoRedo.canUndo()) {
            System.out.println("Undoing a command");
            undoRedo.undo();
            System.out.print("person: ");
            System.out.println(person.getName());
            System.out.println(person.getAddress());
            System.out.print("organization: ");
            System.out.println(organization.getName());
            System.out.println(organization.getAddress());
        }
        
        while(undoRedo.canRedo()) {
            System.out.println("Redoing a command");
            undoRedo.redo();
            System.out.print("person: ");
            System.out.println(person.getName());
            System.out.print("person2: ");
            System.out.println(organization.getName());
            System.out.println(organization.getAddress());
        }
    }
    
     public static void executeNameCommand(NameOrAddObj title, String name)
     {
        Command command = new SetNameCommand(title,name);
        command.execute();
        undoRedo.addCommand(command);
        System.out.println("Executing name change "+ title.getType()+" to "+ title.getName());
     }
     
     public static void executeAddressCommand(NameOrAddObj title, String name)
     {
        Command command = new SetAddressCommand(title,name);
        command.execute();
        undoRedo.addCommand(command);
        System.out.println("Executing address change "+ title.getType()+" to "+ title.getAddress());
     }
     
     
     
}
