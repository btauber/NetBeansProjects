package undoredo;

import java.util.Stack;

public class UndoRedoManager {
    private Stack<Command> undo = new Stack<Command>();
    private Stack<Command> redo = new Stack<Command>();
    
    public void addCommand(Command command)
    {
        undo.push(command);
        redo.clear();
    }
    
    public void undo()
    {
        Command command = undo.pop();
        command.execute();
        redo.push(command);
    }
    
    public void redo()
    {
        Command command = redo.pop();
        command.execute();
        undo.push(command);
    }
    
    public boolean canUndo()
    {
        return !undo.empty();
    }
    
    public boolean canRedo()
    {
        return !redo.empty();
    }
}
