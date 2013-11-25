package com.github.undoredostack;

import java.util.ArrayList;
import java.util.List;

public class UndoRedoStack {

    private final List<String> commands = new ArrayList<String>();
    private final List<String> commandsUndone = new ArrayList<String>();

    public void command(String command) {
        commands.add(command);
    }

    private String removeLastCommand() {
        int lastIndex = commands.size() - 1;
        String lastCommand = commands.get(lastIndex);
        commandsUndone.add(0, lastCommand);
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
        if (commandsUndone.isEmpty()) {
            throw new NoCommandToRedoException();
        }
        String lastCommandUndo = commandsUndone.get(0);
        commandsUndone.remove(0);
        command(lastCommandUndo);
        return lastCommandUndo;
    }
}
