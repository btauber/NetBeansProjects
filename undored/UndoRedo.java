package undoredo;

public class UndoRedo {
    private static UndoRedoManager undoRedo = new UndoRedoManager();
    
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.getName());
        
        //p.setName("Bob");
        
        Command command = new SetNameCommand(person, "Bob");
        command.execute();
        undoRedo.addCommand(command);
        System.out.println(person.getName());
        
        command = new SetNameCommand(person, "Charlie");
        command.execute();
        undoRedo.addCommand(command);
        System.out.println(person.getName());
        
        command = new SetNameCommand(person, "Joe");
        command.execute();
        undoRedo.addCommand(command);
        System.out.println(person.getName());
        
        while(undoRedo.canUndo()) {
            undoRedo.undo();
            System.out.println(person.getName());
        }
        
        while(undoRedo.canRedo()) {
            undoRedo.redo();
            System.out.println(person.getName());
        }
    }
}
