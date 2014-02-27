package undoredo;

public class SetNameCommand implements Command {
    private NameOrAddObj object;
    private String name;
    
    public SetNameCommand(NameOrAddObj object, String name) {
        this.object = object;
        this.name = name;
    }
    
    public void execute() {
        String oldName = object.getName();
        object.setName(name);
        name = oldName;
    }
}
