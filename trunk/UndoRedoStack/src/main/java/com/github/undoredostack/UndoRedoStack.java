package com.github.undoredostack;

public class UndoRedoStack {
    private String lastCommand;
    public void command(String command) {
        this.lastCommand = command;
    }

    public String undo() {
        if (lastCommand == null) {
            throw new RuntimeException();
        }
        return lastCommand;
    }

    public String redo() {
        return null;
    }
}
