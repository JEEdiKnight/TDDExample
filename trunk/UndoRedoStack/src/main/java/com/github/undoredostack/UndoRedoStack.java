package com.github.undoredostack;

import java.util.ArrayList;
import java.util.List;

public class UndoRedoStack {

    private static final int FIRST_LIST_INDEX  = 0;
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

    private boolean undoneCommandStackIsEmpty() {
        return commandsUndone.isEmpty();
    }

    private String removeLastCommandUndone() {
        String lastCommandUndone = commandsUndone.get(FIRST_LIST_INDEX);
        commandsUndone.remove(FIRST_LIST_INDEX);
        return lastCommandUndone;
    }

    public String redo() {
        if (undoneCommandStackIsEmpty()) {
            throw new NoCommandToRedoException();
        }
        String lastCommandUndone = removeLastCommandUndone();
        command(lastCommandUndone);
        return lastCommandUndone;
    }

    boolean canUndoCommand() {
        return !commandStackIsEmpty();
    }

    boolean canRedoCommand() {
        return false;
    }
}
