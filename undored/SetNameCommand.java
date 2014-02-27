package undoredo;

public class SetNameCommand implements Command {
    private Person person;
    private String name;
    
    public SetNameCommand(Person person, String name) {
        this.person = person;
        this.name = name;
    }
    
    public void execute() {
        String oldName = person.getName();
        person.setName(name);
        name = oldName;
    }
}
