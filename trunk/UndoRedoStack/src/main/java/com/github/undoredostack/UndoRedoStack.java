package com.github.undoredostack;

import java.util.ArrayList;
import java.util.List;

public class UndoRedoStack {

    private List<String> commands = new ArrayList<String>();
    private boolean moreThanOneUndo = false;
    public void command(String command) {
        commands.add(command);
    }

    public String undo() {
        if (commands.isEmpty()) {
            throw new NoCommandToUndoException();
        }
        int lastIndex = commands.size() - 1;
        String lastCommand = commands.get(lastIndex);
        commands.remove(lastIndex);
        return lastCommand;
    }

    public String redo() {
        return null;
    }
}
