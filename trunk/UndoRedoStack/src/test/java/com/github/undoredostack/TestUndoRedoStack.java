package com.github.undoredostack;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestUndoRedoStack {

    static final String COMMAND_1 = "command1";

    @Test
    public void undoReturnLastCommand() {
        //Arrange
        UndoRedoStack stack = new UndoRedoStack();
        stack.command(COMMAND_1);
        //Act
        String actualResult = stack.undo();
        //Assert
        assertEquals(COMMAND_1, actualResult);
    }
}
