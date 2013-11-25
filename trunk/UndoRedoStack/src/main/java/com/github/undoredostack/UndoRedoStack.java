package com.github.undoredostack;

import java.util.ArrayList;
import java.util.List;

public class UndoRedoStack {

    private final List<String> commands = new ArrayList<String>();
    private String lastCommandUndone;

    public void command(String command) {
        commands.add(command);
    }

    private String removeLastCommand() {
        int lastIndex = commands.size() - 1;
        String lastCommand = commands.get(lastIndex);
        lastCommandUndone = lastCommand;
        commands.remove(lastIndex);
        return lastCommand;
    }

    private boolean commandStackIsEmpty() {
        return commands.isEmpty();
    }

    public String undo() {
        if (commandStackIsEmpty()) {
            throw new NoCommandToUndoException();
        }
        return removeLastCommand();
    }

    public String redo() {
        if (lastCommandUndone == null) {
            throw new NoCommandToRedoException();
        }
        return lastCommandUndone;
    }
}
