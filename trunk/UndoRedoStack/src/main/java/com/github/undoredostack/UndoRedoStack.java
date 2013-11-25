package com.github.undoredostack;

public class UndoRedoStack {
    private String lastCommand;
    public void command(String command) {
        this.lastCommand = command;
    }

    public String undo() {
        return lastCommand;
    }

    public String redo() {
        return null;
    }
}
