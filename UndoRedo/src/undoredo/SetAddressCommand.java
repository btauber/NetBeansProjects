package undoredo;

public class SetAddressCommand implements Command {
    private NameOrAddObj object;
    private String address;
    
    public SetAddressCommand(NameOrAddObj object, String address) {
        this.object = object;
        this.address = address;
    }
    
    public void execute() {
        String oldAddress = object.getAddress();
        object.setAddress(address);
        address = oldAddress;
    }
}
